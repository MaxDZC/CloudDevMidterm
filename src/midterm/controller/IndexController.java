/* ------------------------------------------------------------------------------
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) Rococo Global Technologies, Inc - All Rights Reserved 2016
 * --------------------------------------------------------------------------- */
 
package midterm.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

/**
* This controller will be called when the web page is accessed. (localhost:8888)
* @author Lehmar Cabrillos
* @version 0.01
* Version History
* [03/08/2016] 0.01 – Lehmar Cabrillos – initial codes
**/ 
public class IndexController extends Controller {
    
    /**
     * The function that will be ran by default when this class is called.
     */
    @Override
    public Navigation run() throws Exception {
        System.out.println("IndexController " + "start, end");
        // TODO: Implement this function.
        return forward("/html/midtermExam.html");
    }
}
