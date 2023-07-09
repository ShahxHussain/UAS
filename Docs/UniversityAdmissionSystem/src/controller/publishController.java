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

    public publishController(Publishmeritlist ui) {
        this.ui = ui;
      this.dalManager = publishFactory.createDALManager(publishFactory.createConnection("jdbc:sqlserver://localhost:1433;databaseName=universityadmissionsystem;trustServerCertificate=true;", "sa", "123456"));

        this.validator = publishFactory.createValidator();
        attachEventListeners();
    }

    private void attachEventListeners() {
        ui.getJButton6().addActionListener(e -> onViewButtonClicked());
        ui.getJButton3().addActionListener(e -> onPublishButtonClicked());
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
        PublishDTO student = ui.getStudentData();

        if (!validator.validateStudent(student)) {
            JOptionPane.showMessageDialog(ui, "Invalid student data", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        dalManager.saveStudent(student);
        JOptionPane.showMessageDialog(ui, "Student data published successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Publishmeritlist ui = new Publishmeritlist();
            publishController controller = new publishController(ui);
            ui.setVisible(true);
        });
    }
}
