function getAction(){

    var email = document.getElementById('email').value;
    var pass = document.getElementById('password').value;
    var confPass = document.getElementById('confPass').value;

    if (email == '' || pass == '' || confPass == ''){
        alert("Fields must be filled!!!");
        return false;
    }
    if (pass != confPass){
        alert('Password and confirm must be the same!!');
        return false;
    }

    sendUser(email, pass)
}

function sendUser(email, password){

    var xhr = new XMLHttpRequest();

    var json = JSON.stringify({
      "login": email,
      "password": password
    });

    xhr.open('POST', '/addUser', false);

    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');

    xhr.send(json);

    if (xhr.status != 200) {
      alert("Такой пользователь уже существует");
    } else {
      alert("Пользователь добавлен");
      window.location.pathname = "/";
    }

}