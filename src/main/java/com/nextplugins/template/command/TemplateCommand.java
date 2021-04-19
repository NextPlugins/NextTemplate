package com.nextplugins.template.command;

import com.google.inject.Inject;
import com.nextplugins.template.configuration.ConfigValue;
import com.nextplugins.template.util.ColorUtil;
import com.nextplugins.template.view.registry.InventoryRegistry;
import lombok.val;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import me.saiintbrisson.minecraft.command.target.CommandTarget;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author Yuhtin
 * Github: https://github.com/Yuhtin
 */
public class TemplateCommand {

    @Inject private InventoryRegistry inventoryRegistry;

    @Command(
            name = "example",
            permission = "test.admin",
            description = "Example of command",
            target = CommandTarget.ALL,
            usage = "example <player>",
            async = true
    )
    public void onExampleCommand(Context<CommandSender> context,
                                 OfflinePlayer player) {

        if (!player.isOnline()) {

            context.sendMessage(ColorUtil.colored("&cThis players is currently offline."));
            return;

        }

        player.getPlayer().sendMessage(ColorUtil.colored(
                "&aYou received an example from " + context.getSender().getName(),
                "&aExample: &f" + ConfigValue.get(ConfigValue::example)
        ));

        context.sendMessage(ColorUtil.colored("&aYou sent a example to " + player.getName()));

    }

    @Command(
            name = "templateinventory",
            aliases = {"ti", "templateinv"},
            target = CommandTarget.PLAYER
    )
    public void onTemplateInventoryCommand(Context<Player> context) {

        val templateView = inventoryRegistry.getTemplateView();

        templateView.openInventory(
                context.getSender(),
                viewer -> viewer.getPropertyMap().set("dirtName", "&aEspecial Dirt")
        );

    }

}
