
function submeterFormulario() {
    let titulo = document.getElementById("titulo").value;
    let autor = document.getElementById("autor").value;
    let conteudo = document.getElementById("conteudo").value;

    let materia = {
        'titulo' : titulo,
        'autor' : autor,
        'conteudo' : conteudo,
    };

    function reqListener () {
        let materia = JSON.parse(this.responseText);
        adicionarMateria(materia);
    }

    let oReq = new XMLHttpRequest();
    oReq.onload = reqListener;
    oReq.open("POST", "materia", true);
    oReq.setRequestHeader("Content-Type", "application/json");
    oReq.send(JSON.stringify(materia));
}

function adicionarMateria(materia) {
    let container = document.createElement("div");
    container.classList.add("container");

    let titulo = document.createElement("div");
    titulo.classList.add("row");
    titulo.innerHTML = "<h2>" + materia.titulo + "</h2>";

    let conteudo = document.createElement("div");
    conteudo.classList.add("row");
    let p = document.createElement("p");
    p.innerHTML = materia.conteudo;
    conteudo.appendChild(p);

    container.appendChild(titulo);
    container.appendChild(conteudo);
    document.getElementById("materias").appendChild(container);
}

function exibirMaterias() {
    let oReq = new XMLHttpRequest();
    oReq.onload = function() {
        let listaDeMaterias = JSON.parse(this.responseText);
        for (let i = 0; i < listaDeMaterias.length; i++) {
            adicionarMateria(listaDeMaterias[i]);
        }
    };
    oReq.open("GET", "materia", true);
    oReq.setRequestHeader("Content-Type", "application/json");
    oReq.send();
}

window.addEventListener("load", function () {
   exibirMaterias();
});
