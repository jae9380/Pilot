package com.step3.problem08.entity;

public class Newbie extends Member{
    public Newbie(String name) {
        super(name);
        System.out.printf("\"%s\" 님이 신규 멤버로 가입되었습니다.\n", getName());
    }

    public Newbie(String name, String skill) {
        super(name, skill);
        System.out.printf("\"%s\" 님이 신규 멤버로 가입되었습니다.\n", getName());
    }
}
