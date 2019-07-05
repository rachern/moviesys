package team.csjr.moviesys.dto;

import lombok.Getter;
import lombok.Setter;
import team.csjr.moviesys.base.dto.BaseDTO;
import team.csjr.moviesys.entity.ScreensSeat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * @author ReMidDream
 * @date 2018/12/20 10:40
 **/
@Getter
@Setter
public class ScreensDTO extends BaseDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long screensId;

    private String screensName;

    private List<ScreensSeat> screensSeatList;
}
