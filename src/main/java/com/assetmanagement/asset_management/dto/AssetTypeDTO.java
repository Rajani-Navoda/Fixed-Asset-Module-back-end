package com.assetmanagement.asset_management.dto;

import com.assetmanagement.asset_management.entity.Accounts;
import com.assetmanagement.asset_management.entity.enums.ComputationType;
import com.assetmanagement.asset_management.entity.enums.DepreciationFrequency;
import com.assetmanagement.asset_management.entity.enums.DepreciationMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AssetTypeDTO {

    private int faTypeId;
    private String faTypeName;
    private DepreciationMethod depreciationMethod;
    private DepreciationFrequency depreciationFrequency;
    private int assetLife;
    private ComputationType computationType;
    private Accounts accumulatedDepreciationAccount;
    private Accounts DepreciationExpenseAccount;

}
