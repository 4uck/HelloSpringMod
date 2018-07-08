function getTime(){

    var xhr = new XMLHttpRequest();
    xhr.open('GET', '/timestamps/STOP', true);
    xhr.responseType = 'json';
    xhr.setRequestHeader('Authorization', localStorage.getItem('token'));
    xhr.send();

    xhr.onreadystatechange = function() {
        if (xhr.readyState != 4) return;

        if(xhr.status == 401){
            localStorage.removeItem("token");
            window.location.pathname = "/";
            return;
        }

        if(xhr.status != 200){
            alert("Что-то пошло не так");
            return;
        }

        var body = xhr.response;

        var sumTime = document.getElementById('sumTime').value =
            "Твое время: " + body.hours + "ч " + body.minutes + "м " + body.seconds + "с";
        var divTime = document.getElementById('divTime').style = "visibility: visible";
    }
}

function sendTime(action){

    var path = '/timestamps/' + action;
    var xhr = new XMLHttpRequest();
    xhr.open('GET', path, true);

    if(action == 'STOP') xhr.responseType = 'json';

    xhr.setRequestHeader('Authorization', localStorage.getItem('token'));

    xhr.send();

    xhr.onreadystatechange = function() {
        if (xhr.readyState != 4) return;

        if(xhr.status == 401){
            localStorage.removeItem("token");
            window.location.pathname = "/";
            return;
        }

        if(xhr.status != 200){
            alert("Что-то пошло не так");
            return;
        }

        if(action == 'STOP'){
             var body = xhr.response;

             var sumTime = document.getElementById('sumTime').value =
                    "Твое время: " + body.hours + "ч " + body.minutes + "м " + body.seconds + "с";
             var divTime = document.getElementById('divTime').style = "visibility: visible";
        }
    }
}

//function startTime(){
//
//    var xhr = new XMLHttpRequest();
//    xhr.open('GET', '/timestamps/START', false);
//
//    xhr.setRequestHeader('Authorization', localStorage.getItem('token'));
//
//    xhr.send();
//
//    if(xhr.status != 200){
//        alert(xhr.status);
//        alert("Что-то пошло не так");
//    }
//}
//
//function pauseTime(){
//
//    var xhr = new XMLHttpRequest();
//    xhr.open('GET', '/timestamps/PAUSE', false);
//
//    xhr.setRequestHeader('Authorization', localStorage.getItem('token'));
//
//    xhr.send();
//
//    if(xhr.status != 200){
//        alert(xhr.status);
//        alert("Что-то пошло не так");
//    }
//}

