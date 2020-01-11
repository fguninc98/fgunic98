package com.api.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.api.model.UserSubsription;

@Service
public interface SubscriptionService {
	
	 List<UserSubsription> findAll(PageRequest pageRequest);
	 UserSubsription findById(String id);
	 UserSubsription add(UserSubsription userSubscription);
}