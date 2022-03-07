var submitBtn = document.querySelector('#resolve')
var user = JSON.parse(sessionStorage.getItem("user"))

submitBtn.addEventListener('click', () => {
	let userObj = {
			taskId: taskId
	}
	console.log(taskId)
	console.log(user)
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
			// this user already exists!
			alert("You must be in the same department as the task's assigned department")
			window.location = "/dashboard"
			
		}
	})
})