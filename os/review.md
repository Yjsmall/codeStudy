## 操作系统概述
### 介绍

OS是配置计算机硬件的第一层软件，为用户提供一系列接口方便用户，提高资源利用率，合理地组织计算机工作。

### 发展
>单道批处理系统

监督程序（Monitor）。cpu执行，I/O停止

特征：自动性，顺序性，单道性
>多道批处理系统

AB A-cpu B-I/O
为了提高资源利用率
优点：资源利用率高，系统吞吐量大 缺点：平均周转时间长，无交互能力

特征：多道性，无序性，调度性

**多道程序技术(不是多道批处理系统)** 标志os诞生

>分时系统

每一个人都有一个时间片

特征：人际交互 共享主机

### os的基本特征

1. 并发（concurrency）
并发行：多个事件同一**时间间隔**发生\
并行性：多个时间同一**时刻**发生

2. 共享（sharing）

进入内存作业，都有机会让cpu给其安排资源

3. 虚拟（virtual）

4. 异步（asynchronism）

作业完成时间未知，调度程序和等待cpu时间

### os的功能
1. 处理机管理功能
2. 存储器管理功能
3. 文件管理功能
4. 设备管理功能

## 进程管理
### 前趋图和程序执行
程序并发的特征：

* 间断性
* 失去封闭性
* 不可再现性

程序满足再现性的条件
$$
read(p_i)：读这个程序 
$$
$$
write(p_i)：写这个程序
$$

$$
[r(p_i)\cap w(p_j)]\cup
[r(p_j)\cap w(p_i)]\cup
[w(p_i)\cap w(p_j)] = \{\}
$$

### 进程描述
进程具有生命周期：创建产生，调度执行，撤销消亡

#### 进程的状态

>三种状态转换图

>suspend && active 操作图

#### 进程控制

进程控制一般:
是由os的内核的原语实现.
原语:若干条机器码指令集合,执行过程中不允许中断

---
进程的创建的事件:

系统内核:用户登录 作业调度 提供服务
用户:应用请求

进程创建(create()原语):

申请空表pcb->为新进程分配运行所需资源->初始化呢pcb->如果就绪队列可以接收新进程,则新进程插入就绪队列.

进程终止:
1. 正常结束(自然死亡)
2. 异常结束(自杀)
3. 外界干预(他杀)

进程的阻塞与唤醒

阻塞:阻塞是进程自身的一种主动行为--block()
1. 想系统请求共享资源失败
2. 等待某种操作完成--想要使用打印机
3. 新数据没有到达--合作
4. 等待新的任务到达--网络环境

思考状态图,并且联想实际

唤醒:wakeup()

block--wakeup一对作用想法原语,必须成对出现.

两个进程的事情:
a与b竞争,合作

a竞争到资源,b进程阻塞;

a释放资源,唤醒b,使其b可以进行工程

#### 进程同步问题
> 生产者-消费者问题

~~~c
/**
 * error:
 * 生产者先 申请占有临界资源,表示对缓冲池占有
 * 然后    申请占有空的缓冲池,但是没有空位置,block
 * 消费者  申请占有临界资源,被生产者占有,block
 * 两人都block,死锁
 */

int in = out = 0;
item buffer[n];
//mutex表示对缓冲池资源的访问
semaphore mutex = 1;
semaphore empty_count = n;
semaphore full_count = 0;

void producer(){
    while(true){
        //生产一个商品
        item temp;

        //AND信号量{Sait(empty_count,mutex)}
        wait(empty_count);
        wait(mutex);

        buffer[in] = temp;
        in = (in+1)%n;

        signal(mutex);
        signal(full_count);
    }
    
}

void consumer() {
    while(true){
        wait(full_count);
        wait(mutex);
        
        temp = buffer[out];
        out = (out+1)%n;

        sigal(mutex);
        sigal(empty_count);
    }
}
void main() {
    cobegin
        producer();
        consumer();
    coend;
}
~~~

>哲学家进餐

