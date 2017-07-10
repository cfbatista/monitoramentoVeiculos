app.controller('veiculoController', function($scope, $routeParams, $location, authService, authConfig, toastr, veiculoService) {

    $scope.obterVeiculo = function obterVeiculo(){
        veiculoService.obterVeiculo().then(response => {
            response.data;
        }).catch(error => console.log(error));
    }

    $scope.obterVeiculoPlaca = function obterVeiculoPlaca(placa){
        veiculoService.obterVeiculoPlaca(placa).then(response => {
            response.data;
        }).catch(error => console.log(error));
    }

    $scope.obterVeiculoClonado = function obterVeiculoClonado(){
        veiculoService.obterVeiculoClonado().then(response => {
            response.data;
        }).catch(error => console.log(error));
    }

    $scope.adicionarVeiculo = function adicionarVeiculo(veiculo){
        veiculoService.adicionarVeiculo(veiculo).then(response => {
            $scope.veiculo = angular.copy($scope.veiculos);
        }).catch(error => console.log(error));
    }

    $scope.atualizarVeiculo = function atualizarVeiculo(veiculo){
        veiculoService.atualizarVeiculo(veiculo).then(response => {
            response.data;
        }).catch(error => console.log(error));
    }

    $scope.deletarVeiculo = function deletarVeiculo(veiculo){
        veiculoService.deletarVeiculo(veiculo).then(response => {

        }).catch(error => console.log(error));
    }
});