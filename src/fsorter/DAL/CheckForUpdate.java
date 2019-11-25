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
import java.util.Arrays;
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
    private static String lastUsedTagv=null;
    private static String lastUsedBodyTxt=null;
    
    public static String getVersionfromURL(){
        try {
            //get JSON data
            String tagv=getTagFromUrlString(readUrl(UPDATE_URL));
            lastUsedTagv=tagv;
            LOGGER.log(Level.INFO, "latest version is: {0}", tagv);
            
            
            //remove 'v' and '.' from version number
            //int versionNumber=parseVersionNumber(tagv);
            //System.out.println(versionNumber);
            return tagv;
        } catch (Exception ex) {
            LOGGER.warning("Looking for new versions error: \n "+ex.toString());
        }
        return "a";
    }
    
    public static String getLastTagv(){
        return lastUsedTagv;
    }
    public static String getLastBodyTxt(){
        return lastUsedBodyTxt;
    }
    
    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader=null;
        try {
            reader = new BufferedReader(new InputStreamReader(new URL(urlString).openStream()));
            StringBuilder buffer = new StringBuilder();
            int read;
            //not sure why it's needed. Setting 0 or -1 results in loop
            char[] chars = new char[1];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read); 
            
            return buffer.toString();
        } finally {//always end connection
            if (reader != null)
            reader.close();
        }
    }
    
    //Gets the TAG (aka version tag) from Github URL
    private static String getTagFromUrlString(String urlData){
        JSONObject json = new JSONObject(urlData);
        // tag_name = version number in GitHub
        String versionNo=json.getString("tag_name");
        lastUsedBodyTxt=json.getString("body");
        return  versionNo.toString();
    }

    //takes Github version tag (ie. v1.8.0.1) and returns a normalized form:
    //          
    private static int parseVersionNumber(String str) {
        //remove 'v' from string
        String normalStr=str.substring(1);
        //replace all "." with nothing for comparing int with < and >
        normalStr=normalStr.replace(".","");
        
        return Integer.parseInt(normalStr);        
    }
    
    
       
    
    //return int:
    // 1 = new major version
    // 2 = new minor version
    // 3 = new patch
    // 0 = latest version installed
    public static int isNewUpdateAvailable(String localVersionStr){
        //get version from URL
        String externalVersionStr=getVersionfromURL();
        //remove 'v' from srt
        externalVersionStr=externalVersionStr.substring(1);
        
        //turn Strings into arrays
        String[] localVersionInt=localVersionStr.split("\\.");
        String[] externalVersionInt=externalVersionStr.split("\\.");
        //DEBUG PRINT:
        System.out.println(Arrays.toString(localVersionInt));
        System.out.println(Arrays.toString(externalVersionInt));

        if(Integer.parseInt(localVersionInt[0])<Integer.parseInt(externalVersionInt[0])){
            System.out.println("new major version around");
            return 1;
        }else if(Integer.parseInt(localVersionInt[1])<Integer.parseInt(externalVersionInt[1])) {
            System.out.println("new minor version around2");
            return 2;
        }else if(Integer.parseInt(localVersionInt[2])<Integer.parseInt(externalVersionInt[2])){
            System.out.println("new patch around");
            return 3;
        }else{
            return 0;
        }
    }
}
