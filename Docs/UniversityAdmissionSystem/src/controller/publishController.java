package controller;

import common.PublishDTO;
import dal.DALManager;
import model.publishFactory;
import UI.ui.compnents.Publishmeritlist;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class publishController {
    private Publishmeritlist ui;
    private DALManager dalManager;
    private publishValidator validator;
    private boolean isDataPublished = false;

    public publishController(Publishmeritlist ui) {
        this.ui = ui;
        this.dalManager = publishFactory.createDALManager(publishFactory.createConnection("jdbc:sqlserver://localhost:1433;databaseName=universityadmissionsystem;trustServerCertificate=true;", "sa", "123456"));
        this.validator = publishFactory.createValidator();
        attachEventListeners();
    }

 private void attachEventListeners() {
    ui.getJButton6().addActionListener(e -> onViewButtonClicked());
    ui.getJButton3().addActionListener(e -> onPublishButtonClicked());
    ui.getJButton8().addActionListener(e -> onModifyButtonClicked());
    ui.getJButton1().addActionListener(e -> onDeleteButtonClicked());
}


    public void onViewButtonClicked() {
        List<PublishDTO> students = dalManager.getAllStudents();
        DefaultTableModel model = (DefaultTableModel) ui.getJTable4().getModel();
        model.setRowCount(0);

        for (PublishDTO student : students) {
            Object[] rowData = {
                    student.getStudentID(),
                    student.getStudentName(),
                    student.getTestResult(),
                    student.getPercentage()
            };
            model.addRow(rowData);
        }
    }

    public void onPublishButtonClicked() {
//    if (isDataPublished) {
//        // Data has already been published, return or show a message
//        JOptionPane.showMessageDialog(ui, "Data has already been published.", "Information", JOptionPane.INFORMATION_MESSAGE);
//        return;
//    }

    PublishDTO student = ui.getStudentData();

    if (!validator.validateStudent(student)) {
        // Validation failed, return without publishing
        return;
    }

    dalManager.saveStudent(student);
//    JOptionPane.showMessageDialog(ui, "Student data published successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

    isDataPublished = true; // Update the flag to indicate data has been published
}
public void onModifyButtonClicked() {
    PublishDTO student = ui.getStudentData();

    if (!validator.validateStudent(student)) {
        JOptionPane.showMessageDialog(ui, "Invalid student data", "Validation Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int selectedRow = ui.getJTable4().getSelectedRow();

    if (selectedRow >= 0) {
        // Update the data in the table
        DefaultTableModel model = (DefaultTableModel) ui.getJTable4().getModel();
        model.setValueAt(student.getStudentID(), selectedRow, 0);
        model.setValueAt(student.getStudentName(), selectedRow, 1);
        model.setValueAt(student.getTestResult(), selectedRow, 2);
        model.setValueAt(student.getPercentage(), selectedRow, 3);

        // Update the data in the database
        dalManager.updateStudent(student);

        JOptionPane.showMessageDialog(ui, "Student data modified successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(ui, "Please select a row to modify", "Error", JOptionPane.ERROR_MESSAGE);
    }
}




public void onDeleteButtonClicked() {
    int selectedRow = ui.getJTable4().getSelectedRow();

    if (selectedRow >= 0) {
        int confirmResult = JOptionPane.showConfirmDialog(ui, "Are you sure you want to delete this student?", "Confirmation", JOptionPane.YES_NO_OPTION);

        if (confirmResult == JOptionPane.YES_OPTION) {
            // Remove the row from the table
            DefaultTableModel model = (DefaultTableModel) ui.getJTable4().getModel();
            PublishDTO student = new PublishDTO();
            student.setStudentID((int) model.getValueAt(selectedRow, 0)); // Get the student ID from the table
            model.removeRow(selectedRow);

            // Delete the data from the database
            dalManager.deleteStudent(student);
            JOptionPane.showMessageDialog(ui, "Student data deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    } 
//    else {
//        JOptionPane.showMessageDialog(ui, "No row selected", "Error", JOptionPane.ERROR_MESSAGE);
//    }
}


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Publishmeritlist ui = new Publishmeritlist();
            publishController controller = new publishController(ui);
            ui.setVisible(true);
        });
    }
}
