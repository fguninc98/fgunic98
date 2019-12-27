package com.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.api.dto.TokenRequestDto;
import com.api.dto.TokenResponseDto;
import com.api.dto.UserCreateDto;
import com.api.dto.UserDto;

public interface UserService {
	
	Page<UserDto> findAll(Pageable pageeable);
	UserDto add(UserCreateDto userCreateDto);
	TokenResponseDto login(TokenRequestDto tokenRequestDto);
	
}
