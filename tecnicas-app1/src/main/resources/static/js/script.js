
function submeterFormulario() {
    var titulo = document.getElementById("titulo").value;
    var autor = document.getElementById("autor").value;
    var conteudo = document.getElementById("conteudo").value;

    var materia = {
        'titulo' : titulo,
        'autor' : autor,
        'conteudo' : conteudo,
    };

    function reqListener () {
        var materia = JSON.parse(this.responseText);
        console.log(materia);

        var container = document.createElement("div");
        container.classList.add("container");

        var titulo = document.createElement("div");
        titulo.classList.add("row");
        titulo.innerHTML = "<h2>" + materia.titulo + "</h2>";

        var conteudo = document.createElement("div");
        conteudo.classList.add("row");
        var p = document.createElement("p");
        p.innerHTML = materia.conteudo;
        conteudo.appendChild(p);

        container.appendChild(titulo);
        container.appendChild(conteudo);
        document.getElementById("materias").appendChild(container);
    };

    var oReq = new XMLHttpRequest();
    oReq.onload = reqListener;
    oReq.open("POST", "criarMateria", true);
    oReq.setRequestHeader("Content-Type", "application/json");
    oReq.send(JSON.stringify(materia));
}
