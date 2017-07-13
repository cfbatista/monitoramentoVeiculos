app.service('registroService', function($http) {
    var url = 'http://localhost:9090/registro';


    function obterRegistros() {
        return $http.get(url);
    }

    return {
        obterRegistros: obterRegistros,
    }
});