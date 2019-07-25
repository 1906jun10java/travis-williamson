let user = {};

window.onload = function() {
	updateuserinfo();
}

function updateuserinfo() {
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
			
			document.forms['contactinfo'].elements['addressline1'].value = user.addressLine1;
			document.forms['contactinfo'].elements['addressline2'].value = user.addressLine2;
			document.forms['contactinfo'].elements['city'].value = user.city;
			document.forms['contactinfo'].elements['state'].value = user.state;
			document.forms['contactinfo'].elements['zipcode'].value = user.zipCode;
			document.forms['contactinfo'].elements['email'].value = user.emailAddress;
			document.forms['contactinfo'].elements['phone'].value = user.phoneNumber;
			
		}
	})
}