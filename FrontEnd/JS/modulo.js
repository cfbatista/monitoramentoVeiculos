var app = angular.module('modulo', ['ngRoute', 'auth', 'toastr', 'uiGmapgoogle-maps']);

// (function() {
//     'use strict';

//     angular
//         .module('app.dpa', [
//           'ngRoute',
//           'ngCookies',
//           'auth',
//           'toastr',
//           'app.dpa.login',
//           'app.dpa.home'
//         ]);
// })();



app.constant('authConfig',{
    urlUsuario: 'http://localhost:9090/usuario',

    urlLogin: '/login',

    urlPrivada: '/home',

    urlLogout: '/login'
});