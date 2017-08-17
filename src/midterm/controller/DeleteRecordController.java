/* ------------------------------------------------------------------------------
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) Rococo Global Technologies, Inc - All Rights Reserved 2016
 * --------------------------------------------------------------------------- */
 
package midterm.controller;

import midterm.dto.ReportCardDto;
import midterm.service.ReportCardService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

/**
* This controller handles the deletion of reportCard model from the datastore.
* @author Lehmar Cabrillos
* @version 0.01
* Version History
* [03/08/2016] 0.01 – Lehmar Cabrillos – initial codes
**/ 
public class DeleteRecordController extends Controller {
    
    /**
     * Service object that will be used to call the delete from datastore function.
     */
    ReportCardService reportCardService = new ReportCardService();
    
    /**
     * The function that will be ran by default when this class is called.
     */
    @Override
    public Navigation run() throws Exception {
        System.out.println("DeleteRecordController " + "start");
        /**
         * dto object that will be used to store the values passed from the request.
         */ 
        ReportCardDto reportCardDto = new ReportCardDto();
        Long id;
        
        try {
            // TODO: Implement this function
            id = Long.parseLong(request.getParameter("studentId"));
            reportCardDto.setId(id);
            
            reportCardService.deleteRecord(reportCardDto);
         
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        System.out.println("DeleteRecordController " + "end");
        // displaying back to the main web page.
        return redirect("/html/midtermExam.html");
    }
}