>读者-写者问题

写者:他与任何人互斥
读者:读者-读者->同步;读者-写着->互斥
通过使用计数器判断是否有读者占用文件,不同读者对计数器访问是互斥的;
文件写的权利是互斥的
~~~C
/**
 * 读者1 读者2 写者 读者3 读者4
 */ 
//读者优先
//这些都是全局变量
int readcount = 0;
semaphore rmutex = 1;
semaphore mutex = 1;

Reader(){
    while(true){
        P(rmutex);
        if(readcount == 0) {
            P(mutex);
        }
        readcount++;
        //申请readcount(rmutex)占有权,防止另一个读者来读文件,readcount依旧是1;
        V(rmutex);
        
        /** 
         * readcout = 1;
         * semaphore rmutex = 1;
         * semaphore mutex = 0;
         * 读者1来了,读者2来了,写者3来了(阻塞)
         * 读者4来了,读者5来了
         * 即使后来,写者还是要等读者5全部读完才能写
         */ 

        reading operations;

        P(rmutex);
        readcount--;
        if(readcount == 0) {
            V(mutex);
        }
        V(rmutex);
    }
}

Writer(){
    while(true){
        P(mutex);

        writer operations;

        V(mutex);
    }
}
~~~

~~~C
//公平算法
int readcount = 0;
semaphore rmutex = 1; //初始化,读者互斥访问readcount
semaphore mutex = 1;  //互斥访问数据区
semaphore wmutex = 1; //互斥占有数据区的修改权

//读者,写者都是先来先服务,申请占有数据区的使用权
Reader(){
    while(true){
        P(mutex);
        P(readmutex);
        if(readcount == 0)
            P(wmutex);
        readcout++;
        V(rmutex);
        V(mutex);

        reading;

        P(readmutex);
        readcout--;
        if(readcount == 0)
            V(wmutex);
        V(rmutex);

    }
}

Writer(){
    while(true){
        P(mutex);
        P(wmutex);

        writing;

        V(wmutex);
        V(mutex);
    }
}
~~~

### 进程调度
### 死锁
> 银行家算法 && 安全序列

已知Available资源数目,然后寻找Need资源 < Available
分配给它,然后已经有的ALLocation加上Available就是现在所要是释放的.以此循环.

--- 
银行家算法

$$Request_i(3,3,0) \leq Need_i(4,4,4);$$
$$Request_i(3,3,0) \leq Available_i(4,4,4);$$
然后同上,如果Available满足那些Need,有安全序列,否则没有安全序列

$$Request_i(3,3,0) \leq Need_i(4,4,4);$$
$$Request_i(3,3,0) > Available_i(4,4,4);$$
进程$P_i$进行等待

### 资源分配图(Resource Allocation Graph---RAG)

## 内存管理
$$
\mathrm{A}\alpha
\mathrm{B}\beta
\gamma
\delta
\theta
\digamma
\leq
\nleq
\subseteq
\nsubseteq
\approx
\div
\times
\neq

\lor
\land
\neg
\forall
\rightarrow
\begin{bmatrix}
1 & x & x^2 \\
1 & y & y^2 \\
1 & z & z_2 \\
\end{bmatrix}
$$
$$
\left\{ 
\begin{array}{c}
a_1x+b_1y+c_1z=d_1 \\ 
a_2x+b_2y+c_2z=d_2 \\ 
a_3x+b_3y+c_3z=d_3
\end{array}
\right.

$$
$$
\begin{cases}
a_1x+b_1y+c_1z=d_1 \\ 
a_2x+b_2y+c_2z=d_2 \\ 
a_3x+b_3y+c_3z=d_3
\end{cases}
$$

$$
Ax=b\\
A
\begin{bmatrix}
    0.1\\
    0.2
\end{bmatrix}=b
\\
\spadesuit\quad\heartsuit\quad\diamondsuit\quad\clubsuit\quad\color{red}{\heartsuit}\quad\color{red}{\diamondsuit}
$$

