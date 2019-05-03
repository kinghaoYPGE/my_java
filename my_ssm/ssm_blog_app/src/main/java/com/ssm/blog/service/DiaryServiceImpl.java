package com.ssm.blog.service;

import com.ssm.blog.mapper.DiaryMapper;
import com.ssm.blog.model.Diary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaryServiceImpl implements DiaryService {

    @Autowired
    private DiaryMapper diarymapper;

    public void writediary(Diary diary) {
        diarymapper.writediary(diary);

    }

    public List<Diary> selectAllDiary() {
        List<Diary> diarys = this.diarymapper.selectAllDiary();
        return diarys;
    }

    public void deleteDiaryById(int diaryid) {
        diarymapper.deleteDiaryById(diaryid);

    }

}