package com.example.restexample.restexample.controller;


import com.example.restexample.restexample.model.AccountStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountStatusService {
    private final AccountRepository accountRepository;

    public List<AccountStatus> findAll(){
        return accountRepository.findAll();
    }

    public Optional<AccountStatus> findById(String id){
        return accountRepository.findById(id);
    }

    public AccountStatus save(AccountStatus account){
        return accountRepository.save(account);
    }

    public void deleteById(String id){
        accountRepository.deleteById(id);
    }
}
