var submitBtn = document.querySelector('#resolve')


submitBtn.addEventListener('click', () => {
	let user = {
			
			'username': usernameTextBox.value,
			
			
	}
	console.log(user)
	fetch(`/matches`, {
		method: 'POST',
		headers: {
			"Content-Type": "application/json",
			'X-CSRF-TOKEN': token
		},
		body: JSON.stringify(user)
	})
	.then((responseEntity) => responseEntity.json())
	.then( (data) => {
		if (data===false) {
			// this user already exists!
			alert("username already exists")
			window.location = "/dashboard"
			
		}
	})
})