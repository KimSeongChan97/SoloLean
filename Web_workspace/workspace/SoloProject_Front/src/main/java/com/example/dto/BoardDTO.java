package com.example.dto;

import java.util.Date;

public class BoardDTO {
    private int seq;           // 게시글 번호
    private String memberId;   // 작성자 ID
    private String subject;    // 게시글 제목
    private String content;    // 게시글 내용
    private Date logtime;      // 작성 시간

    // 기본 생성자
    public BoardDTO() {}

    // 모든 필드를 포함하는 생성자
    public BoardDTO(int seq, String memberId, String subject, String content, Date logtime) {
        this.seq = seq;
        this.memberId = memberId;
        this.subject = subject;
        this.content = content;
        this.logtime = logtime;
    }

    // Getter와 Setter
    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getLogtime() {
        return logtime;
    }

    public void setLogtime(Date logtime) {
        this.logtime = logtime;
    }
}
