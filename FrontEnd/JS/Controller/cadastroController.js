app.controller('cadastroController', function ($scope, $routeParams, $location, authService, authConfig, toastr, usuarioService) {

    obterCidades();

    function obterCidades() {
        usuarioService.obterCidades().then(response => {
            $scope.cidades = response.data;
            console.log($scope.cidades);
        }).catch(error => console.log(error));;
    }

    function novoUsuario(usuario) {
        usuarioService.adicionar(usuario).then(r => {
            authService.login($scope.usuario).then(response => {
                $location.path("/home");
                toastr.sucess('Login realizado com sucesso');
            })
            delete $scope.usuario;
        }, error => {
            toastr.error(error.data.message);
        })
    }

    $scope.novoUsuario = novoUsuario;

});