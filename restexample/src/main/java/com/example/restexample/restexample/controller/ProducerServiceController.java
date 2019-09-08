package com.example.restexample.restexample.controller;


import com.example.restexample.restexample.model.AccountStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/give/me/aml/stuff")
@Slf4j
@RequiredArgsConstructor
public class ProducerServiceController {
    private final AccountStatusService accountService;

    @GetMapping
    public ResponseEntity<List<AccountStatus>> findAll(){
        return ResponseEntity.ok((accountService.findAll()));
    }

    @RequestMapping(value ="/mirrorme/{accountid}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getAMLstuff(@PathVariable("accountid") String accountid){
        Map response = new HashMap<>();
        response.put("accountid", accountid);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountStatus> findById(@PathVariable String id){
        Optional<AccountStatus> account = accountService.findById(id);
        if(!account.isPresent()){
            log.error("Id" + id + "does not exist");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(account.get());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody AccountStatus account){
        return ResponseEntity.ok(accountService.save(account));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountStatus> update(@PathVariable String id, @Valid @RequestBody AccountStatus account){
        if(!accountService.findById(id).isPresent()){
            log.error("Id" + id + "does not exist");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(accountService.save(account));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id){
        if(!accountService.findById(id).isPresent()){
            log.error("Id" + id + "does not exist");
            return ResponseEntity.badRequest().build();
        }
        accountService.deleteById(id);
        accountService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
