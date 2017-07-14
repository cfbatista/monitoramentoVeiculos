app.controller('estatisticaController', function ($scope, $http, estatisticaService, $routeParams, $location, authService, authConfig, toastr) {

    $scope.fabricanteOcorrencia = {
        chart: {
            caption: "FABRICANTES X OCORRENCIAS",
            subCaption: "Fabricantes com maiores números de ocorrencias",
            theme: "zune"
        },
    };

    $scope.modelosRoubados = {
        chart: {
            caption: "MODELOS X ROUBOS",
            subCaption: "Modelos com maiores números de roubos",
            theme: "zune"
        },
    };

    $scope.horarioRoubos = {
        chart: {
            caption: "HORARIOS X ROUBOS",
            subCaption: "Horarios com maiores números de roubos",
            theme: "zune"
        },
    };

    $scope.cidadeRoubos = {
        chart: {
            caption: "CIDADES X ROUBOS",
            subCaption: "Horarios com maiores números de roubos",
            theme: "zune"
        },
    };

    fabricantesMaiorOcorrencia();
    function fabricantesMaiorOcorrencia() {
        estatisticaService.fabricantesMaiorOcorrencia().then(response => {
            let dataResponse = [];
            response.data.forEach(element => {
                dataResponse.push({ label: element.nome, value: element.quantidade });
            });
            $scope.fabricanteOcorrencia.data = dataResponse;
        });
    }

    modelosMaisRoubados();
    function modelosMaisRoubados() {
        estatisticaService.modelosMaisRoubados().then(response => {
            let dataResponse = [];
            response.data.forEach(element => {
                dataResponse.push({ label: element.nome, value: element.quantidade });
            });
            $scope.modelosRoubados.data = dataResponse;
        });
    }

    horarioComMaiorRoubo();
    function horarioComMaiorRoubo() {
        estatisticaService.horarioComMaiorRoubo().then(response => {
            let dataResponse = [];
            response.data.forEach(element => {
                dataResponse.push({ label: element.nome, value: element.quantidade });
            });
            $scope.horarioRoubos.data = dataResponse;
        });
    }

    cidadesComMaisRoubos();
    function cidadesComMaisRoubos() {
        estatisticaService.cidadesComMaisRoubos().then(response => {
            let dataResponse = [];
            response.data.forEach(element => {
                dataResponse.push({ label: element.nome, value: element.quantidade });
            });
            $scope.cidadeRoubos.data = dataResponse;
        });
    }

    //function camerasComMaisVeiculosRoubados() {
    //   estatisticaService.camerasComMaisVeiculosRoubados().then(response => {
    //       let dataResponse = [];
    //        response.data.forEach(element => {
    //           dataResponse.push({ label: element.nome, value: element.contagem });
    //        });
    //       $scope.camerasVeiculosRoubados.data = dataResponse;
    //   });
    //}
});