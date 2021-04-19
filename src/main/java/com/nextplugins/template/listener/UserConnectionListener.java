package com.nextplugins.template.listener;

import com.nextplugins.template.configuration.ConfigValue;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * @author Yuhtin
 * Github: https://github.com/Yuhtin
 */
public class UserConnectionListener implements Listener {

    @EventHandler
    public void onGreeting(PlayerJoinEvent event) {
        event.setJoinMessage(ConfigValue.get(ConfigValue::greeting)
                .replace("$player", event.getPlayer().getName())
        );
    }

}
