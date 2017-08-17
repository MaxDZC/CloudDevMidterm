/* ------------------------------------------------------------------------------
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) Rococo Global Technologies, Inc - All Rights Reserved 2016
 * --------------------------------------------------------------------------- */

/**
 * Contains the javascript codes for the midterm html.
 * @author Lehmar Cabrillos
 * @version 0.01 
 * Version History [03/08/2016] 0.01 – Lehmar Cabrillos – initial
 *          codes
 **/

/*Global Variables Start*/
// Basic information for the report car
 var studentName = document.getElementById("studentName");
 var gradeLevel = document.getElementById("gradeLevel");
 var sectionName = document.getElementById("sectionName");
 var gradingPeriod = document.getElementById("gradingPeriod");
 
 // Grade Information for the report card
 var gradeFil = document.getElementById("gradeFil");
 var gradeSocStud = document.getElementById("gradeSocStud");
 var gradeMapeh = document.getElementById("gradeMapeh");
 var gradeEnglish = document.getElementById("gradeEnglish");
 var gradeScience = document.getElementById("gradeScience");
 var gradeMath = document.getElementById("gradeMath");
 var gradeTotal = document.getElementById("gradeTotal");
 var passFail = document.getElementById("passFail");
 /*Global Variables End*/

 
 /**
  * This function is used to create a record to the datastore. The data are passed
  * as request.
  */
function createRecord() {
	console.log("createRecord " + "start");
	// check if the user want to proceed to adding the item.
	if (confirmation("add")){
		// creating a form that be sent to the controller.
		var form = document.createElement("form");
		form.setAttribute("method", "post");
		form.setAttribute("action", "/CreateRecord"); 
		
		// setting the elements that will be sent as request.
		form = storeToForm(form);
		
		// Added fix
		document.body.appendChild(form);
		 
		form.submit();
		
	}
	console.log("createRecord " + "end");
}

/**
 * Used to update a record to the datastore. The data are passed as request.
 */
function updateRecord() {
	console.log("updateRecord " + "start");
	// check if the user want to proceed to updating the item.
	if (confirmation("update")){
		
		// prompt the user to input the id of the item to be updated.
		var studentId = prompt("Put the id of the student to be updated. (Base from datastore)","");
		
		// check if the inputted value is valid or not.
		if (studentId != null) {
			// creating a field that will be used to store the studentId
			// this will be attached to the form element created below.
			var studentIdField = document.createElement("input");
			studentIdField.setAttribute("type", "hidden");
			studentIdField.setAttribute("name", "studentId");
			studentIdField.setAttribute("value", studentId);
			
			// creating a form that will be sent to the controller.
			var form = document.createElement("form");
			form.setAttribute("method", "post");
			form.setAttribute("action", "/UpdateRecord"); 
			
			// setting the elements that will be sent as request.
			form = storeToForm(form);
			form.appendChild(studentIdField);
			
			// Added fix
			document.body.appendChild(form);
			
			form.submit();
		}
	}
	console.log("updateRecord " + "end");
}

/**
 * Used to delete a record from the datastore. The data are passed as request.
 */
function deleteRecord() {
	console.log("deleteRecord " + "start");
	// prompt the user to input the id of the item to be deleted.
	var studentId = prompt("Put the id of the student to be deleted. (Base from datastore)","");
	
	// check if the inputted value is valid or not.
	if (studentId != null) {
		// creating a field that will be used to store the studentId
		// this will be attached to the form element created below.
		var studentIdField = document.createElement("input");
		studentIdField.setAttribute("type", "hidden");
		studentIdField.setAttribute("name", "studentId");
		studentIdField.setAttribute("value", studentId);
		
		// creating a form that be sent to the controller.
		var form = document.createElement("form");
		form.setAttribute("method", "post");
		form.setAttribute("action", "/DeleteRecord");
		
		// setting the elements that will be sent as request.
		form.appendChild(studentIdField);
		document.body.appendChild(form);
		form.submit();
	}
	console.log("deleteRecord " + "end");
}

