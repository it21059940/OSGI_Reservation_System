# OSGI_Reservation_System
We have chosen to build an OSGI centralized reservation system. As of today there are many large companies that provide multiple services in different areas to customers. For example – Jetwing has Jetwing hotels, Jetwing travels etc:- Our system is focused on being of use to these type of companies. For this implementation we considered a company Lemon Holdings PLC which provides 4 types of services.

1.	 Lemon Hotels - A hotel that has room reservation and vacation day out options for customers
2.	 Lemon Travels - A vehicle booking service
3.	 Lemon Restaurants - A restaurant and catering service
4.	 Lemon Fitness - A gym and wellness center

Since in these types of situations a customer only uses one service at a time, we have implemented different consumers (customers) for each service. 

Why use a microkernel approach over a monolithic architecture?

There are so many reasons why we thought of OSGI (microkernel) would be a best approach for a centralized service reservation system.

•	Extensibility -  since all the services are implemented separately and they are loosely coupled it is extremely easy for us to add new services or modify existing services without changing the entire system. For e.g.- Lemon holdings decide to new sector as Lemon Clothing. We can easily add the required services as a new bundle without having to change the core system.

•	Security – Since services are implemented as separate components, there was much protection between the components and there fore much less vulnerable to attacks (attackers will find it harder to attack the entire system).

•	Reliable and Portable – Microkernel architecture provides great reliability and portability too.
