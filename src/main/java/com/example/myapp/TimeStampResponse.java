package com.example.myapp;

public final class TimeStampResponse {

    private Long currentTimeMilliseconds;
    private int seconds;
    private int minutes;
    private int hours;

    public TimeStampResponse(final Long currentTimeMilliseconds) {
        this.currentTimeMilliseconds = currentTimeMilliseconds;
        this.seconds = (int) (currentTimeMilliseconds/1000)%60;
        this.minutes = (int) (currentTimeMilliseconds/60000) % 60;
        this.hours = (int) (currentTimeMilliseconds/3600000);
    }

    public Long getCurrentTimeMilliseconds() {
        return currentTimeMilliseconds;
    }

    public int getSeconds() {
        return seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getHours() {
        return hours;
    }

    @Override
    public String toString() {
        return String.format("%d:%d:%d", hours, minutes, seconds);
    }
}
