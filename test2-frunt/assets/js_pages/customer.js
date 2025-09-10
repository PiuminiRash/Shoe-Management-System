$(document).ready(function () {
    // Save Customer
    $('#save-customer').click(function () {
        const customer = getCustomerFormData();
        $.ajax({
            url: 'http://localhost:8081/api/v1/customer',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(customer),
            success: function (response) {
                alert('Customer saved successfully');
                fetchAllCustomers();
            },
            error: function (error) {
                alert('Error saving customer');
                console.log(error);
            }
        });
    });

    // Update Customer
    $('#update-customer').click(function () {
        const customer = getCustomerFormData();
        $.ajax({
            url: `http://localhost:8081/api/v1/customer`,
            method: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(customer),
            success: function (response) {
                alert('Customer updated successfully');
                fetchAllCustomers();
            },
            error: function (error) {
                alert('Error updating customer');
                console.log(error);
            }
        });
    });

    // Delete Customer
    $('#delete-customer').click(function () {
        const customerId = $('#customer-id').val();
        $.ajax({
            url: `http://localhost:8081/api/v1/customer/${customerId}`,

            method: 'DELETE',
            success: function (response) {
                alert('Customer deleted successfully');
                fetchAllCustomers();
            },
            error: function (error) {
                alert('Error deleting customer');
                console.log(error);
            }
        });
    });

    // Fetch All Customers
    $('#getAllCustomer').click(function () {
        fetchAllCustomers();
    });

    // Fetch Customer Data
    function fetchAllCustomers() {
        $.ajax({
            url: 'http://localhost:8081/api/v1/customer',

            method: 'GET',
            success: function (response) {
                populateCustomerTable(response);
            },
            error: function (error) {
                alert('Error fetching customers');
                console.log(error);
            }
        });
    }

    // Populate Customer Table
    function populateCustomerTable(customers) {
        const tbody = $('#body');
        tbody.empty();
        customers.forEach(customer => {
            const row = `
                <tr class="customer-row" data-customer='${JSON.stringify(customer)}'>
                    <td>${customer.code}</td>
                    <td>${customer.name}</td>
                    <td>${customer. userEntity}</td>
                    <td>${customer.gender}</td>
                    <td>${customer.loyaltyDate}</td>
                    <td>${customer.loyaltyPoints}</td>
                    <td>${customer.contact}</td>
                    <td>${customer.loyaltyLevel}</td>
                    <td>${customer.email}</td>
                    <td>${customer.dob}</td>
                    <td>${customer.address.addressLine1}, ${customer.address.addressLine2}, ${customer.address.addressLine3}, ${customer.address.addressLine4}, ${customer.address.addressLine5}</td>
         
               </tr>
            `;
            tbody.append(row);
        });


        $('.customer-row').click(function () {
            const customer = $(this).data('customer');
            populateCustomerForm(customer);
        });
    }


    function populateCustomerForm(customer) {
        $('#customer-id').val(customer.code);
        $('#customer-name').val(customer.name);
        $('#seluseId').val(customer. userEntity);
        $('#customer-tp').val(customer.contact);
        $('#mail').val(customer.email);
        $('#address1').val(customer.address.addressLine1);
        $('#address2').val(customer.address.addressLine2);
        $('#address3').val(customer.address.addressLine3);
        $('#address4').val(customer.address.addressLine4);
        $('#address5').val(customer.address.addressLine5);

        $('#gender').val(customer.gender);
        $('#level').val(customer.loyaltyLevel);
        $('#join').val(customer.loyaltyDate);
        $('#dob').val(customer.dob);
        $('#total1').val(customer.loyaltyPoints);
    }

    // Get form data
    function getCustomerFormData() {
        return {
            code: $('#customer-id').val(),
            name: $('#customer-name').val(),
            userEntity: $('#seluseId').val(),
            contact: $('#customer-tp').val(),
            email: $('#mail').val(),
            address: {
                addressLine1: $('#address1').val(),
                addressLine2: $('#address2').val(),
                addressLine3: $('#address3').val(),
                addressLine4: $('#address4').val(),
                addressLine5: $('#address5').val()
            },

            gender: $('#gender').val(),
            loyaltyLevel: $('#level').val(),
            loyaltyDate: $('#join').val(),
            dob: $('#dob').val(),
            loyaltyPoints: $('#total1').val()
        };
    }

    function loadAllUserId() {

        $.ajax({
            url: "http://localhost:8081/api/v1/user",
            method: "GET",
            success: function (resp) {
                console.log("Success: ", resp);
                for (const user of resp) {
                    $('#seluseId').append(`<option>${user.email}</option>`)
                }
            },
            error: function (error) {
                console.log("Error: ", error);
            }
        });
    }
    loadAllUserId();
});
