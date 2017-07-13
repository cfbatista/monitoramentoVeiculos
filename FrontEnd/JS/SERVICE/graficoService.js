app.service('graficoService', function($http) {

    var url = 'http://localhost:9090/';

    return {
        obterCidades: obterCidades,
        totalVeiculos: totalVeiculos,
        // totalVeiculosClonados: totalVeiculosClonados,
        ocorrenciasUltimos3meses: ocorrenciasUltimos3meses
    }

    function obterCidades() {
        return $http.get(url + 'cidade/obternumerocidades');
    }

    function totalVeiculos() {
        return $http.get(url + 'veiculo/obterContagem');
    }

    function totalVeiculosClonados() {
        return $http.get(url + 'registro/obter/veiculossuspeitos');
    }

    function ocorrenciasUltimos3meses() {
        return $http.get(url + 'ocorrencia/tresultimosmeses');
    }
});