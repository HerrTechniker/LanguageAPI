package de.herrtechniker.api;

import de.herrtechniker.mysql.MySQLManager;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Event;
import org.bukkit.event.HandlerList;

public class PlayerTestEvent extends Event {

    public static HandlerList handlers = new HandlerList();

    private ProxiedPlayer player;

    public PlayerTestEvent(ProxiedPlayer arg0) {this.player = arg0;}

    public ProxiedPlayer getPlayer() {return player;}

    public void testEvento(ProxiedPlayer arg0) {MySQLManager.getPlayerLanguage(arg0.getUniqueId().toString());}

    public static HandlerList getHandlerList() {return handlers;}

    public HandlerList getHandlers() {return handlers;}
}
