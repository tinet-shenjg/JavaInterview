## 工作中总结的一些正则表达式
1. 字母数字和英文半角，    
```javascript 1.8
^\w+(,\w+)*$
``` 
```javascript
var reg = / ^\w+(,\w+)*$/;
var mt= campaignid.match(reg);
```


2. 数字和英文半角，     
```javascript
^\d+(,\d+)*$
```

```javascript
var reg = /^\d+(,\d+)*$/;
var mt= campaignid.match(reg);
```
