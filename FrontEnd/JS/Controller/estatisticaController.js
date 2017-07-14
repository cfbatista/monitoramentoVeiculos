app.controller('estatisticaController', function ($scope, $http, estatisticaService, $routeParams, $location, authService, authConfig, toastr) {
    cidadesComMaisRoubos();
    horarioComMaiorRoubo();
    modelosMaisRoubados();
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

    function modelosMaisRoubados() {
        estatisticaService.modelosMaisRoubados().then(response => {
            let dataResponse = [];
            response.data.forEach(element => {
                dataResponse.push({ label: element.nome, value: element.quantidade });
            });
            $scope.modelosRoubados.data = dataResponse;
        });
    }

    function horarioComMaiorRoubo() {
        estatisticaService.horarioComMaiorRoubo().then(response => {
            let dataResponse = [];
            response.data.forEach(element => {
                dataResponse.push({ label: element.nome, value: element.quantidade });
            });
            $scope.horarioRoubos.data = dataResponse;
        });
    }

    function cidadesComMaisRoubos() {
        estatisticaService.cidadesComMaisRoubos().then(response => {
            let dataResponse = [];
            response.data.forEach(element => {
                dataResponse.push({ label: element.nome, value: element.quantidade });
            });
            $scope.cidadeRoubos.data = dataResponse;
        });
    }

    $scope.fabricanteOcorrencia = {
        chart: {
            caption: "FABRICANTES X OCORRENCIAS",
            subCaption: "Fabricantes com maiores números de ocorrencias",
            theme: "zune",
            captionAlignment: "center"
        },
    };

    $scope.modelosRoubados = {
        chart: {
            caption: "MODELOS X ROUBOS",
            subCaption: "Modelos com maiores números de roubos",
            theme: "zune",
            captionAlignment: "center"
        },
    };

    $scope.horarioRoubos = {
        chart: {
            caption: "HORARIOS X ROUBOS",
            subCaption: "Horarios com maiores números de roubos",
            theme: "zune",
            captionAlignment: "center"
        },
    };

    $scope.cidadeRoubos = {
        chart: {
            caption: "CIDADES X ROUBOS",
            subCaption: "Horarios com maiores números de roubos",
            theme: "zune",
            captionAlignment: "center"
        },
    };

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