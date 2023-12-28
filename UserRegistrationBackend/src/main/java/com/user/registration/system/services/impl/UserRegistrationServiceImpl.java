package com.user.registration.system.services.impl;

import com.user.registration.system.dtos.UserDTO;
import com.user.registration.system.entities.UserEntity;
import com.user.registration.system.exceptions.RegistrationException;
import com.user.registration.system.repositories.UserRegistrationRepository;
import com.user.registration.system.services.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

    @Autowired
    private UserRegistrationRepository userRegistrationRepository;

    @Override
    public void createUser(UserDTO userDTO) {
        UserEntity userEntity = UserEntity.builder()
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .build();
        this.userRegistrationRepository.save(userEntity);
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        UserEntity userEntity = UserEntity.builder()
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .build();
        this.userRegistrationRepository.save(userEntity);
    }

    @Override
    public UserDTO getUserByID(Integer id) throws RegistrationException {
       Optional<UserEntity> userEntityOptional = this.userRegistrationRepository.findById(id);
       if(!userEntityOptional.isPresent()){
            throw new RegistrationException("User is not found in database with id"+ id);
       }

       UserEntity userEntity = userEntityOptional.get();
       return UserDTO.builder()
               .username(userEntity.getUsername())
               .password(userEntity.getPassword())
               .build();
    }

    @Override
    public void deleteUserByID(Integer id) {
        this.userRegistrationRepository.deleteById(id);
    }
}
