app.service('cidadeService',function($http){
    
    var url = 'http://localhost:9090/cidade';

    return{
        obterCidades: obterCidades,
        totalCidades: totalCidades,
        adicionarCidade: adicionarCidade,
        atualizarCidade: atualizarCidade,
        deletarCidade: deletarCidade
    }


    function obterCidades(){
        return $http.get(url);
    }

    function totalCidades(){
        return $http.get(url + '/obtertodas');
    }

    function adicionarCidades(cidade){
        return $http.post(url, cidade);
    }

    function atualizarCidade(cidade){
        return $http.post(url, cidade);
    }

    function deletarCidade(cidade){
        return $http.delete(cidade);
    }
});