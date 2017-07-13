app.controller('autoridadeController', function($scope, $routeParams, $location, authService, authConfig, toastr, usuarioService, homeService, cidadeService){
    var usuario = $routeParams.id;
    var permissao;

    function obterPermissoes(usuario){
        usuarioService.obterPorRole(usuario).then(response => {
            permissao = response.data.role;
        }).catch(error => console.log(error));;
    }

        obterCameras();

        function obterCameras(){
            usuarioService.obterCameras().then(response => {
                $scope.cameras = response.data;
            }).catch(error => console.log(error));
        }

        $scope.obterVeiculoPlaca = function obterVeiculoPlaca(placa){
            usuarioService.obterVeiculoPlaca(placa).then(response =>{
                $scope.veiculo = response.data;
            }).catch(error => console.log(error));
        }

        $scope.obterVeiculoClonado = function obterVeiculoClonado(veiculo){
            usuarioService.obterVeiculoClonado(veiculo.placa).then(response => {
                $scope.veiculo = response.data;
            }).catch(error => console.log(error));
        }
    
});