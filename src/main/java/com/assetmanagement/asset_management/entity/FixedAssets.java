package com.assetmanagement.asset_management.entity;

import com.assetmanagement.asset_management.entity.enums.ComputationType;
import com.assetmanagement.asset_management.entity.enums.DepreciationFrequency;
import com.assetmanagement.asset_management.entity.enums.DepreciationMethod;
import com.assetmanagement.asset_management.entity.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="fixed_asset")
public class FixedAssets {


    @Id
    @Column(name= "fixed_asset_number")
    private String faNumber;

    @Column(name = "fixed_asset_name")
    private String faName;

    @Column(name = "purchase_value")
    private double purchaseValue;

    @Column(name = "purchase_date")
    @JsonFormat(pattern="dd-MM-YYYY")
    private LocalDate purchaseDate;

    @Column(name = "serial_number")
    private int serialNumber;

    @Column(name = "warranty_exp_date")
    @JsonFormat(pattern="dd-MM-YYYY")
    private LocalDate warrantyExpDate;

    @Column(name = "current_value", precision = 19, scale = 2)
    private BigDecimal currentValue;

    @Column(name = "disposal_value", precision = 19, scale = 2)
    private double disposalValue;

    @Column(name = "description", length = 255)
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "fa_Type_Id", referencedColumnName = "faTypeId")
    private FixedAssetTypes fixedAssetTypes;

    @Enumerated(EnumType.STRING)
    @Column(name = "depreciation_method")
    private DepreciationMethod depreciationMethod;

    @Enumerated(EnumType.STRING)
    @Column(name = "depreciation_frequency")
    private DepreciationFrequency depreciationFrequency;

    @Enumerated(EnumType.STRING)
    @Column(name = "computation_type")
    private ComputationType computationType;

    @Column(name = "asset_life")
    private int assetLife;

    @Column(name = "depreciation_start_date")
    @JsonFormat(pattern="dd-MM-YYYY")
    private LocalDate depreciationStartDate;


    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "fa_account_code", referencedColumnName = "account_code")
    private Accounts faAccount;

    @ManyToOne
    @JoinColumn(name = "accumulated_depreciation_account_code", referencedColumnName = "account_code")
    private Accounts accumulatedDepreciationAccount;

    @ManyToOne
    @JoinColumn(name = "depreciation_expense_account_code", referencedColumnName = "account_code")
    private Accounts depreciationExpenseAccount;

    @Column(name = "notes",length = 255)
    private String notes;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;


}
