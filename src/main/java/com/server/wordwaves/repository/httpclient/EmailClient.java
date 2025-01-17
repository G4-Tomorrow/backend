package com.server.wordwaves.repository.httpclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.server.wordwaves.dto.request.common.EmailRequest;
import com.server.wordwaves.dto.response.common.EmailResponse;

@FeignClient(name = "email-client", url = "${app.email-client.brevo-url}")
public interface EmailClient {
    @PostMapping(value = "/v3/smtp/email", produces = MediaType.APPLICATION_JSON_VALUE)
    EmailResponse sendEmail(@RequestHeader("api-key") String apiKey, @RequestBody EmailRequest request);
}
