package team.csjr.moviesys.control;

import com.sun.org.apache.regexp.internal.REUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import team.csjr.moviesys.base.ResultUtil;
import team.csjr.moviesys.base.dto.ResultDTO;
import team.csjr.moviesys.base.page.PageList;
import team.csjr.moviesys.converter.Ticket2TicketDTO;
import team.csjr.moviesys.dto.TicketDto;
import team.csjr.moviesys.dto.TicketForm;
import team.csjr.moviesys.entity.Ticket;
import team.csjr.moviesys.entity.User;
import team.csjr.moviesys.enums.AccountEnum;
import team.csjr.moviesys.exception.AccountException;
import team.csjr.moviesys.service.TicketService;
import team.csjr.moviesys.service.UserService;

import java.time.Period;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ReMidDream
 * @date 2018/12/20 10:18
 **/
@RestController
@CrossOrigin
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private UserService userService;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private Ticket2TicketDTO ticket2TicketDTO;

    @PostMapping
    public List<TicketDto> buy(@RequestBody TicketForm tickets, @AuthenticationPrincipal  Authentication authentication) throws Exception {
        if (authentication == null) {
            throw new AccountException(AccountEnum.UN_LOGIN);
        }
        UserDetails user = (UserDetails) authentication.getPrincipal();
        List<User> userList = userService.findByParams(new User(user.getUsername()));
        Integer userId = userList.get(0).getUserId();
        List<Ticket> ticketList = new ArrayList<>();

        for (Ticket ticket : tickets.getTickets()) {
            Ticket testTicket = new Ticket();
            testTicket.setScreeningId(ticket.getScreeningId());
            testTicket.setScreeningColumn(ticket.getScreeningColumn());
            testTicket.setScreeningRow(ticket.getScreeningRow());
            List<Ticket> testTicketList = ticketService.findByParams(testTicket);
            if (testTicketList.size() > 0) {
                throw new AccountException(AccountEnum.EXIST_TICKET);
            }

            ticket.setTicketStatus("0");
            ticket.setUserId(userId);
            Ticket save = ticketService.save(ticket);
            ticketList.add(save);
        }

        return ticket2TicketDTO.convert(ticketList);
    }

    @GetMapping("/{id:\\d+}/{status:\\d+}")
    public ResultDTO pay(@PathVariable Long id,@PathVariable Integer status) throws Exception {
        if( status == null || status.equals(0)){
            return ResultUtil.Error("505","支付失败");
        }
        Ticket ticket = new Ticket();
        ticket.setTicketId(id);
        ticket.setTicketStatus("1");
        ticketService.update(ticket);
        return ResultUtil.Success();
    }

    @GetMapping("/{id:\\d+}")
    public TicketDto getUserTicket(@PathVariable Long id) throws Exception {
        Ticket ticket = new Ticket();
        ticket.setTicketId(id);

        List<Ticket> ticketList = ticketService.findByParams(ticket);
        return ticket2TicketDTO.convert(ticketList).get(0);
    }

    /**
     *  用户获取电影票详细页
     */
    @GetMapping
    public PageList<TicketDto> getUserTicketList(@AuthenticationPrincipal Authentication authentication,
                                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                             @RequestParam(value = "pageSize", defaultValue = "15") Integer pageSize) throws Exception {
        if (authentication == null) {
            throw new AccountException(AccountEnum.UN_LOGIN);
        }
        UserDetails user = (UserDetails) authentication.getPrincipal();
        List<User> userList = userService.findByParams(new User(user.getUsername()));
        Integer userId = userList.get(0).getUserId();

        Ticket ticket = new Ticket();
        ticket.setUserId(userId);

        PageList<Ticket> ticketList = ticketService.findPageData(ticket, pageNum, pageSize, "ticket_id DESC");
        PageList<TicketDto> ticketDtoPage = new PageList<>();
        BeanUtils.copyProperties(ticketList,ticketDtoPage);
        ticketDtoPage.setData(ticket2TicketDTO.convert(ticketList.getData()));

        return ticketDtoPage;
    }

}
