package team.csjr.moviesys.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.csjr.moviesys.base.ResultUtil;
import team.csjr.moviesys.base.dto.ResultDTO;
import team.csjr.moviesys.entity.Feedback;
import team.csjr.moviesys.service.FeedbackService;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author ReMidDream
 * @date 2018/12/20 10:20
 **/
@RestController
@CrossOrigin
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping
    public ResultDTO insertFeedBack(Feedback feedback) throws Exception {
        feedback.setFeedbackTime(new Date());
        feedbackService.save(feedback);
        return ResultUtil.Success();
    }

    @GetMapping
    public List<Feedback> getFeedBack() throws Exception {
        List<Feedback> feedbackList = feedbackService.findAll();
        /*
            降序
         */
        feedbackList.sort((f1, f2) -> {
            if (f1.getFeedbackId() > f2.getFeedbackId()) {
                return -1;
            }else if (f1.getFeedbackId() < f2.getFeedbackId()) {
                return 1;
            }else {
                return 0;
            }
        });
        return feedbackList;
    }

}
