app.controller('graficoController', function($scope, graficoService, $routeParams, $location, authService, authConfig, toastr) {
  
  
  // chart data source
  $scope.graficoTotalCidades = {
    "chart": {
      "caption": "Column Chart Built in Angular!",
      "captionFontSize": "30",
      // more chart properties - explained later
    },
    "data": [{
        "label": "kaka",
        "value": totalCidades()
      }, //more chart data
    ]
  };

  
    

    function totalCidades(){
        // $http.get('http://localhost:9090/registro/cidade/obtertodas')
        graficoService.totalCidades()
        .then(response => {
            console.log(response.data.length);
            $scope.graficoTotalCidades.data[0].value = response.data.length;
            //$scope.totalCidade = response.data;
        }).catch(error => console.log(error));   
    }

    $scope.totalVeiculos = function totalVeiculos(){
        graficoService.totalVeiculos().then(response => {
            $scope.totalVeiculo = response.data;
        }).catch(error => console.log(error));
    }

    $scope.totalVeiculosClonados = function totalVeiculosClonados(){
        graficoService.totalVeiculosClonados().then(response => {
            $scope.totalClonado = response.data;
        }).catch(error => console.log(error));
    }

    $scope.ocorrenciasUltimos3meses = function ocorrenciasUltimos3meses(){
        graficoService.ocorrenciasUltimos3meses().then(response => {
            $scope.ultimasOcorrencias = response.data;
        }).catch(error => console.log(error));
    }
});