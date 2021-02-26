package com.vacancyproject.api.client;

import com.vacancyproject.api.rest.response.GiphyResponce;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "${giphy.feign.config.name}", url = "${giphy.feign.config.url}")
public interface GiphyApi {
    @RequestMapping(method = RequestMethod.GET, value = "/random")
    GiphyResponce getRandomGif(@RequestParam String api_key, @RequestParam String tag);
}
