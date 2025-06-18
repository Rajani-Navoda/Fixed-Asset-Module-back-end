package com.assetmanagement.asset_management.entity;

import com.assetmanagement.asset_management.entity.enums.AccountType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Accounts")
public class Accounts {

    @Id
    @Column(name = "account_code")
    private String accountCode;

    @Column(name = "account_name")
    private String accountName;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type")
    private AccountType accountType;

    @Column(name = "is_sub_account")
    private Boolean isSubAccount;

    @Column(name = "parent_account")
    private String parentAccount;

    @Column(name = "description",length= 255)
    private String description;

    @Column(name = "is_Zoho_Expense")
    private Boolean isZohoExpense;


//    @OneToMany(mappedBy = "faAccount")
//    private List<FixedAssets> fixedAssets;

    //map the fixed assets
    @OneToMany(mappedBy = "accumulatedDepreciationAccount", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<FixedAssets> FAAccumulatedDepreciationAssetTypes;

    @OneToMany(mappedBy = "depreciationExpenseAccount", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<FixedAssets> FADepreciationExpenseAssetTypes;


    //map the fixed asset types
    @OneToMany(mappedBy = "accumulatedDepreciationAccount")
    private List<FixedAssetTypes> accumulatedDepreciationAssetTypes;

//    @OneToMany(mappedBy = "depreciationExpenseAccount")
//    private List<FixedAssetTypes> depreciationExpenseAssetTypes;

}
