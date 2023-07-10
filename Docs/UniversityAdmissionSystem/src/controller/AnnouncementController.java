/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import UI.ui.compnents.DALManager;
import javax.swing.JOptionPane;
import model.AnnouncementModel;
import java.sql.SQLException;


/**
 *
 * @author HP 840 G3
 */
public class AnnouncementController {
    private AnnouncementModel model;
    private DALManager dalManager;

    public AnnouncementController(AnnouncementModel model, DALManager dalManager) {
        this.model = model;
        this.dalManager = dalManager;
    }

    public void handleClearAction() {
        model.setAnnouncementText("");
    }

public void handleSubmitAction() {
    String text = model.getAnnouncementText();

    if (text == null || text.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please enter a valid message.");
    } else {
        try {
            dalManager.saveAnnouncement(text);
            JOptionPane.showMessageDialog(null, "The message has been stored in the database.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred while storing the message in the database.");
            e.printStackTrace(); 
        }
    }
}



    public void handleBackAction() {
        // Handle back action
       
    }

//    public void saveAnnouncement(String text) {
//        dalManager.saveAnnouncement(text);
//    }

    public AnnouncementModel getModel() {
        return model;
    }
}

    
    


