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
});