package com.assetmanagement.asset_management.service;

import com.assetmanagement.asset_management.dto.FixedAssetDTO;
import com.assetmanagement.asset_management.dto.GetFixedAssetsDTO;

import java.util.List;

public interface FixedAssetService {
    public  String createFixedAsset(FixedAssetDTO fixedAssetDTO);

    public List<GetFixedAssetsDTO> getAllFixedAssets();

}
