/* ------------------------------------------------------------------------------
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) Rococo Global Technologies, Inc - All Rights Reserved 2016
 * --------------------------------------------------------------------------- */

package midterm.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Base DTO that will inherited by the DTO classes.
 * @author Lehmar Cabrillos
 * @version 0.01 
 * Version History [03/08/2016] 0.01 – Lehmar Cabrillos – initial
 *          codes
 **/
public class BaseDto {

    /**
     * List of errors.
     */
    private List<String> errorList = new ArrayList<String>();

    /**
     * Add error to the existing error list.
     * @param error error to add.
     */
    public void addError(String error) {
        this.getErrorList().add(error);
    }

    /**
     * Clears the error list.
     */
    public void clearErrors() {
        this.getErrorList().clear();
    }

    /**
     * Retrieves list of errors.
     * @return the errorList
     */
    public List<String> getErrorList() {
        return errorList;
    }

    /**
     * Sets list of errors.
     * @return the errorList to set
     */
    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }

}
