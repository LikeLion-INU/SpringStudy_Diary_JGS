package com.example.Diary.Entity;

import com.example.Diary.Dto.Diary.DiaryRequestDto;
import com.example.Diary.Entity.BaseEntity;
import com.example.Diary.Entity.UsersEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class DiaryEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diary_id")
    private Long id;    //고유 식별자
    private int publicState;   //공개상태 (0:전체공개 1:비공개 2:일부공개)
    @Column(name = "record_date")
    private LocalDate recordDate;   //일기상 날짜
    private String weather;     // 날씨
    private Double tempMin;     // 최저 온도
    private Double tempMax;     // 최고 온도

    private String title;   //제목
    private String contents; //내용
    private int photoYn;  //사진유무 (0:X 1:O)

    private int viewsCnt;   // 조회수
    private int likeItCnt;   // 좋아요수

    @ManyToOne
    @JoinColumn(name = "users_id")
    private UsersEntity users;

    @OneToMany(mappedBy = "diaryEntity")
    private List<PhotoFile> photoFileList;

    @OneToMany(mappedBy = "diaryEntity", fetch = FetchType.LAZY)
    private List<Viewer> viewerList;


    // 다이어리 수정
    public void updateDiary( DiaryRequestDto.updateDiary dto, Map<String, Object> weather){
        this.publicState = dto.getPublicState();
        this.recordDate = LocalDate.of(dto.getYear(), dto.getMonth(), dto.getDay());
        this.weather = (String) weather.get("weather");
        this.tempMin = (Double) weather.get("tempMin");
        this.tempMax = (Double) weather.get("tempMax");
        this.title = dto.getTitle();
        this.contents = dto.getContents();
        this.photoYn = dto.getPhotoYn();
    }

    // 조회수 카운트
    public void viewsCnt(){
        this.viewsCnt += 1;
    }

    // 좋아요수 카운트
    public void likeItsCnt(){
        this.likeItCnt += 1;
    }

}
