package team.csjr.moviesys.service;


import team.csjr.moviesys.base.service.BaseService;
import team.csjr.moviesys.entity.User;

/**
 * @author ReMidDream
 * @date 2018/10/22 20:57
 **/
public interface UserService extends BaseService<User> {

     User signIn(User user)throws Exception;

}
