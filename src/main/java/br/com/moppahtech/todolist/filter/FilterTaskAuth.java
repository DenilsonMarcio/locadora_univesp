package br.com.moppahtech.todolist.filter;

import java.io.IOException;
import java.util.Base64;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.moppahtech.todolist.model.UserModel;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

//    private final UserRepository repository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        
        String authorization = request.getHeader("Authorization");
        String token = authorization.substring("Basic".length()).trim();
        byte[] authDecode = Base64.getDecoder().decode(token);
        String authString = new String(authDecode);
        String[] credentials = authString.split(":");

        String username = credentials[0];
        String password = credentials[1];

        UserModel user = UserModel.builder().username(username).password(password).build();//repository.findByUsername(username);
        if (user == null){
            response.sendError(401);
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
