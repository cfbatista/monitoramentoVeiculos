app.controller('registroController',function($scope, $routeParams, $location, authService, authConfig, toastr, registroService){

    $scope.obterRegistros = function obterRegistros(){
        registroService.obterRegistros().then(Response => {
            response.data;
        }).catch(error => console.log(error));
    }

    $scope.adicionarRegistro = function adicionarRegistro(registro){
        registroService.adicionarRegistro(registro).then(response => {
            response.data;
        }).catch(error => console.log(error));
    }

    $scope.atualizarRegistro = function atualizarRegistro(registro){
        registroService.atualizarRegistro(registro).then(response => {
            response.data;
        }).catch(error => console.log(error));
    }

    $scope.deletarRegistro = function deletarRegistro(registro){
        registroService.deletarRegistro(registro).then(response => {

        }).catch(error => console.log(error));
    }
});