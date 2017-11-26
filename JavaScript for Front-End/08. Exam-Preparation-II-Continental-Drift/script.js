/**
 * Created by Venelin on 26.11.2017 г..
 */

// Problem 1
function renderAllContinents(continents) {
    for (let key in continents) {
        let continent = continents[key];
        console.log(continent['name']);
    }
}


function renderSingleContinent(continent) {
    console.log(continent['name']);
    console.log("Countries");

    let countries = continent['countries'];
    for (let key in countries) {
        let country = countries[key];
        console.log("$$$" + country['name']);
    }
}

function renderSingleCountry(country) {
    console.log(country['name']);
    console.log("Capital: " + country['capital']);
    console.log("Official Language: " + country['officialLanguage']);
    console.log("Population: " + country['population']);
    console.log("Area: " + country['area'] + ' km2');
    console.log("Political Status: " + country['politicalStatus']);

    if (country['politicalStatus'] === 'Republic') {
        console.log("President: " + country['president']);
    } else {
        console.log("Monarch: " + country['monarch']);

    }
    console.log("Official Currency: " + country['officialCurrency']);
}

// Problem 2
function renderDataInHTML(continents) {
    const continentsDiv = $('.continents');
    const continentDataDiv = $('.continent-data');
    const continentCountry = $('.continent-country');

    renderAllContinentsInHtml(continents);

    // Private functions
    function renderAllContinentsInHtml(continents) {
        for (let key in continents) {
            let continent = continents[key];

            let continentDiv = $('<div>').addClass('continent')
                .append(
                    $('<h5>')
                        .addClass('continent-title')
                        .text(continent['name']));

            continentsDiv.append(continentDiv);

            renderSingleContinentInHtml(continent);
        }
    }

    function renderSingleContinentInHtml(continent) {
        let countriesDiv = $('<div>')
            .addClass('countries');

        let dropdownSelect = $('<select>')
            .addClass('dropdown-select')
            .append('<option disabled selected value> -- select an option -- </option>');

        let countries = continent['countries'];
        for (let key in countries) {
            let country = countries[key];

            dropdownSelect
                .append($('<option>')
                    .attr('value', country['name'])
                    .text(country['name']));

            renderSingleCountryInHtml(country);
        }

        countriesDiv.append(dropdownSelect);

        // Render image
        let continentImageDiv = $('<div>')
            .addClass('continent-image')
            .append($('<img>')
                .attr('src', 'images/' + continent['name'].toLowerCase() + '.png'));

        continentDataDiv
            .append($('<h2>')
                .addClass('continent-title')
                .text(continent['name']))
            .append($('<h3>')
                .addClass('countries-title')
                .text('Countries'))
            .append(countriesDiv)
            .append(continentImageDiv);
    }

    function renderSingleCountryInHtml(country) {
        let countryTitle = $('<div>')
            .addClass('country-title')
            .append($('<h2>')
                .text(country['name']));

        let countryData = $('<div>')
            .addClass('country-data')
            .append('<div class="country-capital"><strong>Capital:</strong> <div>' + country['capital'] + '</div></div>')
            .append('<div class="country-official-language"><strong>Official Language:</strong><div>' + country['officialLanguage'] + '</div></div>')
            .append('<div class="country-population"><strong>Population:</strong> <div>' + country['population'] + '</div></div>')
            .append('<div class="country-area"><strong>Area:</strong> <div>' + country['area'] + ' km<sup>2</sup></div></div>')
            .append('<div class="country-political-status"><strong>Political Status:</strong><div>' + country['politicalStatus'] + '</div></div>')
            .append(
                country['politicalStatus'] === 'Republic'
                ? '<div class="country-president"><strong>President:</strong><div>' + country['president'] + '</div></div>'
                : '<div class="country-monarch"><strong>Monarch:</strong><div>' + country['monarch'] + '</div></div>')
            .append('<div class="country-official-currency"><strong>Official Currency:</strong><div>' + country['officialCurrency'] + '</div></div>');

        continentCountry
            .append(countryTitle)
            .append(countryData);
    }
}

// Problem 3
const continentsDiv = $('.continents');
const continentDataDiv = $('.continent-data');
const continentCountryDiv = $('.continent-country');
const continentCountry = $('.continent-country');

function showData() {
    continentDataDiv.show();
    continentCountryDiv.show();
}

function hideData() {
    continentDataDiv.hide();
    continentCountryDiv.hide();
}

function clearData() {
    continentDataDiv.empty();
    continentCountryDiv.empty();
}

function attachEvents(continents) {
    attachContinentEvents();

    // Private functions
    function attachContinentEvents() {
        $('.continent').click(function (e) {
            e.preventDefault();

            if ($(this).hasClass('shown')) {
                $(this).removeClass('shown');

                hideData();
                clearData();
            } else {
                clearData();

                $(this).parent().find('.shown').removeClass('shown');
                $(this).addClass('shown');

                let continentName = $(this).find('.continent-title').text();

                renderSingleContinentInHtml(continents[continentName]);

                attachCountryEvents(continents[continentName]);
                showData();
            }

        })
    }

    function attachCountryEvents(continent) {
        $('.dropdown-select').change(function (e) {
            e.preventDefault();

            let countryName = $(this).val();

            renderSingleCountryInHtml(continent['countries'][countryName]);
        });
    }
}

function renderAllContinentsInHtml(continents) {
    for (let key in continents) {
        let continent = continents[key];

        let continentDiv = $('<div>').addClass('continent')
            .append(
                $('<h5>')
                    .addClass('continent-title')
                    .text(continent['name']));

        continentsDiv.append(continentDiv);
    }
}

