$(document).ready(function () {
    // Save inventory
    $('#save-item').click(function () {
        const inventory = getItemFormData();
        const formData = new FormData();
        formData.append('data', JSON.stringify(inventory));
        formData.append('itempic', $('#item-Pic')[0].files[0]);

        $.ajax({
            url: 'http://localhost:8081/api/v1/inventory',
            method: 'POST',
            processData: false,
            contentType: false,
            data: formData,
            success: function (response) {
                alert('Inventory saved successfully');
                fetchAllItems();
            },
            error: function (error) {
                alert('Error saving inventory');
                console.log(error);
            }
        });
    });


    $('#update-item').click(function () {
        const inventory = getItemFormData();
        const formData = new FormData();
        formData.append('data', JSON.stringify(inventory));
        formData.append('itempic', $('#item-Pic')[0].files[0]);

        $.ajax({
            url: 'http://localhost:8081/api/v1/inventory',
            method: 'PUT',
            processData: false,
            contentType: false,
            data: formData,
            success: function (response) {
                alert('Inventory updated successfully');
                fetchAllItems();
            },
            error: function (error) {
                alert('Error updating inventory');
                console.log(error);
            }
        });
    });


    $('#delete-item').click(function () {
        const itemId = $('#item-id').val();
        $.ajax({
            url: `http://localhost:8081/api/v1/inventory/${itemId}`,
            method: 'DELETE',
            success: function (response) {
                alert('Inventory deleted successfully');
                fetchAllItems();
            },
            error: function (error) {
                alert('Error deleting inventory');
                console.log(error);
            }
        });
    });

    //  All inventory
    $('#getAllItem').click(function () {
        fetchAllItems();
    });


    function fetchAllItems() {
        $.ajax({
            url: 'http://localhost:8081/api/v1/inventory',
            method: 'GET',
            success: function (response) {
                populateItemTable(response);
            },
            error: function (error) {
                alert('Error fetching inventory');
                console.log(error);
            }
        });
    }

    //  inventory Table
    function populateItemTable(inventories) {
        const tbody = $('#Item-body');
        tbody.empty();
        inventories.forEach(inventory => {
            const row = `
                <tr class="item-row" data-item='${JSON.stringify(inventory)}'>
                    <td>${inventory.itemCode}</td>
                    <td>${inventory.supplierCode}</td>
                    <td>${inventory.unitPriceSale}</td>
                    <td>${inventory.unitPriceBuy}</td>
                    <td>${inventory.expectedProfit}</td>
                    <td>${inventory.profitMargin}</td>
                    <td>${inventory.status}</td>
                    <td>${inventory.size}</td>
                    <td>${inventory.category}</td>
                    <td>${inventory.supplierName}</td>
                    <td><img src="data:image/jpeg;base64,${inventory.itemPicture}" alt="Item Pic" style="width: 50px; height: 50px;"></td>
                    <td>${inventory.itemDescription}</td>
                    <td>${inventory.qty}</td>
                </tr>
            `;
            tbody.append(row);
        });

        $('.item-row').click(function () {
            const inventory = $(this).data('item');
            populateItemForm(inventory);
        });
    }

    //inventory data
    function populateItemForm(inventory) {
        $('#item-id').val(inventory.itemCode);
        $('#supId').val(inventory.supplierCode);
        $('#buy').val(inventory.unitPriceBuy);
        $('#sale').val(inventory.unitPriceSale);
        $('#size').val(inventory.size);
        $('#margin').val(inventory.profitMargin);
        $('#sup-name').val(inventory.supplierName);
        $('#profit').val(inventory.expectedProfit);
        $('#texstates').val(inventory.status);
        $('#category').val(inventory.category);
        $('#item-name').val(inventory.itemDescription);
        $('#qty').val(inventory.qty);

    }

    // Get form data
    function getItemFormData() {
        return {
            itemCode: $('#item-id').val(),
            supplierCode: $('#supId').val(),
            unitPriceBuy: $('#buy').val(),
            unitPriceSale: $('#sale').val(),
            size: $('#size').val(),
            profitMargin: $('#margin').val(),
            supplierName: $('#sup-name').val(),
            expectedProfit: $('#profit').val(),
            status: $('#texstates').val(),
            category: $('#category').val(),
            itemDescription: $('#item-name').val(),
            qty: $('#qty').val()
        };
    }

    function loadAllSupplierId() {
        $.ajax({
            url: "http://localhost:8081/api/v1/supplier",
            method: "GET",
            success: function (resp) {
                console.log("Success: ", resp);
                for (const Supplier of resp) {
                    $('#supId').append(`<option>${Supplier.code}</option>`);
                }
            },
            error: function (error) {
                console.log("Error: ", error);
            }
        });
    }

    loadAllSupplierId();
});


