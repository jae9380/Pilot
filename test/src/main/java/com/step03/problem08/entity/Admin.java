package com.step03.problem08.entity;

public class Admin extends Member implements PracticeManager{
    public Admin(String name) {
        super(name);
        System.out.printf("\"%s\" 님이 운영진으로 가입되었습니다.\n", getName());
    }

    public Admin(String name, String skill) {
        super(name, skill);
        System.out.printf("\"%s\" 님이 운영진으로 가입되었습니다.\n", getName());
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


