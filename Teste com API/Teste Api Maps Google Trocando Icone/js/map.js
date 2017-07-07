function initMap() {
    var keyMap = 'AIzaSyD7NfLfxZTzQYWnsfpnAVkUu7OuBABCKb4'
    var uluru = { lat: -29.658511, lng:-51.140428};
    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 12,
        center: uluru
    });
    var marker = new google.maps.Marker({
        position: uluru,
        map: map,
        icon: 'https://lh3.googleusercontent.com/csqhMWOAY1r4QDhQwkr038cfIDBRrDOWHt6JBoHX67A-mPt1zfQm_ESnVdHEhjDDFiCcxMZwltRNfes=w1304-h702'
    });
}