$(() => {
    const host = 'https://phonebook-5e5f7.firebaseio.com/';
    const list = $('#phonebook');
    const personInput = $('#person');
    const phoneInput = $('#phone');
    const errorMessage =$('#error');

    $('#btnLoad').click(loadContacts);
    $('#btnCreate').click(createContact);

    loadContacts();

    function loadContacts() {
        list.empty();
        list.html('<li>Loading &hellip;</li>');
        $.ajax({
            url: host + ".json",
            success: loadSuccess
        })
    }

    function createContact() {
        const person = personInput.val();
        const phone = phoneInput.val();

        if (person.length < 1 || phone.length < 1) {
            errorMessage.text('Both Person and Phone are required.');
            return;
        }
        errorMessage.empty();

        $.ajax({
            url: host + '.json',
            method: 'POST',
            data: JSON.stringify({person, phone}),  // same as { person: person, phone: phone }
            success: success
        })

        function success(data) {
            const person = personInput.val();
            const phone = phoneInput.val();

            personInput.val('');
            phoneInput.val('');
            console.log(data);

            appendContact({person, phone});
        }
    }



    function loadSuccess(data) {
        list.empty();

        for (let key in data) {
            let entry = data[key];
            appendContact(entry, key);
        }
    }

    function appendContact(entry, key) {
        const contact = $(`<li data-id="${key}">${entry.person}: ${entry.phone}</li>`);
        const deleteBtn = $('<button>Delete</button>');
        deleteBtn.click(deleteContact);
        // deleteBtn.click(() => deleteContact(id) );
        contact.append(deleteBtn);
        list.append(contact);
    }

    function deleteContact() {
        const item = $(this).parent();
        const key = item.attr('data-id');
        $.ajax({
            url: host + key + '.json',
            method: 'DELETE',
            success: success
        });

        function success(data) {
            item.remove();
        }
    }
});

