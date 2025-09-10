$(document).ready(function () {
    let today = new Date().toISOString().slice(0, 10);
    $('#txtDate').css({
        color: 'green',
        fontWeight: '500'
    }).val(today);

    let finalTotal = 0;
    let final = 0;

    function clearAll() {
        $('#txtOrderId').val('');
        $('#txtDate').val(today);
        $('#selCusId').val('');
        $('#orderCusName').val('');
        $('#Cashier-name').val('');
        $('#selusersId').val('');
        $('#selItemId').val('');
        $('#orderItemDesc').val('');
        $('#orderItemPrice').val('');
        $('#size1').val('');
        $('#getQty').val('');
        $('#handQty').val('');
        $('#txtCash').val('');
        $('#txtDiscount').val(0);
        $('#txtBalnce').val('');
        finalTotal = 0;
        final = 0;
        $('#total').text(' 0.00/=');
        $('#subTotal').text('0.00/=');
        $('#order-tbl-body').empty();
        $('#btnPlaceOrder').prop("disabled", true);
    }

    function clearBill() {
        $('#order-tbl-body').empty();
    }

    $('#btnClear').on('click', function () {
        clearAll();
        clearBill();
    });

    $('#btnPlaceOrder').on('click', function () {
        let cash = parseFloat($('#txtCash').val());
        if (isNaN(cash)) {
            alert("Please enter a valid cash amount.");
            return;
        }

        let balance = cash - final;
        $('#txtBalnce').val(balance.toFixed(2));

        $('#btnPlaceOrder').prop("disabled", true);

        let itemList = [];
        let trList = $('#order-tbl-body > tr');

        trList.each(function () {
            let child = $(this).children();
            let object = {
                sales: $('#txtOrderId').val(),
                inventory: $(child[1]).text(),
                quantity: $(child[6]).text(),
                unitPriceSale: $(child[11]).text(),
                itemDescription: $(child[10]).text(),
                size: $(child[5]).text()
            };
            itemList.push(object);
        });
        console.log(itemList);
        let orderObj = {
            orderID: $("#txtOrderId").val(),
            date: $('#txtDate').val(),
            customerID: $('#selCusId').val(),
            orderDetailsDTOList: itemList
        };

        $.ajax({
            url: "http://localhost:8081/api/v1/sales",
            method: "POST",
            data: JSON.stringify(orderObj),
            contentType: "application/json",
            success: function (resp) {
                console.log("Order placed successfully:", resp);
                loadAllOrderDetails();
                clearAll();
            },
            error: function (jqxhr, textStatus, error) {
                console.error("Error placing order:", textStatus, error);
            }
        });
    });

    $('#btnAddOrder').on('click', function () {
        let price = parseFloat($('#orderItemPrice').val());
        let quantity = parseInt($('#handQty').val());

        if (isNaN(price) || isNaN(quantity)) {
            alert("Please enter valid price and quantity.");
            return;
        }

        let total = price * quantity;

        $('#order-tbl-body').append(`
            <tr>
                <td>${$('#txtOrderId').val()}</td>
                <td>${$('#selItemId').val()}</td>
                <td>${$('#selCusId').val()}</td>
                <td>${$('#selusersId').val()}</td>
                <td>${$('#size1').val()}</td>
                <td>${$('#orderCusName').val()}</td>
                <td>${quantity}</td>
                <td>${$('#txtCash').val()}</td>
                <td>${$('#txtBalnce').val()}</td>
                <td>${$('#orderItemDesc').val()}</td>
                <td>${price}</td>
                <td>${$('#testmethord').val()}</td>
                <td>${$('#txtDate').val()}</td>
                <td>${total}</td>
            </tr>
        `);

        finalTotal += total;
        final = finalTotal;
        $('#total').text(' ' + finalTotal + '/=');
        $('#subTotal').text(finalTotal + '/=');

        $('#btnPlaceOrder').prop("disabled", false);
        $('#btnAddOrder').prop("disabled", true);
    });

    $('#selCusId').on('change', function () {
        let code = $('#selCusId').val();

        $.ajax({
            url: "http://localhost:8081/api/v1/customer",
            method: "GET",
            success: function (resp) {
                for (const customer of resp) {
                    if (customer.code == code) {
                        $('#orderCusName').val(customer.name);
                    }
                }
                $('#selItemId').focus();
            },
            error: function (error) {
                console.error("Error loading customer details:", error);
            }
        });
    });

    $('#selItemId').on('change', function () {
        let itemCode = $('#selItemId').val();

        $.ajax({
            url: "http://localhost:8081/api/v1/inventory",
            method: "GET",
            success: function (resp) {
                for (const inventory of resp) {
                    if (inventory.itemCode == itemCode) {
                        $('#orderItemDesc').val(inventory.itemDescription);
                        $('#orderItemPrice').val(inventory.unitPriceSale);
                        $('#size1').val(inventory.size);
                        $('#getQty').val(inventory.qty);
                    }
                }
                $('#handQty').focus();
                $('#btnAddOrder').prop("disabled", false);
            },
            error: function (error) {
                console.error("Error loading inventory details:", error);
            }
        });
    });

    $('#txtDiscount').on('keyup change', function () {
        let discount = parseFloat($('#txtDiscount').val());
        if (isNaN(discount)) {
            discount = 0;
        }
        let subTotal = finalTotal - discount;
        final = subTotal;
        $('#subTotal').text(final + '/=');
    });

    $('#txtDiscount').val(0);
    $('#selCusId').prop('disabled', true);

    function loadCustomerId() {
        $.ajax({
            url: "http://localhost:8081/api/v1/customer",
            method: "GET",
            success: function (resp) {
                for (const customer of resp) {
                    console.log(customer);
                    console.log("--------------------------------------");
                    $('#selCusId').append(`<option>${customer.code
                    }</option>`);
                }
            },
            error: function (error) {
                console.error("Error loading customer IDs:", error);
            }
        });
    }

    function loadAllItemId() {
        $.ajax({
            url: "http://localhost:8081/api/v1/inventory",
            method: "GET",
            success: function (resp) {
                for (const inventory of resp) {
                    $('#selItemId').append(`<option>${inventory.itemCode}</option>`);
                }
            },
            error: function (error) {
                console.error("Error loading item IDs:", error);
            }
        });
    }

    function loadAllUserId() {
        $.ajax({
            url: "http://localhost:8081/api/v1/user",
            method: "GET",
            success: function (resp) {
                for (const user of resp) {
                    $('#selusersId').append(`<option>${user.email}</option>`);
                }
            },
            error: function (error) {
                console.error("Error loading user IDs:", error);
            }
        });
    }

    loadAllUserId();
    loadAllItemId();
    loadCustomerId();

    function loadAllOrderDetails() {

    }
});


