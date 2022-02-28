var submitBtn = document.querySelector('#submitBtn')
var usernameTextBox = document.querySelector('#usernameTxtBox');
var password = document.querySelector('#password')


submitBtn.addEventListener('click', () => {
	let user = {
			
			'username': usernameTextBox.value,
			'password': password.value
			
	}
	console.log(user)
	fetch(`/exists`, {
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
			window.location = "/register"
			usernameTextBox.focus()
			usernameTextBox.select()
		} 
	})
})


