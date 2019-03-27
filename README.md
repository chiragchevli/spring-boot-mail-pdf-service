<div align="center">
  
# Mail-pdf-service
#### REST API to email PDF with given data, developed In Spring Boot 2.1

</div>

### Technologies
    
 * **Spring Boot 2.1.3**
 * **CloudAMQP (RabbitMQ)**
 * **Spring Boot Mail**
 * **Apache Log4j 2**
 * **iTextpdf**

### Configuration

  **1.** Add Gmail address and password in application.properties </br>
        **Note:** I have Used `CloudAMQP - RabbitMQ as a Service` for RabbitMQ. Make sure that 2-step verification is off for given gmail.
  
   ```
   spring.mail.username=YOUR-GMAIL-ADDRESS
   spring.mail.password=YOUR-GMAIL-PASSWORD   
   ```
  **2.** Add credentials for RabbitMQ server in `RabbitConfig.java` 
  
   ```java
   @Bean
	public CachingConnectionFactory myCachingConnectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory("YOUR-RABBIT_MQ-HOST-URL");
		connectionFactory.setUsername("RABBIT_MQ-USERNAME");
		connectionFactory.setPassword("RABBIT_MQ-PASSWORD");
		connectionFactory.setVirtualHost("RABBIT_MQ-VIRTUAL-HOST(IF ANY)");
		return(connectionFactory);
	}
   ```
   
   **voilà! All Set :)** 
   
 ### Run Apllication
 
  ```
  $ mvnw spring-boot:run
  ```
  
  **You can Also Run This Application in java Based IDE like STS, Eclipse or intellij**
  
  ### API Structure
  
   You can Use Any API tool like Postman,Swagger Inspector or Paw 3
   
   * POST : http://localhost:8080/generatePDF
   
    Json Body
     
    {
	  "email" : "chevlichirag@gmail.com",
	  "emailTitle" : "Check out PDF!",
	  "pdfName" : "Demo_pdf",
	  "pdfData" : "Demo Data" 
    } 
    
    
 #### Now Go And Check Mail!
 
 
 ### References
 
  * https://www.cloudamqp.com/docs/index.html
  * https://howtodoinjava.com/apache-commons/read-generate-pdf-java-itext/
  * https://logging.apache.org/log4j/2.x/
  
**In case you find any problems or you have any suggestion or you want to add new features fell free to contact me** :smile:  
