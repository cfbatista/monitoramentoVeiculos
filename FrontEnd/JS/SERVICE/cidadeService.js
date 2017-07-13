app.service('cidadeService', function($http) {

    var url = 'http://localhost:9090/cidade';

    function obterCidades() {
        return $http.get(url + '/obternumerocidades');
    }

    function totalCidades() {
        return $http.get(url + '/obter/numerocidades');
    }

    function cidadesComRegistro() {
        return $http.get(url + 'obter/cidadescomregistro');
    }

    return {
        obterCidades: obterCidades,
        totalCidades: totalCidades,
        cidadesComRegistro: cidadesComRegistro
    }

});