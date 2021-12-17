## News Feed Android App (Summary)

This app works as an app that shows the recent news headlines gotten from an api.

### The Structure

This project makes use of the following technologies:

1. MVVM (Model-View-ViewModel) Architecture
2. Kotlin Coroutines for background operations.
3. Dagger Hilt for injecting required dependencies.
4. Retrofit for Network requests.
5. Jetpack Navigation Components for Navigation.
6. JUnit/Mockito for unit tests.
7. Jetpack Compose for UI

### The Package Structure

<img src="https://github.com/OlaoreFouad/news-feed-android/blob/main/shots/package_structure.png" width="250" />

The project files were grouped by feature as seen in the image below where:

1. data package contains the common models used across the app, the models per feature (newslist)
   and specs for the network layer.
2. di package contains the dependency injection components and modules.
3. ui package includes the UI-related classes e.g. viewmodels, composables per feature (newslist).
4. util package includes the constants and helper functions used across the application.
