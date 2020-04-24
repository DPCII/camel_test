# Camel Demo

Camel is a lightweight framework that integrates networked systems.
It links information sources of different formats and protocols through a
system of abstracted processes, which build into a sustainable and re-usable composite
system. It receives data in any format as 'messages' and passes them along after translating
them or performing operations on them as necessary. 

##

### Demo Setup

ActiveMQ
```
docker pull rmohr/activemq
docker run -p 61616:61616 -p 8161:8161 rmohr/activemq
```

Open localhost:8161 and create a queue named "send_queue", "receive_queue", and "db_queue".

PostgreSQL
```
1. Start local postgres on default 5432
2. Open psql at console
3. CREATE TABLE test_db_camel (                                                                                                                                            
    id INT GENERATED ALWAYS AS IDENTITY,                                                                                                                                               
    message VARCHAR NOT NULL DEFAULT 'No message passed'                                                                                                                               
    );
```

##

### Key Architecture
1. Camel Context: A class which integrates all elements of camel, similar to SpringContext.
2. Route / RouteBuilder: Establishes a linking entity between two communication nodes.
3. Endpoint: Entity that represents a single communication node.
4. TypeConverters: Performs type conversion under the hood and abstracted away from the larger operation.
5. Registry: An abstraction utility which stores and returns the key objects used by Camel. It is bound to the Context.
6. Component: A class which represents a common protocol or use-case. ie Dropbox, Gmail, ActiveMQ.
7. Message: The entity which represents transferred data. Structured into Header, Attachment, Body. Data type agnostic.
8. Exchange: Encapsulates the message entity. May contain an InOnly message, or an InOut message which includes the
destination's response.

### Useful Links
Data Format: https://camel.apache.org/manual/latest/data-format.html

Core Components: https://camel.apache.org/components/latest/index.html

Core Concepts: https://livebook.manning.com/book/camel-in-action/chapter-1/1

