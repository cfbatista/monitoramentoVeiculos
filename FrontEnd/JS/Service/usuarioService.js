app.service('usuarioService', function($http){

    var url = 'http://localhost:9090/usuario';

    return{
        obterUsuario: obterUsuario,
        obterPorRole: obterPorRole,
        obterPorId: obterPorId,
        adicionarUsuario: adicionarUsuario,
        updateUsuario: updateUsuario,
        obterCameras: obterCameras
       
    }

    function obterUsuario(){
        return $http.get(url);
    }

    function obterPorRole(role){
        return $http.get(url + '/role?role=' + role);
    }

    function obterPorId(id){
        return $http.get(url + '/id?id=' + id);
    }

    function adicionarUsuario(usuario){
        return $http.post(url+'/cadastrar', usuario);
    }

    function updateUsuario(usuario){
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
});