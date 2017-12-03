$(() => {
    // Constants
    const contentDiv = $('.content');

    getAllPunshes();

    /* Functions */
    // AJAX requests
    function getAllPunshes() {
        let host = 'https://punsh-master.firebaseio.com/data/punshes.json';

        $.ajax({
            url: host,
            method: "GET",
            success: success,
            error: error
        });

        function success(response) {
            renderAllPunshesInHTML(response);
        }
        function error(e) {
            console.log(e);
        }
    }
    function getSinglePunsh(index, punshes) {
        let host = 'https://punsh-master.firebaseio.com/data/punshes/';

        $.ajax({
            url: host + index + '.json',
            method: "GET",
            success: success,
            error: error,
            complete: complete
        });

        function success(punsh) {
            renderSinglePunshInHTML(punsh);
        }
        function error(e) {
            console.log(e);
        }
        function complete() {
            attachBackEvents(punshes);
        }
    }

    // Attach event listeners
    function attachPunshesEvents(punshes) {
        $('.navbar-item').on('click', attachClickEvent);

        function attachClickEvent() {
            let punshIndex = $(this).find('h4').attr('index');

            $(this).parent().remove();

            getSinglePunsh(punshIndex, punshes);
        }
    }

    function attachBackEvents(punshes) {
        $('.content-heading').on('click', attachBackClickEvent);

        function attachBackClickEvent() {
            contentDiv.empty();
            getAllPunshes();
        }
    }

    // Rendering functions
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
                        .attr('index', index)
                );

            navbarItemsDiv.append(punshDiv);
        }

        navbarDiv.append(navbarItemsDiv);
        attachPunshesEvents(punshes);
    }

    function renderSinglePunshInHTML(punsh) {
        let contentHeaderDiv = $('<div>')
            .addClass('content-header')
            .css('cursor', 'pointer');

        let punshDataDiv = $('<div>')
            .addClass('punsh-data');

        appendHeading(punsh);
        appendPunshData(punsh);

        contentDiv
            .append(contentHeaderDiv)
            .append(punshDataDiv);

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
});