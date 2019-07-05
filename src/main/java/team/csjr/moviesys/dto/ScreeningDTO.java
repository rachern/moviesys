package team.csjr.moviesys.dto;

import lombok.Getter;
import lombok.Setter;
import team.csjr.moviesys.base.dto.BaseDTO;
import team.csjr.moviesys.entity.Movie;
import team.csjr.moviesys.entity.Ticket;

import java.util.Date;
import java.util.List;

/**
 * @author ReMidDream
 * @date 2018/12/20 15:22
 **/
@Getter
@Setter
public class ScreeningDTO extends BaseDTO {

    private Long screeningId;

    private Date beginTime;

    private Date endTime;

    private ScreensDTO screens;

    private Movie movie;

    private Double price;

    private List<Ticket> ticketList;

}
