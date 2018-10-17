Spring-security-web
spring-security-config
spring-security-core

Authentication: represents current user/ principal
UsernamePasswordAuthenticationToken: Takes in username, password, authorities and creates authentication instance
AuthenticationManager: Used to authenticate and process authentication request and creates new authentication object once principal is authenticated.
GrantedAuthority

SecurityContextHolder: provides access to security context. Uses threadlocal to store these details
SecurityContext holds principal

Principal p=SecurityContextHolder.getContext().getAuthentication().getPrincipal();

UserDetailsService : returns userDetails object
