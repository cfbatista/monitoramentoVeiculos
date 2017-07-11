app.controller('graficoController', function($scope, $http, graficoService, $routeParams, $location, authService, authConfig, toastr) {
  
  
  // chart data source
  $scope.graficoTotalCidades = {
    "chart": {
      "caption": "Total de cidades com monitoramento",
      "captionFontSize": "20",
      // more chart properties - explained later
    },
    "data": [{
        "label": "Figura 1",
        "value": totalCidades()
      }, //more chart data
    ]
  };

  $scope.graficoTotalVeiculos = {
      "chart": {
          "caption": "Total de veículos",
          "captionFontSize": "20"
      },
      "data": [{
          "label": "Figura 2",
          "value": totalVeiculos()
      }]
  };

//   $scope.graficoClonados = {
//       "chart": {
//           "caption": "Total de veículos clonados",
//           "captionFontSize": "20"
//       },
//       "data": [{
//           "label": "Figura 3",
//           "value": totalVeiculosClonados()
//       }]
//   };

  $scope.graficoUltimasOcorrencias = {
      "chart": {
          "caption" : "Total de ocorrêcias nos últimos 3 meses",
          "captionFontSize": "20"
      }, 
      "data": [{
          "label": "Figura 4",
          "value": ocorrenciasUltimos3meses()
      }]
  };

  
    

    function totalCidades(){
        //  $http.get('http://localhost:9090/registro/cidade/obtertodas')
        graficoService.obterCidades()
        .then(response => {
            console.log(response.data.length)
            $scope.graficoTotalCidades.data[0].value = response.data.length;
            //$scope.totalCidade = response.data;
        }).catch(error => console.log(error));   
    }

    function totalVeiculos(){
        graficoService.totalVeiculos().then(response => {
            console.log(response.data);
            $scope.graficoTotalVeiculos.data[0].value = response.data;
        }).catch(error => console.log(error));
    }

    function ocorrenciasUltimos3meses(){
        graficoService.ocorrenciasUltimos3meses().then(response => {
            console.log(response.data);
            $scope.graficoUltimasOcorrencias.data[0].value = response.data;
        }).catch(error => console.log(error));
    }

    // function totalVeiculosClonados(){
    //     graficoService.totalVeiculosClonados().then(response => {
    //         $scope.totalClonado.data[0] = response.data.length;
    //     }).catch(error => console.log(error));
    // }

});