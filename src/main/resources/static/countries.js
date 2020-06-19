$(document).ready(() => {
    let editMovieId = null;

    $('#modal-save-button').click(() => {
        const title = $('#modal-movie-title').val();
        const year = $('#modal-movie-year').val();
        const rating = $('#modal-movie-rating').val();
        const body = {
            title: title,
            year: year,
            rating: rating
        };

        if (editMovieId === null) {
            addNewMovie(body);
        } else {
            editMovie(editMovieId, body);
        }
    });

    $('.fa-trash-alt').click(function () {
        const movieId = this.parentElement.id;
        fetch('/api/movies/' + movieId, {
            method: 'delete'
        }).then(response => location.reload());
    });

    $('.fa-edit').click(function () {
        editMovieId = this.parentElement.id;

        const row = this.parentElement.parentElement.parentElement;
        const name = row.children[0].innerText;
        const capital = row.children[1].innerText;
        const continent = row.children[2].innerText;
        const population = row.children[3].innerText;

        $('#modal-movie-title').val(title);
        $('#modal-movie-year').val(year);
        $('#modal-movie-rating').val(rating);
    });

    function addNewMovie(body) {
        fetch('/api/movies', {
            method: 'post',
            body: JSON.stringify(body),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => {
            location.reload();
        });
    }

    function editMovie(id, body) {
        fetch('/api/movies/' + id, {
            method: 'put',
            body: JSON.stringify(body),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(() => {
            location.reload();
            editMovieId = null;
        });
    }


})