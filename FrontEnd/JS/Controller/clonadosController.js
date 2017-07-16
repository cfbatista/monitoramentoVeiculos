app.controller('clonadosController', function ($scope, $routeParams, $location, authService, authConfig, toastr, registroService, veiculoService) {

    $scope.clonados = true;
    $scope.clonado = false;
    $scope.view = true;
    $scope.loading = false;

    obterVeiculosClonados();

    function obterVeiculosClonados() {
        registroService.buscarVeiculosSuspeitosClonagem().then(response => {
            $scope.veiculosClonados = response.data;
        }).catch(error => toastr.error("Não há registros de veículos clonados na base!"));
    }

    $scope.buscarVeiculo = function (placa) {
        $scope.view = false;
        $scope.loading = true;
        veiculoService.obterVeiculoPorPlaca(placa).then(response => {
            $scope.veiculoBuscado = response.data;
            initialize($scope.veiculoBuscado.cidade.nome + ',' + 'Br');
            $scope.clonados = false;
            $scope.clonado = true;
        }).catch(error => toastr.error("Não é possivel buscar este veiculo da base!"));
    };

    function initialize(address) {
        var geocoder = new google.maps.Geocoder();
        geocoder.geocode({
            'address': address
        }, function (results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                var Lat = results[0].geometry.location.lat();
                var Lng = results[0].geometry.location.lng();
                var map = new google.maps.Map(
                    document.getElementById("map"), {
                        center: new google.maps.LatLng(Lat, Lng),
                        zoom: 12
                    });
                var marker = new google.maps.Marker({
                    position: new google.maps.LatLng(Lat, Lng),
                    map: map
                });
            } else {
                toastr.error("Algo deu errado!");
            }
        });
    }

    $scope.voltar = function () {
        $scope.clonados = true;
        $scope.clonado = false;
        $scope.view = true;
        $scope.loading = false;
    }
})