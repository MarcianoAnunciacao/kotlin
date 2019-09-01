package com.rsk.java;

import org.jetbrains.annotations.Nullable;

public class Meeting {
    private String title;

    public void addTitle(@Notnull String title) {
        this.title = title;
    }

    public @Nullable String meetingTitle() {
        return title;
    }

    public String titleCanBeNull(){
        return title;
    }
}
