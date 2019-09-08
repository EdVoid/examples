package com.example.restexample.restexample.controller;

import com.example.restexample.restexample.model.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountStatus, String > {

}
