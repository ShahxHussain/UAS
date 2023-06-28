/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.UASController;



public class UASFactory {
    
    public static UASController getInstanceOfUASController()
    {
        return new UASController();
    }
}
