app.controller('usuarioController',function($scope, $routeParams, $location, authService, authConfig, toastr, usuarioService){
    var usuario = $routeParams.id;
    var permissao;

    function obterPermissoes(usuario){
        usuarioService.obterPorRole(usuario).then(response => {
            permissao = response.data.role;
        }).catch(error => console.log(error));;
    }

    //Ver como a permissao ta vindo
    if(permissao === 'admin' || permissao === 'autoridade' || permissao === 'usuario'){
        obterRegistro();
        obterRegistroUsuario(usuario);

        function obterRegistro(){
            usuarioService.obterRegistro().then(response =>{
                $scope.registros = response.data;
            }).catch(error => console.log(error));
        }

        function obterRegistroUsuario(usuario){
            usuarioService.obterRegistroUsuario(usuario).then(response => {
                $scope.registros = response.data;
            }).catch(error => console.log(error));
        }

        $scope.adicionarOcorrencia = (registro) => {
            registro.idUsuario = { id: usuario.id };

            usuarioService.adicionarOcorrencia(registro)
                .then(response => obterRegistro(usuario))
                .catch(error => console.log(error));
        }

        $scope.obterVeiculoPlaca = function obterVeiculoPlaca(placa){
            usuarioService.obterVeiculoPlaca(placa).then(response => {
                $scope.veiculo = response.data;
            });
        }

        $scope.adicionarVeiculo = function adicionarVeiculo(veiculo){
            usuarioService.adicionarVeiculo(veiculo).then(response => {
                $scope.veiculo = angular.copy($scope.veiculos);
            });
        }
    }
});