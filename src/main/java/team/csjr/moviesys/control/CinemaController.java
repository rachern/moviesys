package team.csjr.moviesys.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.csjr.moviesys.entity.Cinema;
import team.csjr.moviesys.service.CinemaService;

/**
 * @author ReMidDream
 * @date 2018/12/20 10:20
 **/
@RestController
@CrossOrigin
@RequestMapping("/cinema")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @GetMapping
    public Cinema getCinema() throws Exception {
        return cinemaService.findAll().get(0);
    }

    @PostMapping("/update")
    public Cinema updateCinema(Cinema cinema) throws Exception {
        cinema.setCinemaId(1L);
        cinemaService.update(cinema);
        return cinema;
    }




}
