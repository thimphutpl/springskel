
package dhi.ca.ttpl.global.service;

/**
 * Created by jigme.dorji on 23/04/2020.
 */
import dhi.ca.ttpl.library.helper.ResponseMessage;

public class BaseService {
    //region private variables
    protected ResponseMessage responseMessage;
    //endregion

    //region setter and getter
    public void setResponseMessage(ResponseMessage responseMessage) {
        this.responseMessage = responseMessage;
    }


}
