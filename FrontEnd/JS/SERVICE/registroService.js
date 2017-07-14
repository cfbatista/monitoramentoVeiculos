app.service('registroService', function ($http) {
    var url = 'http://localhost:9090/registro';

    return {
        obterRegistros: obterRegistros,
        buscarRegistrosVeiculosPorHorario:  buscarRegistrosVeiculosPorHorario
    }

    function obterRegistros() {
        return $http.get(url);
    }

    function buscarRegistrosVeiculosPorHorario(data) {
        return $http.post(url + '/obter/veiculosporhorario', data);
    }
});