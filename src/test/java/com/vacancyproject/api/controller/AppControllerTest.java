package com.vacancyproject.api.controller;

import com.vacancyproject.api.client.GiphyApi;
import com.vacancyproject.api.client.OpenexchangeratesApi;
import com.vacancyproject.api.rest.response.ExchangeratesResponce;
import com.vacancyproject.api.rest.response.GifObject;
import com.vacancyproject.api.rest.response.GiphyResponce;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class AppControllerTest {

    @Autowired
    OpenexchangeratesApi openexchangeratesApi;

    @Autowired
    GiphyApi giphyApi;

    @MockBean
    ExchangeratesResponce exchangeratesResponce;

    @MockBean
    GiphyResponce giphyResponce;

    @MockBean
    GifObject gifObject;


    @Test
    void OpenexchangeratesApiTest() {
        String exchangeratesApp_id = "9094fbb32b8a422ab10ae6300114f831";
        exchangeratesResponce = openexchangeratesApi.readCurrency("2012-07-10", exchangeratesApp_id);
        Assertions.assertEquals(32.867934, exchangeratesResponce.getRates().get("RUB"));
        Assertions.assertEquals(1.257064, exchangeratesResponce.getRates().get("NZD"));
        Assertions.assertEquals(8.216633, exchangeratesResponce.getRates().get("LSL"));
    }

    @Test
    void GiphyApiTest(){
        String giphyApp_id = "0ttS3bI3vIqhUIpBg8E6JXr6xc7gtGyb";
        giphyResponce = giphyApi.getRandomGif(giphyApp_id, "rich");
        gifObject = giphyResponce.getData();
        Assertions.assertNotNull(giphyResponce);
        Assertions.assertNotEquals("", gifObject.getUrl().trim());
    }
}