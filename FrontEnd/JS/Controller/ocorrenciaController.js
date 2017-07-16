app.controller('ocorrenciaController', function ($scope, $routeParams, $location, authService, authConfig, toastr, ocorrenciaService, veiculoService) {

    $scope.mostrarOcorrencia = true;
    $scope.view = true;
    $scope.detalhesOcorrencia = false;

    $scope.cadastro = function () {
        $location.path('/cadastroOcorrencia');
    }
    $scope.consulta = function () {
        $location.path('/consultaOcorrencia');
    }

    obterOcorrencias();
    function obterOcorrencias() {
        ocorrenciaService.obterTodasOcorrencias().then(response => {
            $scope.ocorrencias = response.data;
        }).catch(error => console.log(error));
    }

    $scope.verOcorrencia = function (id) {
        $scope.view = false;
        ocorrenciaService.obterOcorrenciaId(id).then(response => {
            $scope.ocorrenciaDetalhe = response.data;
            gerarMapaOcorrencia($scope.ocorrenciaDetalhe.latitude, $scope.ocorrenciaDetalhe.longitude)
            $scope.detalhesOcorrencia = true;
            $scope.mostrarOcorrencia = false;
        }).catch(error => console.log(error));
    }

    $scope.adicionarOcorrencia = (registro) => {
        ocorrencia.idUsuario = { id: usuario.id };
        usuarioService.adicionarOcorrencia(registro)
            .then(response => obterRegistro(usuario))
            .catch(error => console.log(error));
    }

    $scope.atualizarOcorrencia = function atualizarOcorrencia(ocorrencia) {
        ocorrenciaService.atualizarOcorrencia(ocorrencia).then(response => {
        }).catch(error => console.log(error));
    }

    $scope.deletarOcorrencia = function deletarOcorrencia(ocorrencia) {
        ocorrenciaService.deletarOcorrencia(ocorrencia).then(response => {
        }).catch(error => console.log(error));
    }

    function gerarMapaOcorrencia(latitude, longitude) {
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

    $scope.voltar = function () {
        $scope.mostrarOcorrencia = true;
        $scope.view = true;
        $scope.detalhesOcorrencia = false;
    }
});