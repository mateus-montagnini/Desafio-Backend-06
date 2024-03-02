//package br.com.mrocha.desafio6.infra.security;
//
//import br.com.mrocha.desafio6.domain.Usuario.Usuario;
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.exceptions.JWTCreationException;
//import com.auth0.jwt.exceptions.JWTVerificationException;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Service;
//
//@Service
//public class JWTService {
//
//    @Value("{api.jwt.secret}")
//    private String senha;
//
//    @Value("{api.jwt.issuer}")
//    private String issuer;
//    public String gerarToken(Authentication authentication) {
//        var usuario = (Usuario) authentication.getPrincipal();
//        try {
//            Algorithm algorithm = Algorithm.HMAC256(senha);
//            return JWT.create()
//                    .withIssuer(issuer)
//                    .withSubject(usuario.getId().toString())
//                    .sign(algorithm);
//        } catch (JWTCreationException exception) {
//            throw new RuntimeException("Erro ao gerar o token");
//        }
//    }
//
//    public Long getSubject(String jwt) {
//        try {
//            Algorithm algorithm = Algorithm.HMAC256(senha);
//            return Long.parseLong(JWT.require(algorithm)
//                    .withIssuer(issuer)
//                    .build()
//                    .verify(jwt)
//                    .getSubject());
//
//        } catch (JWTVerificationException exception) {
//            throw new RuntimeException("token invalido ou expirado");
//        }
//    }
//}
