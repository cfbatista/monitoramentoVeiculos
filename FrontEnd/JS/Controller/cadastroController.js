app.controller('cadastroController', function ($scope, $routeParams, $location, authService, authConfig, toastr, usuarioService, cidadeService) {

    obterTodasCidades();

    function obterTodasCidades() {
        cidadeService.obterCidades().then(response => {
            $scope.cidades = response.data;
        }).catch(error => console.log(error));
    }

    function novoUsuario(usuario) {
        alert("teste");
        usuarioService.adicionarUsuario(usuario).then(r => {
            authService.login($scope.usuario).then(response => {
                $location.path("/home");
                toastr.sucess('Login realizado com sucesso');
            })
            delete $scope.usuario;
        }, error => {
            toastr.error(error.data.message);
        })
    }
});