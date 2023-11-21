let map;
let autocomplete;

function initMap() {
    // 지도 초기화
    map = new google.maps.Map(document.getElementById('map'), {
        zoom: 7,
        center: { lat: 36.5, lng: 127.9 } // 대한민국의 중심 좌표
    });

    // Autocomplete 객체 생성
    autocomplete = new google.maps.places.Autocomplete(
        document.getElementById('autocomplete')
    );

    // Autocomplete 이벤트 리스너 설정
    autocomplete.addListener('place_changed', onPlaceSelected);
}

function onPlaceSelected() {
    var place = autocomplete.getPlace();

    if (!place.geometry || !place.geometry.location) {
        console.error("Place information is incomplete or missing.");
        return;
    }

    // 지도 중심 이동 및 마커 설정
    map.panTo(place.geometry.location);
    map.setZoom(15);
    new google.maps.Marker({
        map: map,
        position: place.geometry.location,
        title: place.name
    });
}

function searchPlaces() {
    var input = document.getElementById('autocomplete').value;

    // 검색어가 지역 또는 주소인지 판별
    var isAddressSearch = input.match(/^\d/) !== null; // 숫자로 시작하는지를 기준으로 판별

    if (isAddressSearch) {
        // Geocoding API를 사용하여 지역명 또는 주소 검색
        var geocoder = new google.maps.Geocoder();
        geocoder.geocode({ 'address': input }, function (geoResults, geoStatus) {
            if (geoStatus === 'OK') {
                // 지역명 또는 주소 검색 결과 처리
                map.setCenter(geoResults[0].geometry.location);
                map.setZoom(13); // 지역 전체를 보여주기 위한 줌 레벨
            } else {
                console.error("Geocoding API returned no results.");
            }
        });
    } else {
        // Places API를 사용하여 특정 장소 검색 (음식점 상세 등)
        var service = new google.maps.places.PlacesService(map);
        service.findPlaceFromQuery({
            query: input,
            fields: ['name', 'geometry'],
        }, function (placeResults, placeStatus) {
            if (placeStatus === google.maps.places.PlacesServiceStatus.OK && placeResults.length > 0) {
                // 특정 장소 검색 결과 처리
                map.panTo(placeResults[0].geometry.location);
                map.setZoom(15);
                new google.maps.Marker({
                    position: placeResults[0].geometry.location,
                    map: map,
                    title: placeResults[0].name
                });
            } else {
                console.error("Places API returned no results.");
            }
        });
    }
}

// initMap 함수 호출
initMap();

// 검색창에 엔터 키 이벤트 추가
document.getElementById('autocomplete').addEventListener('keydown', function (e) {
    if (e.key === 'Enter') {
        e.preventDefault(); // 엔터 키의 기본 동작 방지
        searchPlaces();
    }
});
