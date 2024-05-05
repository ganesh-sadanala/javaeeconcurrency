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
- Using: ManagedExecutorService 