package team.csjr.moviesys.service.impl;

import org.springframework.stereotype.Service;
import team.csjr.moviesys.base.service.BaseService;
import team.csjr.moviesys.base.service.impl.BaseServiceImpl;
import team.csjr.moviesys.entity.Movie;
import team.csjr.moviesys.mapper.MovieMapper;
import team.csjr.moviesys.service.MovieService;

/**
 * @author ReMidDream
 * @date 2018/12/20 10:26
 **/
@Service
public class MovieServiceImpl extends BaseServiceImpl<MovieMapper, Movie> implements MovieService {
}
