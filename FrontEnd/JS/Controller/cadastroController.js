app.controller('loginController', function($scope, $routeParams, $location, authService, authConfig, toastr, usuarioServie){


    function novoUsuario(usuario){ 
            usuarioServie.adicionar(usuario).then(r => { 
                authService.login($scope.usuario).then(response => {
                    // $location.path(authConfig.urlPrivado); 
                    toastr.sucess('Login realizado com sucesso'); 
                }) 
            }, error => { 
                toastr.error(error.data.message); 
            }) 
        } 
    
    $scope.novoUsuario = novoUsuario; 

});