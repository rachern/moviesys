package team.csjr.moviesys.base.exception;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import team.csjr.moviesys.base.ResultUtil;
import team.csjr.moviesys.base.dto.ResultDTO;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class AbtBaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private Logger log = LoggerFactory.getLogger(getClass());

    protected String code;

    protected String arguments;

    public AbtBaseException() {
        super();
        this.code = AbtErrorConstants.BASE_ERROR;
    }

    public AbtBaseException(String code) {
        this.code = code;
    }

    public AbtBaseException(String code, String... argumentArray) {
        this.code = code;
        if (argumentArray != null && argumentArray.length > 0) {
            this.arguments = StringUtils.join(argumentArray, ",");
        }
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResultDTO allExceptionHandler(HttpServletRequest request, Exception exception) throws Exception {
        if(exception instanceof  AbtBaseException){
            AbtBaseException abe = (AbtBaseException)exception;
            return ResultUtil.Error(abe.code,abe.arguments);
        }
        log.error("error", exception);
        return ResultUtil.Error("500",exception.toString());
    }

    public String getCode() {
        return code;
    }

    public String getArguments() {
        return arguments;
    }

}
