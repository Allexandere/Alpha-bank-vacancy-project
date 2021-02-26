package com.vacancyproject.api.controller;

import com.vacancyproject.api.client.GiphyApi;
import com.vacancyproject.api.client.OpenexchangeratesApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class AppController {
    private final OpenexchangeratesApi openexchangeratesApi;
    private final GiphyApi giphyApi;
    private final String exchangeratesApp_id = "9094fbb32b8a422ab10ae6300114f831";
    private final String giphyApp_id = "0ttS3bI3vIqhUIpBg8E6JXr6xc7gtGyb";

    @GetMapping(value = "/get_currency")
    public ResponseEntity showRandomGif() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String today = dtf.format(now);
        String yesratrday = dtf.format(now.minusDays(1));
        Double todayCurrency = openexchangeratesApi.readCurrency(today, exchangeratesApp_id).getRates().get("RUB");
        Double yestardayCurrency = openexchangeratesApi.readCurrency(yesratrday, exchangeratesApp_id).getRates().get("RUB");
        String tag = todayCurrency > yestardayCurrency ? "rich" : "broke";
        String url = giphyApi.getRandomGif(giphyApp_id, tag).getData().getUrl();
        return ResponseEntity.ok().body(String.format("<a href=\"%s\">%s</a>", url, tag));
    }
}
