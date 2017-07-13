app.controller('cidadeController', function($scope, $routeParams, $location, authService, authConfig, toastr, cidadeService) {

    $scope.obterCidade = function obterCidade() {
        cidadeService.obterCidade().then(response => {
            response.data;
        }).catch(error => console.log(error));
    }

    $scope.totalCidades = function totalCidades() {
        cidadeService.obterCidade().then(response => {
            response.data.length;
        }).catch(error => console.log(error));
    }

});