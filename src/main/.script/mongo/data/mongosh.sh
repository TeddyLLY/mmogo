### 塞大量測試資料 ###
# insertOne
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


# insertMany
# 注意 insertMany 超過 1000 筆會分拆多個小組分次 insert db
# push 一個 json array 十萬左右可以接受 , 超過 mongo shell 可能會報錯

function getRandomValue() {
  return Math.floor(Math.random() * 1000000);
};

let jsonArray = [];

for (let i = 0; i < 1000000; i++) {
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

for (let i = 0; i < 100; i++) {
  db.employee3.insertMany(jsonArray);
}


# mongoimport with json
sudo yum install -y epel-release
sudo yum install -y nodejs npm

sudo npm install -g mgeneratejs

mgeneratejs --version
mgeneratejs --help

mgeneratejs -n 1000000
 '[{
   "first_name": "$name",
   "last_name": "$name",
   "job": {"$pick": ["Senior Developer","Junior Developer","Intern","PM","QA","DevOps","UI/UX Designer","DBA","SA","Sales","HR"]},
   "salary": {"$number": {"min": 28000, "max": 1000000}},
   "internship": {"$pick": [ "true", "false" ]},
   "regular_date": "$date",
   "email": "$email",
   "insert_date": "$now"
 }]'
 | mongoimport -d demo -c employee4



