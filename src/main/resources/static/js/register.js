var submitBtn = document.querySelector('#submitBtn')
var usernameTextBox = document.querySelector('#usernameTxtBox');
var password = document.querySelector('#password')


var eyeIcon = document.querySelector('.fa-eye')


	eyeIcon.addEventListener('click', () => {
		if(eyeIcon.classList.contains('fa-eye')){
			eyeIcon.classList.replace('fa-eye','fa-eye-slash')			
				document.querySelector("#inputPassword").type ='text'	
		}else{
			eyeIcon.classList.replace('fa-eye-slash', 'fa-eye')
			document.querySelector("#inputPassword").type ='password'
		}
			})



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




