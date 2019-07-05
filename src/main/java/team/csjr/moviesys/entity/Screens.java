package team.csjr.moviesys.entity;

import javax.persistence.*;

public class Screens {

    @Id
    @Column(name = "screens_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long screensId;

    @Column(name = "screens_name")
    private String screensName;

    public Long getScreensId() {
        return screensId;
    }

    public void setScreensId(Long screensId) {
        this.screensId = screensId;
    }

    /**
     * @return screens_name
     */
    public String getScreensName() {
        return screensName;
    }

    /**
     * @param screensName
     */
    public void setScreensName(String screensName) {
        this.screensName = screensName;
    }
}