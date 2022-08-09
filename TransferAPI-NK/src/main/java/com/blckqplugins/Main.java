package com.blckqplugins;

import cn.nukkit.Server;
import cn.nukkit.plugin.PluginBase;
import com.blckqplugins.commands.SendToCommand;

public class Main extends PluginBase {

    @Override
    public void onEnable() {
        Server.getInstance().getCommandMap().register("sendto", new SendToCommand("sendto"));
        getLogger().info("§aEnabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("§cDisabled.");
    }
}
