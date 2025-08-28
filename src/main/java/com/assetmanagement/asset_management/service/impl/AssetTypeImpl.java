package com.assetmanagement.asset_management.service.impl;

import com.assetmanagement.asset_management.dao.AssetTypeDao;
import com.assetmanagement.asset_management.dto.AccountDTO;
import com.assetmanagement.asset_management.dto.AssetTypeDTO;
import com.assetmanagement.asset_management.dto.FixedAssetDTO;
import com.assetmanagement.asset_management.entity.Accounts;
import com.assetmanagement.asset_management.entity.FixedAssetTypes;
import com.assetmanagement.asset_management.service.AssetTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<AssetTypeDTO> getAllAssetTypes(){

        List<FixedAssetTypes> getAllFixedAssets = assetTypeDao.findAll();
        if(!getAllFixedAssets.isEmpty()){
            List<AssetTypeDTO> assetTypeDtoList = new ArrayList<>();
            for(FixedAssetTypes fixedAssetTypes: getAllFixedAssets){
                AssetTypeDTO assetTypeDTO = new AssetTypeDTO(
                                        fixedAssetTypes.getFaTypeId(),
                                        fixedAssetTypes.getFaTypeName(),
                                        fixedAssetTypes.getDepreciationMethod(),
                                        fixedAssetTypes.getDepreciationFrequency(),
                        fixedAssetTypes.getAssetLife(),
                        fixedAssetTypes.getComputationType(),
                                        fixedAssetTypes.getAccumulatedDepreciationAccount(),
                                        fixedAssetTypes.getDepreciationExpenseAccount()

                                );

                assetTypeDtoList.add(assetTypeDTO);
            }

            return assetTypeDtoList;
        }
        else {
            throw new NotFoundException("No fixed asset types found.");
        }

    }


}
