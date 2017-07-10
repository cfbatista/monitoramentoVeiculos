app.controller('usuarioController',function($scope, $routeParams, $location, authService, authConfig, toastr, usuarioService){
    var usuario = $routeParams.id;
    var permissao;

    $scope.obterPorRole = function obterPermissoes(usuario){
        usuarioService.obterPorRole(usuario).then(response => {
            permissao = response.data.role;
        }).catch(error => console.log(error));
    }
    
    $scope.obterPorId = function obterPorId(id){
        usuarioService.obterPorId(id).then(response => {
            response.data;
        }).catch(error => console.log(error));
    }
    
    $scope.obterUsuario = function obterUsuario(){
        usuarioService.obterUsuario().then(response => {
            response.data;
        }).catch(error => console.log(error));
    }

    $scope.adicionarUsuario = function adicionarUsuario(usuario){
        usuarioService.adicionarUsuario(usuario).then(response => {
            response.data;
        }).catch(error => console.log(error));
    }

    $scope.updateUsuario = function updateUsuario(usuario){
        usuarioService.updateUsuario(usuario).then(response => {
            response.data;
        }).catch(error => console.log(error));
    }

});