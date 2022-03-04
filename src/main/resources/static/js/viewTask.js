var sendMessage = document.querySelector("#submitBtn")
const queryString = window.location.href;
let taskId = queryString.substring(queryString.lastIndexOf("/") +1, queryString.length)
var user = JSON.parse(
sessionStorage.getItem("user"))
console.log(user)

sendMessage.addEventListener('click',() => {
	let newMessage = {
		message: sendMessage.value,
		user: user,
		taskId: taskId
		
	}	

	sendMessage.value = "",
	fetch('/messageSent',{
		method: 'POST',
		headers: {
			"Content-Type": "application/JSON"
		},
		body: JSON.stringify(newMessage)
	})
	.then((response) => response.json)
		.then(message => {
			getMessages()
		})})
		
function getMessages(){
	fetch('/obtainMessages/'+taskId,{
		method: 'POST',
		headers:{
			"Content-Type": "application/JSON"
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
			div.innerHTML = messages[i].username + ' : ' + messages[i].message;
				mainContainer.appendChild(div)
				console.log(messages[i])
		}
}