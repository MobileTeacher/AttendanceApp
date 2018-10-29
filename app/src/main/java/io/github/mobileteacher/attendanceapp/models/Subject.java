package io.github.mobileteacher.attendanceapp.models;

public class Subject {
    private String name;
    private String professor;
    private String day;
    private double attendanceRate;

    public Subject(String name, String professor, String day, double attendanceRate) {
        this.name = name;
        this.professor = professor;
        this.day = day;
        this.attendanceRate = attendanceRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public double getAttendanceRate() {
        return attendanceRate;
    }

    public void setAttendanceRate(double attendanceRate) {
        this.attendanceRate = attendanceRate;
    }
}
