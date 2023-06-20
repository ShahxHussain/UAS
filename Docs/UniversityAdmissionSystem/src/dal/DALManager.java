/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.IConnection;
import model.SQLConnection;

/**
 *
 * @author Abdul aziz
 */
public class DALManager {
    IConnection sql;

    public DALManager() {
        this.sql = new SQLConnection("jdbc:sqlserver://localhost:1433;databaseName=universityadmissionsystem;trustServerCertificate=true;", "sa", "123456");
    }
    
    
}
