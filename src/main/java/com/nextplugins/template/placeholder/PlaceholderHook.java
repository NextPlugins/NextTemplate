package com.nextplugins.template.placeholder;

import com.nextplugins.template.configuration.ConfigValue;
import lombok.RequiredArgsConstructor;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

@RequiredArgsConstructor
public final class PlaceholderHook extends PlaceholderExpansion {

    private final Plugin plugin;

    @Override
    public @NotNull String getIdentifier() {
        return plugin.getName();
    }

    @Override
    public @NotNull String getAuthor() {
        return "NextPlugins";
    }

    @Override
    public @NotNull String getVersion() {
        return plugin.getDescription().getVersion();
    }

    @Override
    public String onPlaceholderRequest(Player player, @NotNull String params) {

        if (params.equalsIgnoreCase("example")) return ConfigValue.get(ConfigValue::placeholder);
        return "Invalid placeholder";

    }

}
