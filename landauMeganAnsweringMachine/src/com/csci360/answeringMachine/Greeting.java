/* CSCI 360 - Software Architecture
 * Dr. Jim Bowring
 *
 * Simple Answering Machine Project
 * @author: Megan Landau
 */
package com.csci360.answeringMachine;

public class Greeting {

    protected Recording greeting;

    protected Recording getGreeting() {
        return greeting;
    }

    protected void playGreeting() {
        greeting.play();
    }

    protected void setGreeting(Recording recording) {
        greeting = recording;
    }
}
