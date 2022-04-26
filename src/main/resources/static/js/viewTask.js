var sendMessage = document.querySelector("#commentBtn")
var textBox = document.querySelector("#comment")
const queryString = window.location.href;
var url = window.location.pathname;
let taskId = queryString.substring(queryString.lastIndexOf("/") +1, queryString.length)
var id = url.substring(url.lastIndexOf('/'))
var arr = url.split('/')
arr = arr[arr.length-2]
var user = sessionStorage.getItem("user")
console.log(user)

sendMessage.addEventListener('click',() => {
	let newMessage = {
		message: textBox.value,
		userId: arr,
		taskId: taskId
		
	}	
	textBox.value = "",
	fetch('/messageSent',{
		method: 'POST',
		headers: {
			"Content-Type": "application/JSON",
			'X-CSRF-TOKEN': token
		},
		body: JSON.stringify(newMessage)
	})
	.then((response) => response.json())
		.then(message => {
			console.log(message)
		})})
		
function getMessages(){
	fetch('/obtainMessages'+id,{
		method: 'POST',
		headers:{
			"Content-Type": "application/JSON",
			'X-CSRF-TOKEN': token
		},
	})
		.then((response) => response.json())
			.then(messages => {
				displayMessages(messages)
					
			}
	)
}
setInterval(getMessages, 500);


function displayMessages(messages){
			var mainContainer = document.getElementById("commentSection")
			mainContainer.innerHTML = "";
		for(var i = 0; i < messages.length; i++){
			var div = document.createElement("div");
			div.innerHTML = messages[i].user +' : '+ messages[i].message;
				mainContainer.appendChild(div)
				console.log(messages[i])
		}
}