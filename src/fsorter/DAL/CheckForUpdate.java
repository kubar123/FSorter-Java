/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fsorter.DAL;

import fsorter.FSorter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.*;





/**
 *
 * @author Jakub Rybicki <Jake at lansoftprogramming.com>
 */
public class CheckForUpdate {
    // test URL TODO: change to FSorter Git URL
    private static final String UPDATE_URL="https://api.github.com/repos/kubar123/magneticKelp/releases/latest";
    private static final Logger LOGGER = Logger.getLogger(FSorter.class.getName());
    
    public static String getVersionfromURL(){
        try {
            //get JSON data
            String tagv=getTagFromUrlString(readUrl(UPDATE_URL));
            LOGGER.log(Level.INFO, "latest version found: {0}", tagv);
            
            //remove 'v' from version number
            //return tagv.substring(1);
            
        } catch (Exception ex) {
            LOGGER.warning("Looking for new versions error: \n "+ex.toString());
        }
        return "a";
    }
    
    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader=null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder buffer = new StringBuilder();
            int read;
            char[] chars = new char[1];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read); 

            return buffer.toString();
        } finally {
            if (reader != null)
            reader.close();
        }
    }
    
    private static String getTagFromUrlString(String urlData){
        JSONObject json = new JSONObject(urlData);
        // tag_name = version number in GitHub
        String versionNo=json.getString("tag_name");
        return  versionNo.toString();
    }
}
