package com.assetmanagement.asset_management.dao;

import com.assetmanagement.asset_management.entity.FixedAssets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FixedAssetDao extends JpaRepository<FixedAssets, String> {
    FixedAssets findByFaNumber(String faNumber);

}
