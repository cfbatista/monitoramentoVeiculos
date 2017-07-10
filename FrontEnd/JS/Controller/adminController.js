app.controller('adminController', function($scope, $routeParams, $location, authService, authConfig, toastr, usuarioService, autoridadeController, usuarioController, homeController){
    var usuario = $routeParams.id;
    var permissao;

    function obterPermissoes(usuario){
        usuarioService.obterPorRole(usuario).then(response => {
            permissao = response.data.role;
        }).catch(error => console.log(error));;
    }

    if(permissao === 'AUTORIDADE' && permissao === 'ADMINISTRADOR'){
        
        $scope.adicionarCamera = (camera) => {
            
            function obterIdAtual(){
                var objetos = obterCameras();
                return objetos.length() + 1;    
            }

            camera.idCamera = {id: obterIdAtual()};
            usuarioService.adicionarCamera().then(response => {
                toastr.sucess("Câmera adicionada com sucesso");
            }).catch(error => console.log(error));
        };
    }
});