/**
 * Used to create an input field and sets its element with the values of 
 * 		the parameters.
 * @param name - the name of the input field.
 * @param value - the value of the input field.
 * @returns - input field that was created.
 * 		this will be attached to the form.
 */
function storeInputField(name, value) {
	console.log("storeInputField " + "start");
	var field = document.createElement("input");
	field.setAttribute("type", "hidden");
	field.setAttribute("name", name);
	field.setAttribute("value", value);
	
	console.log("storeInputField " + "end");
	return field;
}

/**
 * Function used to store the information from the input fields in the web page
 * 		to the form that was created programatically.
 * @param form - the form where the input fields will be attached.
 * @returns the form with the attached fields.
 */
function storeToForm(form){
	 console.log("storeToForm " + "start");
	 // attaching the fields to the form
	 form.appendChild(storeInputField("studentName", studentName.value));
	 form.appendChild(storeInputField("gradeLevel", gradeLevel.value));
	 form.appendChild(storeInputField("sectionName", sectionName.value));
	 form.appendChild(storeInputField("gradingPeriod", 
			 	gradingPeriod.options[gradingPeriod.selectedIndex].value));
	 
	 var grades = [gradeFil.value, gradeSocStud.value, gradeMapeh.value,
	               gradeEnglish.value, gradeScience.value, gradeMath.value];
	 
	 var gradeField = document.createElement("input");
	 gradeField.setAttribute("type", "hidden");
	 gradeField.setAttribute("name", "grades");
	 gradeField.setAttribute("value", grades);
	 
	 form.appendChild(gradeField);
	 form.appendChild(storeInputField("gradeTotal", gradeTotal.value));
	 form.appendChild(storeInputField("passFail", passFail.value));

	 console.log("storeToForm " + "end");
	 return form;
}


/*------------------------------------------------------------------------------
 * NOTE TO STUDENTS: DO NOT MIND THESE FUNCTIONS
 */

/**
 * Use to ask the user for confirmation if he/she want to proceed doing the 'operation'.
 * This function will also set the value for the totalGrade field, and passedFail field.
 * @param operation - either 'add' or 'update'
 */
function confirmation(operation){
	console.log("confirmation " + "start");
	var confirmed = null;
	
	// validating the input field values before proceeding
	if (validateInputs()) {
		setPassFail(setTotalGrade());
		confirmed = window.confirm("Are you sure you want to " + operation + " record?");
	}
	console.log("confirmation " + "end");
	return confirmed;
}

/**
 * Used to compute the total grade
 * @returns value of the total grade.
 */
function setTotalGrade(){
	console.log("setTotalGrade " + "start");
	// values for each corresponding subjects.
	var gFil = gradeFil.value;
	var gSocStud = gradeSocStud.value;
	var gMapeh = gradeMapeh.value;
	var gEnglish = gradeEnglish.value;
	var gScience = gradeScience.value;
	var gMath = gradeMath.value;
	
	// computation of the grade.
	var totalGrade = parseInt(gFil) + parseInt(gSocStud) + parseInt(gMapeh) 
					+ parseInt(gEnglish) + parseInt(gScience) + parseInt(gMath);
	
	// setting the value of the total grade field.
	gradeTotal.value = (totalGrade/6);
	console.log("setTotalGrade " + "end");
	return gradeTotal.value;
}

/**
 * Used to set the passFail field.
 * @param totalGrade - the grade that will assessed if it passed or failed.
 */
function setPassFail(totalGrade){
	 console.log("setPassFail " + "start");
	 var passFail = document.getElementById("passFail");
	 passFail.value = (totalGrade >= 75) ? "true" : "false";
	 console.log("setPassFail " + "end");
}

/**
 * Function used to validate all the input fields.
 * @returns {Boolean} true - if all inputs are valid; false - otherwise
 */
