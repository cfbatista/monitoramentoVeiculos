app.service('usuarioService', function($http){

    var url = 'http://localhost:9090';

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
        obterOcorrencia: obterOcorrencia,
        adicionarOcorrencia: adicionarOcorrencia,
        obterOcorrenciaUsuario: obterOcorrenciaUsuario,
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
        return $http.post(url+'/usuario/cadastrar', usuario);
    }

    function update(usuario){
        return $http.post(url, usuario);
    }

    function obterCameras(dataInicial, headerAuth) {
    return $http({
        url: urlBase, cliente,
        method: 'POST',
        headers: {
            Authorization: headerAuth
        },
            data: cliente
        });
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

    function obterOcorrencia(){
        return $http.get(url + '/registros');
    }

    function adicionarOcorrencia(registro){
        return $http.post(url, registro);
    }

    function obterOcorrenciaUsuario(id){
        return $http.get(url + '/registros/' + id);
    }

    function obterCidades(){
        return $http.get('http://localhost:9090/cidade');
    }

    function adicionarCidades(cidade){
        return $http.post(url, cidade);
    }
});