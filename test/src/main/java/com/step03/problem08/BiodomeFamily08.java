package com.step03.problem08;

import com.step03.problem08.entity.*;

public class BiodomeFamily08 {
    public static void main(String[] args) {
//        TODO: 전체적인 코드와 디자인 패턴 수정 예정
        Club club = new Club();
//        John 운영진
        Member member = new Admin("John");
        club.addMember(member);
//        Jane과 Doe 일반
        Member member1 = new Common("Jane");
        Member member2 = new Common("Doe");
        club.addMember(member1);
        club.addMember(member2);
//        Amy와 Leo 신규
        Member member3 = new Newbie("Amy");
        Member member4 = new Newbie("Leo");
        club.addMember(member3);
        club.addMember(member4);


        Session session = new Session("2130년 09월 12일", "도메 스타디움", member);
        club.addSession(session);
        club.getSessionsList();
        session.joinPractice(member1, member4);
        club.getSessionsList();
    }
}
