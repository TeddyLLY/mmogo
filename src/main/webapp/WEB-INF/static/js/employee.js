
$(function () {
  //insert
  $('#addEmployeeForm').submit(function () {
    addEmployeeForm();
  });

});// $(function () { }); end

function toAddEmployeePage(){
    window.location.href = "/addEmployeePage";
};

function backHome(){
   location.href = "/hello";
};

function updateEmployeePage(id){
    let data = {
      id: id
    };
    let jsonData = encodeURIComponent(JSON.stringify(data));
    console.log(JSON.stringify(data));

    let url = "/updateEmployeePage?data="+jsonData ;
    window.location.href = url ;
};

function deleteEmployee(id){
    if(!id ){
       alert('pk not found');
       return;
    }

    //confirm
    if(!confirm('Are you sure you want to delete this?')){
         return;
    }else{
        // 建立要傳送的數據對象
        let data = {
           id: id
        };
        // 發送AJAX請求
        $.ajax({
          url: '/deleteEmployee',
          type: 'POST',
          data: JSON.stringify(data),
          contentType: 'application/json',
          success: function (response) {
            // 請求成功後的處理
            // 可選：顯示成功訊息或執行其他操作
            alert('Delete success！');
            backHome();
          },
          error: function (error) {
            // 請求失敗後的處理
            // 可選：顯示錯誤訊息或執行其他操作
            alert('Delete fail，please try again！');
          }
        });
    }
};

function addEmployeeForm(){
    event.preventDefault(); // 阻止表单的默认提交行为
    // 獲取輸入值
    let firstName = $('#firstName').val();
    let lastName = $('#lastName').val();
    let job = $('#job').val();
    let salaryString = $('#salary').val();
    let salary = parseInt(salaryString, 10);
    let internship = $('#internship').val();
    let regularDate = $('#regularDate').val();

    if(!firstName && !job && !salary  ){
           alert('Please enter needed values');
           return;
    }
    if(!(regularDate && regularDate != "")){
           alert('Please enter regular date');
           return;
    }
    if (isNaN(salary)) {
        alert('Salary must be a valid integer');
        return;
    }

    // 建立要傳送的數據對象
    let data = {
      firstName: firstName,
      lastName: lastName,
      job: job,
      salary: salary,
      internship: internship,
      regularDate: regularDate
    };

    console.log(data);
    // 發送AJAX請求
    $.ajax({
      url: '/addEmployee',
      type: 'POST',
      data: JSON.stringify(data),
      contentType: 'application/json',
      success: function (msg) {
           // 請求成功後的處理
           // 可選：顯示成功訊息或執行其他操作
           if(msg && msg==1){
                alert('新增員工成功！');
                backHome();
           }else{
               alert('系統異常！');
           }
      },
      error: function (error) {
        // 請求失敗後的處理
        // 可選：顯示錯誤訊息或執行其他操作
        alert('員工新增失敗，請稍後再試！');
      }
    });
}

function updateEmployeeForm(){
    // 獲取輸入值
    let id = $('#id').val();
    let firstName = $('#firstName').val();
    let lastName = $('#lastName').val();
    let job = $('#job').val();
    let salaryString = $('#salary').val();
    let salary = parseInt(salaryString, 10);
    let internship = $('#internship').val();
    let regularDate = $('#regularDate').val();

    if(!firstName && !job && !salary  ){
           alert('Please enter needed values');
           return;
    }
    if(!(regularDate && regularDate != "")){
           alert('Please enter regular date');
           return;
    }
    if(!id){
            alert('id not found');
            return;
    }
    if (isNaN(salary)) {
        alert('Salary must be a valid integer');
        return;
    }

    // 建立要傳送的數據對象
    let data = {
      id: id,
      firstName: firstName,
      lastName: lastName,
      job: job,
      salary: salary,
      internship: internship,
      regularDate: regularDate
    };

    console.log(data);
    // 發送AJAX請求
    $.ajax({
      url: '/updateEmployee',
      type: 'POST',
      data: JSON.stringify(data),
      contentType: 'application/json',
      success: function (msg) {
        // 請求成功後的處理
        // 可選：顯示成功訊息或執行其他操作
        if(msg && msg==1){
             alert('修改成功！');
             backHome();
        }else{
            alert('系統異常！');
        }
      },
      error: function (error) {
        // 請求失敗後的處理
        // 可選：顯示錯誤訊息或執行其他操作
        alert('修改失敗，請稍後再試！');
      }
    });
}

function selectEmployeeByParam(){
     let selectField = $('#selectField').val();
     let selectContent = $('#selectContent').val();
      let data = {
        selectField: selectField,
        selectContent: selectContent
      };

      let jsonData = encodeURIComponent(JSON.stringify(data));
      console.log(JSON.stringify(data));

      let url = "/hello?data="+jsonData ;
      window.location.href = url ;
}