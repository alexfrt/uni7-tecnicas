function adicionarPeca(peca) {
    let tr = document.createElement("tr");
    tr.id = "peca-" + peca.id;

    let id = document.createElement("th");
    id.innerHTML = peca.id;
    tr.appendChild(id);

    let nome = document.createElement("td");
    nome.innerHTML = peca.nome;
    tr.appendChild(nome);

    let fabricante = document.createElement("td");
    fabricante.innerHTML = peca.fabricante;
    tr.appendChild(fabricante);

    let quantidade = document.createElement("td");
    quantidade.innerHTML = peca.quantidade;
    tr.appendChild(quantidade);

    let preco = document.createElement("td");
    preco.innerHTML = peca.preco;
    tr.appendChild(preco);

    let opcoes = document.createElement("td");
    let btnRemover = document.createElement("button");
    btnRemover.innerHTML = "Remover";
    btnRemover.type = "button";
    btnRemover.onclick = function () {
        removerPeca(peca.id);
    };
    opcoes.appendChild(btnRemover);

    let btnAtualizar = document.createElement("button");
    btnAtualizar.innerHTML = "Atualizar";
    btnAtualizar.type = "button";
    btnAtualizar.onclick = function () {
        incluirPecaNoFormulario(peca);
    };
    opcoes.appendChild(btnAtualizar);

    tr.appendChild(opcoes);

    document.getElementById("corpoTabela").appendChild(tr);
}

function exibirPecas() {
    let oReq = new XMLHttpRequest();
    oReq.onload = function () {
        let listDePecas = JSON.parse(this.responseText);
        for (let i = 0; i < listDePecas.length; i++) {
            adicionarPeca(listDePecas[i]);
        }
    };
    oReq.open("GET", "peca", true);
    oReq.setRequestHeader("Content-Type", "application/json");
    oReq.send();
}

window.addEventListener("load", function () {
    exibirPecas();
});

function cadastarPeca() {
    let peca = {
        'id': document.getElementById("id-entidade").value,
        'nome': document.getElementById("nome").value,
        'fabricante': document.getElementById("fabricante").value,
        'quantidade': document.getElementById("quantidade").value,
        'preco': document.getElementById("preco").value
    }

    if (peca.id == "") {
        let oReq = new XMLHttpRequest();
        oReq.onload = function () {
            let peca = JSON.parse(this.responseText);
            adicionarPeca(peca);
        };
        oReq.open("POST", "peca", true);
        oReq.setRequestHeader("Content-Type", "application/json");
        oReq.send(JSON.stringify(peca));
    } else {
        let oReq = new XMLHttpRequest();
        oReq.onload = function () {
            apagarLinhaDaTabela(peca.id);
            adicionarPeca(peca);
        };
        oReq.open("PUT", "peca/" + peca.id, true);
        oReq.setRequestHeader("Content-Type", "application/json");
        oReq.send(JSON.stringify(peca));
    }

    limparFormulario();
}

function limparFormulario() {
    document.getElementById("id-entidade").value = "";
    document.getElementById("nome").value = "";
    document.getElementById("fabricante").value = "";
    document.getElementById("quantidade").value = "";
    document.getElementById("preco").value = "";
}

function removerPeca(id) {
    let oReq = new XMLHttpRequest();
    oReq.onload = function () {
        apagarLinhaDaTabela(id);
    };
    oReq.open("DELETE", "peca/" + id, true);
    oReq.setRequestHeader("Content-Type", "application/json");
    oReq.send();
}

function apagarLinhaDaTabela(pecaId) {
    let pecaNaTabela = document.getElementById("peca-" + pecaId);
    document.getElementById("corpoTabela").removeChild(pecaNaTabela);
}

function incluirPecaNoFormulario(peca) {
    document.getElementById("id-entidade").value = peca.id;
    document.getElementById("nome").value = peca.nome;
    document.getElementById("fabricante").value = peca.fabricante;
    document.getElementById("quantidade").value = peca.quantidade;
    document.getElementById("preco").value = peca.preco;
}