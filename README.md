Spring Boot app with domain driven design(DDD).

## Layers

### User Interface
This is where the customer can find all the information needed to place an order. In an e-commerce case, this is where the products are. This layer presents the information to the client and interprets their actions.

### Application
This layer doesn't contain business logic. It's the part that leads the user from one to another UI screen. It also interacts with application layers of other systems. It can perform simple validation but it contains no domain-related logic or data access. Its purpose is to organize and delegate domain objects to do their job. Moreover, it's the only layer accessible to other bounded contexts.

### Domain
This is where the concepts of the business domain are. This layer has all the information about the business case and the business rules. Here’s where the entities are. As we mentioned earlier, entities are a combination of data and behavior, like a user or a product.

They have a unique identity guaranteed via a unique key and remains even when their attributes change. For example, in an e-commerce store, every order has a unique identifier. It has to go through several actions like confirming and shipping to be considered as an entity.

On the other hand, value objects don't have unique identifiers. They represent attributes that various entities can share. For example, this could be the same last name of different customers.

This part also contains services with defined operational behavior that don't have to be a part of any domain. However, they are still part of the business domain. The services are named according to the ubiquitous language. They shouldn't deprive entities and value objects of their clear accountability and actions. Customers should be able to use any given service instance. The history of that instance during the lifetime of the application shouldn't be a problem.

Most importantly, the domain layer is in the center of the business application. This means that it should be separated from the rest of the layers. It shouldn't depend on the other layers or their frameworks.

### Infrastructure
This layer supports communication between other layers and can contain supporting libraries for the UI layer.
