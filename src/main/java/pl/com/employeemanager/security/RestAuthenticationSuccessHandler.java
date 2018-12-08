package pl.com.employeemanager.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Component
public class RestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        List<String> authorities = new ArrayList<>();
        for (GrantedAuthority authority : authentication.getAuthorities()){
            authorities.add(authority.getAuthority());
        }
        SecurityUtils.sendResponse(response, HttpServletResponse.SC_OK, authorities);
    }
}
