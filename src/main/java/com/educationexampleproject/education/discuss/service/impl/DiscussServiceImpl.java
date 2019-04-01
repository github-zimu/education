package com.educationexampleproject.education.discuss.service.impl;

import com.educationexampleproject.education.discuss.dao.DiscussDao;
import com.educationexampleproject.education.discuss.entity.Discuss;
import com.educationexampleproject.education.discuss.service.DiscussService;
import com.educationexampleproject.education.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DiscussServiceImpl implements DiscussService {

    @Autowired
    DiscussDao discussDao;

    @Override
    public List<Discuss> queryDiscuss(String cardId) {
        return discussDao.queryDiscuss(cardId);
    }

    @Override
    public int addDiscuss(Discuss discuss) {
        discuss.setId(UUIDUtil.getUUID());
        discuss.setDisTime(new java.sql.Date(new Date().getTime()) + "");
        return discussDao.addDiscuss(discuss);
    }
}
