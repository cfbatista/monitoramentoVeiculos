app.service('veiculoService', function ($http) {

    var url = 'http://localhost:9090/veiculo';

    return {
        obterTotalVeiculos: obterTotalVeiculos,
        obterConsulta: obterConsulta,
    }

    function obterTotalVeiculos() {
        return $http.get(url + '/obter/contagem');
    }

    function obterVeiculoPorId(id) {
        return $http.get(url + '/obter/' + id);
    }

    function obterConsulta(placa) {
        return $http.get(url + '/consulta/' + placa);
    }
});