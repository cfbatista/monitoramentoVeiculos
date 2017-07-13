app.controller('veiculoController', function($scope, $routeParams, $location, authService, authConfig, toastr, veiculoService) {

    $scope.obterTotalVeiculos = function obterTotalVeiculos() {
        veiculoService.obterTotalVeiculos().then(response => {
            response.data;
        }).catch(error => console.log(error));
    }

    $scope.obterVeiculoPlaca = function obterVeiculoPlaca(placa) {
        veiculoService.obterVeiculoPlaca(placa).then(response => {
            response.data;
        }).catch(error => console.log(error));
    }

    $scope.obterVeiculoClonado = function obterVeiculoClonado() {
        veiculoService.obterVeiculoClonado().then(response => {
            response.data;
        }).catch(error => console.log(error));
    }
});