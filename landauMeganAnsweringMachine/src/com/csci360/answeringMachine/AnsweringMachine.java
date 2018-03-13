/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci360.answeringMachine;

import static com.csci360.answeringMachine.Recorder.RECORD_TIME;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class AnsweringMachine {
	
	public Passcode passcode = new Passcode();
	public Greeting greeting = new Greeting();
	public Messages newMessages = new Messages("New");
	public Messages savedMessages = new Messages("Saved");
        public boolean isSetUp = false;
        public String ownerName;
        public boolean isInitialized = false;
	
	public AnsweringMachine(String owner){
		System.out.println("Initializing Answering Machine...");
		//setPasscode();
		//recordNewGreeting();
                isSetUp = true;
                this.ownerName = owner.substring(0, 1).toUpperCase() + owner.substring(1);
//                System.out.println(owner);
	}
        
        public boolean isInitialized(){
            return this.isInitialized;
        }
        
        public void setInitialized(boolean set){
            isInitialized = (set == true) ? true : false;
        }
        
        public String getOwnerName(){
            return this.ownerName;
        }
	
	public void recordNewGreeting(){
            System.out.println("Please record your greeting...");

            Recording newGreeting = new Recording();

            greeting.setGreeting(newGreeting);
            System.out.println("Your greeting has been recorded!");
	}
	
	public void listenToGreeting(){
            greeting.playGreeting();
	}
	
	public boolean authenticatePasscode(String enteredPasscode){
            if (enteredPasscode.equals(this.passcode.getPasscode())){
                    return true;
            } else {
                    return false;
            }
	}
	
//	public void enterPasscode(){
//            System.out.println("Please enter your passcode.");
//
//            Scanner scan = new Scanner(System.in);
//            Passcode p = new Passcode();
//
//            String tryPasscode = scan.nextLine();
//
//            int tries = 3;
//            while (!authenticatePasscode(tryPasscode)){
//                    System.out.println("Invalid passcode. You have " + Integer.toString(tries) + " more tries.");
//                    tries--;
//                    tryPasscode = scan.nextLine();
//            }
//
//            System.out.println("Passcode authenticated.");
//	}
        
        public void setPasscode(String inpPasscode){
            passcode.setPasscode(inpPasscode);
        }
	
//	public void setPasscode(String inpPasscode){
//		System.out.println("Please set your passcode. Passcodes must be exactly 4 digits long.");
//		
////		Scanner scan = new Scanner(System.in);
//
////		String tryPasscode = scan.nextLine();
//                String tryPasscode = inpPasscode;
//		
//		while (!passcode.validatePasscode(tryPasscode)){
//			System.out.println("Invalid passcode. Passcodes must be exactly 4 digits long.");
//			tryPasscode = scan.nextLine();
//		}
//		
//		System.out.println("Passcode set!");
//		
//		passcode.setPasscode(tryPasscode);
//		
//		System.out.println(passcode.getPasscode());
//	}
	
	public void playMessage(String inboxName, int messageId){
            if (inboxName.equals("New")){
                    newMessages.playMessage(messageId);
            } else {
                    savedMessages.playMessage(messageId);
            }
	}
	
	public void deleteMessage(String inboxName, int messageId){
            if (inboxName.equals("New")){
                    newMessages.removeMessage(messageId);
            } else {
                    savedMessages.removeMessage(messageId);
            }
	}
	
	public void moveNewMessageToSavedMessages(int messageId){
            if (savedMessages.isFull()){
                    System.out.println("Saved Messages is full. Delete a message in Saved Messages in order to save this message.");
            } else {
                    Message message = newMessages.removeMessage(messageId);
                    // Don't need to worry about messageId because newMessages changes it.
                    savedMessages.addMessage(message); 
            }
	}
	
	public void deleteAllMessages(String inboxName){
            Messages inbox = (inboxName.equals("New")) ? newMessages : savedMessages;
		inbox.removeAllMessages();
	}
	
	public boolean haveNewMessages(){
            return (newMessages.getNumMessages() > 0) ? true : false;
	}
	
	
	// For leaving messages
	public void leaveMessage(String senderName){
            Message message = new Message(this.newMessages.getLastIdEntered(), senderName);
            if (newMessages.isFull()){
                    System.out.println("This inbox is full. You cannot leave a message at this time.");
            } else {
                    newMessages.addMessage(message); 
            }
	}
	
        public Passcode getPasscode(){
            return this.passcode;
        }
        
	// this is basically the user
	public static void main(String[] args) {
            
            Scanner scan = new Scanner(System.in);
            
            System.out.println("Let's create an answering machine. What is your name?");
            String name = scan.nextLine();
            AnsweringMachine machine = new AnsweringMachine(name);
            System.out.println("\nChoose a 4-digit passcode:");
            
            String trypass = scan.nextLine();
                    
            while (!machine.getPasscode().validatePasscode(trypass)){
                System.out.println("Invalid passcode. Passcodes must be 4-digits long only. Try again.");
                trypass = scan.nextLine();
            }
            
            System.out.println("Passcode set!");
            System.out.println("\nNow please record your greeting. You have 5 seconds.");
            
//                    Timer t2 = new Timer();
//                    t2.schedule(new TimerTask() {
//                        int num = 5;
//                        @Override
//                        public void run() {
//                            if (num>0){
//                                System.out.println(num);
//                                num--;
//                            } else {
//                                System.out.println("cancelled");
//                                t2.cancel();
//                            }
//
//                        }
//                    },1000);

            machine.recordNewGreeting();
            
                System.out.println("\nMain Menu:");
                System.out.println("\t1. New Messages");
                System.out.println("\t2. Saved Messages");
                System.out.println("\t3. Settings");
                System.out.println("\t4. Leave");
                
            boolean leftmessage = false;
            String line = scan.nextLine();
            while (!line.equals("-1")){
                if (line.equals("1")){
                    System.out.println("\nNew Messages");
                    System.out.println("You have " + machine.newMessages.getNumMessages() + " new messages.");
                    if (machine.newMessages.getNumMessages() > 0){
                        for (Message m : machine.newMessages.getMessages()){
//                            System.out.println(m.messageId);
                            m.playMessage();
                        }
                    }
                    if (leftmessage){
                        System.out.println("\nYou are moving your message to saved messages.");
                        machine.moveNewMessageToSavedMessages(1);
                        System.out.println("Message moved.");
                    }
                } else if (line.equals("2")){
                    System.out.println("\nSaved Messages");
                    System.out.println("You have " + machine.savedMessages.getNumMessages() + " saved messages.");
                    if (machine.savedMessages.getNumMessages() > 0){
                        for (Message m : machine.savedMessages.getMessages()){
                            m.playMessage();
                        }
                    }              
                } else if (line.equals("3")){
                    System.out.println("\n\tSettings:");
                    System.out.println("\t\t1. Change Passcode");
                    System.out.println("\t\t2. Play Greeting");
                    System.out.println("\t\t3. Change Greeting");
                    
                    System.out.println("\n\tYou pressed 2 for Play Greeting");
                    machine.listenToGreeting();
                    
                } else if (line.equals("4")){
                    System.out.println("\nWelcome to " + machine.getOwnerName() + "'s Answering Machine!");
                    System.out.println("Would you like to Login or Leave a Message?");

                    System.out.println("\nYou chose to leave a message. Your name is Megan. \nLeave a message for " + machine.getOwnerName());
                    System.out.println("You have 5 seconds to record your message.");
                    machine.leaveMessage("Megan");
                    leftmessage = true;
                    
                    System.out.println("\nNow you are logging in as " + machine.getOwnerName() + ".");
//                    machine.authenticatePasscode(machine.passcode.getPasscode());
                    
                    System.out.println("Go check your messages.");
                }
                System.out.println();
                System.out.println("\nMain Menu:");
                System.out.println("\t1. New Messages");
                System.out.println("\t2. Saved Messages");
                System.out.println("\t3. Settings");
                System.out.println("\t4. Leave");
                line = scan.nextLine();
            }
            
            

//		a.enterPasscode();
		//Message m = new Message(a.newMessages.getLastIdEntered());
		
		//System.out.println("creating new message");
		//a.newMessages.addMessage(m);
		//System.out.println("a has " + a.newMessages.getNumMessages() + " messages");
		
//		System.out.println("this is your greeting");
//		a.listenToGreeting();
//		a.newMessages.addMessage(a.newMessages.getLastIdEntered());
//		a.newMessages.addMessage(a.newMessages.getLastIdEntered());
		
//		for (int i = 0; i < 20; i++) {
//			a.savedMessages.addMessage(new Recording());
//		}
//		System.out.println("playing new message number 1");
//		a.playMessage("New", 1);
////		a.playMessage("Saved", 14);
//		System.out.println("moving message 1 to saved messages");
//		a.moveNewMessageToSavedMessages(1);
//		
//		System.out.println("num of saved messages = " + a.savedMessages.getNumMessages());
//		System.out.println("playing all saved messages");
//		a.newMessages.playAllMessages();
//		System.out.println("deleting all saved messages");
//		a.deleteAllMessages("Saved");
////		a.moveNewMessageToSavedMessages(1);
////		System.out.println(a.savedMessages.getNumMessages());
	}

}

