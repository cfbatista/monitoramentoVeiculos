app.service('usuarioService', function($http){

    var url = 'http://localhost:9090/usuario';

    return{
        obter: obter,
        obterPorRole: obterPorRole,
        obterPorId: obterPorId,
        adicionar: adicionar,
        update: update,
        obterCameras: obterCameras,
        adicionarCameras: adicionarCameras,
        obterVeiculos: obterVeiculos,
        obterVeiculoPlaca: obterVeiculoPlaca,
        obterVeiculoClonado: obterVeiculoClonado,
        adicionarVeiculo: adicionarVeiculo,
        obterRegistro: obterRegistro,
        adicionarRegistro: adicionarRegistro,
        obterCidades: obterCidades,
        adicionarCidades: adicionarCidades        
    }

    function obter(){
        return $http.get(url);
    }

    function obterPorRole(role){
        return $http.get(url + '/role?role=' + role);
    }

    function obterPorId(id){
        return $http.get(url + '/id?id=' + id);
    }

    function adicionar(usuario){
        return $http.post(url, usuario);
    }

    function update(usuario){
        return $http.post(url, usuario);
    }

    function obterCameras(){
        return $http.get(url + '/cameras');
    }

    function adicionarCameras(cameras){
        return $http.post(url, cameras);
    }

    function obterVeiculos(){
        return $http.get(url + '/veiculos');
    }

    function obterVeiculoPlaca(placa){
        return $http.get(url + '/veiculo/placa');
    }

    function obterVeiculoClonado(placa){
        return $http.get(url + '/veiculo/clonado');
    }

    function adicionarVeiculo(veiculo){
        return $http.post(url, veiculo);
    }

    function obterRegistro(){
        return $http.get(url + '/registros');
    }

    function adicionarRegistro(registro){
        return $http.post(url, registro);
    }

    function obterCidades(){
        return $http.get(url + '/cidades');
    }

    function adicionarCidades(cidade){
        return $http.post(url, cidade);
    }
});