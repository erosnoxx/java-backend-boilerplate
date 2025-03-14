package com.erosnox.backend.domain.entities.user;

import com.erosnox.backend.application.enums.Roles;
import com.erosnox.backend.domain.entities.BaseEntity;
import com.erosnox.backend.domain.utils.EntityUtils;

import javax.swing.text.html.parser.Entity;
import java.util.UUID;

public class User extends BaseEntity<UUID> {
    private String username;
    private String passwordHash;
    private Roles role;
    private boolean enabled;

    public User(String username, String passwordHash, Roles role) {
        changeUsername(username);
        changePassword(passwordHash);
        changeRole(role);
        enabled = true;
    }

    public void changeUsername(String username) {
        EntityUtils.isFieldEmpty(username, "Username");
        if (username.length() < 3 || username.length() > 16) {
            throw new IllegalArgumentException("Username must be between 3 and 16 characters");
        }

        this.username = username;
    }

    public void changePassword(String password) {
        if (!EntityUtils.isPasswordValid(password)) {
            throw new IllegalArgumentException("Invalid password");
        }

        this.passwordHash = EntityUtils.encodePassword(password);;
    }

    public void changeRole(Roles role) {
        this.role = role;
    }

    public void toggleEnabled() {
        this.enabled = !this.enabled;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public Roles getRole() {
        return role;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
