package team.csjr.moviesys.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import team.csjr.moviesys.entity.Role;
import team.csjr.moviesys.mapper.RoleMapper;
import team.csjr.moviesys.mapper.UserMapper;
import team.csjr.moviesys.service.UserService;

import java.util.List;

/**
 * 登录时的认证
 * 通过用户名获取用户信息, 进行帐号信息验证
 * 验证是Spring security 内部实现的
 *  *需要在config里 注入PasswordEncoder的bean*
 * @author ReMidDream
 * @date 2018-08-17 14:55
 **/
@Component
@Slf4j
public class UserDetailService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("登录用户名 : {}",username);
        List<team.csjr.moviesys.entity.User> user;

        // 根据用户名查找用户信息
        try {
            user = userService.findByParams(new team.csjr.moviesys.entity.User(username));
        } catch (Exception e) {
            throw new UsernameNotFoundException("系统异常");
        }

        if (user.get(0) == null) {
            throw new UsernameNotFoundException("用户名不存在!");
        }

        if (user.size()>1) {
            throw new UsernameNotFoundException("系统异常");
        }

        String userPassword = user.get(0).getPassword();
        List<Role> roles = roleMapper.select(new Role(user.get(0).getRoleId()));

        return new User(username,userPassword,
                AuthorityUtils.commaSeparatedStringToAuthorityList(roles.get(0).getRoleName()));
    }
}
