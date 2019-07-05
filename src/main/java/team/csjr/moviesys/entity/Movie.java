package team.csjr.moviesys.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;

public class Movie {
    @Id
    @Column(name = "movie_id")
    private Long movieId;

    @Column(name = "movie_name")
    private String movieName;

    /**
     * 上映时间
     */
    @Column(name = "release_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date releaseTime;

    /**
     * 电影时长
     */
    @Column(name = "running_time")
    private String runningTime;

    @Column(name = "movie_icon")
    private String movieIcon;

    @Column(name = "movie_describe")
    private String movieDescribe;

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    /**
     * @return movie_name
     */
    public String getMovieName() {
        return movieName;
    }

    /**
     * @param movieName
     */
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    /**
     * 获取上映时间
     *
     * @return release_time - 上映时间
     */
    public Date getReleaseTime() {
        return releaseTime;
    }

    /**
     * 设置上映时间
     *
     * @param releaseTime 上映时间
     */
    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    /**
     * 获取电影时长
     *
     * @return running_time - 电影时长
     */
    public String getRunningTime() {
        return runningTime;
    }

    /**
     * 设置电影时长
     *
     * @param runningTime 电影时长
     */
    public void setRunningTime(String runningTime) {
        this.runningTime = runningTime;
    }

    /**
     * @return movie_icon
     */
    public String getMovieIcon() {
        return movieIcon;
    }

    /**
     * @param movieIcon
     */
    public void setMovieIcon(String movieIcon) {
        this.movieIcon = movieIcon;
    }

    /**
     * @return movie_describe
     */
    public String getMovieDescribe() {
        return movieDescribe;
    }

    /**
     * @param movieDescribe
     */
    public void setMovieDescribe(String movieDescribe) {
        this.movieDescribe = movieDescribe;
    }
}