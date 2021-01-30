# 执行 重复 回退

## 1.认识'.'
Line one
	Line two 
		Line three
		Line four
>G本行(included)以下缩进
'x'删除当前光标字符

## 2.不要自我重复
var foo = 1;
var bar = 'a';
var foobar = foo + bar;

A;<Esc> 进入本行末尾(insert)返回添加';'退出
用'A'替代'$a'
'.'重复这个操作

~~~开头shell
复合命令    等效命令
C           c$       删除当前行光标字符(included)以后所有,进入insert
s           cl       删除当前光标字符,进入insert
I                    当前行开头,进入insert
A                    当前行结尾,进入insert
0                    当前行开头,normal
$                    当前行结尾,normal
~~~

## 3.以进为退
var foo = "method("+arguement1+","+arguement2+")";

var foo = "method(" + arguement1 + ","+arguement2 + ")";

f+ find'+' \
';'分号重复find动作\
s+空格+空格<Esc> 移动到'+',用重复这个动作'.' 


~~~shell
整个文档里面查找:
正向查找/
反向查找?

一行查找:
f正向查找
F反向查找
~~~

## 4.查找并手动替换
We're waiting for copy before the site can go live \
If you are copy with this,let's go ahead with
~~~shell
'*' 高亮这个字符
cw{replacement}<Esc> 删除当前word,进入insert
'n'移动到下一个高亮
','重复
~~~

## 5.构造可重复删除
The end is high;
~~~shell
'daw'光标在单词结尾,要删除一个单词
因为可以使用'.'重复
~~~

## 6.次数做简单的算术运算
.blog,.new { background-image: url(data:image);} \
.blog { background-position:0px 0px} \
.new { background-position:-180px 0px} \
.new { background-position:-110px 40px} 
~~~shell
数字<C-a>正向查找第一个number并且加上这个数字 
数字<C-a>正向查找第一个number并且删去这个数字
默认情况加减一
~~~

## 7.操作符+动作命令=操作

|命令 	 |	用途
|--      |---
|c 	 |	删除并且进入插入模式
|d	 |	删除
|y	 |	复制到寄存器
|g~	 |	反转大小写
|gu	 |	转小写
|gU	 |	转大写



