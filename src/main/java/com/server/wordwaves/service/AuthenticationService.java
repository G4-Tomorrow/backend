package com.server.wordwaves.service;

import java.text.ParseException;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;

import com.nimbusds.jose.JOSEException;
import com.server.wordwaves.dto.request.auth.AuthenticationRequest;
import com.server.wordwaves.dto.request.auth.IntrospectRequest;
import com.server.wordwaves.dto.request.auth.LogoutRequest;
import com.server.wordwaves.dto.request.auth.RefreshTokenRequest;
import com.server.wordwaves.dto.response.auth.AuthenticationResponse;
import com.server.wordwaves.dto.response.auth.IntrospectResponse;

public interface AuthenticationService {
    ResponseEntity<AuthenticationResponse> authenticate(AuthenticationRequest request);

    ResponseEntity<AuthenticationResponse> oauth2Authenticate(OAuth2AuthenticationToken oauth2AuthenticationToken);

    IntrospectResponse introspect(IntrospectRequest request);

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    ResponseEntity<Void> logout(LogoutRequest request);

    ResponseEntity<AuthenticationResponse> getRefreshToken(RefreshTokenRequest request)
            throws ParseException, JOSEException, JOSEException;
}
