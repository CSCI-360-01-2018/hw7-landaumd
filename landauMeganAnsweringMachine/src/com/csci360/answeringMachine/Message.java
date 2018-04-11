package com.csci360.answeringMachine;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {

    protected int messageId;
    protected Recording message;
    protected String timestamp;
    protected String sender;

    protected Message(int messageId, String sender) {
        this.messageId = messageId;
        String messageFileName = "message_" + Integer.toString(messageId);
        message = new Recording(messageFileName);
        this.sender = sender;

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        timestamp = dateFormat.format(date); //2016/11/16 12:08:43
    }

    protected String getSenderName() {
        return this.sender;
    }

    protected int getMessageId() {
        return this.messageId;
    }

    protected void setMessageId(int id) {
        this.messageId = id;
    }

    protected Recording getMessage() {
        return this.message;
    }

    protected void playMessage() {
        message.play();
        System.out.println("playing message " + Integer.toString(messageId));
    }
}
