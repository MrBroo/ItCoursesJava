package byfayzullayev.itcourses.service;

import byfayzullayev.itcourses.entity.CardEntity;
import byfayzullayev.itcourses.model.receive.CardReceiveModel;
import byfayzullayev.itcourses.model.response.ApiResponse;
import byfayzullayev.itcourses.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@RequiredArgsConstructor
@Service
public class CardServiceImplements implements BaseService {

    private final CardRepository cardRepository;

    public ApiResponse addCard(CardReceiveModel cardReceiveModel) {

        CardEntity cardEntity = new CardEntity();
        cardEntity.setName(cardReceiveModel.getName());
        cardEntity.setAbout(cardReceiveModel.getAbout());
        cardRepository.save(cardEntity);
        return SUCCESS_V2;
    }

    public ApiResponse getCardList(){
        SUCCESS.setData(cardRepository.findAll());
        return SUCCESS;
    }
    public ApiResponse updateCard(long id, CardEntity cardEntity) {
        Optional<CardEntity> optionalCardEntity = cardRepository.findById(id);
        if (optionalCardEntity.isPresent()) {
            CardEntity updateId = optionalCardEntity.get();
            Optional<CardEntity> updateCard = cardRepository.findByName(cardEntity.getName());

            if (updateCard.isPresent())
                return CARD_EXIST;

            updateId.setName(cardEntity.getName());
            cardRepository.save(updateId);
        }
        return SUCCESS_V2;
    }

    public ApiResponse deleteCard(long id) {
        Optional<CardEntity> optionalCategoryEntity = cardRepository.findById(id);
        if (optionalCategoryEntity.isPresent()) {
            cardRepository.deleteById(id);

            return SUCCESS_V2;
        }
        return ERROR_DELETE;
    }
}

