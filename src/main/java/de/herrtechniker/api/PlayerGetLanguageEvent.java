package de.herrtechniker.api;

import de.herrtechniker.mysql.MySQLManager;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerGetLanguageEvent extends Event {

    public static HandlerList handlers = new HandlerList();

    private Player player;

    public PlayerGetLanguageEvent(Player arg0) {this.player = arg0;}

    public Player getPlayer() {return player;}

    public void getLanguage(Player arg0) {MySQLManager.getPlayerLanguage(arg0.getUniqueId().toString());}

    public static HandlerList getHandlerList(){return handlers;}

    public HandlerList getHandlers() {return handlers;}
}
