package com.spring.common.openapi.data.service;

import com.spring.common.openapi.URLConnectUtil;
import com.spring.common.openapi.data.dto.OpenApiDTO;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService{
    private final String serviceKey = "c774c8dc6067dd3fe310433c57f70141f99f7920c008809925393e181a51c62d";

    @Override
    public String busanWalkingList() {
        try {
            String baseUrl = "http://apis.data.go.kr/6260000/WalkingService/getWalkingKr";
            String params = String.format("?serviceKey=%s&pageNo=1&numOfRows=12&resultType=json", serviceKey);
            String site = baseUrl + params;

            OpenApiDTO openApi = new OpenApiDTO(site, "GET");
            return URLConnectUtil.openAPIData(openApi).toString();
        } catch (Exception e) {
            return "API 호출 중 오류 발생";
        }
    }
}
