/**
 * Created by Venelin on 25.11.2017 г..
 */

// Problem 1
function renderData(location) {
    console.log('Location: ' + location['name']);
    console.log('Longitude: ' + location['longitude'] + ' ' + 'Latitude ' + location['latitude'])
    console.log('Pokemons:');

    let pokemons = location['pokemons'];

    if (pokemons) {
        for (let key in pokemons) {
            let currentPokemon = pokemons[key];

            console.log('###Name: ' + currentPokemon.name);
            console.log('###Power: ' + currentPokemon.power + 'pp');
            console.log('###Evolved From: ' + currentPokemon.evolvedFrom);
            console.log('###Evolves To: ' + currentPokemon.evolvesTo);
        }
    }
}

// Problem 2
function renderDataInHTML(location) {
    let containerDiv = $('<div class="container">');
    let resultDiv = $('<div class="result">');

    let locationDiv = $('<div class="location">');
    let pokemonsDiv = $('<div class="pokemons">');

    renderLocation(locationDiv, location);
    renderPokemons(pokemonsDiv, location['pokemons']);

    resultDiv.append(locationDiv);

    resultDiv.append(pokemonsDiv);
    containerDiv.append(resultDiv);
    $('body').append(containerDiv);
}

function renderLocation(locationDiv, location) {
    let locationName = $(`<h1 class="location-name">Location: ${location['name']}</h1>`);
    let locationCoordinatesDiv =
        $('<div class="location-coordinates">')
        .append(`<h2 class="location-longitude">Longitude: ${location['longitude']}</h2>`)
        .append(`<h2 class="location-latitude">Latitude: ${location['latitude']}</h2>`);

    locationDiv.append(locationName);
    locationDiv.append(locationCoordinatesDiv);
}

function renderPokemons(pokemonsDiv, pokemons) {
    if (!pokemons) {
        return;
    }

    for (let key in pokemons) {
        let currentPokemon = pokemons[key];

        let pokemonDiv = $('<div class="pokemon">');
        let pokemonTitleDiv = $('<div class="pokemon-title">').text(currentPokemon['name']);
        let pokemonStatsDiv =
            $('<div class="pokemon-stats">')
                .append(`<div class="pokemon-name">Name: ${currentPokemon['name']}</div>`)
                .append(`<div class="pokemon-power">Power: ${currentPokemon['power']}pp</div>`)
                .append(`<div class="pokemon-evolved-from">Evolved From: ${currentPokemon['evolvedFrom']}</div>`)
                .append(`<div class="pokemon-evolves-to">Evolves To: ${currentPokemon['evolvesTo']}</div>`);

        pokemonDiv
            .append(pokemonTitleDiv)
            .append(pokemonStatsDiv);

        pokemonsDiv.append(pokemonDiv);
    }
}

// Problem 3
function attachEvents() {
    const locationInput = $('.location-input');

    $('.location-form > button').click(function (e) {
        e.preventDefault();

        let inputValue = locationInput.val();

        if (inputValue.length > 0 ) {
            $('.result').append(`<div class="result-element">${inputValue}</div>`);
        }

        locationInput.val('');
    });
}


// Problem 4
function attachFormEvents() {
    const locationInput = $('.location-input');

    $('.location-form > button').click(function (e) {
        e.preventDefault();

        let inputValue = locationInput.val();

        if (inputValue.length > 0) {
            obtainData(inputValue);
        }

        locationInput.val('');
    });
}

function obtainData(location) {
    const host = 'https://pokemoncodex.firebaseio.com/locations/';

    $
        .get(host + location + '.json')
        .then(renderLocationData)
        .catch((error) => console.log(error));
}

function renderLocationData(location) {
    const result = $('.result');

    result.empty();
    result.show();

    if (!location) {
        result.append('<div class="error">Error loading location.</div>');
        return;
    }

    let locationDiv = $('<div class="location">');
    let pokemonsDiv = $('<div class="pokemons">');

    renderLocation(locationDiv, location);
    renderPokemons(pokemonsDiv, location['pokemons']);

    result
        .append(locationDiv)
        .append(pokemonsDiv);

    attachAccordionEvents();
}

function attachAccordionEvents() {
    $('.pokemon-title').click(function (e) {
        e.preventDefault();

        let $this = $(this);

        if ($this.next().hasClass('show')) {
            $this.next().removeClass('show');
            $this.next().slideUp(350);
        } else {
            $this.parent().parent().find('.pokemon-stats').removeClass('show');
            $this.parent().parent().find('.pokemon-stats').slideUp(350);
            $this.next().toggleClass('show');
            $this.next().slideToggle(350);
        }
    })
}

attachFormEvents();