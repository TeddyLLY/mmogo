//insert
$(document).ready(function () {
  $('#addEmployeeForm').submit(function (event) {
    event.preventDefault();

    // 獲取輸入值
    var name = $('#name').val();
    var salary = $('#salary').val();
    var isPermanent = $('#isPermanent').val();
    var conversionDate = $('#conversionDate').val();

    // 建立要傳送的數據對象
    var employeeData = {
      name: name,
      salary: salary,
      isPermanent: isPermanent,
      conversionDate: conversionDate
    };

    // 發送AJAX請求
    $.ajax({
      url: '/api/addEmployee',
      type: 'POST',
      data: JSON.stringify(employeeData),
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
        $.ajax({
              url: '/addEmployeePage',
              type: 'POST',
              success: function (response) {
                     // 請求成功後的處理
                     console.log(response);
                     alert(response);
                     // 將網頁重新導向到後端回傳的URL
//                     let redirectUrl = response.url;
                     // 使用JavaScript进行页面跳转
//                     window.location.href = redirectUrl;
              },
              error: function (error) {
                // 請求失敗後的處理
                console.log(error);
                alert('請求失敗，請稍後再試！');
              }
        });
};

function selectEmployee(){

};

function insertEmployee(){

};

function updateEmployee(){

};

function deleteEmployee(){

};