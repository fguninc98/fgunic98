package com.api.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.dto.TokenRequestDto;
import com.api.dto.TokenResponseDto;
import com.api.dto.UserCreateDto;
import com.api.dto.UserDto;
import com.api.exeptions.NotFoundException;
import com.api.mapper.UserMapper;
import com.api.model.User;
import com.api.repository.UserRepository;
import com.api.service.UserService;
import com.api.tokenService.TokenService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service
public class UserServiceImpl implements UserService {

	private TokenService tokenService;
	private UserRepository userRepository;
	private ModelMapper userMapper;
	
	
	public UserServiceImpl(TokenService tokenService, UserRepository userRepository) {
		super();
		this.tokenService = tokenService;
		this.userRepository = userRepository;
		this.userMapper = new ModelMapper();
	}

	@Override
	public Page<UserDto> findAll(Pageable pageeable) {
		return userRepository.findAll(pageeable).map(userMapper::map);
	}

	@Override
	public UserDto add(UserCreateDto userCreateDto) {
		//User user = userMapper.userCreateDtoToUser(userCreateDto);
		User user = userMapper.map(userCreateDto, User.class);
		userRepository.save(user);
		//return userMapper.userToUserDto(user);
		return userMapper.map(user, UserDto.class);
	}

	@Override
	public TokenResponseDto login(TokenRequestDto tokenRequestDto) {
		User user = userRepository.findByUsernameAndPassword(tokenRequestDto.getUsername(), tokenRequestDto.getPassword())
				.orElseThrow(() -> new NotFoundException(String.format("User with username %s and password %s not found.", tokenRequestDto.getUsername(),tokenRequestDto.getPassword())));
		Claims claims = Jwts.claims();
		claims.put("id",user.getId());
		claims.put("role",user.getRole().getName());
		return new TokenResponseDto(tokenService.generate(claims));
	}

}
