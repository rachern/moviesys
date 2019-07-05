package team.csjr.moviesys.exception;


import lombok.Data;
import lombok.Setter;
import team.csjr.moviesys.base.exception.AbtBaseException;
import team.csjr.moviesys.enums.AccountEnum;

/**
 * @author ReMidDream
 * @date 2018/10/23 20:55
 **/
public class AccountException extends AbtBaseException {

    public AccountException(AccountEnum Enum) {
        super(Enum.getCode(),Enum.getMessage());
    }
}
