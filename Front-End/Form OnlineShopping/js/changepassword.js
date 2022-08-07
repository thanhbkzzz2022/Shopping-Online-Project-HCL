//Validate Login
var form = document.querySelector(".box"); 
validate = () => {
    var currentPassword = document.getElementById("pwd").value;
    var newPassword = document.getElementById("newPwd").value;
    var confirmPassword = document.getElementById("confPwd").value;


    if (currentPassword.trim().length == 0 && newPassword.trim().length == 0 && confirmPassword.trim().length == 0) {
        event.preventDefault();
        document.getElementById("pwd").style.border = '2px solid red';
        document.getElementById("newPwd").style.border = '2px solid red';
        document.getElementById("confPwd").style.border = '2px solid red';
        document.getElementById("msg").style.display = 'block';
        document.getElementById("msg").innerHTML = 'Do not leave fields blank!';
    }
    
    else if(currentPassword.trim().length == 0) {
        event.preventDefault();
        document.getElementById("pwd").style.border = '2px solid red';
        document.getElementById("msg").style.display = 'block';
        document.getElementById("msg").innerHTML = 'Please enter your current password';
    }
    
    else if (newPassword.trim().length == 0) {
        event.preventDefault();
        document.getElementById("newPwd").style.border = '2px solid red';
        document.getElementById("msg").style.display = 'block';
        document.getElementById("msg").innerHTML = 'Please enter your new password!';
    }

    else if(newPassword.trim().length < 6) {
        event.preventDefault();
        document.getElementById("newPwd").style.border = '2px solid red';
        document.getElementById("msg").style.display = 'block';
        document.getElementById("msg").innerHTML = 'Please enter at least 7 characters';
    }

    else if (confirmPassword.trim().length == 0) {
        event.preventDefault();
        document.getElementById("confPwd").style.border = '2px solid red';
        document.getElementById("msg").style.display = 'block';
        document.getElementById("msg").innerHTML = 'Please enter confirm password!';
    }

    else if(newPassword != confirmPassword) {
        event.preventDefault();
        document.getElementById("newPwd").style.border = '2px solid red';
        document.getElementById("confPwd").style.border = '2px solid red';
        document.getElementById("msg").style.display = 'block';
        document.getElementById("msg").innerHTML = 'Password does not match!';
    }
    else {
        alert("Changed password successfully!");
    }

}

checkPwd = () => {
    var username = document.getElementById("pwd").value;
    
    if(username.trim().length != 0) {
        document.getElementById("pwd").style.border = '1px solid black';
    }
}

checkNewPwd = () => {
    var email = document.getElementById("newPwd").value;

    if(email.trim().length != 0) {
        document.getElementById("newPwd").style.border = '1px solid black';
    }
}

checkConfPwd = () => {
    var capcha = document.getElementById("confPwd").value;

    if(capcha.trim().length != 0) {
        document.getElementById("confPwd").style.border = '1px solid black';
    }
}

