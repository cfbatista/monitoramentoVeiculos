app.controller('loginController', function($scope, $routeParams, $location, authService, authConfig, toastr){

    $scope.login = login;
    
    function login(usuario){
        authService.login(usuario)
            .then(
                function(response){
                    $location.path(authConfig.urlPrivado);
                    toastr.sucess('Login realizado com sucesso');
                },
                function(response){
                    toastr.error('Erro ao tentar fazer login. Por favor verifica usuário e senha');
                }
            )
    }
});