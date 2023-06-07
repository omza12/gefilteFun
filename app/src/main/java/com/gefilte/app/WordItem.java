package com.gefilte.app;

public class WordItem {
    String name, info;
    Integer image;

    public WordItem(String name, String info, Integer image) {
        this.name = name;
        this.info = info;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getImage(){
        return image;
    }

    public void setImage(Integer image){this.image=image;}
}
