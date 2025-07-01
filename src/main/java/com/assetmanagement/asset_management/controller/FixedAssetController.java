package com.assetmanagement.asset_management.controller;

import com.assetmanagement.asset_management.dto.FixedAssetDTO;
import com.assetmanagement.asset_management.dto.GetFixedAssetsDTO;
import com.assetmanagement.asset_management.service.FixedAssetService;
import com.assetmanagement.asset_management.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/fixed-Assets")
@CrossOrigin(origins = "http://localhost:4200")
public class FixedAssetController {

    @Autowired
    private FixedAssetService fixedAssetService;

    @PostMapping(
            path = "/create-fixed-asset"
    )
    public ResponseEntity<StandardResponse> createFixedAsset(@RequestBody FixedAssetDTO fixedAssetDTO){
        String message = fixedAssetService.createFixedAsset(fixedAssetDTO);
        return new ResponseEntity<>(new StandardResponse(201, "Success", fixedAssetDTO),
                HttpStatus.CREATED);
    }

    @GetMapping(
            path = "/get-all-fixed-Assets"
    )

    public List<GetFixedAssetsDTO> getAllFixedAssets(){

        List<GetFixedAssetsDTO> allFixedAssets = fixedAssetService.getAllFixedAssets();
        return  allFixedAssets;
    }
}
