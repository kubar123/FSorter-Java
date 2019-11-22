/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fsorter.GUI;

import javax.swing.JOptionPane;
import static javax.swing.TransferHandler.MOVE;

/**
 *
 * @author Jakub Rybicki <Jake at lansoftprogramming.com>
 */
public class GuiManager {
    public static void printUpdateMessage(int updateID){
        //1 major, 2 minor, 3 patch
        if(updateID>0){
            //JOptionPane.showMessageDialog(null,updateID);
            //JOptionPane.showMessageDialog(parentComponent, MOVE, "s", updateID);
        }
    }
}
