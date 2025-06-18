package com.assetmanagement.asset_management.service.impl;

import com.assetmanagement.asset_management.dao.AssetTypeDao;
import com.assetmanagement.asset_management.dto.AssetTypeDTO;
import com.assetmanagement.asset_management.entity.Accounts;
import com.assetmanagement.asset_management.entity.FixedAssetTypes;
import com.assetmanagement.asset_management.service.AssetTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetTypeImpl implements AssetTypeService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AssetTypeDao assetTypeDao;

    @Override
    public String createNewAssetType(AssetTypeDTO assetTypeDTO) {
        try{

            FixedAssetTypes fixedAssetType = modelMapper.map(assetTypeDTO, FixedAssetTypes.class);

            FixedAssetTypes existingFixedAsset = assetTypeDao.findByFaTypeName(fixedAssetType.getFaTypeName());

            if(existingFixedAsset != null){
                throw new RuntimeException("Fixed asset type with the name '" + fixedAssetType.getFaTypeName() + "' already exists. ");
            }

            assetTypeDao.save(fixedAssetType);
            return fixedAssetType.getFaTypeName() + " added successfully";

        }catch (Exception e){
            System.out.println("Error creating the fixed  asset Type " + e);
            throw new RuntimeException("Failed to create the fixed Asset Type: " + e.getMessage(), e);
        }
    }
}
