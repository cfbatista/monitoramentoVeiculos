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
        
        .when('/ocorrencia', {
            templateUrl: 'VIEW/ocorrencia.html'
        })

        .otherwise({redirectTo: '/home'});
});