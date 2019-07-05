package team.csjr.moviesys.service.impl;

import org.springframework.stereotype.Service;
import team.csjr.moviesys.base.service.BaseService;
import team.csjr.moviesys.base.service.impl.BaseServiceImpl;
import team.csjr.moviesys.entity.Feedback;
import team.csjr.moviesys.mapper.FeedbackMapper;
import team.csjr.moviesys.service.FeedbackService;

/**
 * @author ReMidDream
 * @date 2018/12/20 10:26
 **/
@Service
public class FeedbackServiceImpl extends BaseServiceImpl<FeedbackMapper, Feedback> implements FeedbackService {
}
