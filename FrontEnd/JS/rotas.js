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
        .when('/cadastroCamera', {
            controller: 'adminController',
            templateUrl: 'VIEW/cadastroCamera.html'
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
            templateUrl: 'VIEW/veiculo.html',
            controller: 'veiculoController'
        })
        .when('/cadastroOcorrencia', {
            templateUrl: 'VIEW/cadastroOcorrencia.html',
            controller: 'ocorrenciaController'
        })
        .when('/consultaOcorrencia', {
            templateUrl: 'VIEW/consultaOcorrencia.html',
            controller: 'ocorrenciaController'
        })
        .when('/estatistica', {
            templateUrl: 'VIEW/estatistica.html',
            controller: 'estatisticaController'
        })
        .otherwise({redirectTo: '/home'});
});