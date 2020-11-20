package com.example.demo;


import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
@Service
public class ApiCalls {

    public static String getJsonString(String url)  {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);
        ResponseEntity<String> emps = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        String str = emps.getBody();

        return str;
    }

}
