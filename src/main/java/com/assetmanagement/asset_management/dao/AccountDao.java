package com.assetmanagement.asset_management.dao;

import com.assetmanagement.asset_management.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDao extends JpaRepository<Accounts, String> {

    Accounts findByAccountName(String accountName);
}
