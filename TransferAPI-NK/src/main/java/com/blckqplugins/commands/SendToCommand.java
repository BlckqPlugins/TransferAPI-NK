package com.blckqplugins.commands;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import com.blckqplugins.api.TransferAPI;

import java.sql.Array;

public class SendToCommand extends Command {
    public SendToCommand(String name) {
        super(name, "SendTo Command", "/sendto <server> <player (default: your name)>");
        this.setAliases(new String[]{"transferto"});
        this.setPermission("transferapi.sendto");
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {

        if (!this.testPermissionSilent(sender)){
            sender.sendMessage("§cYou don't have the permissions to execute this command.");
            return false;
        }

        String server = null;
        if (args.length > 0){
            server = args[0].toString();
        } else {
            sender.sendMessage(this.usageMessage);
            return false;
        }

        String player = null;
        if (args.length < 2){
            player = sender.getName();
        } else {
            player = args[1].toString();
        }

        Player transferPlayer = Server.getInstance().getPlayerExact(player);
        if (transferPlayer != null) {
            transferPlayer.sendMessage("§aYou will be transferred to §e" + server + "§8.");
            TransferAPI.transferPlayer(transferPlayer, server);
        } else {
            sender.sendMessage("§cThe player §e" + player + " §cis not online.");
        }
        return false;
    }
}
