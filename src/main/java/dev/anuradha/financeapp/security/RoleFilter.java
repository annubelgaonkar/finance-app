package dev.anuradha.financeapp.security;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;
import java.util.List;

public class RoleFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        String role = req.getHeader("X-ROLE");

        String assignedRole = (role != null) ? role: "VIEWER";
      //  System.out.println("ROLE = " + assignedRole);


        var auth = new UsernamePasswordAuthenticationToken(
                "user",
                null,
                List.of(new SimpleGrantedAuthority("ROLE_" + assignedRole))
        );
        SecurityContextHolder.getContext().setAuthentication(auth);

        chain.doFilter(request,response);
    }
}
