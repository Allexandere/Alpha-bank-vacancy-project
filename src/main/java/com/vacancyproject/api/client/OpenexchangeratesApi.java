package com.vacancyproject.api.client;

import com.vacancyproject.api.rest.response.ExchangeratesResponce;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "${penexchangerates.feign.config.name}", url = "${penexchangerates.feign.config.url}")
public interface OpenexchangeratesApi {

    @RequestMapping(method = RequestMethod.GET, value = "/historical/{date}.json")
    ExchangeratesResponce readCurrency(@PathVariable String date, @RequestParam String app_id);

}
