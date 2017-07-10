app.service('graficoService', function ($http) {

    return{
        totalCidades: totalCidades,
        totalVeiculos: totalVeiculos,
        totalVeiculosClonados: totalVeiculosClonados,
        ocorrenciasUltimos3meses: ocorrenciasUltimos3meses
    }

    function totalCidades(){
        return $http.get('http://localhost:9090/registro/cidade');
    }

    function totalVeiculos(){
        return $http.get('http://localhost:9090/registro/veiculo');
    }

    function totalVeiculosClonados(){
        return $http.get('http://localhost:9090/registro/veiculo');
    }

    function ocorrenciasUltimos3meses(){
        return $http.get('http://localhost:9090/registro/veiculo');
    }
});
