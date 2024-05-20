function getUrl(url) {
    
    //definindo a request da aplicação
    let request = new XMLHttpRequest()

    //abrindo a requisição
    request.open("GET", url, false)
    
    //enviando a requisição
    request.send()
    return request.responseText
}

function criaLinha(usuario) {

    //Criando uma linha para cada propriedade do banco de dados
    let linha = document.createElement("tr") //criando a linha na tablea
    let tdId = document.createElement("td"); //criando o conteudo
    let tdName = document.createElement("td"); //criando outro conteudo
    let tdGender = document.createElement("td");
    let tdAddress = document.createElement("td");
    
    //escrevendo o conteudo adquirido da api para cada celula na aplicação
    tdId.innerHTML = usuario.id
    tdName.innerHTML = usuario.name
    tdGender.innerHTML = usuario.gender
    tdAddress.innerHTML = usuario.address

    linha.appendChild(tdId)
    linha.appendChild(tdName)
    linha.appendChild(tdGender)
    linha.appendChild(tdAddress)

    return linha;
}

function main() {
    
    let data = (getUrl("http://localhost:8080/api/myApi"))
    let usuarios = JSON.parse(data);
    let table = document.getElementById("person-table")

    //para cada usuario criar uma linha e adicionar na tabela

    usuarios.forEach(element => {
        let linha = criaLinha(element);

        table.appendChild(linha);
    });
}

main()