package team.csjr.moviesys.service.impl;

import org.springframework.stereotype.Service;
import team.csjr.moviesys.base.service.BaseService;
import team.csjr.moviesys.base.service.impl.BaseServiceImpl;
import team.csjr.moviesys.entity.Screening;
import team.csjr.moviesys.mapper.ScreeningMapper;
import team.csjr.moviesys.service.ScreeningService;

/**
 * @author ReMidDream
 * @date 2018/12/20 10:26
 **/
@Service
public class ScreeningServiceImpl extends BaseServiceImpl<ScreeningMapper, Screening> implements ScreeningService {
}
