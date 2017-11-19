function attachEvents() {
    $('.button').on('click', buttonClicked());

    function buttonClicked() {
        $('.selected').removeClass('selected');
        $(this).addClass('selected')
    }
}
