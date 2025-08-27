/* package com.rodrigo.previsao_safra.config;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.rodrigo.previsao_safra.model.Produtor;
import com.rodrigo.previsao_safra.repository.ProdutorRepository;
import com.rodrigo.previsao_safra.util.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final ProdutorRepository produtorRepository;

    public JwtFilter(JwtUtil jwtUtil, ProdutorRepository produtorRepository) {
        this.jwtUtil = jwtUtil;
        this.produtorRepository = produtorRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain) throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");
        final String token;
        final String email;

        token = (authHeader != null && authHeader.startsWith("Bearer "))
                ? authHeader.substring(7)
                : null;

        email = (token != null) ? jwtUtil.extractEmail(token) : null;

        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            Produtor produtor = produtorRepository.findByEmail(email).orElse(null);
            if (produtor != null && jwtUtil.isTokenValid(token, produtor.getEmail())) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(produtor, null,
                        null);
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        chain.doFilter(request, response);
    }


}
 */