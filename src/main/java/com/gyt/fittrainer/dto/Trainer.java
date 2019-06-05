package com.gyt.fittrainer.dto;

import lombok.*;

import javax.persistence.Transient;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Trainer extends BaseDto{
    private Long trainerId;

    private Long userId;

    private String description;

    private String picture;

    @Transient
    private String userName;
}