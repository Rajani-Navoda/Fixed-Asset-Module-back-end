package com.assetmanagement.asset_management.service.impl;

import com.assetmanagement.asset_management.dao.FixedAssetDao;
import com.assetmanagement.asset_management.dto.FixedAssetDTO;
import com.assetmanagement.asset_management.dto.GetFixedAssetsDTO;
import com.assetmanagement.asset_management.entity.FixedAssets;
import com.assetmanagement.asset_management.service.FixedAssetService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FixedAssetImpl implements FixedAssetService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    FixedAssetDao fixedAssetdao;


    @Override
    public String createFixedAsset(FixedAssetDTO fixedAssetDTO) {

        try{

            FixedAssets fixedAssets = modelMapper.map(fixedAssetDTO, FixedAssets.class);


            FixedAssets existingFixedAsset = fixedAssetdao.findByFaNumber(fixedAssets.getFaNumber());

            if(existingFixedAsset != null){
                throw new RuntimeException("Fixed asset type with the name '" + fixedAssets.getFaNumber() + "' already exists. ");
            }

            fixedAssetdao.save(fixedAssets);

            return fixedAssets.getFaNumber() + " added successfully";

        }catch (Exception e){
            System.out.println("Error creating the fixed  asset Type " + e);
            throw new RuntimeException("Failed to create the fixed Asset Type: " + e.getMessage(), e);
        }
    }

    @Override
    public List<GetFixedAssetsDTO> getAllFixedAssets() {

        List<FixedAssets> getAllFixedAssets = fixedAssetdao.findAll();
        if(!getAllFixedAssets.isEmpty()){
            List<GetFixedAssetsDTO> getFixedAssetsDTOS = new ArrayList<>();

            for(FixedAssets fixedAssets: getAllFixedAssets){
                GetFixedAssetsDTO getFixedAssetsDTO = new GetFixedAssetsDTO(
                        fixedAssets.getFaNumber(),
                        fixedAssets.getFaName(),
                        fixedAssets.getPurchaseValue(),
                        fixedAssets.getCurrentValue(),
                        fixedAssets.getFixedAssetTypes(),
                        fixedAssets.getStatus()

                );
                getFixedAssetsDTOS.add(getFixedAssetsDTO);
            }
            return getFixedAssetsDTOS;
        }
        else{
            throw new NotFoundException("No fixed assets found");
        }

    }


}
