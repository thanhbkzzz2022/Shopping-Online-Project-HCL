//Validate Login
validate = () => {
    var name = document.getElementById("name").value;
    var price = document.getElementById("price").value;
    var number = document.getElementById("number").value;
    var date = document.getElementById("date").value;
    var des = document.getElementById("description").value;
    var regexNum = /^\d+$/;

    if (name.trim().length == 0 && price.trim().length == 0 && number.trim().length == 0 && date.trim().length == 0 && des.trim().length == 0) {
        event.preventDefault();
        document.getElementById("name").style.border = '2px solid red';
        document.getElementById("price").style.border = '2px solid red';
        document.getElementById("number").style.border = '2px solid red';
        document.getElementById("date").style.border = '2px solid red';
        document.getElementById("msg").style.display = 'block';
        document.getElementById("msg").innerHTML = 'Do not leave fields blank!';
    }
    
    else if(name.trim().length == 0) {
        event.preventDefault();
        document.getElementById("name").style.border = '2px solid red';
        document.getElementById("msg").style.display = 'block';
        document.getElementById("msg").innerHTML = 'Please enter product name!';
    }
    
    else if (price.trim().length == 0) {
        event.preventDefault();
        document.getElementById("price").style.border = '2px solid red';
        document.getElementById("msg").style.display = 'block';
        document.getElementById("msg").innerHTML = 'Please enter product price!';
    }

    else if(number.trim().length == 0) {
        event.preventDefault();
        document.getElementById("number").style.border = '2px solid red';
        document.getElementById("msg").style.display = 'block';
        document.getElementById("msg").innerHTML = 'Please enter quantity of product';
    }

    else if(date.trim().length == 0) {
        event.preventDefault();
        document.getElementById("date").style.border = '2px solid red';
        document.getElementById("msg").style.display = 'block';
        document.getElementById("msg").innerHTML = 'Please enter date released!';
    }

    else if (des.trim().length == 0) {
        event.preventDefault();
        document.getElementById("description").style.border = '2px solid red';
        document.getElementById("msg").style.display = 'block';
        document.getElementById("msg").innerHTML = 'Please enter confirm password!';
    }

    else if(!number.match(regexNum)){
        event.preventDefault();
        document.getElementById("number").style.border = '2px solid red';
        document.getElementById("msg").style.display = 'block';
        document.getElementById("msg").innerHTML = 'Please enter number only!';
    }
    else {
        alert("Add Product Successfully!");
    }

}

checkPN = () => {
    var username = document.getElementById("name").value;
    
    if(username.trim().length != 0) {
        document.getElementById("name").style.border = '1px solid black';
    }
}

checkPP = () => {
    var email = document.getElementById("price").value;

    if(email.trim().length != 0) {
        document.getElementById("price").style.border = '1px solid black';
    }
}

checkNP = () => {
    var capcha = document.getElementById("number").value;

    if(capcha.trim().length != 0) {
        document.getElementById("number").style.border = '1px solid black';
    }
}

checkRD = () => {
    var capcha = document.getElementById("date").value;

    if(capcha.trim().length != 0) {
        document.getElementById("date").style.border = '1px solid black';
    }
}

checkDes = () => {
    var capcha = document.getElementById("description").value;

    if(capcha.trim().length != 0) {
        document.getElementById("description").style.border = '1px solid black';
    }
}

