package com.example.Diary.Entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Region {
    @Id
    @Column(name = "region_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;            // 고유 식별자
    private String regionName;  // 시도명
    private int nx;             // X 좌표
    private int yx;             // Y 좌표

    @ManyToOne
    @JoinColumn(name="rf_id")
    private RegionFirst regionFirst;   // 도어락 구분자
}
