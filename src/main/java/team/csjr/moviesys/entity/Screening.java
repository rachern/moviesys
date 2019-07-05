package team.csjr.moviesys.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;

public class Screening {
    @Id
    @Column(name = "screening_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long screeningId;

    @Column(name = "begin_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date beginTime;

    @Column(name = "end_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date endTime;

    /**
     * 影厅id
     */
    @Column(name = "screens_id")
    private Long screensId;

    @Column(name = "movie_id")
    private Long movieId;

    private Double price;

    /**
     * @return screening_id
     */
    public Long getScreeningId() {
        return screeningId;
    }

    /**
     * @param screeningId
     */
    public void setScreeningId(Long screeningId) {
        this.screeningId = screeningId;
    }

    /**
     * @return begin_time
     */
    public Date getBeginTime() {
        return beginTime;
    }

    /**
     * @param beginTime
     */
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * @return end_time
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endTime
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getScreensId() {
        return screensId;
    }

    public void setScreensId(Long screensId) {
        this.screensId = screensId;
    }

    /**
     * @return movie_id
     */
    public Long getMovieId() {
        return movieId;
    }

    /**
     * @param movieId
     */
    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    /**
     * @return price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(Double price) {
        this.price = price;
    }
}