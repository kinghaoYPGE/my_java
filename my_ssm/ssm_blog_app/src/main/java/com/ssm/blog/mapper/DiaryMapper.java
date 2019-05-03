package com.ssm.blog.mapper;

import com.ssm.blog.model.Diary;

import java.util.List;

public interface DiaryMapper {

    void writediary(Diary diary);

    List<Diary> selectAllDiary();

    void deleteDiaryById(int diaryid);

}