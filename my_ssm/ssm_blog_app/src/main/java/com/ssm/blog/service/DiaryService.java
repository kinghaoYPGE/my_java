package com.ssm.blog.service;

import com.ssm.blog.model.Diary;

import java.util.List;

public interface DiaryService {

    void writediary(Diary diary);

    List<Diary> selectAllDiary();

    void deleteDiaryById(int diaryid);

}
