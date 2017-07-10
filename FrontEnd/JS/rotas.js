app.config(function($routeProvider){

    $routeProvider

        .when('/home', {
            controller: 'homeController',
            templateUrl: 'VIEW/home.html'
        })
 
         .when('/login', {
            controller: 'loginController',
            templateUrl: 'VIEW/login.html'
        })
        
         .when('/cadastro', {
            controller: 'cadastroController',
            templateUrl: 'VIEW/cadastro.html'
        })

        .when('/analiserota', {
            controller: 'analiseRotaController',
            templateUrl: 'VIEW/analiseRota.html',
            resolve: {
                autenticado: function (authService) {
                    return authService.isAutenticadoPromise();
                }
            }
        })

        .when('/veiculo', {
            templateUrl: 'VIEW/veiculo.html'
        })
        
        .when('/cadastroOcorrencia', {
            templateUrl: 'VIEW/cadastroOcorrencia.html',
            controller: 'usuarioController'
        })
        .when('/grafico', {
            templateUrl: 'VIEW/graficos.html'
        })

        .otherwise({redirectTo: '/home'});
});