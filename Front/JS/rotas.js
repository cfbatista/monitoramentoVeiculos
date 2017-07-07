app.config(function($routeProvider){
    $routeProvider
        .when('/login',{
            controller: 'loginController',
            templateUrl: 'VIEW/login.html'
        })
        .when('/home', {
            controller: 'homeController',
            templateUrl: 'VIEW/home.html'
        })
        .otherwise('/login');
});