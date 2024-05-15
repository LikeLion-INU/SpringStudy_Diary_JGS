package com.example.Diary.Controller.diary;

import com.example.Diary.Controller.diary.dto.DiaryRequestDto;
import com.example.Diary.Controller.diary.dto.DiaryResponseDto;
import com.example.Diary.Entity.DiaryEntity;
import com.example.Diary.Entity.UsersEntity;
import com.example.Diary.Repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class DiaryServiceImpl implements DiaryService{
    private final DiaryRepository diaryRepository;

    /**
     * 다이어리 - 다이어리 작성 (날씨 API / 이미지 첨부)
     * @param dto DiaryRequestDto.writeDiary
     * @return DiaryResponseDto.writeDiary
     */
    @Override
    public DiaryResponseDto.writeDiary writeDiary(DiaryRequestDto.writeDiary dto, Long userId) throws ParseException {
//        // 1. 존재하는 user인지 확인
//        UsersEntity users =

        // 1. 날씨 API 로 전달할 데이터 set 생성
        Map<String, Object> dataSet = new HashMap<>();

        // 2. 위.경도 데이터 가져오기
        JSONObject latAndLon = getLatAndLon(dto.getLocationName());
        dataSet.put("lat", latAndLon.get("lat"));
        dataSet.put("lon", latAndLon.get("lon"));

        // 3. 해당 날짜의 00시 unix 시간 가져오기
        dataSet.put("nowUnixTime", unixTime(LocalDate.of(dto.getYear(), dto.getMonth(), dto.getDay())));

        // 4. 전달받은 날짜를 가지고 날씨 API에서 데이터 가져오기
        Map<String, Object> weather = getWeather(dataSet);

        // 4. 데이터 저장
        DiaryEntity diaryEntity = dto.toEntity(weather);

        return null;
    }

    /**
     * 다이어리 - 작성한 다이어리 수정
     * @param dto DiaryRequestDto.updateDiary
     * @return DiaryResponseDto.updateDiary
     */
    @Override
    public DiaryResponseDto.updateDiary updateDiary(DiaryRequestDto.updateDiary dto, Long userId) {
        // 1. 구분자 값으로 데이터 존재 여부 확인

        // 2. 데이터가 존재하는 경우, 날짜값을 비교하여 날짜가 변경된 경우, 날씨 API에서 데이터 가져오기

        // 3. 데이터 수정
        return null;
    }

    /**
     * 다이어리 - 작성한 다이어리 삭제
     * @param dto DiaryRequestDto.deleteDiary
     * @return DiaryResponseDto.deleteDiary
     */
    @Override
    public DiaryResponseDto.deleteDiary deleteDiary(DiaryRequestDto.deleteDiary dto, Long userId) {
        // 1. 데이터 존재 여부 확인

        // 2. 존재하는 경우, 삭제
        return null;
    }

    /**
     * 다이어리 - 열람가능한 다이어리 리스트 조회
     * @param dto DiaryRequestDto.diaryList
     * @return DiaryResponseDto.diaryList
     */
    @Override
    public DiaryResponseDto.diaryList diaryList(DiaryRequestDto.diaryList dto, Long userId) {
        // 1. 사용자가 팔로우한 목록 확인

        // 2. 본인 및 팔로우한 사람이 작성한 사람에 해당하는 데이터 가져오기

        // 3. entity 데이터 dto 로 전환
        return null;
    }

    /**
     * 다이어리 - 상세읽기 ( 권한 설정 - 비공개, 전체공개, 일부공개 )
     * @param dto DiaryRequestDto.diaryContent
     * @return DiaryResponseDto.diaryContent
     */
    @Override
    public DiaryResponseDto.diaryContent diaryContent(DiaryRequestDto.diaryContent dto, Long userId) {
        // 1. 조회 요청한 다이어리 정보 가져오기

        // 2. 사용자가 팔로우한 사용자인지 확인

        // 3. 2에서 접근 권한이 있는 경우, 데이터 전달

        return null;
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
}

