package service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import dto.TokenRequestDto;
import dto.TokenResponseDto;
import dto.UserCreateDto;
import dto.UserDto;

public interface UserService {
	
	Page<UserDto> findAll(Pageable pageeable);
	UserDto add(UserCreateDto userCreateDto);
	TokenResponseDto login(TokenRequestDto tokenRequestDto);
	
}
