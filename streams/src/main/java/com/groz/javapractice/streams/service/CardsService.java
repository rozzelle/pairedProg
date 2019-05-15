package com.groz.javapractice.streams.service;

import com.groz.javapractice.streams.entity.Cards;
import com.groz.javapractice.streams.stream.CardsStreams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
@Slf4j
public class CardsService {

    private CardsStreams cardsStreams;

    public CardsService(CardsStreams cardsStreams) {
        this.cardsStreams = cardsStreams;
    }

    public void sendCards(Cards cards) {
        log.info("Sending greetings {}", cards);

        MessageChannel messageChannel = cardsStreams.outboundCards();
        messageChannel.send(MessageBuilder
                .withPayload(cards)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
    }
}
