package com.gis_server.pojo;

public class User {

    public static final int USER_AUTHORITY_SUPERADMIN = 0;
    public static final int USER_AUTHORITY_ADMINISTRATOR = 1;
    public static final int USER_AUTHORITY_ORDINARY = 2;

    private Integer id;

    private String username;

    private String password;

    private Integer authority;

    public User(Integer id, String username, String password, Integer authority) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authority = authority;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getAuthority() {
        return authority;
    }

    public void setAuthority(Integer authority) {
        this.authority = authority;
    }
}