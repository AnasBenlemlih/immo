package com.example.demo.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.UserEntity;


@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {
	
	
	UserEntity findByEmail(String email);
	
	UserEntity findByUserId(String userId);
	
	
}
