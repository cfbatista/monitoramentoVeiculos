app.factory('AnaliseRotaService', function ($http) {

    var urlBase = 'http://localhost:9090/registro';

    function listarTodosPontos() {
        return $http.get(urlBase);
    };

    function listarPontosEspecificos(pontoInicial, pontoFinal) {
        return $http({
            url: urlBase + '/calculo',
            params: { pontoInicial: pontoFinal },
            method: 'GET'
        })
    }

    return{
        listarTodosPontos:listarTodosPontos,
        listarPontosEspecificos, listarPontosEspecificos
    };
})
