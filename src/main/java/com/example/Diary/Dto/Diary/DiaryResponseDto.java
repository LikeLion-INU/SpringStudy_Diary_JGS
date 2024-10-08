package com.example.Diary.Dto.Diary;

import com.example.Diary.Entity.DiaryEntity;
import com.example.Diary.Entity.UsersEntity;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class DiaryResponseDto {
    @Getter
    @Builder
    public static class writeDiary{
        private Long diaryId;
        private LocalDate recordDate;
        private String weather;
        private Double tempMin;
        private Double tempMax;

    }
    @Getter
    @Builder
    public static class updateDiary{
        private Long diaryId;
        private LocalDate recordDate;
        private String weather;
        private Double tempMin;
        private Double tempMax;
    }
    @Getter
    @Builder
    public static class canViewDiaryList{
        private List<DiaryDto> diaryList;

    }
    @Getter
    public static class diaryContent{
        private Long diaryId;       //고유 식별자
        private int publicState;    //공개상태 (0:전체공개 1:비공개 2:일부공개)
        private LocalDate recordDate;   //일기상 날짜
        private String weather;     // 날씨
        private Double tempMin;     // 최저 온도
        private Double tempMax;     // 최고 온도
        private String title;       //제목
        private String contents;    //내용
        private int photoYn;        //사진유무 (0:X 1:O)
        private int viewsCnt;        //조회수
        private int likeItCnt;        //좋아요수
        private List<viewerList> viewerList;  // 일부 공개의 경우, 볼 수 있는 유저 정보
        private List<byte[]> imgDataList;

        public diaryContent(DiaryEntity entity, List<viewerList> viewerList, List<byte[]> imgDataList){
            this.diaryId = entity.getId();
            this.publicState = entity.getPublicState();
            this.recordDate = entity.getRecordDate();
            this.weather = entity.getWeather();
            this.tempMin = entity.getTempMin();
            this.tempMax = entity.getTempMax();
            this.title = entity.getTitle();
            this.contents = entity.getContents();
            this.photoYn = entity.getPhotoYn();
            this.viewsCnt = entity.getViewsCnt();
            this.likeItCnt = entity.getLikeItCnt();
            this.viewerList = viewerList;
            this.imgDataList = imgDataList;
        }
    }

    @Getter
    public static class viewerList {
        private Long id;                // 사용자 고유 식별자
        private String userNickname;    // 사용자 닉네임
        public viewerList(UsersEntity entity) {
            this.id = entity.getId();
            this.userNickname = entity.getUserNickname();
        }
    }

    @Getter
    @Builder
    public static class viewsCnt {
        private int viewsCnt;
    }


    //다이어리 리스트 반환
    @Getter
    public static class DiaryListDto {
        private List<DiaryDto> diaryDtoList;
        public DiaryListDto(List<DiaryDto> diaryDtoList) {

            this.diaryDtoList = diaryDtoList;
        }
    }
}
