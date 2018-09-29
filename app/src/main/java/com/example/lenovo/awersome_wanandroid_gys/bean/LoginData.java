package com.example.lenovo.awersome_wanandroid_gys.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class LoginData implements Serializable{
    private ArrayList<String> collectIds;
    private String email;
    private String icon;
    private int id;
    private String password;
    private String token;
    private int type;
    private String username;

    @Override
    public String toString() {
        return "LoginData{" +
                "collectIds=" + collectIds +
                ", email='" + email + '\'' +
                ", icon='" + icon + '\'' +
                ", id=" + id +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                ", type=" + type +
                ", username='" + username + '\'' +
                '}';
    }

    public ArrayList<String> getCollectIds() {
        return collectIds;
    }

    public void setCollectIds(ArrayList<String> collectIds) {
        this.collectIds = collectIds;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LoginData(ArrayList<String> collectIds, String email, String icon, int id, String password, String token, int type, String username) {

        this.collectIds = collectIds;
        this.email = email;
        this.icon = icon;
        this.id = id;
        this.password = password;
        this.token = token;
        this.type = type;
        this.username = username;
    }
}
