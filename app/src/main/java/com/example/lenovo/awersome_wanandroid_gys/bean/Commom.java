package com.example.lenovo.awersome_wanandroid_gys.bean;

public class Commom {

    private String icon;
    private int id;
    private String link;
    private String name;
    private int order;
    private int visible;

    @Override
    public String toString() {
        return "Commom{" +
                "icon='" + icon + '\'' +
                ", id=" + id +
                ", link='" + link + '\'' +
                ", name='" + name + '\'' +
                ", order=" + order +
                ", visible=" + visible +
                '}';
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public Commom(String icon, int id, String link, String name, int order, int visible) {

        this.icon = icon;
        this.id = id;
        this.link = link;
        this.name = name;
        this.order = order;
        this.visible = visible;
    }
}
