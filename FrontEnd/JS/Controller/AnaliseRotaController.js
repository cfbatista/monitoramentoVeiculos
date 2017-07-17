app.controller('analiseRotaController', function ($scope, $routeParams, $location, authService, authConfig, toastr, AnaliseRotaService, registroService, cameraService) {

    $scope.selecionar_orientacao = true;
    $scope.dados_Rota = false;
    $scope.botoes_Mapa = false;
    $scope.mapaPlotado = false;

    $scope.buscarCamerasPorSentido = function (direcao) {
        $scope.pegardirecao = direcao;
        AnaliseRotaService.buscarCameraSentido(direcao).then(response => {
            $scope.camerasSentido = response.data;
            toastr.success("Cameras carregadas com sucesso!!");
            $scope.selecionar_orientacao = false;
            $scope.dados_Rota = true;
        }).catch(error => toastr.error('Selecione algum campo válido!'))
    }

    $scope.pegarCameras = function (RegistroCountModel) {

        RegistroCountModel.direcao = $scope.pegardirecao;
        $scope.modelEnergia = RegistroCountModel;

        AnaliseRotaService.listarPontosEspecificos(RegistroCountModel).then(response => {
            $scope.cameras = response.data;
            $scope.tamanho = $scope.cameras.length;
            $scope.camerasCalor = $scope.cameras;
            $scope.dados_Rota = false;
            $scope.botoes_Mapa = true;
        }).catch(error => toastr.error('Algum campo inválido, insira novamente!'));
    }

    //pontos de calor

    $scope.heatMapData = [];

    function criarMapaCalor(camerasCalor) {
        for (let i = 0; i < camerasCalor.length; i++) {
            $scope.heatMapData.push({ location: new google.maps.LatLng(camerasCalor[i].camera.latitude, camerasCalor[i].camera.longitude), weight: camerasCalor[i].fator });
        }
    }

    var directionsDisplay = new google.maps.DirectionsRenderer;
    var directionsService = new google.maps.DirectionsService;
    var NovoHamburgo = new google.maps.LatLng(-29.6918991, -51.1255697);
    var map;
    var heatmap;
    var marker;
    var LatLng;

    //funcao para mostrar o mapa com seus pontos de calor
    $scope.click = function () {
        map = new google.maps.Map(document.getElementById('map'), {
            center: NovoHamburgo,
            zoom: 10
        })
        criarMapaCalor($scope.camerasCalor);
        heatmap = new google.maps.visualization.HeatmapLayer({
            data: $scope.heatMapData,
            radius: 50
        });
        heatmap.setMap(map);
        directionsDisplay.setMap(map);
    }

    $scope.tracarRota = function () {
        calculateAndDisplayRoute(directionsService, directionsDisplay, $scope.camerasCalor);
        $scope.mapaPlotado = true;
    }

    //funcao para calcular a rota
    function calculateAndDisplayRoute(directionsService, directionsDisplay, camerasCalor, modelEnergia) {

        var start = camerasCalor[0].camera.latitude + ',' + camerasCalor[0].camera.longitude;
        var end = camerasCalor[$scope.tamanho - 1].camera.latitude + ',' + camerasCalor[$scope.tamanho - 1].camera.longitude;

        $scope.distanciaEntrePontos = google.maps.geometry.spherical.computeDistanceBetween(new google.maps.LatLng(camerasCalor[0].camera.latitude, camerasCalor[0].camera.longitude), new google.maps.LatLng(camerasCalor[$scope.tamanho - 1].camera.latitude, camerasCalor[$scope.tamanho - 1].camera.longitude));
        $scope.modelEnergia.metros = $scope.distanciaEntrePontos;

        var model = new Object;
        model = $scope.modelEnergia;

        calculoEnergia($scope.modelEnergia);
        buscarRegistroVeiculosPorData(model);
        buscarRegistroVeiculosPorHorario(model);

        directionsService.route({
            origin: start,
            destination: end,
            travelMode: 'DRIVING'
        }, function (response, status) {
            if (status === 'OK') {
                directionsDisplay.setDirections(response);
            } else {
                toastr.error('Tente novamente!' + status);
            }
        });
    }

    function calculoEnergia(modelEnergia) {
        AnaliseRotaService.buscarCalculoEnergia(modelEnergia).then(response => {
            $scope.energia = response.data;
            numeroCasasAlimentadasComEnergiaMensalmente($scope.energia.energia);
        }).catch(error => toastr.error('Algum erro ocorrido! Contate o administrador!'))
    }

    function numeroCasasAlimentadasComEnergiaMensalmente(energia) {
        $scope.energia.numeroCasas = (energia / 170) * 30;
    }

    function buscarRegistroVeiculosPorData(model) {
        cameraService.buscarRegistroVeiculosPorData(model).then(response => {
            let dataResponse = [];
            response.data.forEach(element => {
                dataResponse.push({ label: element.dia, value: element.contagem });
            });
            $scope.veiculoPorDia.data = dataResponse;
        }).catch(error => toastr.error('Algum erro ocorrido! Contate o administrador!'))
    }

    function buscarRegistroVeiculosPorHorario(model) {
        registroService.buscarRegistrosVeiculosPorHorario(model).then(response => {
            let dataResponse = [];
            response.data.forEach(element => {
                dataResponse.push({ label: element.descricao, value: element.contagem });
            });
            $scope.veiculoPorHorario.data = dataResponse;
        }).catch(error => toastr.error('Algum erro ocorrido! Contate o administrador!'))
    }

    $scope.veiculoPorHorario = {
        chart: {
            caption: "Fluxo Durante o Dia",
            captionFontSize:22,
            subCaption: "Fluxo de veÍculos por horário",
            xAxisname: "Horários",
            yAxisName: "Numero de veículos",
            baseFontSize: 18,
            theme: "zune"
        },
    };

    $scope.veiculoPorDia = {
        chart: {
            caption: "Fluxo Durante a Semana",
            captionFontSize:22,
            subCaption: "Fluxo de veiculos por dias da semana",
            xAxisname: "Dias da semana",
            yAxisName: "Numero de veículos",
            baseFontSize: 18,
            theme: "zune",
            yAxisMaxValue: 70000,
            yAxisMinValue: 50000
        },
    };

    $scope.voltar = function () {
        window.location.reload();
    }
})