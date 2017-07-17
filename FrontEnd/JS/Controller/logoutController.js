app.controller('logoutController', function ($scope, $location, authService, authConfig, toastr) {
    
    $scope.logout = authService.logout;
    $scope.voltar = voltar;

    function voltar() {
         $location.path('/home');
    };

});