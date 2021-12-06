package com.estagiei.app.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class RestClientService<T> {
    @Value("${server.url}:${server.port}/api")
    private String url;
    private String uri;
    private Class<T> model;

    public final HttpHeaders headers = new HttpHeaders();
    public final RestTemplate restTemplate = new RestTemplate();

    public RestClientService<T> api() {
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        return this;
    }

    public RestClientService<T> model(Class<T> model) {
        this.model = model;

        return this;
    }

    public RestClientService<T> uri(String uri) {
        this.uri = uri;

        return this;
    }

    public T postRequest(T entity) {
        return restTemplate.postForObject(
                url.concat(uri),
                entity,
                model
        );
    }
}
