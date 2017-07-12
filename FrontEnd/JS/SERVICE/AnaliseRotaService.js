app.factory('AnaliseRotaService', function ($http) {

    var urlBase = 'http://localhost:9090/camera';

    function listarPontosEspecificos(RegistroCountModel){
        return $http.post(urlBase + '/heatmap',RegistroCountModel);
    }

    function buscarCameraSentido(direcao){
        return $http.get(urlBase + '/buscarCameraPorSentido/' + direcao);
    }

    function buscarCalculoEnergia(distancia) {
        return $http({
            url: urlBase + '/energia',
            params: { distancia: distancia },
            method: 'GET'
        })
    }
    
    return{
        buscarCameraSentido: buscarCameraSentido,
        buscarCalculoEnergia: buscarCalculoEnergia,
        listarPontosEspecificos, listarPontosEspecificos
    };
})
