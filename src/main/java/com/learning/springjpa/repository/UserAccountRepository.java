package com.learning.springjpa.repository;

import com.learning.springjpa.entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserAccountRepository extends JpaRepository<UserAccount,Long> {
}
