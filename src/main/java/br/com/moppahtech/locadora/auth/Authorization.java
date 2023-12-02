package br.com.moppahtech.locadora.auth;

import br.com.moppahtech.locadora.model.entities.UserModel;
import br.com.moppahtech.locadora.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;
import java.util.Objects;

@Component
@AllArgsConstructor
public class Authorization extends OncePerRequestFilter {

    private final UserRepository userRepository;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");
        String token = authorization.substring("Basic".length()).trim();
        byte[] authDecode = Base64.getDecoder().decode(token);
        String authString = new String(authDecode);
        String[] credentials = authString.split(":");
        String login = credentials[0];
        String password = credentials[1];

        UserModel user = userRepository.findByLoginAndPassword(login, password);

        if (Objects.isNull(user)){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }else {
            filterChain.doFilter(request, response);
        }
    }
}
