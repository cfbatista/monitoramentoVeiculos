app.service('ocorrenciaService', function($http){
    var url = 'http://localhost:9090/ocorrencia';

    return{
        obterOcorrencias: obterOcorrencias,
        obterOcorrenciaUsuario: obterOcorrenciaUsuario,
        adicionarOcorrencia: adicionarOcorrencia,
        atualizarOcorrencia: atualizarOcorrencia,
        deletarOcorrencia: deletarOcorrencia
    }


    function obterOcorrencias(){
        return $http.get(url);
    }

    function obterOcorrenciaUsuario(usuario){
        return $http.get(url + '/usuario');
    }

    function adicionarOcorrencia(ocorrencia){
        return $http.post(url, ocorrencia);
    }

    function atualizarOcorrencia(ocorrencia){
        return $http.post(url, ocorrencia);
    }
    function deletarOcorrencia(ocorrencia){
        return $http.delete(ocorrencia);
    }
}); 