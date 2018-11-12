package io.github.mobileteacher.attendanceapp.models;

public class AttendanceCard {

    private String day;
    private long checkin;
    private long checkout;
    private String status;

    public AttendanceCard(){}

    public AttendanceCard(String day, long checkin, long checkout, String status) {
        this.day = day;
        this.checkin = checkin;
        this.checkout = checkout;
        this.status = status;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public long getCheckin() {
        return checkin;
    }

    public void setCheckin(long checkin) {
        this.checkin = checkin;
    }

    public long getCheckout() {
        return checkout;
    }

    public void setCheckout(long checkout) {
        this.checkout = checkout;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
