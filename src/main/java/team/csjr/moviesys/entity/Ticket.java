package team.csjr.moviesys.entity;

import javax.persistence.*;

public class Ticket {
    @Id
    @Column(name = "ticket_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "ticket_status")
    private String ticketStatus;

    @Column(name = "screening_id")
    private Long screeningId;

    @Column(name = "screening_column")
    private Integer screeningColumn;

    @Column(name = "screening_row")
    private Integer screeningRow;

    /**
     * @return ticket_id
     */
    public Long getTicketId() {
        return ticketId;
    }

    /**
     * @param ticketId
     */
    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return ticket_status
     */
    public String getTicketStatus() {
        return ticketStatus;
    }

    /**
     * @param ticketStatus
     */
    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

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
     * @return screening_column
     */
    public Integer getScreeningColumn() {
        return screeningColumn;
    }

    /**
     * @param screeningColumn
     */
    public void setScreeningColumn(Integer screeningColumn) {
        this.screeningColumn = screeningColumn;
    }

    /**
     * @return screening_row
     */
    public Integer getScreeningRow() {
        return screeningRow;
    }

    /**
     * @param screeningRow
     */
    public void setScreeningRow(Integer screeningRow) {
        this.screeningRow = screeningRow;
    }
}