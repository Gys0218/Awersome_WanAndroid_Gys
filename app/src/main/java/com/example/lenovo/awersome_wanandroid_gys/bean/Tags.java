package com.example.lenovo.awersome_wanandroid_gys.bean;

public class Tags {

    private String name;
    private String url;

    @Override
    public String toString() {
        return "Tags{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Tags(String name, String url) {

        this.name = name;
        this.url = url;
    }
}
