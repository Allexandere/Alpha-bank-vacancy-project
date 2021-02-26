package com.vacancyproject.api.rest.response;

import lombok.Data;

import java.util.HashMap;

@Data
public class ExchangeratesResponce {
    private HashMap<String, Double> rates;
}
