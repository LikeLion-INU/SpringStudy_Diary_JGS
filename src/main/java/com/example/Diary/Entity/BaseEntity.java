package com.example.Diary.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
//BaseEntity는 Entity가 아님. Entity클래스에서 일반 클래스를 상속받기 위함
// ->BaseEntity가 데이터베이스에 매핑 되지만 실질적으로는 엔티티테이블에 매핑되는 엔티티가 아님을 나타냄.
@MappedSuperclass
//Entity의 lifecycle event를 수신할 Entity listener 클래스 지정
@EntityListeners(AuditingEntityListener.class)

//추상화를 통해 다른클래스의 기본 클래스로 사용 가능
//@Entity 하지않는 이유
// -> Entity테이블에 매핑 하지않고 다른 클래스에 상속되어 필드 생성하는 추상 클래스(@MappedSuperClass 설명)
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 고유 식별자

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createDate; //생성시간

    @LastModifiedDate
    private LocalDateTime updateDate; //수정시간
}
