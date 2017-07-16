app.service('cameraService', function($http) {

    var url = 'http://localhost:9090/camera';

    function buscarRegistroVeiculosPorData(model) {
        return $http.post(url + '/obter/contagemdiassemana', model);
    }

    function contagemTotal() {
        return $http.get(url + '/obter/contagemtotal');
    }

    function obterTodasCameras() {
        return $http.get(url + '/obter/todascameras');
    }

    function obterPorId(id) {
        return $http.get(url + '/obterporid/' + id);
    }

    function calculoEnergia(RegistroCountModel) {
        return $http.post(url + '/energia', RegistroCountModel)
    }

    function obterContagemDiaSemana(DataModel) {
        return $http.post(url + '/obter/contagemdiassemana', DataModel);
    }

    function obterContagemRegistrosPorRota(RegistroCountModel) {
        return $http.post(url + '/obter/detalhescamera/numeroregistros', RegistroCountModel);
    }

    function obterVelocidadeMedia(RegistroCountModel) {
        return $http.post(url + '/obter/mediavelocidade', RegistroCountModel);
    }

    function obterPlacasAcimaVelocidade(idCamera) {
        return $http.get(url + '/obter/foramaximovelocidade/' + idCamera);
    }

    return {
        buscarRegistroVeiculosPorData: buscarRegistroVeiculosPorData,
        contagemTotal: contagemTotal,
        obterTodasCameras: obterTodasCameras,
        obterPorId: obterPorId,
        calculoEnergia: calculoEnergia,
        obterContagemDiaSemana: obterContagemDiaSemana,
        obterContagemRegistrosPorRota: obterContagemRegistrosPorRota,
        obterVelocidadeMedia: obterVelocidadeMedia,
        obterPlacasAcimaVelocidade: obterPlacasAcimaVelocidade
    }
});