# GitHub Search App

A simple Android app to search GitHub users, view their details, and manage favorite users. Built using Kotlin, Jetpack Compose, and Clean Architecture principles.

---

## Features

- Search GitHub users by username
- View detailed user information
- Add users to favorites
- Remove users from favorites
- Offline favorite users (stored locally using Room)

---

## Architecture

This project uses **Clean Architecture** with the following layers:

1. **Data Layer**  
   - `GithubRepository` & `GithubRepositoryImpl` handle API and local database (Room) access.
2. **Domain Layer**  
   - Use cases (`GetFavoriteUsersUseCase`, `AddFavoriteUserUseCase`, `RemoveFavoriteUserUseCase`) contain business logic.
3. **Presentation Layer**  
   - Jetpack Compose UI  
   - ViewModels handle UI state using Kotlin Coroutines and StateFlow.

**Why Clean Architecture:**  
It separates concerns between UI, domain, and data layers, making the codebase modular, testable, and easy to maintain.

---

## Libraries & Tools

- [Jetpack Compose](https://developer.android.com/jetpack/compose) for UI
- [Hilt](https://dagger.dev/hilt/) for dependency injection
- [Room](https://developer.android.com/jetpack/androidx/releases/room) for local database
- [Retrofit](https://square.github.io/retrofit/) + [Moshi](https://github.com/square/moshi) for network calls
- [Coil](https://coil-kt.github.io/coil/) for image loading
- Kotlin Coroutines & Flow for async programming

---
