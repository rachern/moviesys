package team.csjr.moviesys.base.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

/**
 * @author ReMidDream
 * @date 2018-02-22 13:52
 **/
@Data
public class ResultDTO<T> {

    public interface fullResult{};

    @JsonView(fullResult.class)
    private String code;
    @JsonView(fullResult.class)
    private String msg;
    @JsonView(fullResult.class)
    private T data;

}
