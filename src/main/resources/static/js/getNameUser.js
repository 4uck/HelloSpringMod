
    var xhr = new XMLHttpRequest();

    xhr.open('GET', '/getName', false);

    xhr.setRequestHeader('Authorization', localStorage.getItem('token'));

    xhr.send();

    if (xhr.status != 200) {

    localStorage.removeItem("token");
    window.location.pathname = "/";

    alert("Что-то пошло не так");

    } else {

        var email = document.getElementById('name').value = xhr.responseText;

    }