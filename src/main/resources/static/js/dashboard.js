var submitBtn = document.querySelector('#complete')
var user = sessionStorage.getItem("user")


submitBtn.addEventListener('click', () => {
	let userObj = {
			taskId: someId
	}
	console.log(someId)
	alert("Hello")
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
			window.location = "/dashboard"
			
		}
	})
})
var someId
function getId (theUniqueId) {
	alert(theUniqueId)
   someId = theUniqueId;
}

