/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fsorter;

import fsorter.DAL.CheckForUpdate;
import fsorter.DAL.Prefs;
import fsorter.GUI.GuiManager;
import fsorter.GUI.WindowMain;
import fsorter.GUI.WindowNewUpdate;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javax.swing.JOptionPane;
import javax.swing.TransferHandler;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Jake Rybicki <Jake at lansoftprogramming.com>
 */
public class FSorter extends TransferHandler {
    private static final String VERSION_NO="1.0";
    private static boolean isFileDropped=false;
    private static List<File> files=null;
    private static int fileCount=0; // Counter for qty of moved files
    private static WindowMain main;

    private static final Logger LOGGER = Logger.getLogger(FSorter.class.getName());

// --------------------- SETTERS / GETTERS ---------------------
    public static void setFiles(List<File> files){
        fileCount=0;    // reset fileCount when new files dropped
        isFileDropped=true;
        LOGGER.info("file(s) dropped");

        FSorter.files=files;
        main.setJLabelInfo(files.size()+" files ready for sorting");
        LOGGER.log(Level.INFO, "{0} files ready to sort", files.size());
    }
    
    public static void setIsFileDropped(boolean boolDrop){
        isFileDropped=boolDrop;
        LOGGER.info("file(s) dropped");
    }
    // returns the contents of a folder
    public static List<File> getAllFilesFromFolder(){
        List<File> info=Arrays.asList(files.get(0).listFiles());
        return info;
    }
// -----------------------------------------------------------------------
   
    
    /** --------------------- MAIN ----------------------------------------
     * @param args the command line arguments
     * arg 0= files to sort [audio | Video | Image | Text | Archive
     *          | Docs | ALL | Etc. (MAX one selection.)
     * Arg 1 =  Name of the new folder that will be created/sorted into
     * Arg 2+ = FOLDER SORTING ONLY.(for now)
     *              Full folder name (eg. C:\info\sort)
     * Example Usage: C:\files\FSorter.jar "audio" "filesGoHereFolderName" "D:\folder\folderToSort"
     *              
     */
    public static void main(String[] args) {
        //if args exist, do not show GUI; use CMD methods
        argumentCheck(args);
                
        makeAndShowMainWindow();
        
        //start accepting dropped items
        main.setTransferHandler(new FileDropHandler());
        
        //default = check for new version at startup. Disable if unwanted
        // see if see if we should check for update at startup
        LOGGER.info("PREFS: "+Prefs.readPreference("updateAtStartup"));
        if(Prefs.readPreference("updateAtStartup")!=null){
            //checkForNewVersion();
        }else{
            checkForNewVersion();
        }

    }
    
    public static int checkForNewVersion(){
         // 0 = no update, >0 = update available
        int isNewUpdateAvailable=CheckForUpdate.isNewUpdateAvailable(VERSION_NO);
        if(isNewUpdateAvailable>0){
            //show new update GUI window
            GuiManager.printUpdateMessage(isNewUpdateAvailable);
            WindowNewUpdate mainUpdate=new WindowNewUpdate(null, true,isNewUpdateAvailable,
                CheckForUpdate.getLastBodyTxt(), CheckForUpdate.getLastTagv());
       
            mainUpdate.setVisible(true);
        }
        return isNewUpdateAvailable;
    }
    
    //checks if the program uses arguments, if so runs the CMD methods
    private static void argumentCheck(String[] args){
        LOGGER.log(Level.INFO, "Using {0} arguments", args.length);
        // If arguments used, show no GUI, and run *using cmd output*
        if(IsArgumentUsed(args)){
             WindowCmd.parseAndSortUsingCMD(args);
             System.exit(0);
        }
    }
    
    //makes the GUI, sets the look and feel and shows it
    private static void makeAndShowMainWindow() {
        //make UI Pretty
       try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | 
                IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(FSorter.class.getName()).log(Level.SEVERE, null, ex);
        }
        // make UI window
        main=new WindowMain();
        main.setVisible(true);// show the window
    }
//    private static void checkForUpdates(){
//        String latestVersionNo=CheckForUpdate.getVersionfromURL();
//        // --- debug --- check for new versions
//        //if(VERSION_NO==1);
//    }
    
    //prints the info to output for debugging purposes
    public static void echoInfo(){
        if(isFileDropped)
            for (File file: FSorter.files) {
                System.out.println(file);
                if(file.isDirectory())
                    System.out.println("is Directory");
            }
    }
    
    //main 'start' method. Will check pre requisites and call the necessary
    //      methods to sort files or folder.
    public static void startSorting(){
        // ---- File drop check ----
        if(!isFileDropped){
            LOGGER.severe("No files or folders loaded, cannot sort");
            JOptionPane.showMessageDialog(main,"No files selected. \nDrop folders"
                    + " or files into the application","No files loaded",JOptionPane.ERROR_MESSAGE);
            return;
        }
    // ---- STARTING TO SORT ----
        
        // display message to user
        main.setJLabelInfo("Sorting...");       //gui
        LOGGER.info("starting the sorting..."); //log
        
        //TODO Unneeded? 
        boolean sortFolder= fileCount==1;
        
        int sortedFiles=0;
        
    
    // use contents of folder if is a folder
        List<File>fileToSort=files;
        if(files.size()==1 && files.get(0).isDirectory())
            fileToSort=getAllFilesFromFolder();
        
    //use custom extension
        String customExt=main.getGroupSettingsSelection();
        if(main.getGroupSettingsSelection().equalsIgnoreCase("custom"))
            customExt=main.getjTxtCustom();
        
        //echoInfo();
        sortedFiles=FileSorterAI.startSorting(customExt,fileToSort,
                main.getjNewFolderLocation());
        
        
        main.setJLabelInfo(sortedFiles+" files moved");
    }
    
    
    
    //reset the app - may need to be ran after every new sort
    public static void resetApp(){
        fileCount=0;
        files=null;
        isFileDropped=false;
        main.setJLabelInfo("Drop folder");
    }

    

    
// ------------------------------- ------------------------ ----------------------- ------------------
// ------------------------------- ------------------------ ----------------------- ------------------
//
//    

    // =============================== NO GUI-CMD========================
    
    
    
    // when program starts it may start with an argument
    // Try/catch block needed due to  .isEmpty() crashing if ... its empty
    private static boolean IsArgumentUsed(String[] args) {
        // ----------------- ARGUMENT PIPE ---------------------
        // if program started using arguments...
        try{
            if(!args[0].isEmpty()){
                return true;
            }
            return true;
        }catch(Exception exc){
            return false;
        }
        
        // ------------- END ARGUMENT PIPE HANDLING ---------
    }

 

    

    
}