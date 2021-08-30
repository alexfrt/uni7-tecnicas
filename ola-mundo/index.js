function clicouBotao() {
    paragrafo1 = document.getElementById("paragrafo1");
    paragrafo1.innerHTML = "valor modificado!!!";

    elementosLaranjas = document.getElementsByClassName("paragrafosLaranjas");
    for (i = 0; i < elementosLaranjas.length; i++) {
        elementosLaranjas[i].style = "background-color:  black";
    }

    variavel = {
        'atributo' : 'valor',
        'atributo2' : 'valor2',
        'listaDeObjetos' : [
            {}, 1, false, ""
        ],
        'outroObjeto' : {
            'outroObjeto' : {},
            'atributo' : false
        }
    };
    variavel['novoAtributo'] = 'novoValor';
    delete variavel['novoAtributo'];
    
    console.log(variavel);
}