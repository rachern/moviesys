package team.csjr.moviesys.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import team.csjr.moviesys.dto.ScreeningDTO;
import team.csjr.moviesys.dto.TicketDto;
import team.csjr.moviesys.entity.Screening;
import team.csjr.moviesys.entity.Ticket;
import team.csjr.moviesys.service.ScreeningService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ReMidDream
 * @date 2018/12/20 16:33
 **/
@Component
public class Ticket2TicketDTO {

    @Autowired
    private ScreeningService screeningService;
    @Autowired
    private Screening2ScreeningDTO screening2ScreeningDTO;

    public List<TicketDto> convert(List<Ticket> tickets) throws Exception {
        List<TicketDto> ticketDtoList = new ArrayList<>();
        for (Ticket ticket : tickets) {
            TicketDto ticketDto = new TicketDto();
            BeanUtils.copyProperties(ticket,ticketDto);

            Screening screening = new Screening();
            screening.setScreeningId(ticket.getScreeningId());
            List<Screening> screenings = screeningService.findByParams(screening);

            screening2ScreeningDTO.convert(screenings);
            ScreeningDTO screeningDTO = screening2ScreeningDTO.convert(screenings).get(0);
            screeningDTO.getScreens().setScreensSeatList(null);
            ticketDto.setScreeningDTO(screeningDTO);

            ticketDtoList.add(ticketDto);
        }
        return ticketDtoList;
    }
}
