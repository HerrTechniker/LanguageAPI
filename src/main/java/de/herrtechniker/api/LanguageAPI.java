package de.herrtechniker.api;

import de.herrtechniker.bukkit.Bukkit_LanguageAPI;
import de.herrtechniker.bungee.Bungee_LanguageAPI;
import de.herrtechniker.exception.DefaultLanguageNotExistsException;
import de.herrtechniker.exception.IncorrectLanguageNameException;
import de.herrtechniker.exception.LanguageAlreadyExistsException;
import de.herrtechniker.exception.LanguageNotExistsException;
import de.herrtechniker.mysql.MySQL;
import de.herrtechniker.mysql.MySQLManager;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LanguageAPI {

    public static void setPlayerLanguage(String uuid, String language) {
        try {
            if (MySQLManager.getSupportedLanguages(language)) {
                MySQLManager.setPlayerLanguage(uuid, language);
            }
        }catch (IncorrectLanguageNameException e) {
            System.out.println(e.toString());
        }
    }

    public static String getPlayerLanguage(String uuid) {
        String language = null;
        if (MySQLManager.getPlayerLanguage(uuid) != null) {
            language = MySQLManager.getPlayerLanguage(uuid);
        }else {
            try {
                String defaultlanguage = MySQLManager.getDefaultLanguage();
                MySQLManager.setPlayerLanguage(uuid, defaultlanguage);
                language = MySQLManager.getPlayerLanguage(uuid);
            }catch (DefaultLanguageNotExistsException e) {
                System.out.println(e.toString());
            }
        }
        return language;
    }

    public static void changePlayerLanguage(String uuid, String language) {
        if (MySQLManager.getPlayerLanguage(uuid) != null) {
            MySQLManager.changePlayerLanguage(uuid, language);
        }else {
            try {
                String defaultlanguage = MySQLManager.getDefaultLanguage();
                MySQLManager.setPlayerLanguage(uuid, defaultlanguage);
            }catch (DefaultLanguageNotExistsException e) {
                System.out.println(e.toString());
            }
        }
    }

    public static void removeSupportedLanguage(String language) {
        try {
            MySQLManager.removeSupportedLanguages(language);
        }catch (LanguageNotExistsException e) {
            System.out.println(e.toString());
        }
    }

    public static void addSupportedLanguage(String language) {
        try {
            MySQLManager.addSupportedLanguages(language);
        }catch (LanguageAlreadyExistsException e) {
            System.out.println(e.toString());
        }
    }

    public static boolean getSupportedLanguage(String language) {
        ResultSet resultSet = MySQL.getResult("SELECT * FROM supported_languages WHERE languages='" + language + "'");
        try {
            return resultSet.next();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public static void setDefaultLanguage(String defaultLanguage) {
        if (MySQLManager.getDefaultLanguage() == null) {
            MySQLManager.setDefaultLanguage(defaultLanguage);
        }else {
            MySQLManager.changeDefaultLanguage(defaultLanguage);
        }
    }

    public static String getDefaultLanguage() {
        String defaultLanguage = null;
        try {
            defaultLanguage = MySQLManager.getDefaultLanguage();
        }catch (DefaultLanguageNotExistsException e) {
            e.printStackTrace();
        }
        return defaultLanguage;
    }

    public static void changeDefaultLanguage(String defdefaultLanguage) {
        try {
            MySQLManager.changeDefaultLanguage(defdefaultLanguage);
        }catch (DefaultLanguageNotExistsException e) {
            System.out.println(e.toString());
        }
    }

    public static String getMessageBukkit(String playerUUID, String path, Bukkit_LanguageAPI plugin) {
        String language = getPlayerLanguage(playerUUID);
        File file = new File("plugins/" + plugin + "/messages/" + language + ".yml");
        if (!file.exists()) {
            String defaultLanguage = getDefaultLanguage();
            file = new File("plugins/" + plugin + "/messages/" + defaultLanguage + ".yml");
            if (!file.exists()) {
                return null;
            }
        }
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
        String message = yamlConfiguration.getString(path);
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static String getMessageBungee(String playerUUID, String path, Bungee_LanguageAPI plugin) throws IOException {
        String language = getPlayerLanguage(playerUUID);
        File file = new File("plugins/" + plugin + "/messages/" + language + ".yml");
        if (!file.exists()) {
            String defaultLanguage = getDefaultLanguage();
            file = new File("plugins/" + plugin + "/messages/" + defaultLanguage + ".yml");
            if (!file.exists()) {
                return null;
            }
        }
        Configuration configuration = ConfigurationProvider.getProvider(net.md_5.bungee.config.YamlConfiguration.class).load(file);
        String message = configuration.getString(path);
        return net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', message);
    }

}
