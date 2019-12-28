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
import com.api.model.User;
import com.api.repository.RoleRepository;
import com.api.repository.UserRepository;
import com.api.service.UserService;
import com.api.tokenService.TokenService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service
public class UserServiceImpl implements UserService {

	private TokenService tokenService;
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private ModelMapper userMapper;
	
	
	public UserServiceImpl(TokenService tokenService, UserRepository userRepository, RoleRepository roleRepository) {
		super();
		this.tokenService = tokenService;
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.userMapper = new ModelMapper();
	}

	@Override
	public Page<UserDto> findAll(Pageable pageeable) {
		//return (Page<UserDto>) userMapper.map(userRepository.findAll(pageeable), UserDto.class);
		return null;
	}

	@Override
	public UserDto add(UserCreateDto userCreateDto) {
		//User user = userMapper.userCreateDtoToUser(userCreateDto);
		User user = userMapper.map(userCreateDto, User.class);
		user.setRole(roleRepository.findByName("ROLE_USER").get());
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
