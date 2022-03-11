var submit = document.querySelector("#submitBtn")

var user = document.querySelector("#username")

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

submit.addEventListener('click',()=>{
	sessionStorage.setItem("user",JSON.stringify(user.value))
})

