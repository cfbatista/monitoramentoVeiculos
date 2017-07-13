app.controller('adminController', function($scope, $routeParams, $location, authService, authConfig, toastr, usuarioService, autoridadeService, homeService, cidadeService){
    var usuario = $routeParams.id;
    var permissao;

    function obterPermissoes(usuario){
        usuarioService.obterPorRole(usuario).then(response => {
            permissao = response.data.role;
        }).catch(error => console.log(error));;
    }

    $scope.adicionarCamera = (camera) => {
            
        // function obterIdAtual(){
        //     var objetos = usuarioService.obterCameras();
        //     return objetos.length() + 1;    
        // }

        // camera.idCamera = {id: obterIdAtual()};
        usuarioService.adicionarCamera(camera).then(response => {
            toastr.sucess("Câmera adicionada com sucesso");
        }).catch(error => console.log(error));
    };
    
});