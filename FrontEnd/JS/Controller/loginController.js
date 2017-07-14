app.controller('loginController', function ($scope, $routeParams, $location, authService, authConfig, toastr) {

    $scope.login = function (usuario) {
        if ($scope.formLogin.$valid) {
            authService.login(usuario)
                .then(function (response) {
                    toastr.success('Login com sucesso!');
                    $location.path('/analiserota');
                },
                function (response) {
                    toastr.error('Login ou Senha inválidos!');
                });
        } else {
            toastr.warning('Preencha todos os dados corretamente.', 'Dados inválidos!');
        }
    };
    
    $scope.cadastrar = function () {
        $location.path('/cadastro');
    };

});