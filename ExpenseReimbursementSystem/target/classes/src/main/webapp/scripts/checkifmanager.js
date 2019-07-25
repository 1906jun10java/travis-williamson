let user = {};

window.onload = function() {
	checkifmanager();
}

function checkifmanager() {
	// send a GET request to SessionServlet to obtain session information
	fetch("http://localhost:8082/ExpenseReimbursementSystem/session").then(function(response) {
		return response.json(); // parsing json data in the response as a JS object
	}).then(function(data) {
		console.log(data);
		// check whether there is a valid session
		//define behavior for when there is no valid user
		if(data.session === null) {
			window.location = "http://localhost:8082/ExpenseReimbursementSystem/login"
		} else {
			//define behavior for when a user is returned
			user = data;
			
			if(user.userID != 1) {
				window.location = "http://localhost:8082/ExpenseReimbursementSystem/login"
			}
			
		}
	})
}