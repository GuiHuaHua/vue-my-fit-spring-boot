package com.gyt.fittrainer.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ClassRequest {
    private Long requestId;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss" ,  timezone="GMT+8")
    private Date startTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss" ,  timezone="GMT+8")
    private Date endTime;

    private String classType;

    private String isadjust;

    private String bodypart;

    private String status;

    private String note;

    @JsonFormat(pattern="yyyy-MM-dd" ,  timezone="GMT+8")
    private Date requestDate;

    private Long userId;

    private Long trainerId;

    @Transient
    private String classTypeName;

    @Transient
    private String trainerName;

    @Transient
    private String statusName;

    @Transient
    private String telephone;

    @Transient
    private Date[] classTime;

    @Transient
    private List<String> bodypartList;

}