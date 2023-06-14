//insert
$(document).ready(function () {
  $('#addEmployeeForm').submit(function (event) {
    event.preventDefault();

    // 獲取輸入值
    let firstName = $('#firstName').val();
    let lastName = $('#lastName').val();
    let job = $('#job').val();
    let salaryString = $('#salary').val();
    let internship = $('#internship').val();
    let regularDate = $('#regularDate').val();

    if(!firstName && !job && !salary){
           alert('Please enter a value for Job');
           return;
    }

    let salary = parseInt(salaryString, 10);
    if (isNaN(salary)) {
        alert('Salary must be a valid integer');
        return;
    }

    // 建立要傳送的數據對象
    var data = {
      firstName: firstName,
      lastName: lastName,
      job: job,
      salary: salary,
      internship: internship,
      regularDate: regularDate
    };

    // 發送AJAX請求
    $.ajax({
      url: '/api/addEmployee',
      type: 'POST',
      data: JSON.stringify(data),
      contentType: 'application/json',
      success: function (response) {
        // 請求成功後的處理
        // 可選：顯示成功訊息或執行其他操作
        alert('員工已新增成功！');

        // 清空輸入框
        $('#name').val('');
        $('#salary').val('');
        $('#isPermanent').val('true');
        $('#conversionDate').val('');
        window.location.href = "/";
      },
      error: function (error) {
        // 請求失敗後的處理
        // 可選：顯示錯誤訊息或執行其他操作
        alert('員工新增失敗，請稍後再試！');
      }
    });
  });
});


function toAddEmployeePage(){
    window.location.href = "/addEmployeePage";
};


function backToHome(){
    window.location.href = "/";
};
