package com.user.registration.system.repositories;

import com.user.registration.system.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRegistrationRepository extends CrudRepository<UserEntity, Integer> {
}
