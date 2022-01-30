package com.learning.springjpa.service;

import com.learning.springjpa.entities.UserAccount;
import com.learning.springjpa.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    private UserAccountRepository userAccountRepository;

    public void addUser(UserAccount userAccount){
        userAccountRepository.save(userAccount);
    }

    public Optional<UserAccount> fetchUser(Long id) {
        return userAccountRepository.findById(id);
    }

    public List<UserAccount> fetchAllUsers() {
        return userAccountRepository.findAll();
    }

    public UserAccount updateUser(Long id,UserAccount userAccount) {
        Optional<UserAccount> userInfoById = userAccountRepository.findById(id);
        if(userInfoById.isPresent()){
            UserAccount userAccount1 = userInfoById.get();
            userAccount1.setEmailID(userAccount.getEmailID());
            userAccount1.setContactNumber(userAccount.getContactNumber());
            userAccountRepository.save(userAccount1);
            return userAccount1;
        }else {
            userInfoById.orElse(null);
        }
        return null;
    }

    public void deleteUserById(Long id) {
        userAccountRepository.deleteById(id);
    }
}
