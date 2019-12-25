package service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import dto.TokenRequestDto;
import dto.TokenResponseDto;
import dto.UserCreateDto;
import dto.UserDto;
import exeptions.NotFoundException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import mapper.UserMapper;
import model.User;
import repository.UserRepository;
import service.UserService;
import tokenService.TokenService;

public class UserServiceImpl implements UserService {

	private TokenService tokenService;
	private UserRepository userRepository;
	private UserMapper userMapper;
	
	
	
	
	public UserServiceImpl(TokenService tokenService, UserRepository userRepository, UserMapper userMapper) {
		super();
		this.tokenService = tokenService;
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}

	@Override
	public Page<UserDto> findAll(Pageable pageeable) {
		return userRepository.findAll(pageeable).map(userMapper::userToUserDto);
	}

	@Override
	public UserDto add(UserCreateDto userCreateDto) {
		User user = userMapper.userCreateDtoToUser(userCreateDto);
		userRepository.save(user);
		return userMapper.userToUserDto(user);
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
