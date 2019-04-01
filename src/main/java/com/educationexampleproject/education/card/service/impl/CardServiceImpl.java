package com.educationexampleproject.education.card.service.impl;

import com.educationexampleproject.education.card.dao.CardDao;
import com.educationexampleproject.education.card.entity.Card;
import com.educationexampleproject.education.card.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    CardDao cardDao;

    @Override
    public List<Card> queryCard(String menuId,String cardTwo) {
        return cardDao.queryCard(menuId,cardTwo);
    }

    @Override
    public Card queryCardToTitle(String title) {
        return cardDao.queryCardToTitle(title);
    }
}
