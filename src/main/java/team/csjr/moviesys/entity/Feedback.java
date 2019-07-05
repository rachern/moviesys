package team.csjr.moviesys.entity;

import java.util.Date;
import javax.persistence.*;

public class Feedback {
    @Id
    @Column(name = "feedback_id")
    private Integer feedbackId;

    @Column(name = "feedback_content")
    private String feedbackContent;

    @Column(name = "feedback_time")
    private Date feedbackTime;

    /**
     * @return feedback_id
     */
    public Integer getFeedbackId() {
        return feedbackId;
    }

    /**
     * @param feedbackId
     */
    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    /**
     * @return feedback_content
     */
    public String getFeedbackContent() {
        return feedbackContent;
    }

    /**
     * @param feedbackContent
     */
    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent;
    }

    /**
     * @return feedback_time
     */
    public Date getFeedbackTime() {
        return feedbackTime;
    }

    /**
     * @param feedbackTime
     */
    public void setFeedbackTime(Date feedbackTime) {
        this.feedbackTime = feedbackTime;
    }
}