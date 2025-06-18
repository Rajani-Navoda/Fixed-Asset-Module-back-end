package com.assetmanagement.asset_management.dao;

import com.assetmanagement.asset_management.entity.FixedAssetTypes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetTypeDao extends JpaRepository<FixedAssetTypes,Integer> {
    FixedAssetTypes findByFaTypeName(String faTypeName);

}
