package byfayzullayev.itcourses.controller;

import byfayzullayev.itcourses.entity.CardEntity;
import byfayzullayev.itcourses.model.receive.CardReceiveModel;
import byfayzullayev.itcourses.model.response.ApiResponse;
import byfayzullayev.itcourses.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/itCourses/cards")
public class CardController{
    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }


    @CrossOrigin
    @PostMapping("/add")
    public HttpEntity<?> addCard(@RequestBody CardReceiveModel cardReceiveModel) {
        return ResponseEntity.ok(cardService.addCard(cardReceiveModel));

    }

    @CrossOrigin
    @GetMapping("/list")
    public HttpEntity<?> getCourseList() {
        return ResponseEntity.ok(cardService.getCardList());

    }

    @CrossOrigin
    @PutMapping("/edit/{id}")
    public HttpEntity<?> updateCategory(@RequestBody CardEntity cardEntity, @PathVariable("id") long id) {
        return ResponseEntity.ok(cardService.updateCard(id, cardEntity));
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deleteProduct(@PathVariable("id") long id) {
        ApiResponse delete = cardService.deleteCard(id);
        return ResponseEntity.ok(delete);

    }


}