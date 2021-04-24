package de.herrtechniker.bungee;

import de.herrtechniker.mysql.MySQL;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Bungee_MySQLConfig {

    private Bungee_LanguageAPI plugin;

    public File mysqlFile;
    public final File dataFolder;
    public Configuration configuration;
    private final String PATH = "mysql";

    public Bungee_MySQLConfig(Bungee_LanguageAPI plugin) {
        this.dataFolder = plugin.getDataFolder();
        this.plugin = plugin;
    }


    public void setStandard() {
        this.mysqlFile = new File(plugin.getDataFolder().getPath(), "mysql.yml");
        try {
            if (!plugin.getDataFolder().exists()) {
                plugin.getDataFolder().mkdir();
            }
            if (!mysqlFile.exists()) {
                mysqlFile.createNewFile();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(mysqlFile);
            if (!configuration.contains(PATH)) {
                configuration.set(PATH + ".HOST", "localhost");
                configuration.set(PATH + ".PORT", "3306");
                configuration.set(PATH + ".DATABASE", "database");
                configuration.set(PATH + ".USER", "root");
                configuration.set(PATH + ".PASSWORD", "password");
                ConfigurationProvider.getProvider(YamlConfiguration.class).save(configuration, mysqlFile);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readData() {
        try {
            ConfigurationProvider.getProvider(YamlConfiguration.class).load(mysqlFile);
        }catch (IOException e) {
            e.printStackTrace();
        }

        MySQL.HOST = configuration.getString(PATH + ".HOST");
        MySQL.PORT = configuration.getString(PATH + ".PORT");
        MySQL.DATABASE = configuration.getString(PATH + ".DATABASE");
        MySQL.USER = configuration.getString(PATH + ".USER");
        MySQL.PASSWORD = configuration.getString(PATH + ".PASSWORD");

    }

    public Configuration getConfiguration() {return configuration;}

    public File getMysqlFile() {return mysqlFile;}
}