function validateInputs(){
	 console.log("validateInputs " + "start");
	 // validating all the fields.
	 var errorMessage = "";
	 errorMessage += validateEmpty(studentName, "Student Name");
	 errorMessage += validateGradeLevel(gradeLevel, "Grade Level");
	 errorMessage += validateEmpty(sectionName, "Section Name");
	 errorMessage += validateGrade(gradeFil, "Grade for Filipino");
	 errorMessage += validateGrade(gradeSocStud, "Grade for Social Studies");
	 errorMessage += validateGrade(gradeMapeh, "Grade for MAPEH");
	 errorMessage += validateGrade(gradeEnglish, "Grade for English");
	 errorMessage += validateGrade(gradeScience, "Grade for Science");
	 errorMessage += validateGrade(gradeMath, "Grade for Mathematics");
	 
	 console.log("validateInputs " + "end");
	
	 // checking if all fields are valid.
	 if (errorMessage == null || errorMessage == "") {
		 return true;
	 }
	 
	 // displaying the errormessage.
	 alert(errorMessage);
	 
	 return false;
}

/**
 * Used to validate if a field is empty.
 * @param field - the field that will be validated.
 * @param fieldName - the name of the field to be appended to the errormessage.
 * @returns {String} errorMessage if there exists.
 */
function validateEmpty(field, fieldName){
	console.log("validateEmpty " + "start");
	var errorMessage = "";
	console.log("field: " + field);
	if (field.value == null || field.value == "") {
		errorMessage = "\nPlease input " + fieldName + ".";
	}
	console.log("validateEmpty " + "end");
	return errorMessage;
}

/**
 * Used to validate if a field is an integer or not.
 * @param field - the field that will be validated.
 * @param fieldName - the name of the field to be appended to the errormessage.
 * @returns {String} errorMessage if there exists.
 */
function validateInt(field, fieldName){
	console.log("validateInt " + "start");
	var errorMessage = validateEmpty(field, fieldName);
	if (errorMessage == null || errorMessage == "") {
		if (field.value % 1 != 0) {
			errorMessage = "\n" + fieldName + " must be an integer."
		}
	}
	console.log("validateInt " + "end");
	return errorMessage;
}

/**
 * Used to validate if a field's value if within the range set by the parameters.
 * @param field - the field that will be validated.
 * @param lowerLimit - the lower limit of the range.
 * @param upperLimit - the upper limit of the range.
 * @param fieldName - the name of the field to be appended to the errormessage.
 * @returns {String} errorMessage if there exists.
 */
function validateRange(field, lowerLimit, upperLimit, fieldName){
	console.log("validateRange " + "start");
	var errorMessage = "";
	if (field.value < lowerLimit || field.value > upperLimit) {
		errorMessage = "\n" + fieldName + " must be within " + lowerLimit 
			+ " - " + upperLimit +"."; 
	}
	console.log("validateRange " + "end");
	return errorMessage;
}

/**
 * Used to validate if a field is a valid gradeLevel (1-12).
 * @param field - the field that will be validated.
 * @param fieldName - the name of the field to be appended to the errormessage.
 * @returns {String} errorMessage if there exists.
 */
function validateGradeLevel(field, fieldName) {
	console.log("validateGradeLevel " + "start");
	var errorMessage = validateInt(field, fieldName);
	
	if (errorMessage == null || errorMessage  =="") {
		errorMessage = (validateRange(field, 1, 12, fieldName));
	}
	console.log("validateGradeLevel " + "end");
	return errorMessage;
}

/**
 * Used to validate if a field is a valid grade (1%-100%).
 * @param field - the field that will be validated.
 * @param fieldName - the name of the field to be appended to the errormessage.
 * @returns {String} errorMessage if there exists.
 */
function validateGrade(field, fieldName){
	console.log("validateGrade " + "start");
	var errorMessage = validateInt(field, fieldName);
	
	if (errorMessage == null || errorMessage  == "") {
		errorMessage = (validateRange(field, 1, 100, fieldName));
	}
	console.log("validateGrade " + "end");
	return errorMessage;
}