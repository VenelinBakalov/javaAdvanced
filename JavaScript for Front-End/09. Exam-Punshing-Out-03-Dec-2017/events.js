let punshes = {
    0: {
        name: "One Punsh Man",
        type: "Strong",
        contents: "Very little Vodka, Very little Brendy, Very little Wine, Very little Whiskey, Very little Tequila and a lot of Watermelon Juice.",
        description: "This punsh was discovered in an unknown house party, when there was almost no alcohol left, and the people had to combine a little from every alchohol. One Punsh of this is enough to knock you down for good, hence the name."
    },
    1: {
        name: "Wine Punsh",
        type: "Sweet",
        contents: "Wine, Apple Juice, Ice.",
        description: "Casual Wine Punsh, for the ladies that love wine. It is not very strong, it is actually sweet. Sweet enough to make them sweetly drunk and playful."
    },
    2: {
        name: "Punsh Out",
        type: "Sweet",
        contents: "Champagne, Watermellon Juice, Ice.",
        description: "This is a very sweet, almost non-alchoholic, punsh. Very suitable for ladies, which want to keep their manners but have a little fun at a party."
    }
};

attachPunshesEvents(punshes);

const contentDiv = $('.content');

function attachPunshesEvents(punshes) {

    renderAllPunshesInHTML(punshes);

    $('.navbar-item').on('click', attachClickEvent);

    function attachClickEvent() {
        let punshName = $(this).find('h4').text();

        $(this).parent().remove();

        renderSinglePunshInHTML(punshes, punshName);
        attachBackEvents(punshes);
    }
}

function attachBackEvents(punshes) {
    $('.content-heading ').on('click', attachBackClickEvent);

    function attachBackClickEvent() {
        contentDiv.empty();
        attachPunshesEvents(punshes);
    }
}

function renderAllPunshesInHTML(punshes) {
    let navbarDiv = $('.navbar');

    let navbarItemsDiv = $('<div>')
        .addClass('navbar-items');

    for (let index in punshes) {
        let punsh = punshes[index];
        let punshDiv = $('<div>')
            .addClass('navbar-item')
            .append(
                $('<h4>')
                    .text(punsh['name'])
            );

        navbarItemsDiv.append(punshDiv);
    }

    navbarDiv.append(navbarItemsDiv);
}

function renderSinglePunshInHTML(punshes, punshName) {
    let contentHeaderDiv = $('<div>')
        .addClass('content-header')
        .css('cursor', 'pointer');

    let punshDataDiv = $('<div>')
        .addClass('punsh-data');

    for (let index in punshes) {
        let punsh = punshes[index];

        if (punsh['name'] !== punshName) continue;

        appendHeading(punsh);
        appendPunshData(punsh);

        break;
    }

    contentDiv
        .append(contentHeaderDiv)
        .append(punshDataDiv);

    // Private functions
    function appendHeading(punsh) {
        let contentHeadingDiv = $('<div>')
            .addClass('content-heading')
            .text(punsh['name']);

        contentHeaderDiv.append(contentHeadingDiv);
    }

    function appendPunshData(punsh) {
        let punshTypeDiv = $('<div>')
            .addClass('punsh-type')
            .append(
                $('<label>')
                    .text('Type: '))
            .append(
                $('<h6>')
                    .text(punsh['type'])
            );

        let punshContentsDiv = $('<div>')
            .addClass('punsh-contents')
            .append(
                $('<label>')
                    .text('Contents: '))
            .append(
                $('<p>')
                    .text(punsh['contents'])
            );

        let punshDescriptionDiv = $('<div>')
            .addClass('punsh-description')
            .append(
                $('<label>')
                    .text('Description: '))
            .append(
                $('<p>')
                    .text(punsh['description'])
            );

        punshDataDiv
            .append(punshTypeDiv)
            .append(punshContentsDiv)
            .append(punshDescriptionDiv);
    }
}