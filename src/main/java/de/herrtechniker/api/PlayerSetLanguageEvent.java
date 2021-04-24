package de.herrtechniker.api;

import de.herrtechniker.mysql.MySQLManager;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerSetLanguageEvent extends Event {

    public static HandlerList handlers = new HandlerList();

    private Player player;
    private String lang;

    public PlayerSetLanguageEvent(Player arg0, String arg1) {
        this.player = arg0;
        this.lang = arg1;
    }

    public Player getPlayer() {return this.player;}

    public String getLanguage() {return this.lang;}

    public void setLanguage(Player arg0, String arg1) {MySQLManager.setPlayerLanguage(arg0.getUniqueId().toString(), arg1);}

    public static HandlerList getHandlerList(){return handlers;}

    public HandlerList getHandlers() {return handlers;}
}
