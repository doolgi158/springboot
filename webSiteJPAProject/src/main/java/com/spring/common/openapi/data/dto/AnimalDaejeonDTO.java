package com.spring.common.openapi.data.dto;

import lombok.Data;

@Data
public class AnimalDaejeonDTO {
    private String animalSeq;
    private String searchCondition; // 유기동물 구분
    private String searchCondition3;    // 입양상태
}
