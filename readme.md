# Camel Demo

Camel is a lightweight framework that integrates different data formats.
It subscribes and observes endpoints of different formats and passes
along messages after translating the data as necessary. 

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
1. Camel Context: Integrates component elements of camel, similar to SpringContext
2. Route / RouteBuilder: Establishes a linking entity between two communication nodes
3. Endpoint: Entity that represents a single communication node.
4. Producer / Consumer Templates: Provides model for performing actions on a Route
5. Registry: List of Maps <Endpoints, Connections> bound to Context
6. Component: A class which represents a common protocol or use-case. ie Dropbox, Gmail, ActiveMQ

### Useful Links
Data Format: https://camel.apache.org/manual/latest/data-format.html

Core Components: https://camel.apache.org/components/latest/index.html

