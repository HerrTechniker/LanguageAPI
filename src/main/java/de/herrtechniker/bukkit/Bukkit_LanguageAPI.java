package de.herrtechniker.bukkit;

import de.herrtechniker.api.LanguageAPI;
import de.herrtechniker.mysql.MySQL;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Bukkit_LanguageAPI extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("[LanguageAPI] loading Plugin...");
        System.out.println("----------[ LanguageAPI ]----------");
        System.out.println(" Product: LanguageAPI");
        System.out.println(" Created By: Oliver S. -  HerrTechniker");
        PluginDescriptionFile pluginDescriptionFile = this.getDescription();
        System.out.println(" Version: " + pluginDescriptionFile.getVersion());
        System.out.println(" ");
        System.out.println(" All rights reserved by HerrTechniker");
        System.out.println("----------[ LanguageAPI ]----------");

        Bukkit_MySQLConfig mySQLFile = new Bukkit_MySQLConfig(this);
        mySQLFile.setStandard();
        mySQLFile.readData();

        MySQL.connect();
        MySQL.createPlayerLanguage();
        MySQL.createSupportedLanguage();
        MySQL.createDefaultLanguage();

        if (LanguageAPI.getDefaultLanguage() == null) {
            LanguageAPI.setDefaultLanguage("en_EN");
        }


        System.out.println("[LanguageAPI] Plugin enabled");
    }

    @Override
    public void onDisable() {
        System.out.println("[LanguageAPI] disable Plugin...");
        System.out.println("----------[ LanguageAPI ]----------");
        System.out.println(" Product: LanguageAPI");
        System.out.println("        Thank you for using");
        System.out.println("            LanguageAPI");
        System.out.println(" ");
        System.out.println(" All rights reserved by HerrTechniker");
        System.out.println("----------[ LanguageAPI ]----------");


        MySQL.disconnect();


        System.out.println("[LanguageAPI] Plugin disabled");
    }
}
