app.service('veiculoService', function ($http) {

    var url = 'http://localhost:9090/veiculo';

    return {
        obterTotalVeiculos: obterTotalVeiculos,
        obterConsulta: obterConsulta,
        obterVeiculoPorPlaca: obterVeiculoPorPlaca
    }

    function obterTotalVeiculos() {
        return $http.get(url + '/obter/contagem');
    }

    function obterVeiculoPorPlaca(placa){
        return $http.get(url + '/obter/clonado/' + placa);
    }
    function obterConsulta(placa) {
        return $http.get(url + '/consulta/' + placa);
    }
});