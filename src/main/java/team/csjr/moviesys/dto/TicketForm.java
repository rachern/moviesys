package team.csjr.moviesys.dto;

import lombok.Data;
import team.csjr.moviesys.entity.Ticket;

import java.util.List;

/**
 * @author ReMidDream
 * @date 2019/1/10 13:41
 **/
@Data
public class TicketForm {

    private List<Ticket> tickets;

}
