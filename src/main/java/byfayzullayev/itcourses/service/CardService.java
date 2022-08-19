package byfayzullayev.itcourses.service;

import byfayzullayev.itcourses.entity.CardEntity;

import java.util.List;

public interface CardService {
    CardEntity addCard(CardEntity card);
    CardEntity getCard(String card);
    List<CardEntity> getCards();
    CardEntity editCard(CardEntity card, long id);
    CardEntity deleteCard(CardEntity card);
}
