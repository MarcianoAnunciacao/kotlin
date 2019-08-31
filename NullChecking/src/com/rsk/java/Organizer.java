package com.rsk.java;

public class Organizer {
    boolean closeMeeting(Meeting meeting){
        if(meeting.canClose)return meeting.close();
        return false;
    }

    public static void main(String[] args) {
        Organizer org = new Organizer();
//        org.closeMeeting(null);
    }
}
