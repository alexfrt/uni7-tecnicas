
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

        //construir blocos de materia...
        //fazer append nos blocos do HTML
    };

    var oReq = new XMLHttpRequest();
    oReq.onload = reqListener;
    oReq.open("POST", "criarMateria", true);
    oReq.setRequestHeader("Content-Type", "application/json");
    oReq.send(JSON.stringify(materia));
}
