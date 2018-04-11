package com.csci360.answeringMachine;

import java.util.ArrayList;
import java.util.List;

public class Messages {

    protected String inboxName;
    protected List<Message> messages = new ArrayList<Message>();
    protected static int CAPACITY = 20;
    protected int lastMessageIdEntered;

    protected Messages(String inboxName) {
        this.inboxName = inboxName;
    }

    protected String getInboxName() {
        return this.inboxName;
    }

    protected List<Message> getMessages() {
        return this.messages;
    }

    public int getNumMessages() {
        return messages.size();
    }

    protected void playAllMessages() {
        for (Message m : messages) {
            m.playMessage();
        }
    }

    protected void playMessage(int messageId) {
        for (int i = 0; i < messages.size(); i++) {
            if (messages.get(i).getMessageId() == messageId) {
                messages.get(i).playMessage();
            }
        }
    }

    protected Message removeMessage(int messageId) {
        for (int i = 0; i < messages.size(); i++) {
            if (messages.get(i).getMessageId() == messageId) {
                return messages.remove(i);
            }
        }
        return null;
    }

    protected Message getMessage(int messageId) {
        for (int i = 0; i < messages.size(); i++) {
            if (messages.get(i).getMessageId() == messageId) {
                return messages.get(i);
            }
        }
        return null;
    }

    protected boolean addMessage(Message message) {
        if (!isFull()) {
            lastMessageIdEntered++;
            message.setMessageId(lastMessageIdEntered);
            messages.add(message);
            return true;
        } else {
            System.out.println(inboxName + " messages is full.");
            return false;
        }
    }

    protected boolean isFull() {
        if (this.getNumMessages() < CAPACITY) {
            return false;
        } else {
            return true;
        }
    }

    protected void removeAllMessages() {
        messages.clear();
    }

    protected int getLastIdEntered() {
        return this.lastMessageIdEntered;
    }
}
