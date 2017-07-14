app.factory('AnaliseRotaService', function($http) {

    var urlBase = 'http://localhost:9090/camera';

    function listarPontosEspecificos(RegistroCountModel) {
        return $http.post(urlBase + '/heatmap', RegistroCountModel);
    }

    function buscarCameraSentido(direcao) {
        return $http.get(urlBase + '/buscarcameraporsentido/' + direcao);
    }

    function buscarCalculoEnergia(data) {
        return $http.post(urlBase + '/energia', data);
    }

    return {
        buscarCameraSentido: buscarCameraSentido,
        buscarCalculoEnergia: buscarCalculoEnergia,
        listarPontosEspecificos: listarPontosEspecificos
    };
})