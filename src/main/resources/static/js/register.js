var submitBtn = document.querySelector('#submitBtn')
var usernameTextBox = document.querySelector('#usernameTxtBox')
var password = document.querySelector('#password')
alert('hello')

usernameTextBox.addEventListener('blur', () => {
	var user = {
			'username': usernameTextBox.value,
			'password': password.value
	}
	console.log(user)
	fetch('/exists', {
		method: 'POST',
		headers: {
			"X-CSRF-TOKEN": token,
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(user)
	})
	.then( (responseEntity) => responseEntity )
	.then( (data) => {
		if (data===true) {
			// this users already exists!
			console.log("username already exists")
			usernameTextBox.focus()
			usernameTextBox.select()
		} 
	})
})


