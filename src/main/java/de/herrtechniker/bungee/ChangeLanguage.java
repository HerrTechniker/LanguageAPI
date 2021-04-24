package de.herrtechniker.bungee;

import de.herrtechniker.api.LanguageAPI;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.TabExecutor;

import java.util.ArrayList;
import java.util.List;

public class ChangeLanguage extends Command implements TabExecutor {

    public ChangeLanguage(String name) {super(name);}

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) sender;
            if (args.length == 0) {
                if (LanguageAPI.getPlayerLanguage(player.getUniqueId().toString()).equals("en_EN") || LanguageAPI.getPlayerLanguage(player.getUniqueId().toString()) == null) {
                    player.sendMessage("§7[§6Language§7] §cPlease use: §6/setlanguage <english/deutsch>");
                }else if (LanguageAPI.getPlayerLanguage(player.getUniqueId().toString()).equals("de_DE")) {
                    player.sendMessage("§7[§6Language§7] §cBitte nutze: §6/setlanguage <english/deutsch>");
                }
            }else if (args.length == 1) {
                if (LanguageAPI.getPlayerLanguage(player.getUniqueId().toString()) != null) {
                    if (args[0].equalsIgnoreCase("english")) {
                        LanguageAPI.changePlayerLanguage(player.getUniqueId().toString(), "en_EN");
                        if (LanguageAPI.getPlayerLanguage(player.getUniqueId().toString()).equals("en_EN") || LanguageAPI.getPlayerLanguage(player.getUniqueId().toString()) == null) {
                            player.sendMessage("§7[§6Language§7] §aYou have successful changed your Player-Language!");
                        }else if (LanguageAPI.getPlayerLanguage(player.getUniqueId().toString()).equals("de_DE")) {
                            player.sendMessage("§7[§6Language§7] §aDu hast erfolgreich deine Spieler-Sprache geändert!");
                        }
                    }else if (args[0].equalsIgnoreCase("deutsch")) {
                        LanguageAPI.changePlayerLanguage(player.getUniqueId().toString(), "de_DE");if (LanguageAPI.getPlayerLanguage(player.getUniqueId().toString()).equals("en_EN") || LanguageAPI.getPlayerLanguage(player.getUniqueId().toString()) == null) {
                            player.sendMessage("§7[§6Language§7] §aYou have successful changed your Player-Language!");
                        }else if (LanguageAPI.getPlayerLanguage(player.getUniqueId().toString()).equals("de_DE")) {
                            player.sendMessage("§7[§6Language§7] §aDu hast erfolgreich deine Spieler-Sprache geändert!");
                        }
                    }
                }else {
                    if (args[0].equalsIgnoreCase("english")) {
                        LanguageAPI.setPlayerLanguage(player.getUniqueId().toString(), "en_EN");
                        if (LanguageAPI.getPlayerLanguage(player.getUniqueId().toString()).equals("en_EN") || LanguageAPI.getPlayerLanguage(player.getUniqueId().toString()) == null) {
                            player.sendMessage("§7[§6Language§7] §aYou have successful changed your Player-Language!");
                        } else if (LanguageAPI.getPlayerLanguage(player.getUniqueId().toString()).equals("de_DE")) {
                            player.sendMessage("§7[§6Language§7] §aDu hast erfolgreich deine Spieler-Sprache geändert!");
                        }
                    }else if (args[0].equalsIgnoreCase("deutsch")) {
                        LanguageAPI.setPlayerLanguage(player.getUniqueId().toString(), "de_DE");
                        if (LanguageAPI.getPlayerLanguage(player.getUniqueId().toString()).equals("en_EN") || LanguageAPI.getPlayerLanguage(player.getUniqueId().toString()) == null) {
                            player.sendMessage("§7[§6Language§7] §aYou have successful changed your Player-Language!");
                        } else if (LanguageAPI.getPlayerLanguage(player.getUniqueId().toString()).equals("de_DE")) {
                            player.sendMessage("§7[§6Language§7] §aDu hast erfolgreich deine Spieler-Sprache geändert!");
                        }
                    }
                }
            }else {
                if (LanguageAPI.getPlayerLanguage(player.getUniqueId().toString()).equals("en_EN") || LanguageAPI.getPlayerLanguage(player.getUniqueId().toString()) == null) {
                    player.sendMessage("§7[§6Language§7] §cPlease use: §6/setlanguage <english/deutsch>");
                }else if (LanguageAPI.getPlayerLanguage(player.getUniqueId().toString()).equals("de_DE")) {
                    player.sendMessage("§7[§6Language§7] §cBitte nutze: §6/setlanguage <english/deutsch>");
                }
            }
        }else {
            sender.sendMessage("[LanguageAPI] You have to be a Player");
        }
    }

    @Override
    public Iterable<String> onTabComplete(CommandSender sender, String[] args) {
        List<String> list = new ArrayList<>();
        if (args.length == 1) {
            list.add("english");
            list.add("deutsch");
        }
        return list;
    }
}
