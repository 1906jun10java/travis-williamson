let userArray = {};

window.onload = function() {
	listEmployeesAndManagers();
}

function listEmployeesAndManagers() {
	// send a GET request to servlet to obtain information
	fetch("http://localhost:8082/ExpenseReimbursementSystem//viewallemployeesandmanagers").then(function(response) {
		return response.json(); // parsing json data in the response as a JS object
	}).then(function(data) {
		console.log(data);
		// check whether there is a valid session
		//define behavior for when there is no valid user
		if(data.session === null) {
			window.location = "http://localhost:8082/ExpenseReimbursementSystem/login"
		} else {
			userArray = data;
			
			for (i = 0; i < userArray.length; i++) {
				let li = document.createElement("li");
				let employee = `Employee: ${userArray[i].firstName} ${userArray[i].lastName}`;
				let manager = `Manager: ${userArray[i].managerFirstName} ${userArray[i].managerLastName}`
				if (userArray[i].managerFirstName == null) {
					manager = "Manager: NA";
				}
				let employeeAndManager = document.createTextNode(`${employee}, ${manager}`);
				// use \u00A0 to create extra white space in a template literal
				//let employeeAndManager = document.createTextNode(`Employee: ${userArray[i].firstName} ${userArray[i].lastName}, Manager: ${userArray[i].managerFirstName} ${userArray[i].managerLastName}`);
				//let employeeAndManager = document.createTextNode("Employee: " + userArray[i].firstName + " " + userArray[i].lastName + ", Manager: " + userArray[i].managerFirstName + " " + userArray[i].managerLastName);
				li.appendChild(employeeAndManager);
				document.getElementById("employeesandmanagers").appendChild(li);
			}
			
			/*
			document.getElementById("userid").innerText = "userid: "+userArray[0].userID;
			document.getElementById("firstname").innerText = "firstname: "+userArray[0].firstName;
			document.getElementById("lastname").innerText = "lastname: "+userArray[0].lastName;
			document.getElementById("managerid").innerText = "managerid: "+userArray[0].managerID;
			document.getElementById("managerfirstname").innerText = "managerfirstname: "+userArray[0].managerFirstName;
			document.getElementById("managerlastname").innerText = "managerlastname: "+userArray[0].managerLastName;
			/*
			
			/*
			for (i = 0; i < userArray.length; i++) {
				
				
				document.getElementById("userid").innerText = "userid: "+userArray[i].userID;
				document.getElementById("firstname").innerText = "firstname: "+userArray[i].firstName;
				document.getElementById("lastname").innerText = "lastname: "+userArray[i].lastName;
				document.getElementById("managerid").innerText = "managerid: "+userArray[i].managerID;
				document.getElementById("managerfirstname").innerText = "managerfirstname: "+userArray[i].managerFirstName;
				document.getElementById("managerlastname").innerText = "managerlastname: "+userArray[i].managerLastName;
				
			}
			*/
			
		}
	})
}