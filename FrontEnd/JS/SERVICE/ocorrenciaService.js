app.service('ocorrenciaService', function($http) {
    var url = 'http://localhost:9090/ocorrencia';

    function obterTodasOcorrencias() {
        return $http.get(url + '/obter/todas');
    }

    function adicionarOcorrencia(ocorrencia) {
        return $http.post(url, ocorrencia);
    }

    function obterOcorrenciaId(id){
        return $http.get(url + '/obter/' + id)
    }

    return {
        obterTodasOcorrencias: obterTodasOcorrencias,
        adicionarOcorrencia: adicionarOcorrencia,
        obterOcorrenciaId: obterOcorrenciaId
    }
});