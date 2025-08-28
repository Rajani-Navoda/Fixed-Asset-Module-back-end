package com.assetmanagement.asset_management.service;

import com.assetmanagement.asset_management.dto.AssetTypeDTO;

import java.util.List;

public interface AssetTypeService {

    public String createNewAssetType(AssetTypeDTO assetTypeDTO);

    public List<AssetTypeDTO> getAllAssetTypes();
}
