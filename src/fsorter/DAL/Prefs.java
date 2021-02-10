/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fsorter.DAL;

import java.util.prefs.Preferences;

/**
 *
 * @author Jakub Rybicki <Jake at lansoftprogramming.com>
 */
public class Prefs {
    public static void savePreference(String key,String value) {
        Preferences prefs = Preferences.userNodeForPackage(Prefs.class);
        prefs.put(key,value);
    }
    public static void deletePreference(String key){
        Preferences prefs=Preferences.userNodeForPackage(Prefs.class);
        prefs.remove(key);
    }

    public static String readPreference(String key) {
        Preferences prefs = Preferences.userNodeForPackage(Prefs.class);
        return prefs.get(key, null);
    }
    
    public static String getUpdatesAtStartup(){
        Preferences prefs = Preferences.userNodeForPackage(Prefs.class);
        return prefs.get("updateAtStartup","true");
    }
    
}
