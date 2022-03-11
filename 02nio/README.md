第2周作业  

Week02 作业题目：  

4.（必做）根据上述自己对于 1 和 2 的演示，写一段对于不同 GC 和堆内存的总结，提交到 GitHub。     

   串行GC（Serial GC）：    

    串行 GC 对年轻代使用 mark-copy(标记-复制) 算法，对老年代使用 mark-sweep-compact(标记-清除- 整理)算法。
    两者都是单线程的垃圾收集器，不能进行并行处理，所以都会触发全线暂停(STW)，停止所有的应用线程。 因此这种 GC 算法不能充分利用多核 CPU。不管有多少 CPU 内核，JVM 在垃圾收集时都只能使用单个核心。 CPU 利用率高，暂停时间长。简单粗暴，就像老式的电脑，动不动就卡死。
    该选项只适合几百 MB 堆内存的 JVM，而且是单核 CPU 时比较有用。
    
    -XX:+UseSerialGC 配置串行 GC
    -XX:+USeParNewGC 改进版本的 Serial GC，可以配合 CMS 使用。

   并行GC（ParNew、Parallel Scavenge、Parallel Old）： 

    年轻代和老年代的垃圾回收都会触发 STW 事件。
    在年轻代使用 标记-复制(mark-copy)算法，在老年代使用 标记-清除-整理(mark-sweep-
    compact)算法。
    -XX:ParallelGCThreads=N 来指定 GC 线程数， 其默认值为 CPU 核心数。
    并行垃圾收集器适用于多核服务器，主要目标是增加吞吐量。因为对系统资源的有效使用，能达到 更高的吞吐量:
    • 在 GC 期间，所有 CPU 内核都在并行清理垃圾，所以总暂停时间更短;
    • 在两次 GC 周期的间隔期，没有 GC 线程在运行，不会消耗任何系统资源。

    -XX:+UseParallelGC 
    -XX:+UseParallelOldGC 
    -XX:+UseParallelGC 
    -XX:+UseParallelOldGC

   CMS： 

    其对年轻代采用并行 STW 方式的 mark-copy (标记-复制)算法，对老年代主要使用并发 mark-sweep ( 标记-清除)算法。
    CMS GC 的设计目标是避免在老年代垃圾收集时出现长时间的卡顿，主要通过两种手段来达成此目标:
    1. 不对老年代进行整理，而是使用空闲列表(free-lists)来管理内存空间的回收。
    1. 在 mark-and-sweep (标记-清除) 阶段的大部分工作和应用线程一起并发执行。 也就是说，在这些阶段并没有明显的应用线程暂停。但值得注意的是，它仍然和应用线程争抢CPU 时。 默认情况下，CMS 使用的并发线程数等于 CPU 核心数的 1/4。
    如果服务器是多核 CPU，并且主要调优目标是降低 GC 停顿导致的系统延迟，那么使用 CMS 是个很明智 的选择。进行老年代的并发回收时，可能会伴随着多次年轻代的 minor GC。
    
    -XX:+UseConcMarkSweepGC

   G1：      

    默认将内存划分为1024个小堆，这样这样划分之后，使得 G1 不必每次都去收集整 个堆空间，而是以增量的方式来进行处理: 每 次只处理一部分内存块，称为此次 GC 的回收 集(collection set)。每次 GC 暂停都会收集所 有年轻代的内存块，但一般只包含部分老年代 的内存块。
    G1 的另一项创新是，在并发阶段估算每个小堆 块存活对象的总数。构建回收集的原则是: 垃 圾最多的小块会被优先收集。这也是 G1 名称 的由来


6.（必做）写一段代码，使用 HttpClient 或 OkHttp 访问 http://localhost:8801 ，代码提交到 GitHub  
    代码类：ClientAbortMethod