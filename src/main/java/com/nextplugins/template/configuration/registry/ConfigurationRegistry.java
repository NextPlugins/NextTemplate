package com.nextplugins.template.configuration.registry;

import com.henryfabio.minecraft.configinjector.bukkit.injector.BukkitConfigurationInjector;
import com.nextplugins.template.configuration.ConfigValue;
import org.bukkit.plugin.Plugin;

public final class ConfigurationRegistry {

    public static void enable(Plugin plugin) {
        BukkitConfigurationInjector configurationInjector = new BukkitConfigurationInjector(plugin);

        configurationInjector.saveDefaultConfiguration(
                plugin,
                "config.yml"
        );

        configurationInjector.injectConfiguration(ConfigValue.instance());
    }

}
