package com.example.bot.model;

public class User {
    private String id;
    private String name;
    private String email;
    private String salt;
    private String username;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) {
    }
    public String getSalt() { return salt; }
    public void setSalt(String salt) { this.salt = salt; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
}
