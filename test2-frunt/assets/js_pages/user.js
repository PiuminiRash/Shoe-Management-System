$(document).ready(function () {
    // Save user
    $('#save-user').click(function () {
        const user = getUserFormData();
        $.ajax({
            url: 'http://localhost:8081/api/v1/user',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(user),
            success: function (response) {
                alert('User saved successfully');
                fetchAllUsers();
            },
            error: function (error) {
                alert('Error saving user');
                console.log(error);
            }
        });
    });

    // Update user
    $('#update-user').click(function () {
        const user = getUserFormData();
        $.ajax({
            url: `http://localhost:8081/api/v1/user`,

            method: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(user),
            success: function (response) {
                alert('User updated successfully');
                fetchAllUsers();
            },
            error: function (error) {
                alert('Error updating user');
                console.log(error);
            }
        });
    });

    // Delete user
    $('#delete-user').click(function () {
        const email = $('#email').val();
        $.ajax({
            url: `http://localhost:8081/api/v1/user/${email}`,
            method: 'DELETE',
            success: function (response) {
                alert('User deleted successfully');
                fetchAllUsers();
            },
            error: function (error) {
                alert('Error deleting user');
                console.log(error);
            }
        });
    });


    $('#getAllUser').click(function () {
        fetchAllUsers();
    });


    function fetchAllUsers() {
        $.ajax({
            url: 'http://localhost:8081/api/v1/user',  // Update with your backend endpoint
            method: 'GET',
            success: function (response) {
                populateUserTable(response);
            },
            error: function (error) {
                alert('Error fetching users');
                console.log(error);
            }
        });
    }


    function populateUserTable(users) {
        const tbody = $('#user-tbl-body');
        tbody.empty();
        users.forEach(user => {
            const row = `
                <tr class="user-row" data-user='${JSON.stringify(user)}'>
                    <td>${user.email}</td>
                    <td>${user.password}</td>
                    <td>${user.role}</td>
                </tr>
            `;
            tbody.append(row);
        });


        $('.user-row').click(function () {
            const user = $(this).data('user');
            populateUserForm(user);
        });
    }


    function populateUserForm(user) {
        $('#email').val(user.email);
        $('#password').val(user.password);
        $('#role1').val(user.role);
    }


    function getUserFormData() {
        return {
            email: $('#email').val(),
            password: $('#password').val(),
            role: $('#role1').val()
        };
    }


    fetchAllUsers();
});
