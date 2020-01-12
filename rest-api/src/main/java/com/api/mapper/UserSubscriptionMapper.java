package com.api.mapper;

import org.springframework.stereotype.Component;

import com.api.model.UserSubsription;
import com.api.dto.UserSubscriptionDto;

@Component
public class UserSubscriptionMapper {
	
	public UserSubscriptionDto userSubsriptionToUserSubscriptionDto(UserSubsription userSubsription) {
		UserSubscriptionDto userSubscriptionDto = new UserSubscriptionDto();
		userSubscriptionDto.setId(userSubsription.getId());
		userSubscriptionDto.setUserId(userSubsription.getUserId());
		userSubscriptionDto.setServiceName(userSubscriptionDto.getServiceName());
		userSubscriptionDto.setInterval(userSubsription.getInterval());
		userSubscriptionDto.setLastTimeExecuted(userSubsription.getLastTimeExecuted());
		return userSubscriptionDto;

	}
	
	public UserSubsription UserSubscriptionDtoToUserSubscription(UserSubscriptionDto userSubscriptionDto) {
		UserSubsription userSubsription = new UserSubsription();
		userSubsription.setId(userSubscriptionDto.getId());
		userSubsription.setUserId(userSubscriptionDto.getUserId());
		userSubsription.setServiceName(userSubscriptionDto.getServiceName());
		userSubsription.setInterval(userSubscriptionDto.getInterval());
		userSubsription.setLastTimeExecuted(userSubscriptionDto.getLastTimeExecuted());
		return userSubsription;
		
	}
	

}
