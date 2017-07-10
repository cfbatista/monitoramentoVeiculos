app.controller('cidadeController',function($scope, $routeParams, $location, authService, authConfig, toastr, cidadeService){

    $scope.obterCidade = function obterCidade(){
        cidadeService.obterCidade().then(response => {
            response.data;
        }).catch(error => console.log(error));
    }

    $scope.totalCidades = function totalCidades(){
        cidadeService.obterCidade().then(response => {
            response.data.length;
        }).catch(error => console.log(error));
    }

    $scope.adicionarCidade = function adicionarCidade(cidade){
        cidadeService.adicionarCidade(cidade).then(response => {
            response.data;
        }).catch(error => console.log(error));
    }

    $scope.atualizarCidade = function atualizarCidade(cidade){
        cidadeService.atualizarCidade(cidade).then(response => {
            response.data;
        }).catch(error => console.log(error));
    }

    $scope.deletarCidade = function deletarCidade(cidade){
        cidadeService.deletarCidade(cidade).then(response => {
        }).catch(error => console.log(error));
    }

});