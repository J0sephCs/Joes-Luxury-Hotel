package edu.utsa.cs3443.hotelapplication.model;

public class Amenities {

    public String img, name, hours, desc;

    public Amenities(String img, String name, String hours, String desc) {
        this.img = img;
        this.name = name;
        this.hours = hours;
        this.desc = desc;
    }

    public Amenities(){

    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
