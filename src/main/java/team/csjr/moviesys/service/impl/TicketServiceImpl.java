package team.csjr.moviesys.service.impl;

import org.springframework.stereotype.Service;
import team.csjr.moviesys.base.service.BaseService;
import team.csjr.moviesys.base.service.impl.BaseServiceImpl;
import team.csjr.moviesys.entity.Ticket;
import team.csjr.moviesys.mapper.TicketMapper;
import team.csjr.moviesys.service.TicketService;

/**
 * @author ReMidDream
 * @date 2018/12/20 10:25
 **/
@Service
public class TicketServiceImpl extends BaseServiceImpl<TicketMapper, Ticket> implements TicketService {
}
