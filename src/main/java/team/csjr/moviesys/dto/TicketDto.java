package team.csjr.moviesys.dto;

import lombok.Getter;
import lombok.Setter;
import team.csjr.moviesys.base.dto.BaseDTO;

import javax.persistence.Column;

/**
 * @author ReMidDream
 * @date 2018/12/20 16:30
 **/
@Getter
@Setter
public class TicketDto extends BaseDTO {

    private Long ticketId;

    private Integer userId;

    private String ticketStatus;

    private ScreeningDTO screeningDTO;

    private Integer screeningColumn;

    private Integer screeningRow;
}
