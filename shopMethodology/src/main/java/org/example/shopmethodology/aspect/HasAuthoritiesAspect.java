package org.example.shopmethodology.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.nio.file.AccessDeniedException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

@Aspect
@Component
public class HasAuthoritiesAspect {
    static Logger logger = Logger.getLogger("org.example.shopmethodology.aspect");
    @Before("within(@org.springframework.web.bind.annotation.RestController ) && @annotation(authorities)")
    public void hasAuthorities(final HasAuthorities authorities) throws AccessDeniedException, AuthenticationCredentialsNotFoundException, Exception {
        // securityContext : hold information user authentication
        final SecurityContext securityContext = SecurityContextHolder.getContext();

        // check if security context is empty or not
        if (securityContext == null) {
            logger.log(Level.WARNING, "Security context was null");
            throw new AccessDeniedException("access denied bro!");
        }

        final Authentication authentication = securityContext.getAuthentication();
        if (authentication == null) {
            logger.warning("Authentication was null");
            throw new AuthenticationCredentialsNotFoundException("unauthorized");
        }

        final String username = authentication.getName();
        final Collection userAuthorities = authentication.getAuthorities();

        boolean hasRequire = Stream.of(authorities.authorities()).anyMatch(
                required -> userAuthorities.stream().anyMatch(
                        granted -> required.equals(granted)
                )
        );

        if (!hasRequire) {
            logger.warning("user " + username + " have no permission");
            throw new AccessDeniedException("block lol");
        }

    }
}
