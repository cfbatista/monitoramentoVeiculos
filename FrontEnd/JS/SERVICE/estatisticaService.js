app.service('estatisticaService', function($http) {

    var url = 'http://localhost:9090/estatistica';

    return {
        fabricantesMaiorOcorrencia: fabricantesMaiorOcorrencia,
        modelosMaisRoubados: modelosMaisRoubados,
        horarioComMaiorRoubo: horarioComMaiorRoubo,
        cidadesComMaisRoubos: cidadesComMaisRoubos,
        camerasComMaisVeiculosRoubados: camerasComMaisVeiculosRoubados
    }

    function fabricantesMaiorOcorrencia() {
        return $http.get(url + '/obter/topmarcas');
    }

    function modelosMaisRoubados() {
        return $http.get(url + 'obter/topmodelos');
    }

    function horarioComMaiorRoubo() {
        return $http.get(url + '/horarioComMaiorRoubo');
    }

    function cidadesComMaisRoubos() {
        return $http.get(url + '/obter/topcidades');
    }

    function camerasComMaisVeiculosRoubados() {
        return $http.get(url + '/camerasComMaisVeiculosRoubados');
    }
});