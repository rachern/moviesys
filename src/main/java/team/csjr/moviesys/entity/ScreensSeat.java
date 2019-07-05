package team.csjr.moviesys.entity;

import javax.persistence.*;
import java.lang.reflect.GenericArrayType;

@Table(name = "screens_seat")
public class ScreensSeat {

    @Id
    @Column(name = "screens_seat_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long screensSeatId;

    @Column(name = "screens_id")
    private Long screensId;

    @Column(name = "column_number")
    private Integer columnNumber;

    @Column(name = "row_number")
    private Integer rowNumber;

    /**
     * @return screens_seat_id
     */
    public Long getScreensSeatId() {
        return screensSeatId;
    }

    /**
     * @param screensSeatId
     */
    public void setScreensSeatId(Long screensSeatId) {
        this.screensSeatId = screensSeatId;
    }

    public Long getScreensId() {
        return screensId;
    }

    public void setScreensId(Long screensId) {
        this.screensId = screensId;
    }

    /**
     * @return column_number
     */
    public Integer getColumnNumber() {
        return columnNumber;
    }

    /**
     * @param columnNumber
     */
    public void setColumnNumber(Integer columnNumber) {
        this.columnNumber = columnNumber;
    }

    /**
     * @return row_number
     */
    public Integer getRowNumber() {
        return rowNumber;
    }

    /**
     * @param rowNumber
     */
    public void setRowNumber(Integer rowNumber) {
        this.rowNumber = rowNumber;
    }
}