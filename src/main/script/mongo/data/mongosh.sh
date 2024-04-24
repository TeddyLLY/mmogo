### 塞大量測試資料 ###
# insert one
 for (var i = 1; i <= 10000; i++){
      db.employee.insertOne([
           {
             "first_name":'employee.first_name = ' + UUID(),
             "last_name":'employee.last_name = ' + UUID(),
             "job":'employee.job = ' + UUID(),
             "salary": UUID(),
             "internship": true,
             "regular_date":new Date(),
             "email": UUID() + "@mail.com"
           }
       ])
   };



# insert many
function getRandomValue() {
  return Math.floor(Math.random() * 1000000);
};

let jsonArray = [];

for (let i = 0; i < 100; i++) {
  let jsonObject = {
    "first_name": 'employee.first_name = ' + UUID(),
    "last_name": 'employee.last_name = ' + UUID(),
    "job": 'employee.job = ' + UUID(),
    "salary": getRandomValue(),
    "internship": true,
    "regular_date": new Date(),
    "email": UUID() + "@mail.com"
  };
  jsonArray.push(jsonObject);
}

db.employee.insertMany(jsonArray);

