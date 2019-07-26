let user = {};

window.onload = function() {
	getuserinfo();
}

function getuserinfo() {
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
			
			document.getElementById("addressline1").innerText = "Address Line 1: "+user.addressLine1;
			document.getElementById("addressline2").innerText = "Address Line 2: "+user.addressLine2;
			document.getElementById("city").innerText = "City: "+user.city;
			document.getElementById("state").innerText = "State: "+user.state;
			document.getElementById("zipcode").innerText = "Zip Code: "+user.zipCode;
			document.getElementById("email").innerText = "Email: "+user.emailAddress;
			document.getElementById("phone").innerText = "Phone: "+user.phoneNumber;
		}
	})
}