//package com.example.Diary.Entity;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@Getter
//@Entity
//public class RegionFirst {
//    @Id
//    @Column(name = "rf_id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;        // 고유 식별자
//    private String rfName;  // 시도명
//
//    @OneToMany(mappedBy = "regionFirst")
//    private List<Region> regionList;
//}
