package com.step03.problem08.entity;

import com.step03.problem08.entity.type.Status;
import com.step03.problem08.util.Util;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Session {
    private LocalDateTime date;
    private String place;
    private List<Member> participants = new ArrayList<>();
    private Member host;
    private Status status;

    public Session(String date, String place, Member host) {
        if (host instanceof PracticeManager && ((PracticeManager) host).canOpenNewPractice()) {
            this.date = Util.formatDateToLocalDateTime(date);
            this.place = place;
            this.host = host;
            this.status = Status.OPENED;
            System.out.printf("[SESSION] \"%1$s\"님이 %2$s, %3$s에서 연습 세션을 개설했습니다.\n",
                    host.getName(), date.toString(), place);
        }else System.out.printf("[SESSION] \"%1$s\"님은 연습 세션을 개설할 수 없는 등급입니다.\n",
                host.getName());

    }

    public void joinPractice(Member... members) {
        for (Member member : members) participants.add(member);

        System.out.printf("[SESSION] %s이 연습에 참여 했습니다.\n",
                String.join(", ",
                        Arrays.stream(members)
                                .map(member -> member.getName())
                                .toList()));
    }

//    TODO: 세션 수정 및 삭제 로직 수정
    public void updateSessionDate(Member member, LocalDateTime localDateTime) {
        if (host instanceof Admin && host.equals(member)) {
            System.out.printf("[SESSION] %1$s %2$s 에서 진행되는 연습 날짜가 연기 되었습니다.\n",
                    Util.formatDateToKorean(date), place);
        }
    }

    public void removeSession(Member member) {
        if (host instanceof Admin && host.equals(member)) {
            System.out.printf("[SESSION] %1$s %2$s 에서 진행되는 연습 날짜가 취소 되었습니다.\n",
                    Util.formatDateToKorean(date), place);
        }
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getPlace() {
        return place;
    }

    public List<String> getParticipantsName() {
        return participants.stream()
                .map(member -> member.getName())
                .toList();
    }

    public String getHostName() {
        return host.getName();
    }

    public Status getStatus() {
        return status;
    }
}
