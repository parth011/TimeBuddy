package com.example.pc.timetab;

public class ListItem {
    private String day;
    private String subject;
    private String teacher;
    private int room;
    private String from;
    private int color;

    public ListItem(String subject, String teacher, int room, String from) {
        this.subject = subject;
        this.teacher = teacher;
        this.room = room;
        this.from = from;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getDay() {
        return day;
    }

    public int getRoom() {
        return room;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getSubject() {
        return subject;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getFrom() {return from;}

}