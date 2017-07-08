app.controller('analiseRotaController', function ($scope, $routeParams, $location, authService, authConfig, toastr) {

    $scope.partida;
    $scope.chegada;
    $scope.radares = locations;
    var directionsDisplay = new google.maps.DirectionsRenderer;
    var directionsService = new google.maps.DirectionsService;
    var NovoHamburgo = new google.maps.LatLng(-29.6918991, -51.1255697);
    var map;
    var heatmap;
    var marker;
    var LatLng;

    //radares
    var locations = [
        [-29.658623, -51.140586, "Radar 1"],
        [-29.658511, -51.140428, "Radar 2"],
        [-29.680632, -51.142045, "Radar 3"],
        [-29.680623, -51.142222, "Radar 4"],
        [-29.714803, -51.147935, "Radar 5"],
        [-29.736532, -51.149887, "Radar 6"],
        [-29.736495, -51.150129, "Radar 7"],
        [-29.75971, -51.148261, "Radar 8"],
        [-29.759716, -51.148331, "Radar 9"],
        [-29.758328, -51.145979, "Radar 10"],
        [-29.758403, -51.146017, "Radar 11"]
    ];

    //pontos de calor
    var heatMapData = [
        { location: new google.maps.LatLng(-29.658623, -51.140586), weight: 20 }, new google.maps.LatLng(-29.658511, -51.140428),
        { location: new google.maps.LatLng(-29.680632, -51.142045), weight: 40 },
        { location: new google.maps.LatLng(-29.680623, -51.142222), weight: 60 },
        { location: new google.maps.LatLng(-29.714649, -51.147731), weight: 35 }, new google.maps.LatLng(-29.714803, -51.147935),
        { location: new google.maps.LatLng(-29.736532, -51.149887), weight: 15 },
        { location: new google.maps.LatLng(-29.736495, -51.150129), weight: 45 },
        { location: new google.maps.LatLng(-29.75971, -51.148261), weight: 85 }, new google.maps.LatLng(-29.759716, -51.148331),
        { location: new google.maps.LatLng(-29.758328, -51.145979), weight: 95 },
        { location: new google.maps.LatLng(-29.758403, -51.146017), weight: 30 }
    ];

    //funcao para mostrar o mapa com seus pontos de calor
    $scope.click = function () {
        map = new google.maps.Map(document.getElementById('map'), {
            center: NovoHamburgo,
            zoom: 10
        });
        heatmap = new google.maps.visualization.HeatmapLayer({
            data: heatMapData,
            radius: 50
        });
        heatmap.setMap(map);
        directionsDisplay.setMap(map);
        for (let i = 0; i < locations.length; i++) {
            var lat = locations[i][0];
            var long = locations[i][1];
            LatLng = new google.maps.LatLng(lat, long);
            marker = new google.maps.Marker({
                position: LatLng,
                map: map,
                icon: 'https://png.icons8.com/maximum-speed/office/40',
                animation: google.maps.Animation.BOUNCE
            });
        }
    }

    //funcao para tracar a rota
    $scope.tracarRota = function () {
        calculateAndDisplayRoute(directionsService, directionsDisplay);
    }

    //funcao para calcular a rota
    function calculateAndDisplayRoute(directionsService, directionsDisplay) {
        var start = $scope.partida[0] + ',' + $scope.partida[1];
        var end = $scope.chegada[0] + ',' + $scope.chegada[1];
        directionsService.route({
            origin: start,
            destination: end,
            travelMode: 'DRIVING'
        }, function (response, status) {
            if (status === 'OK') {
                console.log(response);
                directionsDisplay.setDirections(response);
            } else {
                window.alert('Directions request failed due to ' + status);
            }
        });
    }
})


// app.directive('analiseRota', function(){
//     return{
//         restrict: 'E',
//         template: '<div></div>',
//         replace: true,
//         link: function(scope, element, attrs){
//             var LatLng = new google.maps.LatLng(-29.6918991, -51.1255697);
//             var mapOptions = {
//                 center: LatLng,
//                 zoom: 16,
//                 mapTypeId: google.maps.MapTypeId.SATELLITE
//             };
//             var map = new google.maps.Map(document.getElementById(attrs.id), mapOptions);
//             var marker = new google.maps.Marker({
//                 position: LatLng,
//                 map: map,
//                 title: "teste"
//             });
//             marker.setMap(map);
//         }
//     }
// });