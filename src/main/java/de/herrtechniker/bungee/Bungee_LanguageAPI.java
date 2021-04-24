package de.herrtechniker.bungee;

import de.herrtechniker.api.LanguageAPI;
import de.herrtechniker.mysql.MySQL;
import de.herrtechniker.mysql.MySQLManager;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public class Bungee_LanguageAPI extends Plugin {

    private MySQLManager manager = new MySQLManager();


    @Override
    public void onEnable() {
        System.out.println("[LanguageAPI] loading Plugin...");
        System.out.println("----------[ LanguageAPI ]----------");
        System.out.println(" Product: LanguageAPI");
        System.out.println(" Created By: Oliver S. -  HerrTechniker");
        System.out.println(" ");
        System.out.println(" All rights reserved by HerrTechniker");
        System.out.println("----------[ LanguageAPI ]----------");

        Bungee_MySQLConfig mySQLFile = new Bungee_MySQLConfig(this);
        mySQLFile.setStandard();
        mySQLFile.readData();

        MySQL.connect();
        MySQL.createPlayerLanguage();
        MySQL.createSupportedLanguage();
        MySQL.createDefaultLanguage();

        ProxyServer.getInstance().getPluginManager().registerCommand(this, new ChangeLanguage("setlanguage"));
        

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

    public static LanguageAPI getLanguageAPI() {return new LanguageAPI();}
}
