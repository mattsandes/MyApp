function fazPost(url, body) {

    console.log(body);

    let request = new XMLHttpRequest();
    
    request.open("POST", url, true);

    request.setRequestHeader("Content-type", "application/json")
    
    request.send(JSON.stringify(body));

    request.onload = function () {
        console.log(this.requestText)
    }

    return request.responseText;
}

function cadastraUsuario() {
    let url = "http://localhost:8080/api/myApi"

    event.preventDefault();

    //pegando as informações do formulario
    let nome = document.getElementById("name").value;
    let gender = document.getElementById("gender").value;
    let address = document.getElementById("address").value;

    console.log(nome);
    console.log(address);
    console.log(gender);

    //criando o body da requisição;

    let body = {
        "name": nome,
        "address": address,
        "gender": gender
    }

    fazPost(url, body)

    alert("Cadastro realizado com sucesso")

    location.reload();
}