package de.herrtechniker.bukkit;


import de.herrtechniker.mysql.MySQL;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Bukkit_MySQLConfig {

    public File mysqlFile;
    public final File dataFolder;
    public FileConfiguration configuration;
    private final String PATH = "mysql";

    public Bukkit_MySQLConfig(Bukkit_LanguageAPI plugin) {this.dataFolder = plugin.getDataFolder();}

    public void setStandard() {
        this.mysqlFile = new File(this.dataFolder, "mysql.yml");
        this.configuration = new YamlConfiguration();
        if (!this.dataFolder.exists()) {
            this.dataFolder.mkdir();
        }
        try {
            if (!this.mysqlFile.exists()) {
                this.mysqlFile.createNewFile();

                this.configuration.load(this.mysqlFile);

                configuration.set(PATH + ".HOST", "localhost");
                configuration.set(PATH + ".PORT", "3306");
                configuration.set(PATH + ".DATABASE", "database");
                configuration.set(PATH + ".USER", "root");
                configuration.set(PATH + ".PASSWORD", "password");

                this.configuration.save(this.mysqlFile);
            }
        }catch (IOException|InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    private File getFile() {return new File("plugins/MySQL", "mysql.yml");}


    public void readData() {
        try {
            this.configuration.load(this.mysqlFile);
        }catch (IOException| InvalidConfigurationException e) {
            e.printStackTrace();
        }

        MySQL.HOST = configuration.getString(PATH + ".HOST");
        MySQL.PORT = configuration.getString(PATH + ".PORT");
        MySQL.DATABASE = configuration.getString(PATH + ".DATABASE");
        MySQL.USER = configuration.getString(PATH + ".USER");
        MySQL.PASSWORD = configuration.getString(PATH + ".PASSWORD");
    }

    public FileConfiguration getConfiguration() {return configuration;}

    public File getMysqlFile() {return mysqlFile;}
}
