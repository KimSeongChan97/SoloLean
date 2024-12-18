package com.example.demo;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity // 이 클래스는 데이터베이스의 테이블과 매핑될 엔티티 클래스임을 표시합니다.
@Table(name = "boardtbl") // "boardtbl"이라는 데이터베이스 테이블과 연결될 클래스임을 지정합니다.
public class BoardEntity {
    
    @Id // PRIMARY KEY 설정: 데이터베이스 테이블에서 이 필드를 고유 식별자로 사용합니다.
    @Column(name = "seq") // "seq"라는 이름의 컬럼과 연결됩니다. 특정 데이터베이스에 맞게 자동으로 생성하는 방식, 자동으로 시퀀스 테이블이 생성된다.
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOARD_SEQ_GENERATOR")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PRIMARY KEY의 값을 자동 생성하도록 지정합니다. IDENTITY 전략은 데이터베이스가 자동으로 증가하는 숫자를 제공하게 합니다.
    private int seq; // "seq"는 고유 식별자이며, 자동으로 값이 생성되는 정수 필드입니다.

    @Column(name = "id", nullable = false, unique = true, length = 30) 
    // "id"라는 이름의 컬럼과 매핑되며, null 값을 허용하지 않습니다 (nullable=false).
    // 또한 고유한 값이어야 하므로(unique=true), 중복된 값을 허용하지 않습니다. 최대 길이는 30입니다.
    private String id; // 사용자의 ID 정보를 저장하는 필드입니다.

    @Column(name = "name", nullable = false, length = 30) 
    // "name"이라는 컬럼과 매핑되며, null 값을 허용하지 않습니다. 최대 길이는 30자로 설정되어 있습니다.
    private String name; // 사용자의 이름을 저장하는 필드입니다.

    @Column(name = "subject") 
    // "subject"라는 컬럼과 연결됩니다. null 값을 허용하며, 길이 제한은 따로 없습니다.
    private String subject; // 게시물의 제목을 저장하는 필드입니다.

    @Column(name = "content") 
    // "content"라는 컬럼과 매핑됩니다. null 값을 허용하며, 길이 제한이 없습니다.
    private String content; // 게시물의 내용을 저장하는 필드입니다.

    // private Timestamp logtime; 
    // @CreationTimestamp // 엔티티가 생성되는 시점의 시간 등록 - insert 할 때 자동으로 시간 등록
    @UpdateTimestamp // update 할 때 자동으로 시간 등록
    private LocalDateTime logtime = LocalDateTime.now(); // 현재 시간을 기본값으로 가지며, 자동으로 시간 갱신이 이루어질 필드입니다.
    
    // 
    
}
