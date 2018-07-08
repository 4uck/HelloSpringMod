function getToken(){

    var email = document.getElementById('email').value;
    var pass = document.getElementById('password').value;

    if (email == '' || pass == ''){
        alert("Fields must be filled!!!");
        return false;
    }

    sendUser(email, pass)
}

function sendUser(email, password){

    var xhr = new XMLHttpRequest();

    var json = JSON.stringify({
      "username": email,
      "password": password
    });

    xhr.open('POST', '/login', false);

    xhr.setRequestHeader('Content-type', 'application/json');

    xhr.send(json);

    if (xhr.status != 200) {
      alert("Нет такого пользователя");

    } else {
      var token = xhr.getResponseHeader("Authorization");
      localStorage.setItem('token', token);

      window.location.pathname = "/home";
    }

}