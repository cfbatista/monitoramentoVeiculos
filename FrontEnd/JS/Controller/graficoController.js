app.controller('graficoController', function($scope, $http, graficoService, $routeParams, $location, authService, authConfig, toastr) {

    totalCidades();
    function totalCidades(){
        graficoService.obterCidades().then(response => {
            $scope.totalCidade = response.data;
        }).catch(error => console.log(error));   
    }

    totalVeiculos();
    function totalVeiculos(){
        graficoService.totalVeiculos().then(response => {
             $scope.totalVeiculo = response.data;
        }).catch(error => console.log(error));
    }
   
    ocorrenciasUltimos3meses();
    function ocorrenciasUltimos3meses(){
        graficoService.ocorrenciasUltimos3meses().then(response => {
            $scope.ocorrencias = response.data;
        }).catch(error => console.log(error));
    }
    
    // function totalVeiculosClonados(){
    //     graficoService.totalVeiculosClonados().then(response => {
    //         $scope.totalClonado.data[0] = response.data.length;
    //     }).catch(error => console.log(error));
    // }

});