/* ------------------------------------------------------------------------------
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) Rococo Global Technologies, Inc - All Rights Reserved 2016
 * --------------------------------------------------------------------------- */

package midterm.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import midterm.dto.ReportCardDto;
import midterm.service.ReportCardService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

/**
 * This controller handles the updating of reportCard model to the datastore.
 * 
 * @author Lehmar Cabrillos
 * @version 0.01 Version History [03/08/2016] 0.01 – Lehmar Cabrillos – initial
 *          codes
 **/
public class UpdateRecordController extends Controller {

    /**
     * Service object that will be used to call the insert to datastore
     * function.
     */
    ReportCardService reportCardService = new ReportCardService();

    /**
     * The function that will be ran by default when this class is called.
     */
    @Override
    public Navigation run() throws Exception {
        System.out.println("UpdateRecordController " + "start");
        /**
         * dto object that will be used to store the values passed from the
         * request.
         */
        ReportCardDto reportCardDto = new ReportCardDto();
        Long id;
        BigDecimal normalizer;
        Integer gradeLevel;
        Integer gradingPeriod;
        Double gradeTotal;
        boolean passed;
        String[] grades;
        List <Integer> gradingList;
        
        gradingList = new ArrayList<Integer>();
        
        
        try {
            // TODO: Implement this function
            reportCardDto.setStudentName(request.getParameter("studentName").toLowerCase());
            
            gradeLevel = Integer.parseInt(request.getParameter("gradeLevel"));
            reportCardDto.setGradeLevel(gradeLevel);
            
            reportCardDto.setSectionName(request.getParameter("sectionName"));
            
            gradingPeriod = Integer.parseInt(request.getParameter("gradingPeriod"));
            reportCardDto.setGradingPeriod(gradingPeriod);
            
            grades = request.getParameter("grades").split(",");
            for(String grade : grades){
                gradingList.add(Integer.parseInt(grade));
            }        
            reportCardDto.setGradingList(gradingList);
            
            normalizer = new BigDecimal(request.getParameter("gradeTotal"))
            .setScale(2, RoundingMode.HALF_UP);
            gradeTotal = Double.parseDouble(normalizer.toString());
            reportCardDto.setTotalGrade(gradeTotal);
            
            passed = Boolean.parseBoolean(request.getParameter("passFail"));
            reportCardDto.setPassed(passed);
            
            id = Long.parseLong(request.getParameter("studentId"));
            reportCardDto.setId(id);
            
            reportCardService.updateRecord(reportCardDto);
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        System.out.println("UpdateRecordController " + "end");
        // displaying back to the main web page.
        return redirect("/html/midtermExam.html");
    }
}
