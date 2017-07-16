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
            caption: "FÁBRICANTES X OCORRÊNCIAS",
            subCaption: "Fábricantes com os maiores números de ocorrências",
            theme: "zune",
            baseFontSize: 14,
            captionAlignment: "center"
        },
    };

    $scope.modelosRoubados = {
        chart: {
            caption: "MODELOS X ROUBOS",
            subCaption: "Modelos com maiores números de roubos",
            theme: "zune",
            baseFontSize: 14,
            captionAlignment: "center"
        },
    };

    $scope.horarioRoubos = {
        chart: {
            caption: "HORÁRIOS X ROUBOS",
            subCaption: "Horários com maiores números de roubos",
            theme: "zune",
            baseFontSize: 14,
            captionAlignment: "center"
        },
    };

    $scope.cidadeRoubos = {
        chart: {
            caption: "CIDADES X ROUBOS",
            subCaption: "Horários com maiores números de roubos",
            theme: "zune",
            baseFontSize: 14,
            captionAlignment: "center"
        },
    };  
});