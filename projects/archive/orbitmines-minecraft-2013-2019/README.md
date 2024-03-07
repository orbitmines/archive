- [ ] Which 'controversies to name?'
- - [ ] Which things to exclude ? ; Opt-in by people on the server to verify through their minecraft accounts /discord accounts or so?

2015/08/01 test servers:

```shell
sudo nano /etc/hosts

--

127.0.0.1 sql-3.verygames.net
```

```shell
docker run -p 127.0.0.1:3306:3306/tcp --name minecraft4268 -e MYSQL_PASSWORD=hnfxy5h48 -e MYSQL_USER=minecraft4268 -e MYSQL_DATABASE=minecraft4268 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql:5.7.42
```

Install Java 8:
```shell
/usr/lib/jvm/java-8-openjdk-amd64/bin/java -Xmx1024M -Xms1024M -jar minecraft_server.jar
```

mysql terminal
```shell
DROP DATABASE minecraft4268
```

select db
```shell
mysql -h 127.0.0.1 -P 3306 -u minecraft4268 -p"hnfxy5h48" minecraft4268
```

import
```shell
mysql -h 127.0.0.1 -P 3306 -u minecraft4268 -p"hnfxy5h48" < sql-3.verygames.net.sql
```


time played 66261460 / 20 / 60  / 60 / 24
time played 852976256 / 20 / 60  / 60 / 24

Use this instead

/usr/local/bin/aws s3 cp s3://archive/minecraft/survival/FILE_NAME.zip --endpoint-url https://83b891078c449f7a3193945f31f3dc0f.r2.cloudflarestorage.com

/usr/local/bin/aws s3 cp 2015-08-01_OrbitMines_Survival.zip s3://archive/minecraft/survival/2015-08-01_OrbitMines_Survival.zip --endpoint-url https://83b891078c449f7a3193945f31f3dc0f.r2.cloudflarestorage.com

```shell

#Locate certifi bundle (cacert.pem) location 
python -m certifi
export AWS_CA_BUNDLE="[full path to cacert.pem]" from step 1
```

this one works? ; issues with certificate
```shell
sudo apt-get install libffi-dev
sudo pip install -U requests[security]
```

/usr/local/bin/aws s3api put-object --key "minecraft/survival/2019-06-17_OrbitMines_Survival.zip" --body 2019-06-17_OrbitMines_Survival.zip --bucket archive --endpoint-url https://83b891078c449f7a3193945f31f3dc0f.r2.cloudflarestorage.com


https://docs.aws.amazon.com/cli/latest/reference/s3api/put-object.html
archive
```shell
/usr/local/bin/aws s3api put-object --key "minecraft/survival/02-05-2015_OrbitMines_Survival.zip" --body 02-05-2015_OrbitMines_Survival.zip --bucket archive --endpoint-url https://83b891078c449f7a3193945f31f3dc0f.r2.cloudflarestorage.com
```

/usr/local/bin/aws s3api put-object --key "minecraft/kitpvp/2018-10-10_OrbitMines_KitPvP_Desert.zip" --body 2018-10-10_OrbitMines_KitPvP_Desert.zip --bucket archive --endpoint-url https://83b891078c449f7a3193945f31f3dc0f.r2.cloudflarestorage.com

/usr/local/bin/aws s3api put-object --key "minecraft/hub/2019-04-29_OrbitMines_Hub_Lobby.zip" --body 2019-04-29_OrbitMines_Hub_Lobby.zip --bucket archive --endpoint-url https://83b891078c449f7a3193945f31f3dc0f.r2.cloudflarestorage.com

https://pypi.org/project/nbt2yaml/
nbtedit level.dat



```
SELECT concat('SELECT * FROM ',TABLE_NAME,' WHERE ',COLUMN_NAME,' =\'002b44d6-13d3-468f-8f7c-510119a73a10\'')
  FROM INFORMATION_SCHEMA.COLUMNS
 WHERE COLUMN_NAME = 'uuid'
;
```
