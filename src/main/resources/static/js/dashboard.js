var submitBtn = document.querySelector('#resolve')
var user = sessionStorage.getItem("user")

submitBtn.addEventListener('mouseover', () => {
	let userObj = {
			username: user.value,
			taskId: taskId
	}
	console.log(taskId)
	console.log(user)
	fetch(`/matchDepartment`, {
		method: 'POST',
		headers: {
			"Content-Type": "application/json",
			'X-CSRF-TOKEN': token
		},
		body: JSON.stringify(userObj)
	})
	.then((responseEntity) => responseEntity.json())
	.then( (data) => {
		if (data===true) {
			// this user already exists!
			alert("username already exists")
			window.location = "/dashboard"
			
		}
	})
})