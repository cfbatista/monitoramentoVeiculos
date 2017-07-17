app.controller('homeController', function ($scope, $routeParams, $location, authService, authConfig, toastr, usuarioService, graficoService, registroService) {

    totalCidades();
    function totalCidades() {
        graficoService.obterCidades().then(response => {
            $scope.totalCidades = response.data;
        }).catch(error => console.log(error));
    }

    totalVeiculos();
    function totalVeiculos() {
        graficoService.totalVeiculos().then(response => {
            $scope.totalVeiculos = response.data;
        }).catch(error => console.log(error));
    }

    ocorrenciasUltimos3meses();
    function ocorrenciasUltimos3meses() {
        graficoService.ocorrenciasUltimos3meses().then(response => {
            $scope.ocorrenciasUltimos3meses = response.data;
        }).catch(error => console.log(error));
    }

    totalVeiculosClonados();
    function totalVeiculosClonados() {
        registroService.buscarNumeroVeiculoClonados().then(response => {
            $scope.totalClonado = response.data;
        }).catch(error => console.log(error));
    }

     plotarMapa();
    function plotarMapa() {
        var NovoHamburgo = new google.maps.LatLng(-29.6918991, -51.1255697);
        var map = new google.maps.Map(
            document.getElementById("map"), {
                center: NovoHamburgo,
                zoom: 10
            });
    }

    $scope.logar = function () {
        $location.path("/login")
    }
});