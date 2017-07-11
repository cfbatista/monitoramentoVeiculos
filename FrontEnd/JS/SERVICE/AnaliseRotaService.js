app.factory('AnaliseRotaService', function ($http) {

    var urlBase = 'http://localhost:9090/camera';

    function listarPontosEspecificos(RegistroCountModel){
        return $http.post(urlBase + '/heatmap',RegistroCountModel);
    }

    function buscarCameraSentido(direcao){
        return $http.get(urlBase + '/buscarCameraPorSentido/' + direcao);
    }

    return{
        buscarCameraSentido: buscarCameraSentido,
        listarPontosEspecificos, listarPontosEspecificos
    };
})
