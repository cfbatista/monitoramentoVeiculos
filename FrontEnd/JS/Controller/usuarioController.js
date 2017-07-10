app.controller('usuarioController',function($scope, $routeParams, $location, authService, authConfig, toastr, usuarioService){
    var usuario = $routeParams.id;
    var permissao;

    function obterPermissoes(usuario){
        usuarioService.obterPorRole(usuario).then(response => {
            permissao = response.data.role;
        }).catch(error => console.log(error));;
    }
});