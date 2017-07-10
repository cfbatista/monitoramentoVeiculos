app.controller('ocorrenciaController',function($scope, $routeParams, $location, authService, authConfig, toastr, ocorrenciaService){

    $scope.obterOcorrencias = function obterOcorrencias(){
        ocorrenciaService.obterOcorrencias().then(response =>{
            $scope.ocorrencias = response.data;
        }).catch(error => console.log(error));
    }

    $scope.obterOcorrenciaUsuario = function obterOcorrenciaUsuario(usuario){
        ocorrenciaService.obterOcorrenciaUsuario(usuario).then(response => {
            $scope.registros = response.data;
        }).catch(error => console.log(error));
    }

    $scope.adicionarOcorrencia = (registro) => {
        ocorrencia.idUsuario = { id: usuario.id };
            usuarioService.adicionarOcorrencia(registro)
                .then(response => obterRegistro(usuario))
                .catch(error => console.log(error));
        }

    $scope.atualizarOcorrencia = function atualizarOcorrencia(ocorrencia){
            ocorrenciaService.atualizarOcorrencia(ocorrencia).then(response => {
        }).catch(error => console.log(error));
    }

    $scope.deletarOcorrencia = function deletarOcorrencia(ocorrencia){
            ocorrenciaService.deletarOcorrencia(ocorrencia).then(response => {
        }).catch(error => console.log(error));
    }

});