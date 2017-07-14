app.service('cameraService', function ($http) {

    var url = 'http://localhost:9090/camera';

    function buscarRegistroVeiculosPorData(model) {
        return $http.post(url + '/obter/contagemdiassemana', model);
    }

    return {
        buscarRegistroVeiculosPorData: buscarRegistroVeiculosPorData
    }
});