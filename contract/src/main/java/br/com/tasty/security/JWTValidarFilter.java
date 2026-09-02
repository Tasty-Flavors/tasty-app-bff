package br.com.tasty.security;

import jakarta.annotation.Nonnull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static br.com.tasty.config.factory.UsernamePasswordAuthenticationFactory.create;

@RequiredArgsConstructor
public class JWTValidarFilter extends OncePerRequestFilter {

    private final AuthenticationManager authenticationManager;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            @Nonnull HttpServletResponse response,
            @Nonnull FilterChain chain)
            throws ServletException, IOException {

        var header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) {
            try {
                var auth = authenticationManager.authenticate(create(null, header));
                SecurityContextHolder.getContext().setAuthentication(auth);
                request.setAttribute("sub", extraiSub(auth));
                request.setAttribute("id", extraiId(auth));
            } catch (AuthenticationException e) {
                SecurityContextHolder.clearContext();
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }

        chain.doFilter(request, response);
    }

    private Integer extraiSub(Authentication auth) {
        return Integer.valueOf((String) auth.getPrincipal());
    }

    private Integer extraiId(Authentication auth) {
        return Integer.valueOf((String) auth.getPrincipal());
    }
}