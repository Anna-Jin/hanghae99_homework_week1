package com.homework.homework.test.service;

import com.homework.homework.test.dao.TestDao;
import com.homework.homework.test.domain.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestDao testDao;

    public List<Test> getTest() {
        return testDao.findAll();
    }

    public void addTest() {
        Test testUser = new Test("진유진", 26);
        Test savedUser = testDao.save(testUser);
    }
}
