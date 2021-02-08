## 多线程

### ThreadLocal

概念：提供线程本地变量，可以保证每次访问到的变量都是当前线程

ThreadLocal<Obj> tl set()

```java
 public void set(T value) {
        Thread t = Thread.currentThread();
        ThreadLocalMap map = getMap(t);
        if (map != null) {
            //key:ThreadLocal类自身 value:Obj
            map.set(this, value);
        } else {
            createMap(t, value);
        }
    }
```

获取 ThreadLocalMap， 该map为 Thread 类中成员变量，线程私有

```java
 ThreadLocalMap getMap(Thread t) {
        return t.threadLocals;
    }
 
 ThreadLocal.ThreadLocalMap threadLocals = null;
```

Entry对象使用弱引用

* 如果Entry为强引用，tl为null时，key值引用依旧指向ThreadLocal对象，造成内存泄漏，使用弱引用不会

* ThreadLocal回收，key为null, value无法被访问，造成内存泄漏

```java
 private void set(ThreadLocal<?> key, Object value) {

```
            Entry[] tab = table;
            int len = tab.length;
            int i = key.threadLocalHashCode & (len-1);
    	  
    	  ```
        }
        
        
        
          static class Entry extends WeakReference<ThreadLocal<?>> {
                Object value;
                Entry(ThreadLocal<?> k, Object v) {
                    super(k);
                    value = v;
                }
            }





引用类型：

* 强引用：不会被GC回收
* 软引用：内存不足时被回收
* 弱引用：GC时回收
* 虚引用：结合ReferenceQueue队列，随时回收



## 锁

### 轻量级

自旋锁

* CAS：compare and swap 。 自旋锁的实现方式。流程：修改当前值E，计算结果V，比较E和当前值N，相等则更新为V，不想等，将N设置为E，循环计算。

问题： 

ABA问题：版本号解决

CAS修改值的时候原子性原则问题。unsafe类中 compareAndSwapObj方法，由Native修饰， C++，lock cmpxchg 指令，所总线程

### 重量级

操作系统调度，用户态和内核态切换、线程阻塞造成的线程切换。

### 锁升级

对象实例在堆中分三个组成部分，对象头，实例数据和对齐填充，对象头包括 mark word , 指向类的指针，数组长度，mark word记录了对象，锁和垃圾回收的信息。锁升级的目的是为了减低锁带来的性能消耗。

synchronized 锁升级原理：锁对象的的对象头有个threadId 字段，第一次访问时候jvm会让锁对象持有偏向锁，将threadId 设置为线程ID，再次进入是会将threadId 和 线程ID做比较，如果一致直接使用此对象，如果不一致，则升级偏向锁为轻量级锁，通过自旋一定次数来获取锁，如果自旋一定次数未获取到锁，此时锁由轻量级升级为重量级。

## 计算机

### 计算机组成原理

xx.exe -> 内存开辟一块空间->PC通过指针进行标记->register开始计算->返回结果

### 缓存一致性

cpu执行速率为内存100倍左右，所以在寄存器添加缓存 三级缓存，l1 l2 CPU私有，L3CPU公有，缓存行效率最高64字节

### oop-klass

jvm和对象的内存关系，创建的类在**InstanceKlass**类的实例 中存储，保存类的构造方法，继承信息，成员变量，成员方法等，jvm 可以通过反射InstanceKlass获取类的全部数据。

### new Object

* new->Jvm遇到此指令先检测能否在常量池中定位到这个类的符号引用，并检测这个符号引用所代表的类是否被加载解析初始化，如果没有将会执行类加载流程(将.java->.class文件加载进内存)，类加载后可确定内存大小，之后jvm为新生对象分配内存，根据JAVA堆是否规整分配，分配方式有两种，一种是指针碰撞，一种是空间列表，Java堆是否规整由GC算法决定。JVM将分配的内存空间初始化为0,属性赋值。

* 将类加载到方法区域，创建一个klass,klass中保存java类的的所有信息，包括 变量，方法，属性，构造方法等
* 对象完成初始化时，jvm会在堆分配的空间中创建一个oop，这个oop主要存储对象实例的成员变量 ，同时存在一个指针指向 klass,jvm运行期间可以通过这个类获取到所有类元数据                                                                                                                          