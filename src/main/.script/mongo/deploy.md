# 清除舊的 build 並打包
mvn clean package

# test
java -jar target/mmogo.jar --server.port=8085

# scp
```
...... (skip)
mkdir -p /opt/mmogo/logs
sudo chown -R teddy:teddy /opt/mmogo/
```

# project tree (以 ubuntu 26.04 lts 為例)
```
/opt/mmogo/
├── mmogo.jar
└── logs/app.log
```

# add systemd
sudo vi /etc/systemd/system/mmogo.service
```
[Unit]
Description=Spring MongoDB Test Service
After=network.target

[Service]
Type=simple
User=teddy
WorkingDirectory=/opt/mmogo
ExecStart=java -Xms256m -Xmx512m \
-jar /opt/mmogo/mmogo.jar \
--spring.profiles.active=prod
ExecStop=/bin/kill -TERM $MAINPID
Restart=on-failure
RestartSec=10
StandardOutput=append:/opt/mmogo/logs/app.log
StandardError=append:/opt/mmogo/logs/app.log

[Install]
WantedBy=multi-user.target
```

```
# 重新載入 systemd 設定
sudo systemctl daemon-reload

# 設定開機自動啟動
sudo systemctl enable mmogo

# 立即啟動服務
sudo systemctl start mmogo

# 查看服務狀態
sudo systemctl status mmogo

# 查看即時 log
sudo journalctl -u mmogo -f
```