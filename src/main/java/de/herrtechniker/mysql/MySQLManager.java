package de.herrtechniker.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLManager {

    /*
     *
     *
     * set player language
     *
     *
     * */

    public static void setPlayerLanguage(String uuid, String language) {
        MySQL.update("INSERT INTO player_language (uuid,language) VALUES ('" + uuid + "','" + language + "')");
    }

    /*
     *
     *
     * change player language
     *
     *
     * */

    public static void changePlayerLanguage(String uuid, String language) {
        MySQL.update("UPDATE player_language SET language='" + language + "' WHERE uuid='" + uuid + "'");
    }

    /*
     *
     *
     * remove player language
     *
     *
     * */

    public static void removePlayersLanguage(String uuid) {
        MySQL.update("DELETE FROM player_language WHERE uuid='" + uuid + "'");
    }

    /*
     *
     *
     * has player language
     *
     *
     * */

    public static boolean hasPlayerLanguage(String uuid) {
        ResultSet resultSet = MySQL.getResult("SELECT language FROM player_language WHERE uuid='" + uuid + "'");
        try {
            return resultSet.next();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /*
     *
     *
     * get player language
     *
     *
     * */

    public static String getPlayerLanguage(String uuid) {
        ResultSet resultSet = MySQL.getResult("SELECT language FROM player_language WHERE uuid='" + uuid + "'");
        try {
            if (resultSet.next()) {
                return resultSet.getString("language");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /*
     *
     *
     * get supported languages
     *
     *
     * */

    public static boolean getSupportedLanguages(String language) {
        ResultSet resultSet = MySQL.getResult("SELECT * FROM supported_languages WHERE languages='" + language + "'");
        try {
            return resultSet.next();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /*
     *
     *
     * set supported languages
     *
     *
     * */

    public static void addSupportedLanguages(String language) {
        MySQL.update("INSERT INTO supported_languages (languages) VALUES ('" + language + "')");
    }

    /*
     *
     *
     * remove supported languages
     *
     *
     * */

    public static void removeSupportedLanguages(String language) {
        MySQL.update("DELETE FROM supported_languages WHERE languages='" + language + "'");
    }

    /*
     *
     *
     * set Default Language
     *
     *
     * */

    public static void setDefaultLanguage(String defaultlanguage) {
        if (MySQL.getResult("SELECT COUNT(*) FROM default_language") == null) {
            MySQL.update("INSERT INTO default_language (defaultlanguage) VALUES ('" + defaultlanguage + "')");
        }else {
            removeDefaultLanguage();
            MySQL.update("INSERT INTO default_language (defaultlanguage) VALUES ('" + defaultlanguage + "')");
        }
    }

    /*
     *
     *
     * set Default Language
     *
     *
     * */

    public static void changeDefaultLanguage(String defaultlanguage) {
        MySQL.update("UPDATE default_language SET defaultlanguage='" + defaultlanguage + "'");
    }

    /*
     *
     *
     * remove supported languages
     *
     *
     * */

    public static void removeDefaultLanguage() {
        MySQL.update("DELETE FROM default_language");
    }

    /*
     *
     *
     * get Default Language
     *
     *
     * */

    public static String getDefaultLanguage() {
        ResultSet resultSet = MySQL.getResult("SELECT defaultlanguage FROM default_language");
        try {
            if (resultSet.next()) {
                return resultSet.getString("defaultlanguage");
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
