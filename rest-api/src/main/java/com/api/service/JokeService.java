package com.api.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.dto.JokeDto;
import com.api.repository.JokeRepository;

@Service
public interface JokeService {
	
	 List<JokeDto> findAll(PageRequest pageRequest);
}