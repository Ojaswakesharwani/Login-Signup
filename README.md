Login/Signup Page - Android MVVM (Kotlin)
Project Overview
This project demonstrates a simple Login and Signup page using the MVVM (Model-View-ViewModel) architecture in Android with Kotlin. It implements a basic authentication flow with fields for user credentials, a gradient background for visual appeal, and basic form validation. The application also follows best practices such as separation of concerns, LiveData usage, and ViewModel to manage UI-related data.

Features
Login Page: Users can enter an email and password to log in.
Signup Page: Allows users to register with a name, email, and password.
MVVM Architecture: Ensures separation of concerns between UI (View), business logic (ViewModel), and data (Model).
Gradient Background: Aesthetic gradient background to enhance UI design.
Form Validation: Basic form validation for email format and password constraints.
LiveData for Observing Changes: Utilizes LiveData to observe changes in the ViewModel from the UI.

Architecture
This project follows the MVVM architecture, which includes:

Model: Represents the data and the business logic of the app. Here, we use a simple in-memory store for user credentials.
ViewModel: Manages UI-related data in a lifecycle-conscious way. It handles data fetching and validation logic, exposing only necessary data to the UI.
View: The activity/fragment responsible for displaying the data and observing LiveData changes from the ViewModel.
Technologies & Tools
Kotlin: Main programming language.
Android Jetpack Components:
ViewModel
LiveData
Data Binding
Navigation Component
Material Design Components: For input fields, buttons, and other UI elements.
Gradle: For project dependency management.
Coroutines: For managing asynchronous tasks, such as simulated authentication.
