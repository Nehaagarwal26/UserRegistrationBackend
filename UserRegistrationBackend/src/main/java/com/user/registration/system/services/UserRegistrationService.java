
package com.user.registration.system.services;

import com.user.registration.system.dtos.UserDTO;
import com.user.registration.system.exceptions.RegistrationException;

public interface UserRegistrationService {

    public void createUser(UserDTO userDTO);

    public UserDTO getUserByID(Integer id) throws RegistrationException;

    public void deleteUserByID(Integer id);

    void updateUser(UserDTO userDTO);
}
