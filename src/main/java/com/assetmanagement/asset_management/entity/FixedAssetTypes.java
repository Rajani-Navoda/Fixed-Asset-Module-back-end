package com.assetmanagement.asset_management.entity;

import com.assetmanagement.asset_management.entity.enums.DepreciationFrequency;
import com.assetmanagement.asset_management.entity.enums.DepreciationMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "fixed_asset_types")
public class FixedAssetTypes {

  @Id
  @Column(name = "faTypeId")
  private int faTypeId;

  @Column(name = "FA_type_name")
  private String faTypeName;

  @Enumerated(EnumType.STRING)
  @Column(name = "depreciation_method")
  private DepreciationMethod depreciationMethod;

  @Enumerated(EnumType.STRING)
  @Column(name = "depreciation_frequency")
  private DepreciationFrequency depreciationFrequency;

  @Column(name = "asset_life")
  private int assetLife;

//  private String accumulatedDepreciationAccount;
//  private String depreciationExpenseAccount;

  @ManyToOne
  @JoinColumn(name = "accumulated_depreciation_account_code", referencedColumnName = "account_code")
  private Accounts accumulatedDepreciationAccount;

  @ManyToOne
  @JoinColumn(name = "depreciation_expense_account_code", referencedColumnName = "account_code")
  private Accounts depreciationExpenseAccount;

  @OneToMany(mappedBy = "fixedAssetTypes")
  private List<FixedAssets> fixedAssets;


}
