//Validate Login
var form = document.querySelector(".box"); 
validate = () => {
    var username = document.getElementById("username").value;
    var password = document.getElementById("pwd").value;

    if (username.trim().length == 0 && password.trim().length == 0) {
        event.preventDefault();
        document.getElementById("username").style.border = '2px solid red';
        document.getElementById("pwd").style.border = '2px solid red';
        document.getElementById("msg").style.display = 'block';
        document.getElementById("msg").innerHTML = 'Please enter username and password!';
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

    else if(password.trim().length < 6) {
        event.preventDefault();
        document.getElementById("pwd").style.border = '2px solid red';
        document.getElementById("msg").style.display = 'block';
        document.getElementById("msg").innerHTML = 'Please enter at least 7 characters';
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
