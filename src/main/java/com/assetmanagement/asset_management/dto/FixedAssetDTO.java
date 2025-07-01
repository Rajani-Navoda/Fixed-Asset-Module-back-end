package com.assetmanagement.asset_management.dto;

import com.assetmanagement.asset_management.entity.Accounts;
import com.assetmanagement.asset_management.entity.FixedAssetTypes;
import com.assetmanagement.asset_management.entity.enums.ComputationType;
import com.assetmanagement.asset_management.entity.enums.DepreciationFrequency;
import com.assetmanagement.asset_management.entity.enums.DepreciationMethod;
import com.assetmanagement.asset_management.entity.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class FixedAssetDTO {

    private String faNumber;
    private String faName;
    private double purchaseValue;
    private LocalDate purchaseDate;
    private int serialNumber;
    private LocalDate warrantyExpDate;
    private BigDecimal currentValue;
    private double disposalValue;
    private String description;
    private FixedAssetTypes fixedAssetTypes;
    private DepreciationMethod depreciationMethod;
    private DepreciationFrequency depreciationFrequency;
    private ComputationType computationType;
    private int assetLife;
    private LocalDate depreciationStartDate;
    private Accounts faAccount;
    private Accounts accumulatedDepreciationAccount;
    private Accounts depreciationExpenseAccount;
    private String notes;
    private Status status;
}
