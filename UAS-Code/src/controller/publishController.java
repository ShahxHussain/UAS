package controller;

import common.PublishDTO;
import dal.DALManager;
//import model.publishFactory;
import UI.ui.compnents.Publishmeritlist;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import model.publishFactory;

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
    ui.getJButton6().addActionListener(e -> viewList());
    ui.getJButton3().addActionListener(e -> onPublishButtonClicked());
    ui.getJButton8().addActionListener(e -> onModifyButtonClicked());
    ui.getJButton1().addActionListener(e -> onDeleteButtonClicked());
}


    public void viewList() {
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
    int[] selectedRows = ui.getJTable4().getSelectedRows();

    if (selectedRows.length > 0) {
        for (int row : selectedRows) {
            PublishDTO student = ui.getStudentData(row);
            dalManager.updateStudent(student);
        }

        isDataPublished = true; // Update the flag to indicate data has been published
//        JOptionPane.showMessageDialog(ui, "Student data published successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
    } 
//    else {
//        JOptionPane.showMessageDialog(ui, "Please select at least one row to publish", "Error", JOptionPane.ERROR_MESSAGE);
//    }
}



    public void onModifyButtonClicked() {
    int[] selectedRows = ui.getJTable4().getSelectedRows(); // Get the selected rows

    if (selectedRows.length == 0) {
        JOptionPane.showMessageDialog(ui, "Please select rows to modify", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    for (int selectedRow : selectedRows) {
        PublishDTO student = ui.getStudentData(selectedRow); // Pass the selected row as an argument
        // Update the data in the database
        dalManager.updateStudent(student);
    }
}






public void onDeleteButtonClicked() {
    int selectedRow = ui.getJTable4().getSelectedRow();

    if (selectedRow >= 0) {
        DefaultTableModel model = (DefaultTableModel) ui.getJTable4().getModel();
        PublishDTO student = new PublishDTO();
        student.setStudentID((int) model.getValueAt(selectedRow, 0)); // Get the student ID from the table
        model.removeRow(selectedRow);

        // Delete the data from the database
        dalManager.deleteStudent(student);
        JOptionPane.showMessageDialog(ui, "Student data deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Publishmeritlist ui = new Publishmeritlist();
            publishController controller = new publishController(ui);
            ui.setVisible(true);
        });
    }
}
