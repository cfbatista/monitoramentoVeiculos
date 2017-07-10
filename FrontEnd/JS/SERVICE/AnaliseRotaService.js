app.factory('AnaliseRotaService', function ($http) {

    var urlBase = 'http://localhost:9090/registro';

    function listarTodosPontos() {
        return $http.get(urlBase);
    };

    function listarPontosEspecificos(RegistroCountModel){
        return $http.post(urlBase + '/heatmap',RegistroCountModel);
    }

    return{
        listarTodosPontos:listarTodosPontos,
        listarPontosEspecificos, listarPontosEspecificos
    };
})
