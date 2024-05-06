// Java EE terms
- **JNDI:** API for directory services to look up data and resources, done through Initial Context API.
  Data and resources can come from flat file, database or an application server. Java RMI and JEE use JNDI to look up objects over network.
  Very common directory services like LDAP, DNS, etc. can be accessed using JNDI. If you want to do JNDI look-up in your Restful
  beans or EJB classes, there is an Initial Context API.
- **Stateless session bean:** Bean used to perform independent operations. You can add a lot of business methods which do database interactions.
  Application server creates a pool of stateless session bean.
- **Global Xactions:** When you have a distributed environment, you may have multiple resource managers on which you are trying to do
  Xactions. Multiple resources could be Databases, JMS Queues, application servers, etc. Whenever you do this distributed Xaction processing, 
  it is absolutely important that the data integrity is ensured. Now XA or extended architecture, is an open standard which is defined for 
  executing global transaction that accesses more than one backend datastore. This is the one which helps to define the interactions between the 
  Xaction manager and the resource manager. The goal of XA is to allow multiple resources like databases, JMS Queues, Xactional caches, etc.
  to be accessed within the same Xaction, thereby preserving the ACID properties across applications. 
- **Java Xaction API:** List of interfaces between the Xaction manager and the parties involved in the Xaction.
  This Xaction API has specifications to perform transactions over a distributed network. The parties involved in the Xaction processing will be 
  the resource manager, the application server and the application core. So JPA is going to specify the interface between
  the Xaction manager and all of these parties, gives you a way to do Xaction processing. 



// Usecases and JEE concurrency APIs
- Usecase: List of bank accounts and Xactions against those bank accounts. Generate a report for all the 
          Xactions per bank account. 
  - Using: ManagedExecutorService ![managedexecutorservice.png](src%2Fmain%2Fresources%2Fmanagedexecutorservice.png)
- Usecase: Health check for an application. Scheduled health checks.
  - Using: ManagedScheduledExecutorService![managedscheduledexecutorservice.png](src%2Fmain%2Fresources%2Fmanagedscheduledexecutorservice.png)
- ManagedThreadFactory & ThreadPoolExecutor - custom thread factory implemenation.
- ContextService API
  - contextual objects: Java object which has a particular application component's container context associated with it.
  - contextual tasks: tasks submitted to managed resource. When a task instance is submitted to managed instance of executor service then the 
    tasks becomes a contextual task. When the contextual task runs, the task behaves as if it was still running inside a container it was submitted with. 
    When you have a application component like EJB, a servlet. Then we know that the thread that is running is going to have the contextual information 
    associated with it. 
  - ContextService API allows applications to create contextual objects without a managed executor. To understand it, if we create a thread 
    using Java SE platform inside the enterprise environment we know that the contextual information is not guaranteed to be given to the thread.
    Because the container is not aware of the thread created using the Java SE. If you want to capture the container context, and run with that context
    may be on another instance of the server or restart. Then the ContextService API is the way to do it. 
  - Basically it gives the context information to store it and run it later.
  - How? Uses the dynamic proxies capabilities to associate an application's container context with an object instance.
    This object now becomes a contextual object and whenever a method on the contextual object runs, then the method executes with the thread context of that 
    associated application component instance.
  - Used in advanced scenarios