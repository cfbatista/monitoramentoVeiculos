let app = angular.module('app', []);

app.controller('MainController', function ($scope) {

    $scope.radarPartida;
    $scope.radarChegada;

    var a = 'https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&origins=40.6655101,-73.89188969999998&destinations=40.6905615%2C-73.9976592%7C40.6905615%2C-73.9976592%7C40.6905615%2C-73.9976592%7C40.6905615%2C-73.9976592%7C40.6905615%2C-73.9976592%7C40.6905615%2C-73.9976592%7C40.659569%2C-73.933783%7C40.729029%2C-73.851524%7C40.6860072%2C-73.6334271%7C40.598566%2C-73.7527626%7C40.659569%2C-73.933783%7C40.729029%2C-73.851524%7C40.6860072%2C-73.6334271%7C40.598566%2C-73.7527626&key=YOUR_API_KEY';

    $scope.pegarDadosRadares = function (radarA, radarB) {
        console.log(radarA.nome);
        console.log(radarB.lgn);
        //initMap();
    }

    function initMap(){
        var uluru = { lat:  $scope.radarPartida.lat, lng: $scope.radarChegada.lng };
        var map = new google.maps.Map(document.getElementById('map'), {
            zoom: 12,
            center: uluru
        })

        var uluru2 = { lat: $scope.radarPartida.lat, lng: $scope.radarChegada.lng };
        var map2 = new google.maps.Map(document.getElementById('map'), {
            zoom: 12,
            center: uluru2
        })

        var marker = new google.maps.Marker({
            position: uluru, uluru2,
            map: map,
            icon: 'https://lh3.googleusercontent.com/csqhMWOAY1r4QDhQwkr038cfIDBRrDOWHt6JBoHX67A-mPt1zfQm_ESnVdHEhjDDFiCcxMZwltRNfes=w1304-h702'
        });
    }

    $scope.radares = [{
        nome: 'Radar 1',
        lat: -29.658511,
        lng: -51.140428
    },
    {
        nome: 'Radar 2',
        lat: -29.680632,
        lng: -51.142045
    },
    {
        nome: 'Radar 3',
        lat: -29.680632,
        lng: -51.140586
    },
    {
        nome: 'Radar 4',
        lat: -29.658623,
        lng: -51.142222
    },
    {
        nome: 'Radar 5',
        lat: -29.714649,
        lng: -51.147731
    },
    {
        nome: 'Radar 6',
        lat: -29.714803,
        lng: -51.147935
    }];
});