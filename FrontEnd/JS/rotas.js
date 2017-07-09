app.config(function($routeProvider){
    $routeProvider
        when('/home', {
            controller: 'loginController',
            templateUrl: 'index.html'
        })
        .when('/analiserota', {
            controller: 'analiseRotaController',
            templateUrl: 'VIEW/analiseRota.html'
        })
        .when('/veiculo', {
            templateUrl: 'VIEW/veiculo.html'
        })
        .when('/ocorrencia', {
            templateUrl: 'VIEW/ocorrencia.html'
        })
        // .when('/privado', {
        //     controller: 'PrivadoController',
        //     templateUrl: 'privado/privado.html',
        //     resolve: {

        //         // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
        //         autenticado: function (authService) {
        //         return authService.isAutenticadoPromise();
        //         }
        //     }
        // })
        .otherwise('/home');
});