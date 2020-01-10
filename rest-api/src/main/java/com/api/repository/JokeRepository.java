package com.api.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.dto.JokeDto;
import com.api.dto.JokeDto;

@Repository
public interface JokeRepository extends JpaRepository<JokeDto, String>{
	Page<JokeDto> getAll(Pageable pageable);
	Optional<JokeDto> getJoke(String id);
}
