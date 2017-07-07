app.controller('mapasController', function ($scope, mapasService) {

    $scope.origem;
    $scope.destino;

    $scope.pegerCoordernadas = function (origem, destino) {
        mapasService.buscarMapa(origem, destino).then(function (response) {
            $scope.mapa = response;
            debugger;
            console.log($scope.mapa);
        })
    }
})
