package com.example.cloudnativejavaweb;

import com.example.cloudnativejavaweb.model.Feed;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@SpringBootApplication
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

	@Bean
    public RestTemplate restTemplate() {
	    return new RestTemplate();
    }

	@RestController
    class ProxyController {

	    @Value("${rss.uri}")
        private String feedUrl;

	    private final RestTemplate restTemplate;

        ProxyController(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }

        @RequestMapping(value = "/rss", produces = MediaType.APPLICATION_JSON_VALUE)
        public Feed result() throws IOException {
	        String result = restTemplate.getForObject(feedUrl, String.class);
	        JSONObject jsonObject = org.json.XML.toJSONObject(result);
            return new ObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                    .readValue(jsonObject.toString(), Feed.class);
        }
    }
}
