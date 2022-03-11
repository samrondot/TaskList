
var user = sessionStorage.getItem("user")
function getId (theUniqueId) {
	let userObj = {
			taskId: theUniqueId
	}
	fetch("/matchDepartment", {
		
		method: 'POST',
		headers: {
			"Content-Type": "application/json",
			'X-CSRF-TOKEN': token
		},
		body: JSON.stringify(userObj)
	})
	
	.then((responseEntity) => responseEntity.json())
	.then( (data) => {
		if (data===false) {
			alert("You must be in the same department as the task's assigned department")
	
		}else{
			window.location = "/dashboard"
		}
	})
}

