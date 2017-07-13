app.service('veiculoService', function($http) {

    var url = 'http://localhost:9090/veiculo';

    return {
        obterTotalVeiculos: obterTotalVeiculos,
        obterTodosVeiculos: obterTodosVeiculos,
        obterVeiculoPorId: obterVeiculoPorId,
        obterVeiculoPorPlaca: obterVeiculoPorPlaca,
        obterConsulta: obterConsulta,
    }

    function obterTotalVeiculos() {
        return $http.get(url + '/obter/contagem');
    }

    function obterTodosVeiculos() {
        return $http.get(url + '/obter/todos');
    }

    function obterVeiculoPorId(id) {
        return $http.get(url + '/obter/' + id);
    }

    function obterVeiculoPorPlaca(placa) {
        return $http.get(url + '/obter/' + placa);
    }

    function obterConsulta(placa) {
        return $http.get(url + '/consulta/' + placa);
    }
});