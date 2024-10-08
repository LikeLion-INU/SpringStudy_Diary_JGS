package com.example.Diary.Controller;

import com.example.Diary.Dto.Diary.DiaryRequestDto;
import com.example.Diary.Service.Diary.DiaryServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/diary")
@RequiredArgsConstructor
public class DiaryController {
    private final DiaryServiceImpl diaryService;

    /**
     * 다이어리 작성 (날씨 API / 이미지 첨부)
     * @param dto DiaryRequestDto.writeDiary
     * @return ResponseEntity<?>
     */
    @PostMapping("/writeDiary")
    public ResponseEntity<?> writeDiary(DiaryRequestDto.writeDiary dto, HttpServletRequest request) throws ParseException {
        HttpSession session = request.getSession(false);
        Long userId = (Long) session.getAttribute("userId");
        return ResponseEntity.ok().body(diaryService.writeDiary(dto, userId));
    }

    /**
     * 다이어리 - 작성한 다이어리 수정
     * @param dto DiaryRequestDto.updateDiary
     * @return ResponseEntity<?>
     */
    @PostMapping("/updateDiary")
    public ResponseEntity<?> updateDiary(DiaryRequestDto.updateDiary dto, HttpServletRequest request) throws ParseException {
        HttpSession session = request.getSession(false);
        Long userId = (Long) session.getAttribute("userId");
        return ResponseEntity.ok().body(diaryService.updateDiary(dto, userId));
    }

    /**
     * 다이어리 - 작성한 다이어리 삭제
     * @param dto DiaryRequestDto.deleteDiary
     * @return ResponseEntity<?>
     */
    @PostMapping("/deleteDiary")
    public ResponseEntity<?> deleteDiary(@RequestBody DiaryRequestDto.deleteDiary dto, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Long userId = (Long) session.getAttribute("userId");
        return ResponseEntity.ok().body(diaryService.deleteDiary(dto, userId));
    }

    /**
     * 다이어리 - 열람가능한 다이어리 리스트 조회
     * @return ResponseEntity<?>
     */
    @PostMapping("/diaryList")
    public ResponseEntity<?> diaryList(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Long userId = (Long) session.getAttribute("userId");
        return ResponseEntity.ok().body(diaryService.canViewDiaryList(userId));
    }

    /**
     * 다이어리 - 상세읽기 ( 권한 설정 - 비공개, 전체공개, 일부공개 )
     * @param dto DiaryRequestDto.diaryContent
     * @return ResponseEntity<?>
     */
    @PostMapping("/diaryContent")
    public ResponseEntity<?> diaryContent(@RequestBody DiaryRequestDto.diaryContent dto, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Long userId = (Long) session.getAttribute("userId");
        return ResponseEntity.ok().body(diaryService.diaryContent(dto, userId));
    }

    /**
     * 다이어리 - 조회수 카운트
     * @param dto DiaryRequestDto.viewsCnt
     * @param request HttpServletRequest
     * @return ResponseEntity<?>
     */
    @PostMapping("/viewsCnt")
    public ResponseEntity<?> viewsCnt(@RequestBody DiaryRequestDto.viewsCnt dto, HttpServletRequest request){
        HttpSession session = request.getSession(false);
        Long userId = (Long) session.getAttribute("userId");
        return ResponseEntity.ok().body(diaryService.viewsCnt(dto, userId));
    }

    /**
     * 다이어리 - 좋아요 기능
     * @param dto DiaryRequestDto.doLikeIt
     * @param request HttpServletRequest
     * @return ResponseEntity<?>
     */
    @PostMapping("/doLikeIt")
    public ResponseEntity<?> doLikeIt(@RequestBody DiaryRequestDto.doLikeIt dto, HttpServletRequest request){
        HttpSession session = request.getSession(false);
        Long userId = (Long) session.getAttribute("userId");
        return ResponseEntity.ok().body(diaryService.doLikeIt(dto, userId));
    }
}
