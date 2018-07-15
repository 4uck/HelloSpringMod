package com.example.myapp;

public final class TimeStampResponse {
    private static final int MILLISEC_PER_SEC = 1000;
    private static final int MILLISEC_PER_MIN = 60000;
    private static final int MILLISEC_PER_HOUR = 3600000;
    private static final int UNIVERSAL_COUNT = 60;

    private Long currentTimeMilliseconds;
    private int seconds;
    private int minutes;
    private int hours;

    public TimeStampResponse(final Long currentTimeMilliseconds) {
        this.currentTimeMilliseconds = currentTimeMilliseconds;
        this.seconds = (int)
                (currentTimeMilliseconds / MILLISEC_PER_SEC) % UNIVERSAL_COUNT;
        this.minutes = (int)
                (currentTimeMilliseconds / MILLISEC_PER_MIN) % UNIVERSAL_COUNT;
        this.hours = (int)
                (currentTimeMilliseconds / MILLISEC_PER_HOUR);
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
