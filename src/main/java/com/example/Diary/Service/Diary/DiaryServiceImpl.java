package com.example.Diary.Service.Diary;

import com.example.Diary.Dto.Diary.DiaryDto;
import com.example.Diary.Dto.Diary.DiaryRequestDto;
import com.example.Diary.Dto.Diary.DiaryResponseDto;
import com.example.Diary.Entity.*;
import com.example.Diary.Repository.DiaryRepository;
import com.example.Diary.Repository.FollowRepository;
import com.example.Diary.Repository.LikeitRepository;
import com.example.Diary.Repository.Users.UsersRepository;
import com.example.Diary.Repository.ViewerRepository;
import com.example.Diary.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DiaryServiceImpl implements DiaryService{
    private final UsersRepository usersRepository;
    private final DiaryRepository diaryRepository;
    private final FollowRepository followRepository;
    private final ViewerRepository viewerRepository;
    private final LikeitRepository likeitRepository;

    /**
     * 다이어리 - 다이어리 작성 (날씨 API / 이미지 첨부)
     * @param dto DiaryRequestDto.writeDiary
     * @param userId Long
     * @return ApiResponse<DiaryResponseDto.writeDiary>
     */
    @Override
    @Transactional
    public ApiResponse<DiaryResponseDto.writeDiary> writeDiary(DiaryRequestDto.writeDiary dto, Long userId) throws ParseException {
        // 1. 존재하는 user인지 확인
        Optional<UsersEntity> usersOpt = usersRepository.findById(userId);
        if(usersOpt.isEmpty()) return ApiResponse.ERROR(401, "존재하지 않는 user 입니다.");
        UsersEntity users = usersOpt.get();

        // 2. DB에 저장할 날씨 데이터 생성
        Map<String, Object> weather = setWeatherData(
                dto.getLocationName(),dto.getYear(), dto.getMonth(), dto.getDay());

        // 3. 다이어리 저장
        DiaryEntity diaryEntity = dto.toEntity(weather, users);
        Long diaryId = diaryRepository.save(diaryEntity).getId();

        // 4. 일부 공개의 경우, 열람 가능한 리스트 저장
        if (dto.getPublicState() == 2)
            viewerInsert(dto.getUserSeqBundle(), diaryEntity);

        // 5. 사진이 존재하는 경우, 사진 데이터 저장

        return ApiResponse.SUCCESS(200, "저장되었습니다.",
                DiaryResponseDto.writeDiary.builder()
                        .diaryId(diaryId)
                        .recordDate(diaryEntity.getRecordDate())
                        .weather(diaryEntity.getWeather())
                        .tempMin(diaryEntity.getTempMin())
                        .tempMax(diaryEntity.getTempMax())
                        .build());
    }

    /**
     * 다이어리 - 작성한 다이어리 수정
     * @param dto DiaryRequestDto.updateDiary
     * @param userId Long
     * @return ApiResponse<DiaryResponseDto.updateDiary>
     */
    @Override
    @Transactional
    public ApiResponse<?> updateDiary(DiaryRequestDto.updateDiary dto, Long userId) throws ParseException {
        // 1. 존재하는 user인지 확인
        Optional<UsersEntity> usersOpt = usersRepository.findById(userId);
        if(usersOpt.isEmpty()) return ApiResponse.ERROR(401, "존재하지 않는 user 입니다.");
        UsersEntity users = usersOpt.get();

        // 2. 존재하는 diary인지 확인
        Optional<DiaryEntity> diaryOpt = diaryRepository.findById(dto.getDiaryId());
        if (diaryOpt.isEmpty() || !userId.equals(diaryOpt.get().getUsers().getId()))
            return ApiResponse.ERROR(401, "존재하지 않는 diary 입니다.");
        DiaryEntity diary = diaryOpt.get();

        // 3. DB에 저장할 날씨 데이터 생성
        Map<String, Object> weather = setWeatherData(
                dto.getLocationName(),dto.getYear(), dto.getMonth(), dto.getDay());

        // 4. 수정 전 공개도가 일부공개인 경우, viewer 삭제
        if (diary.getPublicState() == 2) {
            viewerDelete(diary.getId());
        }

        // 5. 수정 후 공개도가 일부공개인 경우, viewer 등록
        if (dto.getPublicState() == 2)
            viewerInsert(dto.getUserSeqBundle(), diary);

        // 6. 사진이 존재여부에 따른 사진 데이터 삭제 또는 저장

        // 7. 데이터 수정
        diary.updateDiary(dto, weather);

        return ApiResponse.SUCCESS(200, "수정되었습니다.",
                DiaryResponseDto.updateDiary.builder()
                        .diaryId(diary.getId())
                        .recordDate(diary.getRecordDate())
                        .weather(diary.getWeather())
                        .tempMin(diary.getTempMin())
                        .tempMax(diary.getTempMax())
                        .build());
    }

    /**
     * 다이어리 - 작성한 다이어리 삭제
     * @param dto DiaryRequestDto.deleteDiary
     * @param userId Long
     * @return DiaryResponseDto.deleteDiary
     */
    @Override
    @Transactional
    public ApiResponse<?> deleteDiary(DiaryRequestDto.deleteDiary dto, Long userId) {
        // 1. 존재하는 user인지 확인
        Optional<UsersEntity> usersOpt = usersRepository.findById(userId);
        if(usersOpt.isEmpty()) return ApiResponse.ERROR(401, "존재하지 않는 user 입니다.");
        UsersEntity users = usersOpt.get();

        // 2. 존재하는 diary인지 확인
        Optional<DiaryEntity> diaryOpt = diaryRepository.findById(dto.getDiaryId());
        if (diaryOpt.isEmpty() || !userId.equals(diaryOpt.get().getUsers().getId()))
            return ApiResponse.ERROR(401, "존재하지 않는 diary 입니다.");
        DiaryEntity diary = diaryOpt.get();

        // 3. 사진 데이터 확인 후 삭제


        // 4. 열람 가능 사용자 로우 확인후 삭제
        viewerDelete(diary.getId());

        // 5. diary 삭제
        diaryRepository.delete(diary);

        return ApiResponse.SUCCESS(200, "삭제되었습니다.");
    }

    /**
     * 다이어리 - 열람가능한 다이어리 리스트 조회
     * @param userId Long
     * @return DiaryResponseDto.diaryList
     */
    @Override
    public ApiResponse<?> canViewDiaryList(Long userId) {
        // 1. 존재하는 user인지 확인
        Optional<UsersEntity> usersOpt = usersRepository.findById(userId);
        if(usersOpt.isEmpty()) return ApiResponse.ERROR(401, "존재하지 않는 user 입니다.");
        UsersEntity users = usersOpt.get();

        // 2. 본인 및 팔로우한 사람이 작성한 사람에 해당하는 데이터 가져오기
        List<DiaryEntity> canViewDiaryList = diaryRepository.canViewDiaryList(userId);

        // 3. entity 데이터 dto 로 전환
        List<DiaryDto> diaryDtoList = new ArrayList<>();
        for (DiaryEntity entity: canViewDiaryList){
            DiaryDto diaryDto = new DiaryDto(entity);

            // 3-1. 이미지가 있는 경우, 이미지 첨부

            diaryDtoList.add(diaryDto);
        }

        return ApiResponse.SUCCESS(200, "조회가 완료되었습니다.",
                DiaryResponseDto.canViewDiaryList.builder()
                        .diaryList(diaryDtoList)
                        .build());
    }

    /**
     * 다이어리 - 상세읽기 ( 권한 설정 - 비공개, 전체공개, 일부공개 )
     * @param dto DiaryRequestDto.diaryContent
     * @param userId Long
     * @return ApiResponse<DiaryResponseDto.diaryContent>
     */
    @Override
    public ApiResponse<?> diaryContent(DiaryRequestDto.diaryContent dto, Long userId) {
        // 1. 존재하는 user인지 확인
        Optional<UsersEntity> usersOpt = usersRepository.findById(userId);
        if(usersOpt.isEmpty()) return ApiResponse.ERROR(401, "존재하지 않는 user 입니다.");
        UsersEntity users = usersOpt.get();

        // 2. 존재하는 diary인지 확인
        Optional<DiaryEntity> diaryOpt = diaryRepository.findById(dto.getDiaryId());
        if (diaryOpt.isEmpty() || !userId.equals(diaryOpt.get().getUsers().getId()))
            return ApiResponse.ERROR(401, "존재하지 않는 diary 입니다.");
        DiaryEntity diary = diaryOpt.get();
        List<DiaryResponseDto.viewerList> viewerListDto = new ArrayList<>();

        // 2-1. 일부공개의 경우, 공개 설정된 유저 정보 넘겨주기
        if (diary.getPublicState() == 2) {
            List<Viewer> viewerList = viewerRepository.findByDiaryEntity_Id(diary.getId());
            for (Viewer entity : viewerList)
                viewerListDto.add(new DiaryResponseDto.viewerList(entity.getUsersEntity()));
        }

        // 3. 본인이 작성한 diary인지 확인
        if (userId.equals(diary.getUsers().getId()))
            return ApiResponse.SUCCESS(200, "조회가 완료되었습니다.",
                    new DiaryResponseDto.diaryContent(diary, viewerListDto));

        // 4. 비공개 상태인지 확인
        if(diary.getPublicState() == 1)
            return ApiResponse.ERROR(401, "열람 불가능한 diary 입니다.");

        // 5. 승인된 팔로우 인지 확인
        Optional<Follow> followOpt = followRepository
                .findByApproveYnAndReqUsersEntity_IdAndResUsersEntity_Id(
                        1, userId, diary.getUsers().getId());
        if(followOpt.isEmpty())
            return ApiResponse.ERROR(401, "열람 불가능한 diary 입니다.");

        // 6. 전체 공개 상태인지 확인
        if(diary.getPublicState() == 0)
            return ApiResponse.SUCCESS(200, "조회가 완료되었습니다.",
                    new DiaryResponseDto.diaryContent(diary,viewerListDto));

        // 7. 일부공개 권한이 있는 viewer인지 확인
        Optional<Viewer> viewerOpt = viewerRepository
                .findByDiaryEntity_IdAndUsersEntity_Id(diary.getId(), userId);

        if(viewerOpt.isEmpty())
            return ApiResponse.ERROR(401, "열람 불가능한 diary 입니다.");
        else
            return ApiResponse.SUCCESS(200, "조회가 완료되었습니다.",
                    new DiaryResponseDto.diaryContent(diary, viewerListDto));
    }

    @Override
    @Transactional
    public ApiResponse<?> viewsCnt(DiaryRequestDto.viewsCnt dto, Long userId) {
        // 1. 존재하는 user인지 확인
        Optional<UsersEntity> usersOpt = usersRepository.findById(userId);
        if(usersOpt.isEmpty()) return ApiResponse.ERROR(401, "존재하지 않는 user 입니다.");
        UsersEntity users = usersOpt.get();

        // 2. 존재하는 diary인지 확인
        Optional<DiaryEntity> diaryOpt = diaryRepository.findById(dto.getDiaryId());
        if (diaryOpt.isEmpty() || !userId.equals(diaryOpt.get().getUsers().getId()))
            return ApiResponse.ERROR(401, "존재하지 않는 diary 입니다.");
        DiaryEntity diary = diaryOpt.get();

        // 3. diary 조회수 카운트
        diary.viewsCnt();

        return ApiResponse.SUCCESS(200, "조회가 반영되었습니다.",
                DiaryResponseDto.viewsCnt.builder()
                        .viewsCnt(diary.getViewsCnt())
                        .build());
    }

    /**
     * 다이어리 - 좋아요 기능
     * @param dto DiaryRequestDto.doLikeIt
     * @param userId Long
     * @return ApiResponse<?>
     */
    @Override
    @Transactional
    public ApiResponse<?> doLikeIt(DiaryRequestDto.doLikeIt dto, Long userId) {
        // 1. 존재하는 user인지 확인
        Optional<UsersEntity> usersOpt = usersRepository.findById(userId);
        if(usersOpt.isEmpty()) return ApiResponse.ERROR(401, "존재하지 않는 user 입니다.");
        UsersEntity users = usersOpt.get();

        // 2. 존재하는 diary인지 확인
        Optional<DiaryEntity> diaryOpt = diaryRepository.findById(dto.getDiaryId());
        if (diaryOpt.isEmpty() || !userId.equals(diaryOpt.get().getUsers().getId()))
            return ApiResponse.ERROR(401, "존재하지 않는 diary 입니다.");
        DiaryEntity diary = diaryOpt.get();

        // 3. diary 좋아요수 카운트
        diary.likeItsCnt();

        // 4. like it 생성
        LikeitEntity likeitEntity = LikeitEntity.builder()
                .diary(diary)
                .users(users)
                .build();
        likeitRepository.save(likeitEntity);

        return ApiResponse.SUCCESS(200, "좋아요가 반영되었습니다.");
    }








    /* ===============================================================================================
     * private 공통 코드 모음
     * ===============================================================================================*/

    // DB에 저장할 날씨 데이터 생성
    private Map<String, Object> setWeatherData(String locationName, int year, int month, int day) throws ParseException {
        Map<String, Object> dataSet = new HashMap<>();

        // 3. 위.경도 데이터 가져오기
        JSONObject latAndLon = getLatAndLon(locationName);
        dataSet.put("lat", latAndLon.get("lat"));
        dataSet.put("lon", latAndLon.get("lon"));

        // 4. 해당 날짜의 00시 unix 시간 가져오기
        dataSet.put("nowUnixTime", unixTime(LocalDate.of(year, month, day)));

        // 5. 전달받은 날짜를 가지고 날씨 API에서 데이터 가져오기
        return getWeather(dataSet);
    }

    // 유닉스 타임스탬프 시간 얻기
    private long unixTime(LocalDate date){
        LocalDateTime dateTime = LocalDateTime.of(date, LocalTime.of(0,0));
        return dateTime.atZone(ZoneId.systemDefault()).toEpochSecond();
    }

    // 위.경도 데이터 가져오기
    private JSONObject getLatAndLon(String locationName) throws ParseException {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://api.openweathermap.org/geo/1.0/direct?" +
                "limit=1&appid=b5477fb4a3810f49c1ddcc25da4e9432&q="+locationName;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(response.getBody());
        System.out.println(jsonArray.get(0));
        return (JSONObject) jsonParser.parse(jsonArray.get(0).toString());
    }

    // 날씨 데이터 가져오기
    private Map<String, Object> getWeather(Map<String, Object> dataSet) throws ParseException {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://history.openweathermap.org/data/2.5/history/city?" +
                "type=hour&cnt=24&units=metric" +
                "&appid=b5477fb4a3810f49c1ddcc25da4e9432" +
                "&lat=" + dataSet.get("lat") +
                "&lon=" + dataSet.get("lon") +
                "&start=" + dataSet.get("nowUnixTime");
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(response.getBody());
        System.out.println(jsonObject);
        JSONArray list = (JSONArray) jsonParser.parse(jsonObject.get("list").toString());
        System.out.println(list);

        Double tempMin = null;
        Double tempMax = null;
        Map<String, Integer> weatherMap = new HashMap<>();

        for (int i = 1; i < list.size(); i++){
            JSONObject item = (JSONObject) list.get(i);

            // 최저, 최고 온도 매핑
            JSONObject itemMain = (JSONObject) item.get("main");
            Double itemTempMin = (Double) itemMain.get("temp_min");
            Double itemTempMax = (Double) itemMain.get("temp_max");
            tempMin = (tempMin == null || tempMin > itemTempMin) ? itemTempMin : tempMin;
            tempMax = (tempMax == null || tempMax < itemTempMax) ? itemTempMax : tempMax;

            // 날씨 데이터 매핑 카운트
            JSONArray itemWeatherList = (JSONArray) item.get("weather");
            JSONObject itemWeather = (JSONObject) itemWeatherList.get(0);
            String itemWeatherMain = (String) itemWeather.get("main");
            int cnt = weatherMap.getOrDefault(itemWeatherMain, 0);
            weatherMap.put(itemWeatherMain, cnt+1);
        }

        // 최다 날씨데이터 추출
        String weather = "";
        int maxCnt = 0;
        for (String key : weatherMap.keySet()) {
            if(maxCnt <= weatherMap.get(key)){
                maxCnt = weatherMap.get(key);
                weather = key;
            }
        }

        Map<String, Object> result = new HashMap<>();
        result.put("tempMin", tempMin);
        result.put("tempMax", tempMax);
        result.put("weather", weather);

        return result;
    }

    // 일부 공개의 경우, 열람 가능한 리스트 저장
    private void viewerInsert(String userSeqBundle, DiaryEntity diaryEntity){
        // 1. 문자열 , 단위로 구분하여 배열 생성
        String[] userSeqArray = userSeqBundle.split(",");
        List<Viewer> viewerList = new ArrayList<>();

        // 2. viewer 리스트 생성
        for (String userSeqStr : userSeqArray) {
            viewerList.add(Viewer.builder()
                    .diaryEntity(diaryEntity)
                    .usersEntity(new UsersEntity(Long.parseLong(userSeqStr)))
                    .build());
        }

        // 3. viewer 저장
        if (!viewerList.isEmpty())
            viewerRepository.saveAll(viewerList);
    }

    // 일부공개 시 열람 가능 사용자 로우 확인후 삭제
    private void viewerDelete(Long id){
        List<Viewer> beforeViewers = viewerRepository.findByDiaryEntity_Id(id);
        viewerRepository.deleteAll(beforeViewers);
    }

}

