package com.lmh.service;

import com.lmh.bean.Teacher;
import com.lmh.dao.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LMH
 * @create 2019-12-17 0:10
 */

@Service
public class TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    public List<Teacher> getAll(){
        return teacherMapper.selectAll();
    }

}
