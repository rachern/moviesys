package team.csjr.moviesys.entity;

import javax.persistence.*;

public class Cinema {
    @Id
    @Column(name = "cinema_id")
    private Long cinemaId;

    @Column(name = "cinema_name")
    private String cinemaName;

    /**
     * @return cinema_id
     */
    public Long getCinemaId() {
        return cinemaId;
    }

    /**
     * @param cinemaId
     */
    public void setCinemaId(Long cinemaId) {
        this.cinemaId = cinemaId;
    }

    /**
     * @return cinema_name
     */
    public String getCinemaName() {
        return cinemaName;
    }

    /**
     * @param cinemaName
     */
    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }
}