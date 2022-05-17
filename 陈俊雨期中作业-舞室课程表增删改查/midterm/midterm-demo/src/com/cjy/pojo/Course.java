package com.cjy.pojo;

public class Course {
    // id 主键
    private int id;
    // 舞种
    private String danceType;
    // 授课歌曲
    private String song;
    // 授课时间
    private String time;
    // 授课教师
    private String teacher;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDanceType() {
        return danceType;
    }

    public void setDanceType(String danceType) {
        this.danceType = danceType;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "course{" +
                "id=" + id +
                ", danceType='" + danceType + '\'' +
                ", song='" + song + '\'' +
                ", time='" + time + '\'' +
                ", teacher='" + teacher + '\'' +
                '}';
    }
}
