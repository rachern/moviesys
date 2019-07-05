package team.csjr.moviesys.service.impl;

import org.springframework.stereotype.Service;
import team.csjr.moviesys.base.service.BaseService;
import team.csjr.moviesys.base.service.impl.BaseServiceImpl;
import team.csjr.moviesys.entity.Cinema;
import team.csjr.moviesys.mapper.CinemaMapper;
import team.csjr.moviesys.service.CinemaService;

/**
 * @author ReMidDream
 * @date 2018/12/20 10:26
 **/
@Service
public class CinemaServiceImpl extends BaseServiceImpl<CinemaMapper, Cinema> implements CinemaService {
}
