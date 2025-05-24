package com.step3.problem08.entity;

import java.time.LocalDateTime;

public class Member {
    private String name;
    private LocalDateTime createdAt;
    private String skill;

    public Member(String name) {
        this.name = name;
        this.createdAt = LocalDateTime.now();
    }

    public Member(String name, String skill) {
        this.name = name;
        this.createdAt = LocalDateTime.now();
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
