# Respuestas

### 1. Amplía la definición IEEE de arquitectura de software para incluir una definición de las actividades involucradas en el diseño arquitectónico.

### 2. ¿Cuáles son las diferencias entre una arquitectura de seguridad centralizada y distribuida? 

Una arquitectura distribuida tiene una mayor tolerancia a los fallos, ya que al caer un nodo la información se encontrará en otros. Se trata de un sistema mucho más robusto que uno centralizado debido a esta tolerancia a los fallos sin que se vean afectados los procesos o los datos.

### 3. Enumera  los problemas arquitectónicos más importantes para el desarrollo de productos



### 4. ¿Qué elección de arquitectura es probable que aumente la mantenibilidad del sistema? 

Arquitectura de microservicios ya que divide la aplicación en pequeños servicios independientes los cuales se encargan de una función específica.

### 5. Una arquitectura diseñada para respaldar la seguridad puede basarse en un modelo centralizado, donde toda la información confidencial se almacena en un lugar seguro, o en un modelo distribuido, donde la información se distribuye y almacena en muchos lugares diferentes. Sugiere una ventaja y una desventaja de cada enfoque.


### 6. Explica qué se entiende por disponibilidad del sistema 

Se trata de la capacidad de un servicio, de unos datos o de un sistema, a ser accesible y utilizable por los usuarios (o procesos) autorizados cuando estos lo requieran. Supone que la información pueda ser recuperada en el momento en que se necesite, evitando su pérdida o bloqueo.

### 7. ¿Por qué es importante tratar de minimizar la complejidad en un sistema de software? 



### 8. Estás desarrollando un producto para vender a compañías financieras. Explicando las razones de su respuesta, considera los problemas que afectan la toma de decisiones arquitectónicas y sugiere qué dos factores probablemente sean los más importantes. 


### 9. ¿Cuáles son las tres preguntas fundamentales que debe considerar durante el proceso de diseño arquitectónico? 

Como debe organizarse el sistema como un conjunto de componentes arquitectonicos
Como deberian distribuirse

### 10. Enumera 4 tipos de relaciones entre componentes de software. 


### 11. ¿Por qué a veces es imposible localizar las interacciones de los componentes dentro de una sola capa? 


### 12. ¿Cuáles son las preocupaciones arquitectónicas transversales? 


### 13. ¿Qué tipos de integración son posibles cuando se incluyen múltiples servicios en un producto de software?

Integración mediante API (SOAP), basada en mensajes (RabbitMQ) , mediante servicios de bus (Apache service), mediante eventos (Apache kafka)

### 14. ¿Por qué necesitas considerar las tecnologías utilizadas en una arquitectura en capas al descomponer un sistema en componentes? 

Por que las tecnologías van a influir en cada una de las capas asi como en los componentes dado que estos se interrelacionan. 

### 15. Describe brevemente la noción de arquitectura cliente-servidor.  

La arquitectura cliente-servidor es un modelo de diseño de software en el que las tareas se reparten entre los proveedores de recursos o servicios, llamados servidores, y los demandantes, llamados clientes

### 16. ¿Cuál es la función de los componentes fundamentales del patrón MVC?



### 17. ¿Qué es una arquitectura orientada a servicios?

La arquitectura orientada a los servicios (SOA) es un tipo de diseño de software que permite reutilizar sus elementos gracias a las interfaces de servicios que se comunican a través de una red con un lenguaje común.

### 18. Enumera 5 opciones tecnológicas que debe tomar al diseñar una arquitectura de software 

- Base de Datos
- Plataforma
- Servidor
- Código abierto
- Herramientas de desarrollo

### 19. ¿Qué factores hay que tener en cuenta a la hora de implementar un producto móvil?


### 20. Explica brevemente cómo la estructuración de una arquitectura de software como una pila de capas funcionales ayuda a minimizar la complejidad general de un producto de software. 


### 21. Imagina que un gerente te ha preguntado si tu empresa debería alejarse o no de las descripciones arquitectónicas informales a descripciones más formales basadas en UML. Escribe un breve informe dando consejos al gerente. 


### 22. Usando un diagrama, muestra cómo se puede implementar la arquitectura genérica para una aplicación basada en web usando una arquitectura cliente-servidor de varios niveles. 


### 23. ¿Bajo qué circunstancias impulsaría tanto procesamiento local como sea posible en el cliente en una arquitectura cliente-servidor? 


### 24. Realiza una lectura preliminar y describe tres diferencias fundamentales entre las bases de datos relacionales y NoSQL.

- Las relacionales usan tablas y las noSQL no.
- NoSQL es más barato de mantener a diferencia de SQL.
- Las no relaciones no usan SQL como las relacionales, usan CQL (Cassandra), GQL(BigTable), JSON(MongoDB), etc.

Sugiere tres tipos de productos de software que podrían beneficiarse del uso de bases de datos NoSQL y explique por qué el enfoque NoSQL es apropiado.

- LinkedIn
- Facebook
- eBay

Las no relacionales minimizan costos a diferencia del SQL y esto es muy útil cuando el público dirigido es bastante amplio.



