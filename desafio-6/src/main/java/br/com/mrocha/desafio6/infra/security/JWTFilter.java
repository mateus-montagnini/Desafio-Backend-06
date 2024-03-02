//package br.com.mrocha.desafio6.infra.security;
//
//import br.com.mrocha.desafio6.repository.UsuarioRepository;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Component
//public class JWTFilter extends OncePerRequestFilter {
//
//    @Autowired
//    private UsuarioRepository usuarioRepository;
//
//    @Autowired
//    private JWTService jwtService;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        var header = request.getHeader("Authorization");
//
//        if (header != null) {
//            var subject = jwtService.getSubject(header);
//            var usuario = usuarioRepository.findById(subject).get();
//
//            var authentication = new UsernamePasswordAuthenticationToken(usuario.getLogin(), null, usuario.getAuthorities());
//
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//        }
//
//
//        filterChain.doFilter(request, response);
//    }
//}
