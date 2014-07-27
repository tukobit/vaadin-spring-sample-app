package com.example.rapid;

import org.springframework.data.repository.CrudRepository;

import com.example.rapid.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
