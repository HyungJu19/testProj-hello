package com.testproj.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriUtils;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class TourismService {
    private final String apiKey = "lf1DafliFIimHdu3SR771eVfDrICA%2BU6Q8EZuZVr2yu4nZWGi40WnVoK%2BcPA2Qt%2B1LYYcEHqZwhK6nNw9DznAA%3D%3D"; // API 키
    private final RestTemplate restTemplate;

    public TourismService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getTourismInfo(String keyword, int contentTypeId) {
        String url = "http://apis.data.go.kr/B551011/KorService1/searchKeyword1";
        url += "?serviceKey=" + apiKey;
        url += "&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json";
        url += "&listYN=Y&arrange=A";
        url += "&keyword=" + URLEncoder.encode(keyword, StandardCharsets.UTF_8);
        url += "&contentTypeId=" + contentTypeId;

        return restTemplate.getForObject(url, String.class);
    }
}

