package com.assetmanagement.asset_management.controller;

import com.assetmanagement.asset_management.dto.AccountDTO;
import com.assetmanagement.asset_management.service.AccountService;
import com.assetmanagement.asset_management.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/accounts")
@CrossOrigin(origins =  "http://localhost:4200")
public class AccountController {

    @Autowired
    private AccountService accountService;

    //create account
    @PostMapping(path ="/create-account")
    public ResponseEntity<StandardResponse> createNewAccount(@RequestBody AccountDTO accountDTO){
        String message = accountService.createAccount(accountDTO);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success", message), HttpStatus.CREATED
        );

    }
}
