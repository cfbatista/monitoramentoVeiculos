app.service('estatisticaService', function($http){
    
    var url = 'http://localhost:9090/estatistica';

    return{
        fabricantesMaiorOcorrencia: fabricantesMaiorOcorrencia,
        modelosMaisRoubados: modelosMaisRoubados,
        horarioComMaiorRoubo: horarioComMaiorRoubo,
        cidadesComMaisRoubos: cidadesComMaisRoubos,
        camerasComMaisVeiculosRoubados: camerasComMaisVeiculosRoubados
    }

    function fabricantesMaiorOcorrencia(){
        return $http.get(url + '/fabricantesMaiorOcorrencia');
    }

    function modelosMaisRoubados(){
        return $http.get(url + '/modelosMaisRoubados');
    }

    function horarioComMaiorRoubo(){
        return $http.get(url + '/horarioComMaiorRoubo');
    }

    function cidadesComMaisRoubos(){
        return $http.get(url + '/cidadesComMaisRoubos');
    }

    function camerasComMaisVeiculosRoubados(){
        return $http.get(url + '/camerasComMaisVeiculosRoubados');
    }
});