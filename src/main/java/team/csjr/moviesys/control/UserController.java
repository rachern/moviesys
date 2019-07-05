package team.csjr.moviesys.control;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import team.csjr.moviesys.base.ResultUtil;
import team.csjr.moviesys.base.dto.ResultDTO;
import team.csjr.moviesys.entity.User;
import team.csjr.moviesys.enums.AccountEnum;
import team.csjr.moviesys.service.UserService;

import javax.validation.Valid;
import java.util.List;

/**
 * @author ReMidDream
 * @date 2018/12/19 19:13
 **/
@RequestMapping("/signin")
@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResultDTO signUp(@Valid User user) throws Exception {
        return ResultUtil.Success(userService.signIn(user));
    }

}
