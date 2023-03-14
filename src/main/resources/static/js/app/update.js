var authors = document.getElementsByClassName("author"); //Strong tag
var user = document.getElementById("user").value; //input tag
var updates = document.getElementsByClassName("update");
for(var i=0; i<authors.length;i++){
if(user == authors[i].value){
    updates[i].style.display ="block";
    }
}