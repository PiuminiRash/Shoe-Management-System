

$(document).ready(function () {
    // Save employee
    $('#save-employee').click(function () {
        const formData = getEmployeeFormData();
        $.ajax({
            url: 'http://localhost:8081/api/v1/employees',
            method: 'POST',
            processData: false,
            contentType: false,
            data: formData,
            success: function (response) {
                alert('Employee saved successfully');
                fetchAllEmployees();
            },
            error: function (error) {
                alert('Error saving employee');
                console.log(error);
            }
        });
    });

    // Update employee
    $('#update-employee').click(function () {
        const formData = getEmployeeFormData();
        $.ajax({
            url: 'http://localhost:8081/api/v1/employees',
            method: 'PUT',
            processData: false,
            contentType: false,
            data: formData,
            success: function (response) {
                alert('Employee updated successfully');
                fetchAllEmployees();
            },
            error: function (error) {
                alert('Error updating employee');
                console.log(error);
            }
        });
    });

    // Delete employee
    $('#delete-employee').click(function () {
        const employeeId = $('#emp-id').val();
        $.ajax({
            url: `http://localhost:8081/api/v1/employees/${employeeId}`,
            method: 'DELETE',
            success: function (response) {
                alert('Employee deleted successfully');
                fetchAllEmployees();
            },
            error: function (error) {
                alert('Error deleting employee');
                console.log(error);
            }
        });
    });

    // Fetch All Employees
    $('#getAllEmployee').click(function () {
        fetchAllEmployees();
    });

    // Fetch Employee Data
    function fetchAllEmployees() {
        $.ajax({
            url: 'http://localhost:8081/api/v1/employees',
            method: 'GET',
            success: function (response) {
                populateEmployeeTable(response);
            },
            error: function (error) {
                alert('Error fetching employees');
                console.log(error);
            }
        });
    }

    // Populate employee table
    function populateEmployeeTable(employees) {
        const tbody = $('#Employee-body');
        tbody.empty();
        employees.forEach(employee => {
            const row = `
                <tr class="employee-row" data-employee='${JSON.stringify(employee)}'>
                    <td>${employee.employeeCode}</td>
                    <td>${employee.employeeName}</td>
                    <td><img src="data:image/png;base64,${employee.employeeProfilePic}" alt="Employee Pic" style="width: 50px; height: 50px;"></td>
                    <td>${employee.gender}</td>
                    <td>${employee.status}</td>
                    <td>${employee.designation}</td>
                    <td>${employee.accessRole}</td>
                    <td>${employee.dob}</td>
                    <td>${employee.dateOfJoin}</td>
                    <td>${employee.attachedBranch}</td>
                    <td>${employee.address.addressLine1},${employee.address.addressLine2},${employee.address.addressLine3},${employee.address.addressLine4},${employee.address.addressLine5}</td>
                    <td>${employee.contactNo}</td>
                    <td>${employee.email}</td>
                    <td>${employee.emergencyContactPerson}</td>
                </tr>
            `;
            tbody.append(row);
        });

        $('.employee-row').click(function () {
            const employee = $(this).data('employee');
            populateEmployeeForm(employee);
        });
    }

    //  employee data
    function populateEmployeeForm(employee) {
        $('#emp-id').val(employee.employeeCode);
        $('#emp-name').val(employee.employeeName);
        $('#texstates1').val(employee.status);
        $('#designation').val(employee.designation);
        $('#role').val(employee.accessRole);
        $('#branch').val(employee.attachedBranch);
        $('#address01').val(employee.address.addressLine1);
        $('#address02').val(employee.address.addressLine2);
        $('#address03').val(employee.address.addressLine3);
        $('#address04').val(employee.address.addressLine4);
        $('#address05').val(employee.address.addressLine5);
        $('#mail01').val(employee.email);
        $('#num').val(employee.contactNo);
        $('#emergency').val(employee.emergencyContactPerson);
        $('#joindate').val(employee.dateOfJoin);
        $('#emp-dob').val(employee.dob);
        $('#gender1').val(employee.gender);
        // Handle employee picture separately if needed
    }

    // Get form data
    function getEmployeeFormData() {
        const formData = new FormData();
        formData.append('data', new Blob([JSON.stringify({
            employeeCode: $('#emp-id').val(),
            employeeName: $('#emp-name').val(),
            status: $('#texstates1').val(),
            designation: $('#designation').val(),
            accessRole: $('#role').val(),
            attachedBranch: $('#branch').val(),
            address: {
                addressLine1: $('#address01').val(),
                addressLine2: $('#address02').val(),
                addressLine3: $('#address03').val(),
                addressLine4: $('#address04').val(),
                addressLine5: $('#address05').val()
            },
            email: $('#mail01').val(),
            contactNo: $('#num').val(),
            emergencyContactPerson: $('#emergency').val(),
            dateOfJoin: $('#joindate').val(),
            dob: $('#emp-dob').val(),
            gender: $('#gender1').val()
        })], { type: 'application/json' }));
        formData.append('profilepic', $('#profilepic')[0].files[0]);
        return formData;
    }

    fetchAllEmployees();
});



// {
//     "employeeCode": "EMP001",
//     "employeeName": "amal perera",
//     "gender": "MALE",
//     "status": "Active",
//     "designation": "Software ",
//     "accessRole": "ADMIN",
//     "dob": "2000-01-01",
//     "dateOfJoin": "2020-10-01",
//     "attachedBranch": "galle ",
//     "address":{
//      "addressLine1": "12 Main Street",
//         "addressLine2": "Galle",
//         "addressLine3": "Western Province",
//         "addressLine4": "Sri Lanka",
//         "addressLine5": "12345"},
//
//     "contactNo": "+94123488689",
//     "email": "amal.doe@example.com",
//     "emergencyContactPerson": "Jane Doe"
// }