package team.csjr.moviesys.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * @author ReMidDream
 * @date 2018/10/12 15:56
 **/
@Component
@Slf4j
public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        log.info("登录成功!");
//        UserDetails user = (UserDetails) authentication.getPrincipal();
//        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
//        for (GrantedAuthority authority : authorities) {
//            String role = authority.getAuthority();
//            if (role.equals("ROLE_ADMIN")) {
//                response.sendRedirect("/managerIndex.html");
//            }else {
//                response.sendRedirect("/userIndex.html");
//            }
//        }
        response.setStatus(HttpStatus.OK.value());
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(authentication));

    }
}