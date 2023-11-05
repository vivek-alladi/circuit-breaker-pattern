# Introduction
- In this repository we will implement circuit breaker pattern to handle transient faults in microservices.
- We have 3 microservices product-service (P), order-service (O) and inventory-service (I).
- P contains list of all products avaialable in the system in a json file. 
- I contains the count of the products available at present. O checks if the placed order is valid from P and then updates I after successful order placement.
- We use Java, Springboot

# Circuit Breaker Pattern
- In a distributed system, microservices often face momentary faults such as slow network connections or resource unavailability. 
- These faults can be easily rectified by retrying to connect to the service or placing a timeout after which the failure is returned.

- Sometimes the faults may take longer to get fixed. During that time multiple requests may get queued up in the caller service taking up all the resources. 
- In that case, waiting for the retry time or timeout, to ultimately receive a failure response will have a cascading effect on the caller service. Because caller service 
resources gets utilised waiting for the dependent service to fail. 

- In such scenarios, it is better for the dependent service(B) to give failure response immediately, 
such that requests queueing up at the caller service (A) for other parts of the system will not be blocked.

- This is where circuit breaker pattern can be used, it simply means break the ciruit to B, if it is observed that a series of calls to it are failing leading to massive response times. 
- This is checked for a certain period of time called threshold, if fails to B cross the threshold, then break the circuit and stop calls to B. 
- For more info visit: https://learn.microsoft.com/en-us/azure/architecture/patterns/circuit-breaker

 <img width="797" alt="image" src="https://github.com/vivek-alladi/circuit-breaker-pattern/assets/38089262/c9ea0b1d-dfe9-4e26-9574-b9cfcae6e7ad">

Main uses:
- Allows remote service to recover
- Fails fast to protect resources from exhaustion

Applicability:
- Building a fault-tolerant application where failure of some services shouldn't bring the entire application down.

