app.service('veiculoService', function($http) {

    var url = 'http://localhost:9090/veiculo';

    return {
        obterTotalVeiculos: obterTotalVeiculos,
        obterConsulta: obterConsulta,
        buscarRegistroVeiculosPorData: buscarRegistroVeiculosPorData
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

    function buscarRegistroVeiculosPorData(data){
        return $http.post('http://localhost:9090/camera/obter/contagemdiassemana', data);
    }
});