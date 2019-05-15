package com.groz.javapractice.streams.config;

import com.groz.javapractice.streams.stream.CardsStreams;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(CardsStreams.class)
public class StreamsConfig {

}
