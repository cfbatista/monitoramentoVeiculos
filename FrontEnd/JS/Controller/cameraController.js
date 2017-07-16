app.controller('cameraController', function ($scope, $routeParams, $location, authService, authConfig, toastr, cameraService) {

    $scope.selecionar_camera = true;
    $scope.detalhes = false;

    $scope.buscarInformacoesCamera = function (RegistroCountModel) {
        buscarContagem(RegistroCountModel);
        buscarVelocidadeMedia(RegistroCountModel);
        buscarPlacasAcimaVelocidade(RegistroCountModel.idCameraInicial);
        buscarCameraPorId(RegistroCountModel.idCameraInicial);
        $scope.selecionar_camera = false;
        $scope.detalhes = true;
    }

    function buscarContagem(RegistroCountModel) {
        cameraService.obterContagemRegistrosPorRota(RegistroCountModel).then(response => {
            $scope.numeroVeiculos = response.data;
        });
    }

    function buscarVelocidadeMedia(RegistroCountModel) {
        cameraService.obterVelocidadeMedia(RegistroCountModel).then(response => {
            $scope.velocidadeMedia = response.data;
        });
    }

    function buscarPlacasAcimaVelocidade(idCameraInicial) {
        cameraService.obterPlacasAcimaVelocidade(idCameraInicial).then(response => {
            $scope.placasAcimaVelocidade = response.data;
            if($scope.placasAcimaVelocidade.length === 0){
                $scope.placasAcimaVelocidade = 0;
            }
        })
    }

    function buscarCameraPorId(idcamera) {
        cameraService.obterPorId(idcamera).then(response => {
            $scope.cameraDetalhada = response.data;
            plotarMapa($scope.cameraDetalhada.latitude, $scope.cameraDetalhada.longitude);
        })
    }

    function plotarMapa(latitude, longitude) {
        var map = new google.maps.Map(
            document.getElementById("map"), {
                center: new google.maps.LatLng(latitude, longitude),
                zoom: 14
            });
        var marker = new google.maps.Marker({
            position: new google.maps.LatLng(latitude, longitude),
            map: map
        });
    }

    pegarTodasAsCameras();
    function pegarTodasAsCameras() {
        cameraService.obterTodasCameras().then(response => {
            $scope.cameras = response.data;
        })
    }
})