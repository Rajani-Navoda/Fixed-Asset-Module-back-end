package com.assetmanagement.asset_management.controller;

import com.assetmanagement.asset_management.dto.AssetTypeDTO;
import com.assetmanagement.asset_management.dto.GetFixedAssetsDTO;
import com.assetmanagement.asset_management.service.AssetTypeService;
import com.assetmanagement.asset_management.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/Asset-Types")
@CrossOrigin(origins = "http://localhost:4200")
public class AssetTypeController {
    @Autowired
    private AssetTypeService assetTypeService;


    @PostMapping("/create-asset-type")
    public ResponseEntity<StandardResponse> createNewAssetType(@RequestBody AssetTypeDTO assetTypeDTO){
        String message = assetTypeService.createNewAssetType(assetTypeDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success", message), HttpStatus.CREATED
        );
    }

    @GetMapping(
            path = "/get-all-asset-types"
    )

    public List<AssetTypeDTO> getAllAssetTypes(){

        List<AssetTypeDTO> allAssetTypes = assetTypeService.getAllAssetTypes();
        return allAssetTypes;
    }

}
