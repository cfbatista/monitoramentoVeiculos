app.config(function ($routeProvider) {

    $routeProvider
        .when('/mapas', {
            controller: 'mapasController',
            templateUrl: './mapas.html'
        })
        .otherwise({ redirectTo: '/mapas' })
})