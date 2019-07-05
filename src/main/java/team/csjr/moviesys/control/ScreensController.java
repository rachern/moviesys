package team.csjr.moviesys.control;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import team.csjr.moviesys.base.KeyUtil;
import team.csjr.moviesys.base.ResultUtil;
import team.csjr.moviesys.base.dto.BaseDTO;
import team.csjr.moviesys.base.dto.ResultDTO;
import team.csjr.moviesys.dto.ScreensDTO;
import team.csjr.moviesys.entity.Screens;
import team.csjr.moviesys.entity.ScreensSeat;
import team.csjr.moviesys.service.ScreensSeatService;
import team.csjr.moviesys.service.ScreensService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ReMidDream
 * @date 2018/12/20 10:19
 **/
@RestController
@CrossOrigin
@RequestMapping("/Screens")
public class ScreensController {

    @Autowired
    private ScreensService screensService;
    @Autowired
    private ScreensSeatService screensSeatService;

    @PostMapping
    @Transactional
    public ScreensDTO insertScreensDto(@RequestBody ScreensDTO screensDTO) throws Exception {
        Screens screens = new Screens();
        BeanUtils.copyProperties(screensDTO,screens);
        Screens saveScreens = screensService.save(screens);
        Long screensId = saveScreens.getScreensId();
        List<ScreensSeat> screensSeatList = new ArrayList<>();
        for (ScreensSeat screensSeat : screensDTO.getScreensSeatList()) {
            screensSeat.setScreensId(screensId);
            ScreensSeat saveSeat = screensSeatService.save(screensSeat);
            screensSeatList.add(saveSeat);
        }
        screensDTO.setScreensId(screensId);
        screensDTO.setScreensSeatList(screensSeatList);
        return screensDTO;
    }

    @PostMapping("/update")
    @Transactional
    public ScreensDTO updateScreensDto(@RequestBody ScreensDTO screensDTO) throws Exception {
        screensService.updateDTO(screensDTO, Screens.class);

        ScreensSeat deleteScreensSeat = new ScreensSeat();
        deleteScreensSeat.setScreensId(screensDTO.getScreensId());
        screensSeatService.delete(deleteScreensSeat);

        for (ScreensSeat screensSeat : screensDTO.getScreensSeatList()) {
            screensSeat.setScreensId(screensDTO.getScreensId());
            screensSeatService.save(screensSeat);
        }
        return screensDTO;
    }

    @GetMapping
    public List<Screens> getScreensDtoList() throws Exception {
        return screensService.findAll();
    }

    @GetMapping("/{id:\\d+}")
    public ScreensDTO getScreensDto(@PathVariable Long id) throws Exception {
        ScreensDTO screens = new ScreensDTO();
        screens.setScreensId(id);
        List<ScreensDTO> screensList = screensService.findByParams(screens, ScreensDTO.class);
        ScreensDTO resultScreens = screensList.get(0);

        ScreensSeat screensSeat = new ScreensSeat();
        screensSeat.setScreensId(resultScreens.getScreensId());
        List<ScreensSeat> screensSeatList = screensSeatService.findByParams(screensSeat);

        resultScreens.setScreensSeatList(screensSeatList);

        return resultScreens;
    }



    @PostMapping("/{id:\\d+}")
    public ResultDTO deleteScreensDto(@PathVariable Long id) throws Exception {
        Screens screens = new Screens();
        screens.setScreensId(id);
        screensService.delete(screens);
        return ResultUtil.Success();
    }


}
