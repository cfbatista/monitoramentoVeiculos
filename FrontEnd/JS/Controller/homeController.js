app.controller('homeController', function ($scope, $routeParams, $location, authService, authConfig, toastr, usuarioService, graficoService) {

    totalCidades();
    function totalCidades() {
        graficoService.obterCidades().then(response => {
            $scope.totalCidades = response.data;
        }).catch(error => console.log(error));
    }

    totalVeiculos();
    function totalVeiculos() {
        graficoService.totalVeiculos().then(response => {
            $scope.totalVeiculos = response.data;
        }).catch(error => console.log(error));
    }

    ocorrenciasUltimos3meses();
    function ocorrenciasUltimos3meses() {
        graficoService.ocorrenciasUltimos3meses().then(response => {
            $scope.ocorrenciasUltimos3meses = response.data;
        }).catch(error => console.log(error));
    }

    // function totalVeiculosClonados(){
    //     graficoService.totalVeiculosClonados().then(response => {
    //         $scope.totalClonado.data[0] = response.data.length;
    //     }).catch(error => console.log(error));
    // }

    $scope.logar = function () {
        $location.path("/login")
    }

    $scope.logout = function () {
        authService.logout();
    }

});