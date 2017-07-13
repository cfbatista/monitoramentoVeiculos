app.controller('registroController', function($scope, $routeParams, $location, authService, authConfig, toastr, registroService) {

    $scope.obterRegistros = function obterRegistros() {
        registroService.obterRegistros().then(Response => {
            response.data;
        }).catch(error => console.log(error));
    }
});