app.service('registroService', function($http){
    var url = 'http://localhost:9090/registro';

    return{
        obterRegistros: obterRegistros,
        adicionarRegistro: adicionarRegistro,
        atualizarRegistro: atualizarRegistro,
        deletarRegistro: deletarRegistro
    }

    function obterRegistros(){
        return $http.get(url);
    }

    function adicionarRegistro(registro){
        return $http.post(url, registro);
    }

    function atualizarRegistro(registro){
        return $http.post(url, registro);
    }

    function deletarRegistro(registro){
        return $http.delete(registro);
    }
});