package com.gyt.fittrainer.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Diet {
    private Long dietId;

    private String dietType;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss" ,  timezone="GMT+8")
    private Date date;

    private String image;

    private Long sequence;

    private Long userId;

    private String base64Str;

    private String name;

}