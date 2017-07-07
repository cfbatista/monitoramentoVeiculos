app.factory('mapasService', function ($https) {

    let urlBase = 'http://maps.googleapis.com/maps/api/distancematrix/json?origins=';
    let chave = 'AIzaSyCZYtqYbqniX8mMyFjOpb3JlRVZ0NsKm1s';

    function buscarMapa(origem, destino) {
        let url = urlBase + origem + '&destinations=' + destino + ':&key=' + chave;
        return $https.get(url);
    }

    return {
        buscarMapa: buscarMapa
    };
})