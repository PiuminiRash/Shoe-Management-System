$(document).ready(function () {
    // Save supplier
    $('#save-supplier').click(function () {
        const supplier = getSupplierFormData();
        console.log(supplier);
        $.ajax({
            url: 'http://localhost:8081/api/v1/supplier',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(supplier),
            success: function (response) {
                alert('Supplier saved successfully');
                fetchAllSuppliers();
            },
            error: function (error) {
                alert('Error saving Supplier');
                console.log(error);
            }
        });
    });


    // Update supplier
    $('#update-supplier').click(function () {
        const supplier = getSupplierFormData();
        $.ajax({
            url: `http://localhost:8081/api/v1/supplier`,  // Update with your backend endpoint
            method: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(supplier),
            success: function (response) {
                alert('Supplier updated successfully');
                fetchAllSuppliers();
            },
            error: function (error) {
                alert('Error updating supplier');
                console.log(error);
            }
        });
    });

    // Delete supplier
    $('#delete-supplier').click(function () {
        const supplierId = $('#supp-id').val();
        $.ajax({
            url: `http://localhost:8081/api/v1/supplier/${supplierId}`,  // Update with your backend endpoint
            method: 'DELETE',
            success: function (response) {
                alert('Supplier deleted successfully');
                fetchAllSuppliers();
            },
            error: function (error) {
                alert('Error deleting supplier');
                console.log(error);
            }
        });
    });


    $('#getAllSupplier').click(function () {
        fetchAllSuppliers();
    });

    //  Supplier Data
    function fetchAllSuppliers() {
        $.ajax({
            url: 'http://localhost:8081/api/v1/supplier',  // Update with your backend endpoint
            method: 'GET',
            success: function (response) {
                populateSupplierTable(response);
            },
            error: function (error) {
                alert('Error fetching suppliers');
                console.log(error);
            }
        });
    }

    //  supplier table
    function populateSupplierTable(suppliers) {
        const tbody = $('#Supplier-body');
        tbody.empty();
        suppliers.forEach(supplier => {
            const row = `
                <tr class="supplier-row" data-supplier='${JSON.stringify(supplier)}'>
                    <td>${supplier.code}</td>
                    <td>${supplier.name}</td>
                    <td>${supplier.category}</td>
                    <td>${supplier.address.addressLine1}, ${supplier.address.addressLine2}, ${supplier.address.addressLine3}, ${supplier.address.addressLine4}, ${supplier.address.addressLine5}</td>
        
                    <td>${supplier.contact_1}</td>
                    <td>${supplier.contact_2}</td>
                    <td>${supplier.email}</td>
                </tr>
            `;
            tbody.append(row);
        });


        $('.supplier-row').click(function () {
            const supplier = $(this).data('supplier');
            populateSupplierForm(supplier);
        });
    }


    function populateSupplierForm(supplier) {
        $('#supp-id').val(supplier.code);
        $('#supp-name').val(supplier.name);
        $('#supcotegory').val(supplier.category);
        $('#address001').val(supplier.address.addressLine1);
        $('#address002').val(supplier.address.addressLine2);
        $('#address003').val(supplier.address.addressLine3);
        $('#address004').val(supplier.address.addressLine4);
        $('#address005').val(supplier.address.addressLine5);

        $('#num1').val(supplier.contact_1);
        $('#num2').val(supplier.contact_2);
        $('#mail1').val(supplier.email);
    }

    // Get form data
    function getSupplierFormData() {
        return {
            code: $('#supp-id').val(),
            name: $('#supp-name').val(),
            category: $('#supcategory').val(),
            address: {
                addressLine1: $('#address001').val(),
                addressLine2: $('#address002').val(),
                addressLine3: $('#address003').val(),
                addressLine4: $('#address004').val(),
                addressLine5: $('#address005').val()
            },
            contact_1: $('#num1').val(),
            contact_2: $('#num2').val(),
            email: $('#mail1').val()
        };
    }



    fetchAllSuppliers();
});
