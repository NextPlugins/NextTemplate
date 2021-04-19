package com.nextplugins.template.view;

import com.henryfabio.minecraft.inventoryapi.inventory.impl.paged.PagedInventory;
import com.henryfabio.minecraft.inventoryapi.item.InventoryItem;
import com.henryfabio.minecraft.inventoryapi.item.supplier.InventoryItemSupplier;
import com.henryfabio.minecraft.inventoryapi.viewer.configuration.impl.ViewerConfigurationImpl;
import com.henryfabio.minecraft.inventoryapi.viewer.impl.paged.PagedViewer;
import com.nextplugins.template.util.ItemBuilder;
import lombok.val;
import org.bukkit.Material;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Henry Fabio
 * Github: https://github.com/HenryFabio
 */
public final class TemplateView extends PagedInventory {

    public TemplateView() {
        super(
                "test.inventory.paged", // Inventory identifier
                "&8PagedInventory", // Default inventory title
                9 * 5 // Size of inventory
        );

        // Method for setting up inventory characteristics (no configuration required)
        configuration(configuration -> {
            configuration.secondUpdate(1); // Set the inventory update time (don't set this if you don't want it to update automatically)
        });
    }

    /**
     * Method used to configure the viewer, where you can set
     * only the inventory title and size.
     * <p>
     * It is not mandatory to implement this method, only if you want a configuration
     * unique to each viewer.
     *
     * @param viewer inventory viewer
     */
    @Override
    protected void configureViewer(PagedViewer viewer) {

        ViewerConfigurationImpl.Paged configuration = viewer.getConfiguration();
        configuration.titleInventory("&8Your name: " + viewer.getName());

        // The inventory settings are defined automatically, only change them if you want specific modifications
        configuration.itemPageLimit(7);

    }

    /**
     * Method for setting up the items on the inventory pages.
     *
     * @param viewer inventory viewer
     * @return list of items on all pages
     */
    @Override
    protected List<InventoryItemSupplier> createPageItems(PagedViewer viewer) {
        List<InventoryItemSupplier> itemSuppliers = new LinkedList<>();

        String dirtName = viewer.getPropertyMap().get("dirtName");

        val itemStack = new ItemBuilder(Material.DIRT)
                .name(dirtName)
                .wrap();

        for (int i = 0; i < 100; i++) {
            itemSuppliers.add(() -> InventoryItem.of(itemStack));
        }

        return itemSuppliers;
    }

}
