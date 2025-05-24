package com.step3.problem08.entity;

import java.time.LocalDateTime;

public class Common extends Member implements PracticeManager{
    public Common(String name) {
        super(name);
        System.out.printf("\"%s\" 님이 일반 멤버로 가입되었습니다.\n", getName());
    }

    public Common(String name, String skill) {
        super(name, skill);
        System.out.printf("\"%s\" 님이 일반 멤버로 가입되었습니다.\n", getName());
    }

    @Override
    public boolean canCancelPractice() {
        return true;
    }

    @Override
    public boolean canOpenNewPractice() {
        return true;
    }
}
