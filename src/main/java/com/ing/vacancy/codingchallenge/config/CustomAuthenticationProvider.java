package com.ing.vacancy.codingchallenge.config;

import com.ing.vacancy.codingchallenge.dto.UserCredentialsDto;
import com.ing.vacancy.codingchallenge.data.services.UserService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Resource
    private UserService userService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserCredentialsDto userCredentialsDto = userService.getByUsername(username);
        if (userCredentialsDto == null || !passwordEncoder.matches(password, userCredentialsDto.getPasswordSupplier().get())){
            throw new BadCredentialsException("Username or password mismatch.");
        }

        List<GrantedAuthority> authorities = userCredentialsDto.getRoles().stream()
                .map(p->new SimpleGrantedAuthority(p))
                .collect(Collectors.toList());
        return new UsernamePasswordAuthenticationToken(username, null, authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
