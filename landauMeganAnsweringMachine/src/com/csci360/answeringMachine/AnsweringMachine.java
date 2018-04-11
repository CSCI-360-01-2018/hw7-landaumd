/* CSCI 360 - Software Architecture
 * Dr. Jim Bowring
 *
 * Simple Answering Machine Project
 * @author: Megan Landau
 */
package com.csci360.answeringMachine;

public class AnsweringMachine {

    public Passcode passcode = new Passcode();
    public Greeting greeting = new Greeting();
    public Messages newMessages = new Messages("New");
    public Messages savedMessages = new Messages("Saved");
    public boolean isSetUp = false;
    public String ownerName;
    public boolean isInitialized = false;

    /**
     * Constructor for a new Answering Machine. The owner can record a greeting and set a passcode.
     * Once the system is set up, the user can change their greeting or passcode or listen, save 
     * or delete messages. Other users of the system can leave messages for the owner.
     * 
     * @param owner 
     */
    public AnsweringMachine(String owner) {
        isSetUp = true;
        this.ownerName = owner.substring(0, 1).toUpperCase() + owner.substring(1);
    }

    /**
     * Returns whether or not the machine has a passcode or greeting set up.
     * 
     * @return Boolean value of whether or not machine is initialized.
     */
    public boolean isInitialized() {
        return this.isInitialized;
    }

    /**
     * Sets machine state to either initialized or not initialized. The machine is initialized when
     * the user has recorded a greeting and set the initial passcode.
     * 
     * @param set Whether the machine has been initialized or not.
     */
    public void setInitialized(boolean set) {
        isInitialized = set;
    }

    /**
     * Returns the name of the owner of the answering machine.
     * 
     * @return String name of the owner of the answering machine.
     */
    public String getOwnerName() {
        return this.ownerName;
    }

    /**
     * Answering machine will record the user's greeting, either at initialization or if the
     * user chooses to record a new greeting.
     */
    public void recordNewGreeting() {
        Recording newGreeting = new Recording();
        greeting.setGreeting(newGreeting);
    }

    /**
     * Answering machine will play the owner's current stored greeting.
     */
    public void listenToGreeting() {
        greeting.playGreeting();
    }

    /**
     * This method checks whether or not the input value matches the passcode stored in the
     * system. This authenticates the user's access to the answering machine and messages.
     * 
     * @param enteredPasscode The user's input passcode.
     * @return True if the passcode is correct, false if it is not.
     */
    public boolean authenticatePasscode(String enteredPasscode) {
        return enteredPasscode.equals(passcode.getPasscode());
    }

    /**
     * THe user can choose to enter a new passcode for the system. The Answering Machine will
     * check that the new passcode is a 4-digit numeric only passcode save it if it is.
     * 
     * @param inpPasscode 4-digit passcode with numbers only.
     */
    public void setPasscode(String inpPasscode) {
        passcode.setPasscode(inpPasscode);
    }

    /**
     * The owner can play a recorded message that was left for them by another user. They can play messages
     * from the New Messages Inbox or the Saved Messages Inbox.
     * 
     * @param inboxName Indicates which inbox the user would like to access messages from.
     * @param messageId The unique message id number for the desired message.
     */
    public void playMessage(String inboxName, int messageId) {
        if (inboxName.equals("New")) {
            newMessages.playMessage(messageId);
        } else {
            savedMessages.playMessage(messageId);
        }
    }

    /**
     * The owner can delete messages from either New or Saved Messages inboxes.
     * 
     * @param inboxName Indicates whether the owner would like to delete a message from the New 
     * Messages inbox or the Saved Messages inbox.
     * @param messageId The unique message id number which the system will delete.
     */
    public void deleteMessage(String inboxName, int messageId) {
        if (inboxName.equals("New")) {
            newMessages.removeMessage(messageId);
        } else {
            savedMessages.removeMessage(messageId);
        }
    }

    /**
     * The owner can choose to save a message from the New Messages inbox to the Saved Messages inbox.
     * 
     * @param messageId The unique message id number which the system will move to Saved Messages, where
     * it will be assigned a new message id number.
     */
    public void moveNewMessageToSavedMessages(int messageId) {
        if (savedMessages.isFull()) {
            System.out.println("Saved Messages is full. Delete a message in Saved Messages in order to save this message.");
        } else {
            Message message = newMessages.removeMessage(messageId);
            savedMessages.addMessage(message);
        }
    }

    /**
     * The owner can choose to delete all the messages in an inbox.
     * @param inboxName The inbox name which will be cleared.
     */
    public void deleteAllMessages(String inboxName) {
        Messages inbox = (inboxName.equals("New")) ? newMessages : savedMessages;
        inbox.removeAllMessages();
    }

    /**
     * Whether or not there are new messages in the New Messages inbox.
     * @return True indicates there are new messages, false indicates there are no new messages.
     */
    public boolean haveNewMessages() {
        return (newMessages.getNumMessages() > 0) ? true : false;
    }

    /**
     * A caller user can leave a message for the owner, which will be saved to New Messages.
     * 
     * @param senderName Name of the caller who is leaving the message.
     */
    public void leaveMessage(String senderName) {
        String name = senderName.substring(0, 1).toUpperCase() + senderName.substring(1);
        Message message = new Message(newMessages.getLastIdEntered(), name);
        if (newMessages.isFull()) {
            System.out.println("This inbox is full. You cannot leave a message at this time.");
        } else {
            newMessages.addMessage(message);
        }
    }

    /**
     * Returns the passcode of the system.
     * @return The passcode of the answering machine.
     */
    protected Passcode getPasscode() {
        return this.passcode;
    }
}
