app.controller('homeController', function ($scope, $routeParams, $location, authService, authConfig, toastr, usuarioService) {
    //obterCameras();
    //obterVeiculos();
    //obterOcorrencias();
    //obterVeiculosClonados();

    function obterCameras() {
        usuarioService.obterCameras().then(response => {
            $scope.cameras = response.data;
        }).catch(error => console.log(error));;
    }

    function obterVeiculos() {
        usuarioService.obterVeiculos().then(response => {
            $scope.veiculos = response.data;
        }).catch(error => console.log(error));;
    }

    function obterOcorrencias() {
        usuarioService.obterOcorrencias().then(response => {
            //Pegar só 3 meses
            //Ver como o objeto está vindo           
            $scope.ocorrencias = response.data;
        }).catch(error => console.log(error));;
    }

    function obterVeiculosClonados() {
        usuarioService.obterVeiculosClonados().then(response => {
            $scope.clonado = response.data;
        }).catch(error => console.log(error));;
    }

    $scope.logar = function () {
        $location.path("/login")
    }

});