package com.groz.javapractice.streams.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Cards {
    private String suit;
    private String name;
}
