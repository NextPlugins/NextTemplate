package com.nextplugins.template.command.registry;

import com.nextplugins.template.command.TemplateCommand;
import lombok.val;
import me.saiintbrisson.bukkit.command.BukkitFrame;
import org.bukkit.plugin.Plugin;

/**
 * @author Yuhtin
 * Github: https://github.com/Yuhtin
 */
public class CommandRegistry {

    public static void enable(Plugin instance) {

        val bukkitFrame = new BukkitFrame(instance);
        val templateCommand = new TemplateCommand();

        bukkitFrame.registerCommands(templateCommand);

    }

}
