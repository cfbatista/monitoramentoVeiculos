var app = angular.module('modulo', ['ngRoute', 'auth', 'toastr', 'uiGmapgoogle-maps', 'ng-fusioncharts']);

app.constant('authConfig', {
    urlUsuario: 'http://localhost:9090/usuario',
    urlLogin: '/login',
    urlPrivada: '/home',
    urlLogout: '/login'
});

app.filter('formataSexo', function () {
    return function (sexo) {
        if (sexo === 'F') {
            return 'Feminino';
        } else if (sexo === 'M') {
            return 'Masculino';
        }
        return 'Não Informado';
    };
});

app.filter('tiposOcorrencia', function () {
    return function (tipo) {
        if (tipo === 'R') {
            return 'Roubo';
        } else if (tipo === 'S') {
            return 'Sequestro';
        }
        return 'Furto';
    };
});

app.filter('simOuNao', function () {
    return function (tipo) {
        if (tipo === 'S') {
            return 'Sim';
        } else if (tipo === 'N') {
            return 'Não';
        }
        return 'Furto';
    };
});

app.filter('situacao', function () {
    return function (tipo) {
        if (tipo === 'A') {
            return 'Aberto';
        } else if (tipo === 'E') {
            return 'Encerrado';
        }
        return 'Resolvido';
    };
});
