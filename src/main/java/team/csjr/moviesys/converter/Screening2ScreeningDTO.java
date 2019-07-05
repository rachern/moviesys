package team.csjr.moviesys.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import team.csjr.moviesys.base.page.PageList;
import team.csjr.moviesys.dto.ScreeningDTO;
import team.csjr.moviesys.dto.ScreensDTO;
import team.csjr.moviesys.entity.Movie;
import team.csjr.moviesys.entity.Screening;
import team.csjr.moviesys.entity.Screens;
import team.csjr.moviesys.entity.ScreensSeat;
import team.csjr.moviesys.service.MovieService;
import team.csjr.moviesys.service.ScreensSeatService;
import team.csjr.moviesys.service.ScreensService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ReMidDream
 * @date 2018/12/20 15:24
 **/
@Component
public class Screening2ScreeningDTO {

    @Autowired
    private MovieService movieService;
    @Autowired
    private ScreensService screensService;
    @Autowired
    private ScreensSeatService screensSeatService;


    public List<ScreeningDTO> convert(List<Screening> screeningPageList) throws Exception {
        List<Movie> movieList = movieService.findAll();
        List<Screens> screensList = screensService.findAll();
        List<ScreensSeat> screensSeatList = screensSeatService.findAll();
        List<ScreeningDTO> screeningDTOList = new ArrayList<>();
        for (Screening screening : screeningPageList) {
            ScreeningDTO screeningDTO = new ScreeningDTO();
            BeanUtils.copyProperties(screening,screeningDTO);

            for (Movie movie : movieList) {
                if (movie.getMovieId().equals(screening.getMovieId())) {
                    screeningDTO.setMovie(movie);
                }
            }

            for (Screens screens : screensList) {
                if (screens.getScreensId().equals(screening.getScreensId())) {
                    ScreensDTO screensDTO = new ScreensDTO();
                    BeanUtils.copyProperties(screens,screensDTO);
                    List<ScreensSeat> screensSeats = new ArrayList<>();
                    for (ScreensSeat screensSeat : screensSeatList) {
                        if (screens.getScreensId().equals(screensSeat.getScreensId())) {
                            screensSeats.add(screensSeat);
                        }
                    }
                    screensDTO.setScreensSeatList(screensSeats);
                    screeningDTO.setScreens(screensDTO);
                }
            }
            screeningDTOList.add(screeningDTO);
        }
        return screeningDTOList;
    }

}
