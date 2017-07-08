app.service('usuarioService', function($http){

    var url = 'http://localhost:9090/usuario';

    return{
        obter: obter,
        obterPorRole: obterPorRole,
        obterPorId: obterPorId,
        adicionar: adicionar,
        update: update
    }

    function obter(){
        return $http.get(url);
    }

    function obterPorRole(role){
        return $http.get(url + 'role?role=' + role);
    }

    function obterPorId(id){
        return $http.get(url + 'id?id=' + id);
    }

    function adicionar(usuario){
        return $http.post(url, usuario);
    }

    function update(usuario){
        return $http.post(url, usuario);
    }
});