function renderSingleContinentInHtml(continent) {
    let countriesDiv = $('<div>')
        .addClass('countries');

    let dropdownSelect = $('<select>')
        .addClass('dropdown-select')
        .append('<option disabled selected value> -- select an option -- </option>');

    let countries = continent['countries'];
    for (let key in countries) {
        let country = countries[key];

        dropdownSelect
            .append($('<option>')
                .attr('value', country['name'])
                .text(country['name']));
    }

    countriesDiv.append(dropdownSelect);

    // Render image
    let continentImageDiv = $('<div>')
        .addClass('continent-image')
        .append($('<img>')
            .attr('src', 'images/' + continent['name'].toLowerCase() + '.png'));

    continentDataDiv
        .append($('<h2>')
            .addClass('continent-title')
            .text(continent['name']))
        .append($('<h3>')
            .addClass('countries-title')
            .text('Countries'))
        .append(countriesDiv)
        .append(continentImageDiv);
}

function renderSingleCountryInHtml(country) {
    let countryTitle = $('<div>')
        .addClass('country-title')
        .append($('<h2>')
            .text(country['name']));

    let countryData = $('<div>')
        .addClass('country-data')
        .append('<div class="country-capital"><strong>Capital:</strong> <div>' + country['capital'] + '</div></div>')
        .append('<div class="country-official-language"><strong>Official Language:</strong><div>' + country['officialLanguage'] + '</div></div>')
        .append('<div class="country-population"><strong>Population:</strong> <div>' + country['population'] + '</div></div>')
        .append('<div class="country-area"><strong>Area:</strong> <div>' + country['area'] + ' km<sup>2</sup></div></div>')
        .append('<div class="country-political-status"><strong>Political Status:</strong><div>' + country['politicalStatus'] + '</div></div>')
        .append(
            country['politicalStatus'] === 'Republic'
                ? '<div class="country-president"><strong>President:</strong><div>' + country['president'] + '</div></div>'
                : '<div class="country-monarch"><strong>Monarch:</strong><div>' + country['monarch'] + '</div></div>')
        .append('<div class="country-official-currency"><strong>Official Currency:</strong><div>' + country['officialCurrency'] + '</div></div>');

    continentCountry
        .append(countryTitle)
        .append(countryData);
}

function renderDataInHTML_P03(continents) {
    renderAllContinentsInHtml(continents);
}

let continents = {
    Europe: {
        name: "Europe",
        countries: {
            Bulgaria: {
                name: "Bulgaria",
                capital: "Sofia",
                officialLanguage: "Bulgarian",
                population: 7000000,
                area: 111000,
                politicalStatus: "Republic",
                president: "Rumen Radev",
                officialCurrency: "LEV(BGN)"
            },
            Vatican: {
                name: "Vatican",
                capital: "Vatican City",
                officialLanguage: "Italian",
                population: 1000,
                area: 0.44,
                politicalStatus: "Monarchy",
                monarch: "Francis",
                officialCurrency: "Euro(EUR)"
            }
        }
    },
    Asia: {
        name: "Asia",
        countries: {
            Russia: {
                name: "Russia",
                capital: "Moscow",
                officialLanguage: "Russian",
                population: 144463451,
                area: 17075200,
                politicalStatus: "Republic",
                president: "Vladimir Putin",
                officialCurrency: "Russian ruble(RUB)"
            },
            China: {
                name: "China",
                capital: "Beijing",
                officialLanguage: "Chinese",
                population: 1403500365,
                area: 9596961,
                politicalStatus: "Republic",
                president: "Xi Jinping",
                officialCurrency: "Renminbi(CNY)"
            }
        }
    }
};

let continents_p01 = {
    Europe: {
        name: "Europe",
        countries: {
            Bulgaria: {
                name: "Bulgaria",
                capital: "Sofia",
                officialLanguage: "Bulgarian",
                population: 7000000,
                area: 111000,
                politicalStatus: "Republic",
                president: "Rumen Radev",
                officialCurrency: "LEV(BGN)"
            },
            Vatican: {
                name: "Vatican",
                capital: "Vatican City",
                officialLanguage: "Italian",
                population: 1000,
                area: 0.44,
                politicalStatus: "Monarchy",
                monarch: "Francis",
                officialCurrency: "Euro(EUR)"
            }
        }
    },
    Asia: {
        name: "Asia",
        countries: {
            Russia: {
                name: "Russia",
                capital: "Moscow",
                officialLanguage: "Russian",
                population: 144463451,
                area: 17075200,
                politicalStatus: "Republic",
                president: "Vladimir Putin",
                officialCurrency: "Russian ruble(RUB)"
            },
            China: {
                name: "China",
                capital: "Beijing",
                officialLanguage: "Chinese",
                population: 1403500365,
                area: 9596961,
                politicalStatus: "Republic",
                president: "Xi Jinping",
                officialCurrency: "Renminbi(CNY)"
            }
        }
    }
};

let continentsForHtml = {
    Europe: {
        name: "Europe",
        countries: {
            Bulgaria: {
                name: "Bulgaria",
                capital: "Sofia",
                officialLanguage: "Bulgarian",
                population: 7000000,
                area: 111000,
                politicalStatus: "Republic",
                president: "Rumen Radev",
                officialCurrency: "LEV(BGN)"
            }
        }
    }
};


// renderAllContinents(continents);
// renderSingleContinent(continents['Europe']);
// renderSingleCountry(continents['Europe']['countries']['Bulgaria']);

// renderDataInHTML(continentsForHtml);

renderAllContinentsInHtml(continents);
attachEvents(continents);

