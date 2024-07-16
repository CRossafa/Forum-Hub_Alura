package forum_hub.api.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Data
@Getter
@Table(name = "usuarios")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuario_roles",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(role -> (GrantedAuthority) role::getNome).collect(Collectors.toSet());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Pode ser modificado de acordo com a lógica de negócio
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Pode ser modificado de acordo com a lógica de negócio
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Pode ser modificado de acordo com a lógica de negócio
    }

    @Override
    public boolean isEnabled() {
        return true; // Pode ser modificado de acordo com a lógica de negócio
    }
}
