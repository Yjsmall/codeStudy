#coding=utf-8
import requests

#1.指定url
url = 'http://www.sogou.com'

#2.发起请求get方法的返回值作为对象
response = requests.get(url=url)

#3.响应数据
#.text:返回的是字符串形式的响应数据
page_text = response.text

#4.持久化
with open('sogou.html','w',encoding='utf-8') as f:
    f.write(page_text)
