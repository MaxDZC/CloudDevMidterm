/* ------------------------------------------------------------------------------
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) Rococo Global Technologies, Inc - All Rights Reserved 2016
 * --------------------------------------------------------------------------- */

package midterm.dto;

import java.util.List;

/**
 * DTO class for the reportCardModel.
 * @author Lehmar Cabrillos
 * @version 0.01 
 * Version History [03/08/2016] 0.01 – Lehmar Cabrillos – initial
 *          codes
 **/
public class ReportCardDto extends BaseDto{
    /**
     * Id of the item
     */
    private Long id;
    
    /**
     * Name of the student
     */
    private String studentName;
    
    /**
     * The grade level of the student.
     */
    private int gradeLevel;
    
    /**
     * The section of the student.
     */
    private String sectionName;
    
    /**
     * The grading period for the grades.
     */
    private int gradingPeriod;
    
    /**
     * List of grades for a grading period.
     */
    private List<Integer> gradingList;
    
    /**
     * The average of all the grade.
     */
    private Double totalGrade;
    
    /**
     * Flag that tells whether the student passed or failed.
     */
    private boolean passed;
    
    
    /**
     * Retrieve the id
     * @return id of the model
     */
    public Long getId() {
        return id;
    }
    
    /**
     * Sets the id 
     * @param id - value to be set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Retrive the name of the student
     * @return the name of the student
     */
    public String getStudentName() {
        return studentName;
    }
    
    /**
     * Sets the name of the student
     * @param studentName - name of the student to be set
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    
    /**
     * Retrieves the grade level
     * @return grade level of the student
     */
    public int getGradeLevel() {
        return gradeLevel;
    }
    
    /**
     * Sets the grade level
     * @param gradeLevel - the value to be set
     */
    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }
    
    /**
     * Retrieves the section name.
     * @return the name of the section
     */
    public String getSectionName() {
        return sectionName;
    }
    
    /**
     * Sets the name of the section
     * @param sectionName - the value to be set
     */
    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }
    
    /**
     * Retrieves the grading period for the grades
     * @return the grading period for the grades
     */
    public int getGradingPeriod() {
        return gradingPeriod;
    }
    
    /**
     * Sets the grading period for the grades
     * @param gradingPeriod - the value to be set
     */
    public void setGradingPeriod(int gradingPeriod) {
        this.gradingPeriod = gradingPeriod;
    }
    
    /**
     * Retrieves the list of grades
     * @return list of grades
     */
    public List<Integer> getGradingList() {
        return gradingList;
    }
    
    /**
     * Sets the list of grades
     * @param gradingList the values to be set
     */
    public void setGradingList(List<Integer> gradingList) {
        this.gradingList = gradingList;
    }
    
    /**
     * Retrieves the average of the grades
     * @return the average
     */
    public Double getTotalGrade() {
        return totalGrade;
    }
    
    /**
     * Sets the average of the grades
     * @param totalGrade - the value to be set
     */
    public void setTotalGrade(Double totalGrade) {
        this.totalGrade = totalGrade;
    }
    
    /**
     * Retrieves the flag whether the student passed
     * @return the flag
     */
    public boolean isPassed() {
        return passed;
    }
    
    /**
     * Sets the flag whether the student passed
     * @param passed - the value to be set
     */
    public void setPassed(boolean passed) {
        this.passed = passed;
    }
    
}
