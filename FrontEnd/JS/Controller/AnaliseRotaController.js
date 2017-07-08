app.controller('analiseRotaController', function ($scope, $routeParams, $location, authService, authConfig, toastr) {

    $scope.radarPartida;
    $scope.radarChegada;
    initMap();

    var scheduledAnimationFrame;
    function readAndUpdatePage() {
        console.log('read and update');
        scheduledAnimationFrame = false;
    }

    function onScroll(evt) {

        // Store the scroll value for laterz.
        lastScrollY = window.scrollY;

        // Prevent multiple rAF callbacks.
        if (scheduledAnimationFrame) {
            return;
        }

        scheduledAnimationFrame = true;
        requestAnimationFrame(readAndUpdatePage);
    }

    window.addEventListener('scroll', onScroll);

    function initMap() {
        //array de posicoes para ser plotadas e seus pesos
        var heatMapData = [
            { location: new google.maps.LatLng(-29.658623, -51.140586), weight: 20 },
            new google.maps.LatLng(-29.658511, -51.140428),
            { location: new google.maps.LatLng(-29.680632, -51.142045), weight: 40 },
            { location: new google.maps.LatLng(-29.680623, -51.142222), weight: 60 },
            { location: new google.maps.LatLng(-29.714649, -51.147731), weight: 35 },
            new google.maps.LatLng(-29.714803, -51.147935),
            { location: new google.maps.LatLng(-29.736532, -51.149887), weight: 15 },

            { location: new google.maps.LatLng(-29.736495, -51.150129), weight: 45 },
            { location: new google.maps.LatLng(-29.75971, -51.148261), weight: 85 },
            new google.maps.LatLng(-29.759716, -51.148331),
            { location: new google.maps.LatLng(-29.758328, -51.145979), weight: 95 },
            { location: new google.maps.LatLng(-29.758403, -51.146017), weight: 30 }
        ];

        //posicao inicial do mapa
        var NovoHamburgo = new google.maps.LatLng(-29.6918991, -51.1255697);

        //inicializando o mapa
        var map = new google.maps.Map(document.getElementById('map'), {
            center: NovoHamburgo,
            zoom: 10
        });

        //componente que pega os dados do array para jogar na tela
        var heatmap = new google.maps.visualization.HeatmapLayer({
            data: heatMapData,
            radius: 50,
            scrollwheel: true,
            draggable: true,
            mapTypeId: google.maps.MapTypeId.ROADMAP
        });

        //Jogando na tela o mapa
        heatmap.setMap(map);
    }
})