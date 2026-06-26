#!/bin/bash

# 定義 API 基礎網址
API_URL="http://127.0.0.1:8085/crud"

echo "=========================================="
echo "執行 1. json_insert (新增資料)"
echo "=========================================="
curl --location "$API_URL" \
--header 'Content-Type: application/json' \
--header 'DNT: 1' \
--header 'Upgrade-Insecure-Requests: 1' \
--header 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36' \
--data-raw '{
    "dbName": "demo",
    "collection": "test",
    "type": "insert",
    "documents": [
        {
            "title": "hello",
            "description": "database",
            "likes": 100,
            "by": "teddy"
        }
    ]
}'

echo -e "\n\n=========================================="
echo "執行 2. json_select (查詢資料)"
echo "=========================================="
curl --location "$API_URL" \
--header 'Content-Type: application/json' \
--header 'DNT: 1' \
--header 'Upgrade-Insecure-Requests: 1' \
--header 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36' \
--data-raw '{
    "dbName": "demo",
    "collection": "employee",
    "type": "select",
    "filter": {
        "job": "HR"
    }
}'


echo -e "\n\n=========================================="
echo "執行 3. json_update (更新資料)"
echo "=========================================="
curl --location "$API_URL" \
--header 'Content-Type: application/json' \
--header 'DNT: 1' \
--header 'Upgrade-Insecure-Requests: 1' \
--header 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36' \
--data-raw '{
    "dbName": "demo",
    "collection": "employee",
    "type": "update",
    "filter": {
        "job": "HR"
    },
    "update": {
        "$set": {
            "salary": 7400
        }
    },
    "upsert": true
}'
echo -e "\n"

echo -e "\n\n=========================================="
echo "執行 4. json_delete (刪除資料)"
echo "=========================================="
curl --location "$API_URL" \
--header 'Content-Type: application/json' \
--header 'DNT: 1' \
--header 'Upgrade-Insecure-Requests: 1' \
--header 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36' \
--data-raw '{
    "dbName": "demo",
    "collection": "employee",
    "type": "delete",
    "filter": {
        "job": "HR"
    }
}'
