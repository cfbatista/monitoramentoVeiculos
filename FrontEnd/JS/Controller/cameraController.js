app.controller('cameraController', function ($scope, $routeParams, $location, authService, authConfig, toastr, usuarioService, cidadeService, AnaliseRotaService) {

    $scope.selecionar_orientacao = true;
    $scope.dados_Rota = true;
    $scope.botoes_Mapa = true;
    

    $scope.buscarCamerasPorSentido = function (direcao) {
        AnaliseRotaService.buscarCameraSentido(direcao).then(response => {
            $scope.camerasSentido = response.data;
        }).catch(error => console.log(error));
    }

    $scope.pegarCameras = function (RegistroCountModel) {
        AnaliseRotaService.listarPontosEspecificos(RegistroCountModel).then(response => {
            $scope.cameras = response.data;
        }).catch(error => console.log(error));
    }

    var directionsDisplay = new google.maps.DirectionsRenderer;
    var directionsService = new google.maps.DirectionsService;
    var NovoHamburgo = new google.maps.LatLng(-29.6918991, -51.1255697);


    function gerarMapa(cameras) {
        var map = new google.maps.Map(document.getElementById('map'), {
            center: NovoHamburgo,
            zoom: 10
        })
        directionsDisplay.setMap(map);
        for (let i = 0; i < cameras.length; i++) {
            var lat = cameras[i].camera.latitude;
            var long = cameras[i].camera.longitude;;
            LatLng = new google.maps.LatLng(lat, long);
            marker = new google.maps.Marker({
                position: LatLng,
                map: map
            });
        }
    }

    $scope.tracarRota = function(){
        gerarMapa($scope.cameras);
        gerarTrajeto($scope.cameras, directionsDisplay, directionsService);
    }

    function gerarTrajeto(cameras, directionsDisplay, directionsService) {
        var tamanho = cameras.length;
        var start = cameras[0].camera.latitude + ' , ' + cameras[0].camera.longitude;
        var end = cameras[tamanho - 1].camera.latitude + ' , ' + cameras[tamanho - 1].camera.longitude;

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
})