package com.spring.common.openapi.data.service;

import com.spring.common.openapi.data.dto.AnimalDaejeonDTO;

public interface DataService {
    public String busanWalkingList(String seq);
    public String busanWalkingDetail(String seq);
    public String animalDaejeonList(AnimalDaejeonDTO animalDaejeonDTO);
}
