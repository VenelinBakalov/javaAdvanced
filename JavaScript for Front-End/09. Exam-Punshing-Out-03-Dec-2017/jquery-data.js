let punshes = {
    0: {
        name: "Punsh - The American Pie",
        type: "Strong",
        contents: "Some Apple Pie, Whiskey, Vodka, Orange Juice and some other things...",
        description: "By original recipe from the American Pie franchise, this punsh includes everything you would want in a college/university party."
    },
    1: {
        name: "Brendy Punsh",
        type: "Medium",
        contents: "Brendy, Apple Juice, Ice, Avocado Juice, some other strange fruits...",
        description: "The casual Brendy Punsh, quite expensive, nothing interesting here..."
    },
    2: {
        name: "Just Punsh it",
        type: "Sweet",
        contents: "Very Little Vodka, Orange Juice, Apple Juice, Banana Juice, Ice.",
        description: "A very comfortable taste for the lovers of weakly alchoholic drinks. The Just Pinsh It punsh is a sweet multi-vitamol drink, which cannot drunk you."
    }
};

renderAllPunshesInHTML(punshes);
renderSinglePunshInHTML(punshes, "Punsh - The American Pie");

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
    const contentDiv = $('.content');

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