// $(document).ready(function () {
//     // Save inventory
//     $('#save-item').click(function () {
//         const inventory = getItemFormData();
//         console.log(inventory);
//         $.ajax({
//             url: 'http://localhost:8081/api/v1/inventory',  // Update with your backend endpoint
//             method: 'POST',
//             contentType: 'multipart/form-data',
//             data: JSON.stringify(inventory),
//             success: function (response) {
//                 alert('Inventory saved successfully');
//                 fetchAllItems();
//             },
//             error: function (error) {
//                 alert('Error saving inventory');
//                 console.log(error);
//             }
//         });
//     });
//
//     // Update inventory
//     $('#update-item').click(function () {
//         const inventory = getItemFormData();
//         $.ajax({
//             url: `http://localhost:8081/api/v1/inventory`,  // Update with your backend endpoint
//             method: 'PUT',
//             contentType: 'multipart/form-data',
//             data: JSON.stringify(inventory),
//             success: function (response) {
//                 alert('Inventory updated successfully');
//                 fetchAllItems();
//             },
//             error: function (error) {
//                 alert('Error updating inventory');
//                 console.log(error);
//             }
//         });
//     });
//
//     // Delete inventory
//     $('#delete-item').click(function () {
//         const itemId = $('#item-id').val();
//         $.ajax({
//             url: `http://localhost:8081/api/v1/inventory/${itemId}`,  // Update with your backend endpoint
//             method: 'DELETE',
//             success: function (response) {
//                 alert('Inventory deleted successfully');
//                 fetchAllItems();
//             },
//             error: function (error) {
//                 alert('Error deleting inventory');
//                 console.log(error);
//             }
//         });
//     });
//
//     // Fetch All inventory
//     $('#getAllItem').click(function () {
//         fetchAllItems();
//     });
//
//     // Fetch inventory Data
//     function fetchAllItems() {
//         $.ajax({
//             url: 'http://localhost:8081/api/v1/inventory',  // Update with your backend endpoint
//             method: 'GET',
//             success: function (response) {
//                 populateItemTable(response);
//             },
//             error: function (error) {
//                 alert('Error fetching inventory');
//                 console.log(error);
//             }
//         });
//     }
//
//     // Populate inventory Table
//     function populateItemTable(inventories) {
//         const tbody = $('#Item-body');
//         tbody.empty();
//         inventories.forEach(inventory => {
//             const row = `
//                 <tr class="item-row" data-item='${JSON.stringify(inventory)}'>
//                     <td>${inventory.itemCode}</td>
//                     <td>${inventory.supplierCode}</td>
//                     <td>${inventory.unitPriceSale}</td>
//                     <td>${inventory.unitPriceBuy}</td>
//                     <td>${inventory.expectedProfit}</td>
//                     <td>${inventory.profitMargin}</td>
//                     <td>${inventory.status}</td>
//                     <td>${inventory.size}</td>
//                     <td>${inventory.category}</td>
//                     <td>${inventory.supplierName}</td>
//                     <td>${inventory.itemPicture}</td>
//                     <td>${inventory.itemDescription}</td>
//                     <td>${inventory.qty}</td>
//                 </tr>
//             `;
//             tbody.append(row);
//         });
//
//         //<td><img src="${employee.employeeProfilePic}" alt="Employee Pic" style="width: 50px; height: 50px;"></td>
//         // Attach click event listener to each row
//         $('.item-row').click(function () {
//             const inventory = $(this).data('item');
//             populateItemForm(inventory);
//         });
//     }
//
//     // Populate form with inventory data
//     function populateItemForm(inventory) {
//         $('#item-id').val(inventory.itemCode);
//         $('#supId').val(inventory.supplierCode);
//         $('#buy').val(inventory.unitPriceBuy);
//         $('#sale').val(inventory.unitPriceSale);
//         $('#size').val(inventory.size);
//         $('#margin').val(inventory.profitMargin);
//         $('#sup-name').val(inventory.supplierName);
//         $('#profit').val(inventory.expectedProfit);
//         $('#texstates').val(inventory.status);
//         $('#cotegory').val(inventory.category);
//         $('#item-Pic').val(inventory.itemPicture);  // Make sure this handles the image URL correctly
//         $('#item-name').val(inventory.itemDescription);
//         $('#qty').val(inventory.qty);
//     }
//
//     // Get form data
//     function getItemFormData() {
//         return {
//             itemCode: $('#item-id').val(),
//             supplierCode: $('#supId').val(),
//             unitPriceBuy: $('#buy').val(),
//             unitPriceSale: $('#sale').val(),
//             size: $('#size').val(),
//             profitMargin: $('#margin').val(),
//             supplierName: $('#sup-name').val(),
//             expectedProfit: $('#profit').val(),
//             status: $('#texstates').val(),
//             category: $('#category').val(),  // Fixed typo
//             itemPicture: $('#item-Pic').val(),  // Ensure this handles the image URL correctly
//             itemDescription: $('#item-name').val(),
//             qty: $('#qty').val()
//         };
//     }
//     function loadAllSupplierId() {
//
//         $.ajax({
//             url: "http://localhost:8081/api/v1/supplier",
//             method: "GET",
//             success: function (resp) {
//                 console.log("Success: ", resp);
//                 for (const Supplier of resp) {
//                     $('#supId').append(`<option>${Supplier.code}</option>`)
//                 }
//             },
//             error: function (error) {
//                 console.log("Error: ", error);
//             }
//         });
//     }
//     loadAllSupplierId();
// });


// {
//     "itemCode":"I001",
//     "itemDescription":"shoos",
//     "category":"Local",
//     "size":5,
//     "qty":2,
//     "suplierEntity":"SU001",
//     "supplierName":"Navishka",
//     "unitPriceSale":"1000.00",
//     "unitPriceBuy":"500.00",
//     "expectedProfit":"200.00",
//     "profitMargin":"100.00",
//     "status":"Action"
// }