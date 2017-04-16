* concurrency
    * https://dzone.com/articles/synchronized-vs-lock
    * http://lycog.com/concurency/performance-reentrantlock-synchronized/
    * https://sls.weco.net/blog/silver8250/08-mar-2007/8499
* queue
    * http://stackoverflow.com/questions/1301691/java-queue-implementations-which-one
    * from javaDoc
        * A ConcurrentLinkedQueue is an appropriate choice when many threads will share access to a common collection. This queue does not permit null elements.
        * ArrayBlockingQueue is a classic "bounded buffer", in which a fixed-sized array holds elements inserted by producers and extracted by consumers. This class supports an optional fairness policy for ordering waiting producer and consumer threads
        * LinkedBlockingQueue typically have higher throughput than array-based queues but less predictable performance in most concurrent applications.    
* library
    * http://blog.jevsejev.io/2017/02/19/java-libraries-you-cannot-miss-in-2017/

