/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fsorter;

//import static fsorter.FSorter.files;
import fsorter.ExtManager.Extensions;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jake Rybicki <Jake at lansoftprogramming.com>
 */
public class FileSorterAI {
    private static final Logger LOGGER = Logger.getLogger(FSorter.class.getName());
    
    private static int sortedFiles=0;

    public static int getSortedFiles() {
        return sortedFiles;
    }

    public static void setSortedFiles(int sortedFiles) {
        FileSorterAI.sortedFiles = sortedFiles;
    }
    
    public static void resetFileCount(){
        sortedFiles=0;
    }
    
    /**
     * 
     * 
     * @param selectedSorting
     * @param files
     * @param newFolderName 
     * @return  int: total number of files sorted
     */
     public static int startSorting(String selectedSorting, List<File> files,String newFolderName) {
         System.out.println(files.toString());
         
         for(File file:files){

//  skip folders (they have no extension -  would crash).
            if(file.isDirectory())
                continue;
            //-------
           
        //not a folder, get extension
            String fileExt=getExtension(file);
                
            switch (selectedSorting.toLowerCase()){
                case "audio":
                    sortAudio(file, newFolderName, fileExt);
                    break;

                case "video":
                    sortVideo(file, newFolderName, fileExt);
                    break;
                   
                case "image":
                    sortImage(file, newFolderName, fileExt);
                    break;
                
                case "text":
                    sortText(file, newFolderName, fileExt);
                     break;
                
                case "archive":
                    sortArchive(file, newFolderName, fileExt);
                    break;
                    
                case "docs":
                    sortDocs(file,newFolderName,fileExt);
                    break;
                    
                // ------------- DEFAULT /// CUSTOM ---------------
                default:
                    if(selectedSorting.equalsIgnoreCase(fileExt)){
                        moveFileToNewFolder(file,newFolderName);
                        sortedFiles++;
                    }
                    break;
                // --------------------- ALL ------------------------
                case "all":
                    sortAudio(file, newFolderName+"-Audio", fileExt);
                    sortVideo(file, newFolderName+"-Video", fileExt);
                    sortImage(file, newFolderName+"-Image", fileExt);
                    sortText(file, newFolderName+"-Text", fileExt);
                    sortDocs(file, newFolderName+"-Documents", fileExt);
                    sortArchive(file, newFolderName+"-Archive", fileExt);
                    break;
           }
            
            
        }
         //save filecount for return and reset it
         int fileCount=sortedFiles;
        resetFileCount();// reset total file sorted count

        return fileCount;
    }
     
     // --------------- SORTING SPECIFIC ----------------------------------
     private static void sortAudio(File file,String newFolderName, String fileExt){
        for(Extensions.Audio currExt:Extensions.Audio.values()){
            // remove first char from enum string (enum starts with ' _ ')
            if(currExt.toString().substring(1).equalsIgnoreCase(fileExt)){
                moveFileToNewFolder(file, newFolderName);
                //sortedFiles++;
            }
        }
     }
     private static void sortVideo(File file,String newFolderName, String fileExt){
        for(Extensions.Video currExt:Extensions.Video.values()){
            // remove first char from enum string (enum starts with ' _ ')
            if(currExt.toString().substring(1).equalsIgnoreCase(fileExt)){
                moveFileToNewFolder(file, newFolderName);
                //sortedFiles++;
            }
        }
     }
     private static void sortImage(File file,String newFolderName, String fileExt){
         for(Extensions.Image info:Extensions.Image.values()){
            if(info.toString().substring(1).equalsIgnoreCase(fileExt)){
                moveFileToNewFolder(file,newFolderName);
                //sortedFiles++;
            }
        }
     }
     private static void sortText(File file,String newFolderName, String fileExt){
         for(Extensions.Text info:Extensions.Text.values()){
            if(info.toString().substring(1).equalsIgnoreCase(fileExt)){
                moveFileToNewFolder(file,newFolderName);
                //sortedFiles++;
            }
        }
     }
     private static void sortArchive(File file,String newFolderName, String fileExt){
        for(Extensions.Archive info:Extensions.Archive.values()){
            if(info.toString().substring(1).equalsIgnoreCase(fileExt)){
                moveFileToNewFolder(file,newFolderName);
                //sortedFiles++;
            }
        }
     }
     private static void sortDocs(File file, String newFolderName, String fileExt) {
         for(Extensions.Docs info:Extensions.Docs.values()){
            if(info.toString().substring(1).equalsIgnoreCase(fileExt)){
                moveFileToNewFolder(file,newFolderName);
                //sortedFiles++;
            }
        }
     }
     // --------------------------- END SORTING -----------------------------
     
     
     // Moves file to the specified folder. Creates it if doesnt exit.
     private static void moveFileToNewFolder(File file, String newFolderName) {
        File newSaveLocation=new File(file.getParent()+"/"+newFolderName);
        File newSave2Location=new File(newSaveLocation+"/"+file.getName());
        
        //Make new folder if not made
        boolean isDirCreated=newSaveLocation.mkdir();
        
        if(isDirCreated)
            LOGGER.info("New folder was created");
        
        try {// attempt to move the files
            Files.move(file.toPath(), newSave2Location.toPath(),REPLACE_EXISTING );
            sortedFiles++;
        } catch (IOException ex) {
            //Logger.getLogger(FSorter.class.getName()).log(Level.SEVERE, null, ex);
            LOGGER.info("file was already moved: "+file.toString());
        }
    }
     
     
     
     
     
     // ------------------- DATA MANIPULATION/GETTERS -----------------------
     private static String getExtension(File file){
        // match the last " . " in file name (extension)
        Pattern pat=Pattern.compile(".*\\.(.*)");
        Matcher mat=pat.matcher(file.toString());
        
        // group 0 = full string |  group 1 = extension
        if(mat.find()){
            return mat.group(1);
        }else{
            //Should never happen - file contains no extension???
            LOGGER.severe("file extension not found in file?");
            System.exit(100);
            return null;
        }
    }

    
}
