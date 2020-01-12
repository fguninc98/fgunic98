package com.api.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.model.UserSubsription;

@Repository
public interface SubscriptionRepository extends JpaRepository<UserSubsription, Long>{
	Page<UserSubsription> findAll(Pageable pageable);
	Optional<UserSubsription> findById(String id);
}
