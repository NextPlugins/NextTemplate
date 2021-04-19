package com.nextplugins.template.listener.registry;

import com.nextplugins.template.listener.UserConnectionListener;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import java.util.logging.Logger;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ListenerRegistry {

    public static void enable(Plugin plugin) {

        Logger logger = plugin.getLogger();
        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(
                new UserConnectionListener(),
                plugin
        );

        logger.info("Listeners registered successfully");
    }

}
