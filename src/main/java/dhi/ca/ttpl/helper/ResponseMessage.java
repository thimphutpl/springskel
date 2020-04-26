
package dhi.ca.ttpl.helper;

/**
 * Created by jigme.dorji on 23/04/2020.
 */
public class ResponseMessage {
    //region private declaration
    private Integer status = 1;
    private String text;
    private Object dto;
    //endregion

    //region empty constructor
    public ResponseMessage() {
    }
    //endregion

    //region getter and setter
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Object getDTO() {
        return dto;
    }

    public void setDTO(Object dto) {
        this.dto = dto;
    }
    //endregion
}
