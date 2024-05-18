package com.harshit.inventoryservice.respository;

import com.harshit.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRespository extends JpaRepository<Inventory, Long> {

    boolean existsBySkuCodeAndQuantityisGreaterThanEqual(String skuCode, Integer quantity);
}
