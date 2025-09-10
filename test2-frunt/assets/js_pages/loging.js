$(document).ready(function () {

    $('#eye').click(function () {
        const passwordField = $('#password');
        const passwordFieldType = passwordField.attr('type');

        if (passwordFieldType === 'password') {
            passwordField.attr('type', 'text');
        } else {
            passwordField.attr('type', 'password');
        }
    });


    $('#login-form').submit(function (event) {
        event.preventDefault();

        const email = $('#username').val();
        const password = $('#password').val();


        $.ajax({
            url: 'http://localhost:8081/api/v1/auth',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({ email, password }),
            success: function (response) {
                if (response.role === 'ADMIN') {
                    alert('Login successful');

                    window.location.href = 'index.html';
                } else {
                    alert('You are not authorized to access this page');
                }
            },
            error: function (error) {
                alert('Error logging in');
                console.log(error);
            }
        });
    });
});
