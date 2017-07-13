app.controller('veiculoController', function ($scope, $routeParams, $location, authService, authConfig, toastr, veiculoService) {

    $scope.pesquisa = true;
    $scope.mostrarVeiculo = false;

    $scope.obterTotalVeiculos = function () {
        veiculoService.obterTotalVeiculos().then(response => {
            response.data;
        }).catch(error => console.log(error));
    }

    $scope.obterConsultaVeiculo = function (placa) {
        veiculoService.obterConsulta(placa).then(response => {
            $scope.veiculoConsultado = response.data;
            console.log($scope.veiculoConsultado);
            $scope.pesquisa = false;
            $scope.mostrarVeiculo = true;
            toastr.success("Veiculo Encontrado!");
        }).catch(error => toastr.error("Veiculo não existe na base"));
    }

    $scope.voltar = function () {
        delete $scope.placa;
        $scope.pesquisa = true;
        $scope.mostrarVeiculo = false;
    }
});