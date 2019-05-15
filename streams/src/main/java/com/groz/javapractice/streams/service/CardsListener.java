package com.groz.javapractice.streams.service;

import com.groz.javapractice.streams.entity.Cards;
import com.groz.javapractice.streams.stream.CardsStreams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CardsListener {

    @StreamListener(CardsStreams.INPUT)
    public void handleGreetings(@Payload Cards cards) {
        log.info("Received cards: {}", cards);
    }
}
