package com.service.impl;

import com.data.repository.InventoryItemRepository;
import com.domain.Product;
import com.service.InventoryService;

import java.util.Map;

public class InventoryServiceImpl implements InventoryService {
    private final InventoryItemRepository inventoryItemRepository;

    public InventoryServiceImpl(InventoryItemRepository inventoryItemRepository){
        this.inventoryItemRepository = inventoryItemRepository;
    }

    public Map<Product, Long> getTotalInventoryOnHand() {
        return null;
    }

    public long getQuantityOnHand(String itemId) {
        return 0;
    }

    public void adjustInventory(String itemId, long quantity) {

    }
}
