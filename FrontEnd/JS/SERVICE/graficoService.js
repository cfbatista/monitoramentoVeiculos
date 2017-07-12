app.service('graficoService', function ($http) {

    return{
        obterCidades: obterCidades,
        totalVeiculos: totalVeiculos,
        // totalVeiculosClonados: totalVeiculosClonados,
        ocorrenciasUltimos3meses: ocorrenciasUltimos3meses
    }

    function obterCidades(){
        return $http.get('http://localhost:9090/cidade/obternumerocidades');
    }

    function totalVeiculos(){
        return $http.get('http://localhost:9090/veiculo/obterContagem');
    }

    // function totalVeiculosClonados(){
    //     return $http.get('http://localhost:9090/veiculo/clonados');
    // }

    function ocorrenciasUltimos3meses(){
        return $http.get('http://localhost:9090/ocorrencia/tresultimosmeses');
    }
});
