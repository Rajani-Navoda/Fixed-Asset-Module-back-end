package com.assetmanagement.asset_management.dto;

import com.assetmanagement.asset_management.entity.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountDTO {

    private String accountCode;

    private String accountName;

    private AccountType accountType;

    private Boolean isSubAccount;

    private String parentAccount;

    private String description;

    private Boolean isZohoExpense;

}
