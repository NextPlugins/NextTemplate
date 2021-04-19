package com.nextplugins.template;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.henryfabio.minecraft.inventoryapi.manager.InventoryManager;
import com.henryfabio.sqlprovider.connector.SQLConnector;
import com.nextplugins.template.command.registry.CommandRegistry;
import com.nextplugins.template.configuration.registry.ConfigurationRegistry;
import com.nextplugins.template.guice.PluginModule;
import com.nextplugins.template.listener.registry.ListenerRegistry;
import com.nextplugins.template.placeholder.registry.PlaceholderRegistry;
import com.nextplugins.template.sql.SQLProvider;
import com.nextplugins.template.view.registry.InventoryRegistry;
import lombok.Getter;
import me.bristermitten.pdm.PluginDependencyManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class NextTemplate extends JavaPlugin {

    private Injector injector;
    private SQLConnector sqlConnector;

    @Inject private InventoryRegistry inventoryRegistry;

    @Override
    public void onLoad() {
        saveDefaultConfig();
    }

    @Override
    public void onEnable() {

        PluginDependencyManager.of(this).loadAllDependencies().exceptionally(t -> {

            t.printStackTrace();

            getLogger().severe("An error occurred while initializing the plugin!");

            Bukkit.getPluginManager().disablePlugin(this);
            return null;

        }).thenRun(() -> {

            InventoryManager.enable(this);

            this.sqlConnector = SQLProvider.of(this).setup();

            this.injector = PluginModule.of(this).createInjector();
            this.injector.injectMembers(this);

            CommandRegistry.enable(this);
            ListenerRegistry.enable(this);
            PlaceholderRegistry.enable(this);
            ConfigurationRegistry.enable(this);

            this.inventoryRegistry.init();

            this.getLogger().info("Plugin enabled successfully");

        });

    }

    public static NextTemplate getInstance() {
        return getPlugin(NextTemplate.class);
    }
}
