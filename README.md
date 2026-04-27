# Subscription-Based Streaming Service (Java Implementation)

## Overview
This project is a Java-based simulation of a modern streaming platform like Netflix or Disney+. It demonstrates core Object-Oriented Programming (OOP) principles such as inheritance, polymorphism, encapsulation, and interface design within a structured package-based architecture.

## Objective
The goal is to provide a beginner-friendly yet technically sound example of how different specialized packages (content, users, subscriptions, and payments) interact to form a cohesive system.

## Key Features
- **OOP Hierarchy**: Base `Content` class with specialized `Movie` and `Series` types.
- **Access Control**: A functional `Playable` interface defining content interaction.
- **Custom Exception Handling**: Uses a specialized `SubscriptionException` to handle unauthorized access attempts gracefully.
- **Subscription Lifecycle**: Manage plan tiers (BASIC vs PREMIUM) with automatic expiry tracking.
- **Watch History**: Detailed tracking of user activity with data encapsulation.
- **Recommendation Engine**: Dynamic suggestions based on user behavior and library ratings.
- **Payment Simulation**: Secure transaction simulation using UUID generation.

## Technologies Used
- **Language**: Java 17+
- **Version Control**: Git / GitHub
- **Concepts**: Interfaces, Abstract Classes, List Streams, Enum Types, Date/Time API.

## Project Structure
The project is divided into four main packages:
- `com.streaming.content`: Defines the media library classes and interfaces.
- `com.streaming.subscriptions`: Manages plan types and user access levels.
- `com.streaming.payments`: Simulates the financial transaction layer.
- `com.streaming.users`: Manages the user profile, history, and recommendation logic.

## How to Run the Project
1. **Navigate** to the project root directory.
2. **Compile** all source files:
   ```powershell
   javac -d bin src/com/streaming/*.java src/com/streaming/content/*.java src/com/streaming/users/*.java src/com/streaming/subscriptions/*.java src/com/streaming/payments/*.java
   ```
3. **Run** the main application:
   ```powershell
   java -cp bin com.streaming.Main
   ```

## Detailed Workflow
1. **Content Playback**: When a user selects a piece of content, the system checks if their `Subscription` object exists and `isActive()`.
2. **Watch History**: If access is granted, the `play()` method is executed, and a reference to the content is saved in the user's `WatchHistory`.
3. **Recommendations**: The `RecommendationSystem` scans the user's history for recurring genres. It then searches the `library` for high-rated items in that category that the user hasn't seen yet.

## Sample Workflow (Summary of Main.java)
- Initializing a user "Alex".
- Denying access to a movie because Alex is not yet a subscriber.
- Alex signs up for the **PREMIUM** plan.
- Alex watches "Inception" (Sci-Fi).
- The system recognizes the "Sci-Fi" preference and recommends "Stranger Things" based on the new activity.
