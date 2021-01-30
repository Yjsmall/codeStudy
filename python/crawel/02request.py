#coding=utf-8
import requests

keyWord = input('enter a key word:')
headers = {
    'User-Agent': 'Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.96 Mobile Safari/537.36 Edg/88.0.705.50'
}
#动态参数化
params = {
    'query' : keyWord
}


#携带不同参数的关键字
url='https://www.sogou.com/web'

#params参数:保存请求给URL携带
response = requests.get(url=url,params=params,headers=headers)

#修改响应数据的编码格式
response.encoding = 'utf-8'

page = response.text
fileName = keyWord + '.html'
with open(fileName,'w',encoding='utf-8') as fp:
    fp.write(page)
print(fileName,'爬取成功')