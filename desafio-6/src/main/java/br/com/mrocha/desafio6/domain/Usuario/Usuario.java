//package br.com.mrocha.desafio6.domain.Usuario;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.NoArgsConstructor;
//import lombok.ToString;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//@Entity
//@Data
//@NoArgsConstructor
//@EqualsAndHashCode(of = "id")
//@ToString(of = {"id", "login", "senha"})
//@Table(name = "tb_usuarios")
//@Inheritance(strategy = InheritanceType.JOINED)
//public class Usuario implements UserDetails {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "login")
//    protected String login;
//
//    @Column(name = "senha")
//    protected String senha;
//
//    @Column(name = "email")
//    protected String email;
//
//
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "tb_usuarios_perfis",
//            joinColumns = @JoinColumn(name = "usuario_id"),
//            inverseJoinColumns = @JoinColumn(name = "perfil_id"))
//    @Column(name = "perfis")
//    private List<Perfil> perfis = new ArrayList<>();
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return perfis;
//    }
//
//    @Override
//    public String getPassword() {
//        return senha;
//    }
//
//    @Override
//    public String getUsername() {
//        return login;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
