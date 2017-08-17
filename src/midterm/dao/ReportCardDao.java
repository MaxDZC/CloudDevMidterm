/* ------------------------------------------------------------------------------
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) Rococo Global Technologies, Inc - All Rights Reserved 2016
 * --------------------------------------------------------------------------- */

package midterm.dao;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Transaction;

import midterm.meta.ReportCardModelMeta;
import midterm.model.ReportCardModel;

/**
 * This controller handles the creation of reportCard model to the datastore.
 * @author Lehmar Cabrillos
 * @version 0.01 
 * Version History [03/08/2016] 0.01 – Lehmar Cabrillos – initial
 *          codes
 **/
public class ReportCardDao {

    /**
     * This function is called to insert the reportCardModel to the datastore.
     * 
     * @param inputModel
     *            - model to be inserted to the datastore
     */
    public void insertReportCard(ReportCardModel inputModel) {
        System.out.println("ReportCardDao.insertReportCard " + "start");
        
        Transaction transaction;
        Key key, parentKey;
        
        // TODO: Implement this function.
        transaction = Datastore.beginTransaction();
        key = KeyFactory.createKey("ReportCard", inputModel.getStudentName());
        parentKey = Datastore.allocateId(key, "ReportCardModel");
        
        inputModel.setKey(parentKey);
        inputModel.setId(parentKey.getId());
        
        Datastore.put(inputModel);
        
        transaction.commit();
        
        System.out.println("ReportCardDao.insertReportCard " + "end");
    }

    /**
     * This function is used to update a reportCardModel to the datastore.
     * @param inputModel
     *            - model to be updated
     */
    public void updateReportCard(ReportCardModel inputModel) {
        System.out.println("ReportCardDao.updateReportCard " + "start");
        
        Transaction transaction;
        
        // TODO: Implement this function.
        transaction = Datastore.beginTransaction();
        
        Datastore.put(inputModel);
        
        transaction.commit();
        
        System.out.println("ReportCardDao.updateReportCard " + "end");
    }

    /**
     * This function is used to delete a reportCardModel from the datastore.
     * 
     * @param inputModel
     *            - model to be updated
     */
    public void deleteReportCard(ReportCardModel inputModel) {
        System.out.println("ReportCardDao.deleteReportCard " + "start");
        
        Transaction transaction;
        
        // TODO: Implement this function.
        transaction = Datastore.beginTransaction();
        
        Datastore.delete(inputModel.getKey());
        
        transaction.commit();
        
        System.out.println("ReportCardDao.deleteReportCard " + "end");
    }

    /**
     * This function is used to be a reportCardModel with the same id.
     * 
     * @param inputModel
     *            - contains the id to be checked.
     * @return model that was returned by the query.
     */
    public ReportCardModel getCardById(ReportCardModel inputModel) {
        System.out.println("ReportCardDao.getCardById " + "start");
        
        Transaction transaction;
        ReportCardModelMeta rc;
        ReportCardModel reportCardModel = new ReportCardModel();
        
        // TODO: Implement this function.
        rc = new ReportCardModelMeta();
        transaction = Datastore.beginTransaction();
        
        reportCardModel = Datastore.query(rc)
                .filter(rc.id.equal(inputModel.getId()))
                .asSingle();
        
        transaction.commit();
        
        System.out.println("ReportCardDao.getCardById " + "end");
        return reportCardModel;
    }

    /**
     * This function is used to be a reportCardModel with the same name and
     * level.
     * 
     * @param inputModel
     *            - contains the name and level to be checked.
     * @return model that was returned by the query.
     */
    public ReportCardModel getCardByNameLevel(ReportCardModel inputModel) {
        System.out.println("ReportCardDao.getCardByNameLevel " + "start");
        
        Transaction transaction;
        ReportCardModelMeta rc;
        ReportCardModel reportCardModel = new ReportCardModel(); 
        
        // You must also include grading period in this case
        // Different grades for different grading periods
        // Not implemented due to not being in the instructions :)
        // TODO: Implement this function.
        rc = new ReportCardModelMeta();
        transaction = Datastore.beginTransaction();
        
        reportCardModel = Datastore.query(rc)
                .filter(rc.studentName.equal(inputModel.getStudentName()),
                 rc.gradeLevel.equal(inputModel.getGradeLevel()))
                 .asSingle();
        
        transaction.commit();
        
        System.out.println("ReportCardDao.getCardByNameLevel " + "end");
        return reportCardModel;
    }
}
