var app = angular.module('modulo', ['ngRoute', 'auth', 'toastr', 'uiGmapgoogle-maps']);

app.constant('authConfig',{
    urlUsuario: 'http://localhost:9090/usuario',

    urlLogin: '/login',

    urlPrivada: '/home',

    urlLogout: '/login'
});