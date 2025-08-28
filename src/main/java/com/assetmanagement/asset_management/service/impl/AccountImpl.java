package com.assetmanagement.asset_management.service.impl;

import com.assetmanagement.asset_management.dao.AccountDao;
import com.assetmanagement.asset_management.dto.AccountDTO;
import com.assetmanagement.asset_management.entity.Accounts;
import com.assetmanagement.asset_management.entity.enums.AccountType;
import com.assetmanagement.asset_management.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountImpl implements AccountService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AccountDao accountDao;
    @Override
    public String createAccount(AccountDTO accountDTO) {
        try{
            Accounts accounts = modelMapper.map(accountDTO, Accounts.class);

            Accounts existingAccount = accountDao.findByAccountName(accounts.getAccountName());

            if(existingAccount != null){
                throw new RuntimeException("account with the name '" + accounts.getAccountCode() + "' already exists. ");
            }

            accountDao.save(accounts);
            return accounts.getAccountName() + " added successfully";



        }catch (Exception e){
            System.out.println("Error creating the account" + e);
            throw new RuntimeException("Failed to create the new account: " + e.getMessage(), e);
        }
    }

    @Override
    public List<AccountDTO> getAllAccounts() {
        List<Accounts> getAllAccounts = accountDao.findAll();
        if(!getAllAccounts.isEmpty()){
            List<AccountDTO> accountDTOList = new ArrayList<>();
            for(Accounts accounts: getAllAccounts){
                AccountDTO accountDTO = new AccountDTO(
                        accounts.getAccountCode(),
                        accounts.getAccountName(),
                        accounts.getAccountType(),
                        accounts.getIsSubAccount(),
                        accounts.getParentAccount(),
                        accounts.getDescription(),
                        accounts.getIsZohoExpense()
                );

                accountDTOList.add(accountDTO);


            }
            return accountDTOList;
        }

        else {
            throw new NotFoundException("Accounts not found");
        }
    }
}


