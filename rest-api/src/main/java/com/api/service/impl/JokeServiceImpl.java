package com.api.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.dto.JokeDto;
import com.api.repository.JokeRepository;
import com.api.service.JokeService;

@Service
@Transactional
public class JokeServiceImpl implements JokeService{

	private JokeRepository jokeRepository;

	@Override
	public List<JokeDto> findAll(PageRequest pageRequest) {
		Page<JokeDto> recordsPage = jokeRepository.findAll(Pageable.unpaged());
		return recordsPage.getContent();
	}

	
}
