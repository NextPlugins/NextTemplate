package com.nextplugins.template.placeholder.registry;

import com.nextplugins.template.placeholder.PlaceholderHook;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.bukkit.plugin.Plugin;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PlaceholderRegistry {

    public static void enable(Plugin plugin) {

        PlaceholderHook placeholderHook = new PlaceholderHook(plugin);
        placeholderHook.register();

        plugin.getLogger().info("Registered placeholders successfully");

    }

}
