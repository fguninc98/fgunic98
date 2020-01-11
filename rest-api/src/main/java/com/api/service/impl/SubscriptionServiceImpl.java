package com.api.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.model.UserSubsription;
import com.api.repository.SubscriptionRepository;
import com.api.service.SubscriptionService;

@Service
@Transactional
public class SubscriptionServiceImpl implements SubscriptionService{

	private SubscriptionRepository subscriptionRepository;
	
	public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository) {
		this.subscriptionRepository = subscriptionRepository;
	}

	@Override
	public List<UserSubsription> findAll(PageRequest pageRequest) {
		Page<UserSubsription> recordsPage = subscriptionRepository.findAll(Pageable.unpaged());
		return recordsPage.getContent();
	}
	
	@Override
	public UserSubsription findById(String id) {
		if(subscriptionRepository.findById(id).isPresent()) {
			UserSubsription recordsPage = subscriptionRepository.findById(id).get();
			return recordsPage;
		}
		return null;
	}

	@Override
	public UserSubsription add(UserSubsription userSubscription) {
		subscriptionRepository.save(userSubscription);
		return userSubscription;
	}
}
