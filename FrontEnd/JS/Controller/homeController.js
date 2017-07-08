app.controller('cameraController', function($scope, $routeParams, $location, authService, authConfig, toastr, usuarioService){
    obterCameras();
    obterVeiculos();
    obterOcorrencias();
    obterVeiculosClonados();

    function obterCameras(){
        usuarioService.obterCameras().then(response =>{
            $scope.cameras = response.data;
        });
    }

    function obterVeiculos(){
        usuarioService.obterVeiculos().then(response =>{
            $scope.veiculos = response.data;
        });
    }

    function obterOcorrencias(){
        usuarioService.obterOcorrencias().then(response =>{
            //Pegar só 3 meses
            //Ver como o objeto está vindo           
            $scope.ocorrencias = response.data;
        });
    }

    function obterVeiculosClonados(){
        usuarioService.obterVeiculosClonados().then(response =>{
            $scope.clonado = response.data;
        });
    }
});