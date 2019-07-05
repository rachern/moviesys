package team.csjr.moviesys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.csjr.moviesys.base.service.impl.BaseServiceImpl;
import team.csjr.moviesys.entity.User;
import team.csjr.moviesys.enums.AccountEnum;
import team.csjr.moviesys.exception.AccountException;
import team.csjr.moviesys.mapper.UserMapper;
import team.csjr.moviesys.service.UserService;

import java.util.List;
import java.util.Set;

/**
 * @author ReMidDream
 * @date 2018/10/22 20:58
 **/
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService {

    @Override
    @Transactional
    public User signIn(User user) throws Exception {
        /*
         * 获取所有用户名, 判断是否重复
         * */
        User checkNameUser = new User(user.getUsername());
        List<User> checkNameUserList = findByParams(checkNameUser);

        if (checkNameUserList.size() > 0) {
            throw new AccountException(AccountEnum.USERNAME_EXIST);
        }
        /*
         * 注册用户
         * */
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoleId(1);

        return save(user);
    }
}
