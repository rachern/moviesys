package team.csjr.moviesys.control;

import com.sun.org.apache.regexp.internal.REUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.csjr.moviesys.base.ResultUtil;
import team.csjr.moviesys.base.dto.ResultDTO;
import team.csjr.moviesys.base.page.PageList;
import team.csjr.moviesys.converter.Screening2ScreeningDTO;
import team.csjr.moviesys.dto.ScreeningDTO;
import team.csjr.moviesys.entity.Screening;
import team.csjr.moviesys.entity.Ticket;
import team.csjr.moviesys.mapper.ScreeningMapper;
import team.csjr.moviesys.service.ScreeningService;
import team.csjr.moviesys.service.TicketService;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @author ReMidDream
 * @date 2018/12/20 10:20
 **/
@RestController
@CrossOrigin
@RequestMapping("/Screening")
public class ScreeningController {

    @Autowired
    private ScreeningService screeningService;
    @Autowired
    private Screening2ScreeningDTO screening2ScreeningDTO;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private ScreeningMapper screeningMapper;

    @PostMapping
    public Screening insertScreening(Screening screening) throws Exception {
        return screeningService.save(screening);
    }

    @PostMapping("/update")
    public Screening updateScreening(Screening screening) throws Exception {
        screeningService.update(screening);
        return screening;
    }

    @PostMapping("/{id:\\d+}")
    public ResultDTO deleteScreening(@PathVariable Long id) throws Exception {
        screeningService.deleteById(id);
        return ResultUtil.Success();
    }

    @GetMapping
    public PageList<ScreeningDTO> getScreeningList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                            @RequestParam(value = "pageSize", defaultValue = "15") Integer pageSize) throws Exception {

        PageList<Screening> screeningPageList = screeningService.findPageData(new Screening(), pageNum, pageSize, "begin_time DESC");

        PageList<ScreeningDTO> screeningDTOPageList = new PageList<>();
        BeanUtils.copyProperties(screeningPageList,screeningDTOPageList);
        screeningDTOPageList.setData(screening2ScreeningDTO.convert(screeningPageList.getData()));

        return screeningDTOPageList;
    }

    @GetMapping("/movie/{id:\\d+}")
    public PageList<ScreeningDTO> getScreeningByMovieId(@PathVariable Long id) throws Exception {

        Example example = new Example(Screening.class);
        example.setOrderByClause("begin_time DESC");
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("movieId",id);
        criteria.andGreaterThanOrEqualTo("beginTime",new Date());
        List<Screening> screenings = screeningMapper.selectByExample(example);

        PageList<ScreeningDTO> screeningDTOPageList = new PageList<>();
        BeanUtils.copyProperties(screenings,screeningDTOPageList);
        screeningDTOPageList.setData(screening2ScreeningDTO.convert(screenings));
        return screeningDTOPageList;
    }


    @GetMapping("/{id:\\d+}")
    public ScreeningDTO getScreening(@PathVariable Long id) throws Exception {
        Screening screening = new Screening();
        screening.setScreeningId(id);
        List<Screening> screenings = screeningService.findByParams(screening);
        ScreeningDTO screeningDTO = screening2ScreeningDTO.convert(screenings).get(0);

        Ticket ticket = new Ticket();
        ticket.setScreeningId(screenings.get(0).getScreeningId());
        List<Ticket> ticketList = ticketService.findByParams(ticket);

        screeningDTO.setTicketList(ticketList);
        return screeningDTO;
    }

}
