# Ms

## 基础

### 集合

#### HashMap

* 数据结构 数组+链表+树(扩容时涉及树和链表之间的切换)

* 线程不安全

  * 多线程put方法造成数据覆盖 p.next = newNode(hash, key, value, null) ，链表指针指向下一个数据覆盖之前的

  * 多线程put/get，resize时 table = newTab; 代码此时table为null，其他线程get时获取空

* 扩容
  * 无参构造函数，数组为null,扩容，长度为16，负载因子0.75，阙值12
  * 有参构造，指定容量，容量超过阙值时扩容
  * 非第一次扩容，容量为原来的两倍，阙值也为原来的两倍

#### ConcurrentHashMap

* 数据结构 数组+链表+树, 节点是treeBin, treeBin中包含treeNode节点
* CAS 和 synchronized 保证并发性
  * unsafe 核心方法 tabAt/casTabAt/setTabAt， sizeCtl 负数代表正在进行初始化或扩容操作(cas保证可见性)，正数类似阙值
  * 扩容时 赋值操作 通过 synchronized 对节点上锁支持并发

#### ArrayList

* Object数组 有序 可重复 删/改慢 O(n) 查快 O(1) native
* System.arraycopy(original, 0, copy, 0,Math.min(original.length, newLength))

#### LinkedList

* Node数组 有序 双向链表 删/改慢 O(1) 改变指针 查慢 O(n)
* Node实体之间指针的切换

#### Set

* HashSet 无序 不可重复 底层为hashMap的Key

### 流

#### IO

* 字节流 inputStream / outputStream
* 字符流 reader / writer , bufferReader / BufferWriter

核心设计模式

* 装饰着模式

  ```cpp
  //把InputStreamReader装饰成BufferedReader来成为具备缓冲能力的Reader。
  BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
  ```

* 适配器模式

  ```cpp
  //把FileInputStream文件字节流适配成InputStreamReader字符流来操作文件字符串。
  FileInputStream fileInput = new FileInputStream(file); 
  InputStreamReader inputStreamReader = new InputStreamReader(fileInput);
  ```

#### NIO

* 同步非阻塞
  * Channel: 读写双向通道，阻塞/非阻塞，
  * Buffer: 内存中的一块，数据存储读取的地方
  * Selector：管理多个channel

#### BIO/AIO

 同步阻塞/异步非阻塞

### 多线程

#### 生命周期

new-(start)->runnable-(run)->running->end, waiting(join,wait)，time_waiting(join(1),wait(1),sleep(1)), blocked(IO阻塞/锁),

#### 并发编程

#### 锁

* 线程是否锁住同步资源 乐观锁/悲观锁 
* 锁同步资源失败是否阻塞，不阻塞 自旋锁/自适应自旋锁
* 多线程竞争锁是否需要排队 公平锁/非公平锁
* 一个线程多个流程是否可以获取同一把锁 可重入锁/不可重入锁
* 多线程是否共享一把锁 共享锁/排他锁

#### 锁升级

jvm设将所对象设置为偏向锁(首次获取资源)锁对象中的threadId赋值给线程id, 再次获取资源时比较锁threadId与当前线程id是否相等如果相等直接获取资源，否则设置为轻量级锁，当自旋到一定次数如果还没获取到资源即升级为重量级锁。

#### New Object

jvm遇到new指令，先检测类常量池中的定位到类的符号引用，并检测这些符号引用的所代表的类是否需要加载解析初始化，确定内存分配大小，jvm会根据gc算法决定分配内存是否规整，在堆内存分配一块内存空间初始化为0，赋值

#### Thread Local

``````
//key:ThreadLocal实例，value:Obj
 ThreadLoalMap.set(this, value);,ThreadMap主要承载数据的是Entiy, key为弱引用，若制定key为null,value无法回收导致内存泄漏.降低方式是指行完 get/set 执行remove方法
``````

###  网络通信

#### tcp/ip

应用层/运输层/网络层/连接层

http->tcp(http数据包)->ip(tcp(http数据包))->以太(ip(tcp(http数据包))) -> 反解析

名词: SYN 新建一个链接，FIN释放一个连接，ACK=1确认序号有效，seq 序号 ，ack确认序号

三次握手：(1)客户端新建一个请求连接，seq=1,SYN=1,(2)服务端收到请求回复报文ack=100, ACK=1,SYN=1,seq=100,客服端收到请求，确认服务端已经收到消息，(3)seq=101,ack=101,ACK=1,SYN=1,服务端接收到信息后长连接建立，开始发送数据。（三次和四次是为了防止丢包）

四次挥手：(1)客户端新建一个释放连接请求，seq=1,FIN=1,表示已不再发送数据包，(2) 服务端接收后回复报文，ack=100,ACK=1,seq=100,表示确认收到数据，状态改为关闭等待状态，(3)接着服务端将最后的数据处理完后向客服端发出释放连接报文 FIN=1,sql=101, ack=100,ACK=1,(4)客户端收到服务端报文后经过2msl在发送报文给服务端，ACK=1.seq=102,ack=101,服务端收到报文释放连接

## JVM

### 内存模型



### 堆栈溢出

### 类加载

### new Object

### voliate

### threadLocal

### GC

### JVM/GC调优



## MQ



## Sql / NoSql



## Spring 



## SpringBoot



## SpringCloud





