package de.herrtechniker.api;

import de.herrtechniker.mysql.MySQLManager;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerChangeLanguageEvent extends Event {

    public static HandlerList handlers = new HandlerList();

    private Player player;
    private String lang;

    public PlayerChangeLanguageEvent(Player arg0, String arg1) {
        this.player = arg0;
        this.lang = arg1;
    }

    public void changeLanguage(Player arg0, String arg1) {
        MySQLManager.removePlayersLanguage(arg0.getUniqueId().toString());
        MySQLManager.setPlayerLanguage(arg0.getUniqueId().toString(), arg1);
    }

    public Player getPlayer() {return this.player;}

    public String getLanguage() {return this.lang;}

    public static HandlerList getHandlerList(){return handlers;}

    public HandlerList getHandlers() {return handlers;}
}
