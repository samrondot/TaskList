var submit = document.querySelector("#submitBtn")

var user = document.querySelector("#username")

submit.addEventListener('click',()=>{
	sessionStorage.setItem("user",JSON.stringify(user.value))
})

