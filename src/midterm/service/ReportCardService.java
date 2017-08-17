/* ------------------------------------------------------------------------------
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) Rococo Global Technologies, Inc - All Rights Reserved 2016
 * --------------------------------------------------------------------------- */

package midterm.service;

import midterm.dao.ReportCardDao;
import midterm.dto.ReportCardDto;
import midterm.model.ReportCardModel;
/**
 * Service class for the reportCard entity.
 * @author Lehmar Cabrillos
 * @version 0.01 
 * Version History [03/08/2016] 0.01 – Lehmar Cabrillos – initial
 *          codes
 **/
public class ReportCardService {
    /**
     * Object that will be used to call the dao functions.
     */
    ReportCardDao reportCardDao = new ReportCardDao();
    
    /**
     * Used to insert the reportCard entity to the datastore.
     * @param recordDto - contains the data that will be store to the model.
     */
    public void insertRecord(ReportCardDto recordDto){
        System.out.println("ReportCardService.insertRecord " + "start");
        /**
         * ReportCardModel that will be stored to the datastore. 
         */
        ReportCardModel reportCardModel = storeDtoToModel(recordDto);
        
        try {
            // checking if there is already the same item that exists in the datastore.
            ReportCardModel resultModel = reportCardDao.getCardByNameLevel(reportCardModel);
            
            
            if (resultModel == null) {
                // insert the entity to the datastore.
                this.reportCardDao.insertReportCard(reportCardModel);
                System.out.println("Added Report Card.");
            } else {
                // inserting was canceled.
                System.out.println("There is already an item with same name and level");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        System.out.println("ReportCardService.insertRecord " + "end");
    }
    
    /**
     * Used to update the reportCard entity to the datastore.
     * @param recordDto - contains the data that will be store to the model.
     */
    public void updateRecord(ReportCardDto recordDto) {
        System.out.println("ReportCardService.updateRecord " + "start");
        /**
         * ReportCardModel that will be stored to the datastore. 
         */
        ReportCardModel reportCardModel = storeDtoToModel(recordDto);
        
        try {
            // checking if there is already the same item that exists in the datastore.
            ReportCardModel resultModel = reportCardDao.getCardById(reportCardModel);
            
            if (resultModel != null) {
                // setting the key in order to properly update the item
                reportCardModel.setKey(resultModel.getKey());
                // update the entity to the datastore.
                this.reportCardDao.updateReportCard(reportCardModel);
                System.out.println("Updated Report Card");
            } else {
                // updating was canceled.
                System.out.println("There is no item with the same id.");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        System.out.println("ReportCardService.updateRecord " + "end");
    }
    
    /**
     * Used to delete the reportCard entity from the datastore.
     * @param recordDto - contains the data that will be store to the model.
     */
    public void deleteRecord(ReportCardDto recordDto) {
        System.out.println("ReportCardService.deleteRecord " + "start");
        /**
         * ReportCardModel that will be stored to the datastore. 
         */
        ReportCardModel reportCardModel = storeDtoToModel(recordDto);
        
        try { 
            // checking if there is already the same item that exists in the datastore.
            ReportCardModel resultModel = reportCardDao.getCardById(reportCardModel);
            
            if (resultModel != null) {
                // setting the key in order to properly delete the item
                reportCardModel.setKey(resultModel.getKey());
                // delete the entity to the datastore.
                this.reportCardDao.deleteReportCard(reportCardModel);
                System.out.println("Deleted Report Card");
            } else {
                // deleting was canceled.
                System.out.println("There is no item with the same id.");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        System.out.println("ReportCardService.deleteRecord " + "end");
    }
    
    /**
     * Function that is used to store the datas from the DTO object to the model object
     * @param reportCardDto - the DTO object that contains the data
     * @return reportCardModel that holds the data from the DTO object.
     */
    public ReportCardModel storeDtoToModel(ReportCardDto reportCardDto) {
        System.out.println("ReportCardService.storeDtoToModel " + "start");
        // Used to store the data from the DTO object.
        ReportCardModel reportCardModel = new ReportCardModel();
        
        // Storing the data from the DTO.
        reportCardModel.setId(reportCardDto.getId());
        reportCardModel.setStudentName(reportCardDto.getStudentName());
        reportCardModel.setGradeLevel(reportCardDto.getGradeLevel());
        reportCardModel.setSectionName(reportCardDto.getSectionName());
        reportCardModel.setGradingPeriod(reportCardDto.getGradingPeriod());
        reportCardModel.setGradingList(reportCardDto.getGradingList());
        reportCardModel.setTotalGrade(reportCardDto.getTotalGrade());
        reportCardModel.setPassed(reportCardDto.isPassed());
        System.out.println("ReportCardService.storeDtoToModel " + "end");
        
        // returning the model
        return reportCardModel;
    }
      
    
}
