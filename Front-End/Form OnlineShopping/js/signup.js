validate = () => {
    var username = document.getElementById("username").value;
    var password = document.getElementById("pwd").value;
    var repwd = document.getElementById("repwd").value;
    var fullname = document.getElementById("fullname").value;
    var email = document.getElementById("email").value;
    var phone = document.getElementById("phonenumber").value;
    var address = document.getElementById("address").value;
    var regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    var regexPhone = /^\d+$/;
    
    if (username.trim().length == 0 && password.trim().length == 0 && repwd.trim().length == 0 && fullname.trim().length == 0 && email.trim().length == 0 && phone.trim().length == 0 && address.trim().length == 0) {
        event.preventDefault();
        document.getElementById("username").style.border = '2px solid red';
        document.getElementById("pwd").style.border = '2px solid red';
        document.getElementById("repwd").style.border = '2px solid red';
        document.getElementById("fullname").style.border = '2px solid red';
        document.getElementById("email").style.border = '2px solid red';
        document.getElementById("phone").style.border = '2px solid red';
        document.getElementById("address").style.border = '2px solid red';
        document.getElementById("msg").style.display = 'block';
        document.getElementById("msg").innerHTML = 'Please do not leave fields blank!';
    }
    
    else if(username.trim().length == 0) {
        event.preventDefault();
        document.getElementById("username").style.border = '2px solid red';
        document.getElementById("msg").style.display = 'block';
        document.getElementById("msg").innerHTML = 'Please enter your username!';
    }
    
    else if (password.trim().length == 0) {
        event.preventDefault();
        document.getElementById("pwd").style.border = '2px solid red';
        document.getElementById("msg").style.display = 'block';
        document.getElementById("msg").innerHTML = 'Please enter your password!';
    }

    else if(repwd.trim().length == 0) {
        event.preventDefault();
        document.getElementById("repwd").style.border = '2px solid red';
        document.getElementById("msg").style.display = 'block';
        document.getElementById("msg").innerHTML = 'Please re-enter password!';
    }
    
    else if (fullname.trim().length == 0) {
        event.preventDefault();
        document.getElementById("fullname").style.border = '2px solid red';
        document.getElementById("msg").style.display = 'block';
        document.getElementById("msg").innerHTML = 'Please enter your fullname!';
    }

    else if(email.trim().length == 0) {
        event.preventDefault();
        document.getElementById("email").style.border = '2px solid red';
        document.getElementById("msg").style.display = 'block';
        document.getElementById("msg").innerHTML = 'Please enter your email!';
    }
    
    else if (phone.trim().length == 0) {
        event.preventDefault();
        document.getElementById("phone").style.border = '2px solid red';
        document.getElementById("msg").style.display = 'block';
        document.getElementById("msg").innerHTML = 'Please enter your phone number!';
    }

    else if(address.trim().length == 0) {
        event.preventDefault();
        document.getElementById("address").style.border = '2px solid red';
        document.getElementById("msg").style.display = 'block';
        document.getElementById("msg").innerHTML = 'Please enter your address!';
    }

    else if (!email.match(regex)){
        event.preventDefault();
        document.getElementById("address").style.border = '2px solid red';
        document.getElementById("msg").style.display = 'block';
        document.getElementById("msg").innerHTML = 'Please enter correct email format!';
    }

    else if(!phone.match(regexPhone)){
        event.preventDefault();
        document.getElementById("address").style.border = '2px solid red';
        document.getElementById("msg").style.display = 'block';
        document.getElementById("msg").innerHTML = 'Please enter number only!';
    }

    else if(password.trim().length < 6) {
        event.preventDefault();
        document.getElementById("pwd").style.border = '2px solid red';
        document.getElementById("msg").style.display = 'block';
        document.getElementById("msg").innerHTML = 'Please enter at least 7 characters';
    }

    else if(password != repwd) {
        event.preventDefault();
        document.getElementById("repwd").style.border = '2px solid red';
        document.getElementById("msg").style.display = 'block';
        document.getElementById("msg").innerHTML = 'Password does not match';
    }

    else {
        alert("Logged in successfully");
        document.getElementById('submit').onclick = function() {
            setTimeout(show = () =>{
                event.preventDefault();
                document.getElementById("msg").style.display = 'block';
                document.getElementById("msg").style.color = 'green';
                document.getElementById("msg").innerHTML = 'Logged in successfully';
            }, 3000); 
        }
    }

}

checkInput = () => {
    var username = document.getElementById("username").value;
    
    if(username.trim().length != 0) {
        document.getElementById("username").style.border = '1px solid black';
    }
}

checkPwd= () => {
    var password = document.getElementById("pwd").value;

    if(password.trim().length != 0) {
        document.getElementById("pwd").style.border = '1px solid black';
    }
}

checkRePwd = () => {
    var username = document.getElementById("repwd").value;
    
    if(username.trim().length != 0) {
        document.getElementById("repwd").style.border = '1px solid black';
    }
}

checkFullname= () => {
    var password = document.getElementById("fullname").value;

    if(password.trim().length != 0) {
        document.getElementById("fullname").style.border = '1px solid black';
    }
}

checkEmail = () => {
    var username = document.getElementById("email").value;
    
    if(username.trim().length != 0) {
        document.getElementById("email").style.border = '1px solid black';
    }
}

checkPhone = () => {
    var password = document.getElementById("phonenumber").value;

    if(password.trim().length != 0) {
        document.getElementById("phonenumber").style.border = '1px solid black';
    }
}

checkAddress = () => {
    var username = document.getElementById("address").value;
    
    if(username.trim().length != 0) {
        document.getElementById("address").style.border = '1px solid black';
    }
}



