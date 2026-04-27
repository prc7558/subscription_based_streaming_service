# Payments Package

## Purpose
The `payments` package handles the financial transactions within the streaming service. It simulates the interaction with external payment providers and records payment history.

## Classes

### `Payment.java`
- **Type**: Class
- **Role**: A Data Transfer Object (DTO) that holds the record of a transaction.
- **Attributes**:
    - `transactionId`: A unique identifier for the payment.
    - `amount`: The total cost of the transaction.
    - `timestamp`: The exact time the payment was made.
    - `status`: Current state (e.g., "SUCCESS", "FAILED").

### `PaymentProcessor.java`
- **Type**: Class (Utility/Service)
- **Role**: Logic for executing a payment.
- **Dynamic Logic**: Uses `UUID.randomUUID()` to generate unique transaction IDs, simulating what a real backend system does when talking to a bank.
- **Static Method**: The `process()` method is static because it doesn't need to maintain its own state; it simply acts as a functional pipe for transactions.

## Code Explanation: Simulating Real-World Behavior
```java
public static Payment process(PlanType plan) {
    String txId = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    return new Payment(txId, plan.getPrice(), "SUCCESS");
}
```
In this code, we use `UUID` to ensure that every "simulated" payment gets a unique ID. This is a common pattern in backend development to ensure ledger integrity and allow for easy debugging of specific user issues.
