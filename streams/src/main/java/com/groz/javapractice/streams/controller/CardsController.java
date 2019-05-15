package com.groz.javapractice.streams.controller;

import com.groz.javapractice.streams.entity.Cards;
import com.groz.javapractice.streams.service.CardsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {

    private CardsService cardsService;

    public CardsController(CardsService cardsService) {
        this.cardsService = cardsService;
    }

    @GetMapping("/cards")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void greetings(@RequestParam("suit") String suit, @RequestParam("name") String name) {
        Cards cards = Cards.builder()
                .suit(suit)
                .name(name)
                .build();

        cardsService.sendCards(cards);
    }
}
