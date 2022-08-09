package com.blckqplugins.api;

import cn.nukkit.Player;
import cn.nukkit.network.protocol.TransferPacket;

public class TransferAPI {

    public static boolean transferPlayer(Player player, String server){
        TransferPacket pk = new TransferPacket();
        pk.address = server;
        pk.port = 0;
        player.dataPacket(pk);
        return true;
    }
}
