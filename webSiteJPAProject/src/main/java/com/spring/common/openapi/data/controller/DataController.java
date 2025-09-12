package com.spring.common.openapi.data.controller;

import com.spring.common.openapi.data.dto.AnimalDaejeonDTO;
import com.spring.common.openapi.data.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/data")
@RequiredArgsConstructor
public class DataController {
    private final DataService dataService;

    // 부산도보여행정보 리스트 화면
    @GetMapping("/busanWalkingView")
    public String busanWalkingView() {
        return "data/busanWalkingView";
    }

    // http://localhost:8080/data/busanWalkingList
    @ResponseBody
    @GetMapping(value = "/busanWalkingList", produces = "application/json; charset=UTF-8")
    public String busanWalkingList() {
        String seq = "";
        return dataService.busanWalkingList(seq);
    }

    // 부산도보여행정보 상세 화면
    @GetMapping("/busanWalkingDetailView/{seq}")
    public String busanWalkingDetailView(@PathVariable String seq, Model model) {
        model.addAttribute("seq", seq);
        return "data/busanWalkingDetailView";
    }

    // http://localhost:8080/data/busanWalkingDetail/283
    @ResponseBody
    @GetMapping(value = "/busanWalkingDetail/{seq}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String busanWalkingDetail(@PathVariable String seq) throws Exception {
        return dataService.busanWalkingList(seq);
    }

    /* 대전 유기동물공고 리스트 화면 */
    @GetMapping("/animalDaejeonView")
    public String animalDaejeonView(AnimalDaejeonDTO animalDaejeonDTO){
        return "data/animalDaejeonView";
    }

    @ResponseBody
    @PostMapping(value="/animalDaejeonList", consumes = "application/json", produces = "application/xml; charset=UTF-8")
    public String animalDaejeonList(@RequestBody AnimalDaejeonDTO animalDaejeonDTO) {
        return dataService.animalDaejeonList(animalDaejeonDTO);
    }
}
