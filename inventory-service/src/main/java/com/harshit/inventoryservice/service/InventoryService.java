package com.harshit.inventoryservice.service;

import com.harshit.inventoryservice.respository.InventoryRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRespository inventoryRespository;

    public boolean isInStock(String skuCode, Integer quantity){
        // find Inventory ForGivenSkuCode Where Quantity is >= 0
        return inventoryRespository.existsBySkuCodeAndQuantityisGreaterThanEqual(skuCode, quantity);
    }

}
