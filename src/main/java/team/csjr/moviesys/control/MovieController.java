package team.csjr.moviesys.control;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import team.csjr.moviesys.base.ResultUtil;
import team.csjr.moviesys.base.dto.ResultDTO;
import team.csjr.moviesys.base.page.PageList;
import team.csjr.moviesys.entity.Movie;
import team.csjr.moviesys.service.FileService;
import team.csjr.moviesys.service.MovieService;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * @author ReMidDream
 * @date 2018/12/20 10:20
 **/
@RestController
@CrossOrigin
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private FileService fileService;
    @Autowired
    private MovieService movieService;

    @PostMapping
    public Movie insertMovie(Movie movie, @RequestParam("file") MultipartFile file) throws Exception {
        if(file != null){
            movie.setMovieIcon(fileService.doUpload(file));
        }
        movieService.save(movie);
        return movie;
    }

    @PostMapping("/update")
    public Movie updateMovie(Movie movie, @RequestParam(name = "file",required = false) MultipartFile file) throws Exception {
        if(file != null){
            movie.setMovieIcon(fileService.doUpload(file));
        }
        movieService.update(movie);
        return movie;
    }

    @GetMapping("/index")
    public PageList<Movie> getNewMovieList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                       @RequestParam(value = "pageSize", defaultValue = "8") Integer pageSize) throws Exception {
        return movieService.findPageData(new Movie(),pageNum,pageSize, "release_time DESC");
    }


    @GetMapping
    public PageList<Movie> getMovieList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize", defaultValue = "15") Integer pageSize) throws Exception {
        return movieService.findPageData(new Movie(), pageNum, pageSize);
    }

    @GetMapping("/{id:\\d+}")
    public Movie getMovie(@PathVariable Long id) throws Exception {
        Movie movie = new Movie();
        movie.setMovieId(id);
        return movieService.findByParams(movie).get(0);
    }

    @PostMapping("/{id:\\d+}")
    public ResultDTO deleteMovie(@PathVariable Long id) throws Exception {
        movieService.deleteById(id);
        return ResultUtil.Success();
    }
}
