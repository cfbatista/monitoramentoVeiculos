app.controller('estatisticaController', function($scope, $http, estatisticaService, $routeParams, $location, authService, authConfig, toastr) {

    $scope.graficoFabricantesMaiorOcorrencia = {
      "chart": {
          "caption" : "Fabricantes com maiores ocorrências",
          "captionFontSize": "10"
      }, 
      "data": [{
          "label": "Figura 1",
          "value": fabricantesMaiorOcorrencia()
      }]
    };

    $scope.graficoModelosMaisRoubados = {
        "chart": {
            "caption": "Modelos com maior índice de roubos",
            "captionFontSize": "10"
        },
        "data": [{
            "label": "Figura 2",
            "value": modelosMaisRoubados()
        }]
    };

    $scope.graficoHorarioComMaiorRoubo = {
        "chart": {
            "caption": "Horário que ocorre maior número de roubos",
            "captionFontSize": "10"
        },
        "data": [{
            "label": "Figura 3",
            "value": horarioComMaiorRoubo()
        }]
    };

    $scope.graficoCidadesComMaisRoubos = {
        "chart": {
            "caption": "Cidades com maior número de roubos",
            "captionFontSize": "10"
        },
        "data": [{
            "label": "Figura 4",
            "value": cidadesComMaisRoubos()
        }]
    };

    $scope.graficoCamerasComMaisVeiculosRoubados = {
        "chart": {
            "caption": "Câmeras com maior número de registros de veículos roubados",
            "captionFontSize": "10"
        },
        "data": [{
            "label": "Figura 5",
            "value": camerasComMaisVeiculosRoubados()
        }]
    };


    function fabricantesMaiorOcorrencia(){
        estatisticaService.fabricantesMaiorOcorrencia().then(response => {
            $scope.graficoFabricantesMaiorOcorrencia.data[0].value = response.data;
        });
    }

    function modelosMaisRoubados(){
        estatisticaService.modelosMaisRoubados().then(response => {
            $scope.graficoModelosMaisRoubados.data[0].value = response.data;
        });
    }

    function horarioComMaiorRoubo(){
        estatisticaService.horarioComMaiorRoubo().then(response => {
            $scope.graficoHorarioComMaiorRoubo.data[0].value = response.data;
        });
    }

    function cidadesComMaisRoubos(){
        estatisticaService.cidadesComMaisRoubos().then(response => {
            $scope.graficoCidadesComMaisRoubos.data[0].value = response.data;
        });
    }

    function camerasComMaisVeiculosRoubados(){
        estatisticaService.camerasComMaisVeiculosRoubados().then(response => {
            $scope.graficoCamerasComMaisVeiculosRoubados.data[0].value = respose.data;
        });
    }
});