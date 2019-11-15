/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fsorter;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Jake Rybicki
 */
public class WindowCmd {
    public static int startSorting(String sortingSelection, String sortingName, List<File> files){
        return FileSorterAI.startSorting(sortingSelection, files, sortingName);
        
        // use contents of folder if is a folder
//        List<File>fileToSort=files;
//        
//    //use custom extension
//        String customExt=main.getGroupSettingsSelection();
//        if(main.getGroupSettingsSelection().equalsIgnoreCase("custom"))
//            customExt=main.getjTxtCustom();
//        
//        int sortedFiles=fileSorterAI.startSorting(customExt,fileToSort,
//                main.getjNewFolderLocation());
//        
//        
//        main.setJLabelInfo(sortedFiles+" files moved");
        
       // return 0;
    }
    
    public static void parseAndSortUsingCMD(String[] args) {
            // populate the program
            //Must use **ENTIRE** folder sorting
                List<File>fileToSort = null;
                String customExt=args[0];
                
                String newFolderName=args[1];
                File f=new File(args[2]);
                fileToSort = Arrays.asList(f);
                
                //get list of all files
                System.out.println(fileToSort);
                List<File> filesToSort;
//                for (int i=1;i<args.length;i++) {
                    //fileToSort = (List<File>) new File("C:/users");
//                }
                
                   // System.out.println(filesToSort.toString());
                filesToSort= Arrays.asList(fileToSort.get(0).listFiles());
                    
                    
                    
                startSorting(args[0],args[1],filesToSort);
//                sortedFiles=fileSorterAI.startSorting(customExt,fileToSort,
//                main.getjNewFolderLocation());
    }
}
