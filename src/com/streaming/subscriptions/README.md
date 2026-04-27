# Subscriptions Package

## Purpose
The `subscriptions` package manages the access control and billing tiers of the streaming service. It defines what plans are available and tracks the validity of a user's subscription.

## Classes and Enums

### `PlanType.java`
- **Type**: Enum
- **Role**: Defines the fixed set of subscription tiers.
- **Values**:
    - `BASIC`: Entry-level plan at a lower price point.
    - `PREMIUM`: Top-tier plan with full access.
- **Functionality**: Each constant carries its own `price` value, which can be retrieved during payment processing.

### `Subscription.java`
- **Type**: Class
- **Role**: Handles the lifecycle of a user's subscription.
- **Key Features**:
    - **Automatic Dates**: Sets a `startDate` when initialized and calculates an `expiryDate` (1 month later).
    - **Active Status Check**: The `isActive()` method checks both a boolean flag and the current date to ensure the subscription has not expired.
    - **Encapsulation**: Keeps the subscription logic focused and separate from user profile details.

### `SubscriptionException.java`
- **Type**: Exception Class
- **Role**: A custom checked exception used to handle business-rule violations.
- **Usage**: Thrown when a user attempts to watch content without an active plan, allowing the user-interface layer to catch and display a friendly error message.

## Code Explanation: Enums for Fixed Choices
```java
public enum PlanType {
    BASIC(499),
    PREMIUM(999);
}
```
Enums are ideal here because they restrict the possible plans to a specific set, preventing errors where an invalid plan name might be entered as a string. Each enum constant is essentially a singleton instance of the `PlanType` type.
