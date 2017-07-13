app.service('estatisticaService', function($http) {

    var url = 'http://localhost:9090/';

    return {
        fabricantesMaiorOcorrencia: fabricantesMaiorOcorrencia,
        modelosMaisRoubados: modelosMaisRoubados,
        horarioComMaiorRoubo: horarioComMaiorRoubo,
        cidadesComMaisRoubos: cidadesComMaisRoubos,
        camerasComMaisVeiculosRoubados: camerasComMaisVeiculosRoubados
    }

    function fabricantesMaiorOcorrencia() {
        return $http.get(url + 'ocorrencia/obter/topmarcas');
    }

    function modelosMaisRoubados() {
        return $http.get(url + 'ocorrencia/obter/topmodelos');
    }

    function horarioComMaiorRoubo() {
        return $http.get(url + 'ocorrencia/horarioComMaiorRoubo');
    }

    function cidadesComMaisRoubos() {
        return $http.get(url + 'ocorrencia/obter/topcidades');
    }

    function camerasComMaisVeiculosRoubados() {
        return $http.get(url + 'camerasComMaisVeiculosRoubados');
    }
});