/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

/**
 *
 * @author HP 840 G3
 */
public class Message {
    public String Message;
    public MessageType Type;

    public Message(String errorMessage, MessageType messageType) {
        this.Message = errorMessage;
        this.Type = messageType;
    }
}
