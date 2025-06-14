package com.step03.problem08;

import com.step03.problem08.entity.Member;
import com.step03.problem08.entity.Session;
import com.step03.problem08.util.Util;

import java.util.ArrayList;
import java.util.List;

public class Club {
    private List<Member> members = new ArrayList<>();
    private List<Session> sessions = new ArrayList<>();

    public void addMember(Member member) {
        members.add(member);
    }

    public void addSession(Session session) {
        sessions.add(session);
    }

    public void getSessionsList() {
        System.out.println("---- 개설된 연습 전체 조회 ----");
        for (Session session : sessions) {
            System.out.printf("일자 : %1$s \t 장소 : %2$s \t 호스트 : %3$s \t 참여 멤버 : %4$s \t 상태 : %5$s \n",
                    Util.formatDateToKorean(session.getDate()), session.getPlace(), session.getHostName(),
                    String.join(", ", session.getParticipantsName()), session.getStatus());
        }
    }

}

