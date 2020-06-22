$(document).ready(() => {
    let editCountryId = null;

    $('#modal-save-button').click(() => {
        const name = $('#modal-country-name').val();
        const capital = $('#modal-country-capital').val();
        const continent = $('#modal-country-continent').val();
        const population = $('#modal-country-population').val();

        const body = {
            name: name,
            capital: capital,
            continent: continent,
            population:population
        };

        if (editCountryId === null) {
            addNewCountry(body);
        } else {
            editCountry(editCountryId, body);
        }
    });

    $('.fa-trash-alt').click(function () {
        const countryId = this.parentElement.id;
        fetch('/api/countries/' + countryId, {
            method: 'delete'
        }).then(response => location.reload());
    });

    $('.fa-edit').click(function () {
        editCountryId = this.parentElement.id;

        const row = this.parentElement.parentElement.parentElement;
        const name = row.children[0].innerText;
        const capital = row.children[1].innerText;
        const continent = row.children[2].innerText;
        const population = row.children[3].innerText;

        $('#modal-country-name').val(name);
        $('#modal-country-capital').val(capital);
        $('#modal-country-continent').val(continent);
         $('#modal-country-population').val(population);
    });

    function addNewCountry(body) {
        fetch('/api/countries', {
            method: 'post',
            body: JSON.stringify(body),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => {
            location.reload();
        });
    }

    function editCountry(id, body) {
        fetch('/api/countries/' + id, {
            method: 'put',
            body: JSON.stringify(body),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(() => {
            location.reload();
            editCountryId = null;
        });
    }


})