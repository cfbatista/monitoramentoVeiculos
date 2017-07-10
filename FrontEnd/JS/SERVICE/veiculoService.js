app.service('veiculoService', function($http){

    var url = 'http://localhost:9090/veiculo';

    return{
        obterVeiculo: obterVeiculo,
        obterVeiculoPlaca: obterVeiculoPlaca,
        obterVeiculoClonado: obterVeiculoClonado,
        adicionarVeiculo: adicionarVeiculo,
        atualizarVeiculo: atualizarVeiculo,
        deletarVeiculo: deletarVeiculo
    }

    function obterVeiculo(){
        return $http.get(url);
    }

    function obterVeiculoPlaca(placa){
        return $http.get(url + '/placa');
    }

    function obterVeiculoClonado(){
        return $http.get(url + '/clonado');
    }

    function adicionarVeiculo(veiculo){
        return $http.post(url, veiculo);
    }

    function atualizarVeiculo(veiculo){
        return $http.post(url, veiculo);
    }

    function deletarVeiculo(veiculo){
        return $http.delete(veiculo);
    }
});