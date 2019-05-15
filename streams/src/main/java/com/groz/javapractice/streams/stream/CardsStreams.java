package com.groz.javapractice.streams.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface CardsStreams {

    String INPUT = "cards-in";
    String OUTPUT = "cards-out";

    @Input(INPUT)
    SubscribableChannel inboundCards();

    @Output(OUTPUT)
    SubscribableChannel outboundCards();
}
