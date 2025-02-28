package com.olimpusadonis.securesys.config.tools;

import com.olimpusadonis.securesys.model.UserDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
@Setter
public class MyAuthenticationToken extends AbstractAuthenticationToken {

    private final UserDTO principal; // Puede ser UserDetails o simplemente el nombre de usuario
    private Object credentials; // Puede ser null o el token de acceso (si es necesario)

    public MyAuthenticationToken(UserDTO principal, Object credentials, Collection<? extends GrantedAuthority> roles) {
        super(roles);
        this.principal = principal;
        this.credentials = credentials; // Puede ser null si no necesitas almacenar esto
        super.setAuthenticated(true); // Este token se considera autenticado
    }

}
