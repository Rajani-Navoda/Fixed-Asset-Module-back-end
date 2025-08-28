package com.assetmanagement.asset_management.service;

import com.assetmanagement.asset_management.dto.AccountDTO;

import java.util.List;

public interface AccountService {

    public String createAccount(AccountDTO accountDTO);

    public List<AccountDTO> getAllAccounts();
}
