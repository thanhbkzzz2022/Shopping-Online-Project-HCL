//Validate Login
var form = document.querySelector(".box"); 
validate = () => {
    var username = document.getElementById("username").value;
    var email = document.getElementById("email").value;
    var capcha = document.getElementById("capcha").value;
    var regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;


    if (username.trim().length == 0 && email.trim().length == 0 && capcha.trim().length == 0) {
        event.preventDefault();
        document.getElementById("username").style.border = '2px solid red';
        document.getElementById("email").style.border = '2px solid red';
        document.getElementById("capcha").style.border = '2px solid red';
        document.getElementById("msg").style.display = 'block';
        document.getElementById("msg").innerHTML = 'Please enter username and email!';
    }
    
    else if(username.trim().length == 0) {
        event.preventDefault();
        document.getElementById("username").style.border = '2px solid red';
        document.getElementById("msg").style.display = 'block';
        document.getElementById("msg").innerHTML = 'Please enter your username!';
    }
    
    else if (email.trim().length == 0) {
        event.preventDefault();
        document.getElementById("email").style.border = '2px solid red';
        document.getElementById("msg").style.display = 'block';
        document.getElementById("msg").innerHTML = 'Please enter your email!';
    }

    else if (capcha.trim().length == 0) {
        event.preventDefault();
        document.getElementById("capcha").style.border = '2px solid red';
        document.getElementById("msg").style.display = 'block';
        document.getElementById("msg").innerHTML = 'Please enter correct capcha code!';
    }

    else if(!email.match(regex)) {
        event.preventDefault();
        document.getElementById("email").style.border = '2px solid red';
        document.getElementById("msg").style.display = 'block';
        document.getElementById("msg").innerHTML = 'Please enter correct email format!';
    }
    else {
        alert("Request has been sent!");
    }

}

checkInput = () => {
    var username = document.getElementById("username").value;
    
    if(username.trim().length != 0) {
        document.getElementById("username").style.border = '1px solid black';
    }
}

checkEmail= () => {
    var email = document.getElementById("email").value;

    if(email.trim().length != 0) {
        document.getElementById("email").style.border = '1px solid black';
    }
}

checkCapcha= () => {
    var capcha = document.getElementById("capcha").value;

    if(capcha.trim().length != 0) {
        document.getElementById("capcha").style.border = '1px solid black';
    }
}

