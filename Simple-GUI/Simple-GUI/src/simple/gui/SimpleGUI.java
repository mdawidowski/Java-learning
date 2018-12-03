/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simple.gui;
import javax.swing.JFrame;
/**
 *
 * @author marcin
 */
public class SimpleGUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       JFrame view = new GUI();
       view.setTitle("GUI Test");
       view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       view.setVisible(true);
    }
    
}
