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
			
			document.getElementById("addressline1").innerText = "addressline1: "+user.addressLine1;
			document.getElementById("addressline2").innerText = "addressline2: "+user.addressLine2;
			document.getElementById("city").innerText = "city: "+user.city;
			document.getElementById("state").innerText = "state: "+user.state;
			document.getElementById("zipcode").innerText = "zipcode: "+user.zipCode;
			document.getElementById("email").innerText = "email: "+user.emailAddress;
			document.getElementById("phone").innerText = "phone: "+user.phoneNumber;
		}
	})
}