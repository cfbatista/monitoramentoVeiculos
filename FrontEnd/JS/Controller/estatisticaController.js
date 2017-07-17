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
            caption: "Fabricantes X Ocorrências",
            captionFontSize: 22,
            subCaption: "Fábricantes com os maiores números de ocorrências",
            xAxisname: "Fabricantes",
            yAxisName: "Numero de ocorrências",
            theme: "zune",
            baseFontSize: 18,
            captionAlignment: "center"
        },
    };

    $scope.modelosRoubados = {
        chart: {
            caption: "Modelos X Ocorrências",
            captionFontSize: 22,
            subCaption: "Modelos com maiores números de ocorrências",
            xAxisname: "Modelos",
            yAxisName: "Numero de ocorrências",
            theme: "zune",
            baseFontSize: 18,
            captionAlignment: "center"
        },
    };

    $scope.horarioRoubos = {
        chart: {
            caption: "Horários X Ocorrências",
            captionFontSize: 22,
            subCaption: "Horários com maiores números de ocorrências",
            xAxisname: "Horários",
            yAxisName: "Numero de ocorrências",
            theme: "zune",
            baseFontSize: 18,
            captionAlignment: "center"
        },
    };

    $scope.cidadeRoubos = {
        chart: {
            caption: "Cidades X Roubos",
            captionFontSize: 22,
            subCaption: "Cidades com maiores números de ocorrências",
            xAxisname: "Cidades",
            yAxisName: "Numero de ocorrências",
            theme: "zune",
            baseFontSize: 18,
            captionAlignment: "center"
        },
    };
});