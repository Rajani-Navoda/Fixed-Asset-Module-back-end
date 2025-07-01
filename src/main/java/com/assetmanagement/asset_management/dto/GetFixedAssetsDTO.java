package com.assetmanagement.asset_management.dto;

import com.assetmanagement.asset_management.entity.Accounts;
import com.assetmanagement.asset_management.entity.FixedAssetTypes;
import com.assetmanagement.asset_management.entity.FixedAssets;
import com.assetmanagement.asset_management.entity.enums.ComputationType;
import com.assetmanagement.asset_management.entity.enums.DepreciationFrequency;
import com.assetmanagement.asset_management.entity.enums.DepreciationMethod;
import com.assetmanagement.asset_management.entity.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GetFixedAssetsDTO {


    private String faNumber;

    private String faName;

    private double purchaseValue;

    private BigDecimal currentValue;

    private FixedAssetTypes fixedAssetTypes;

    private Status status;

}
