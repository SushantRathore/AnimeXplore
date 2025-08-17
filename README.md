# 📱 AnimeXplore App

A simple Android app that fetches and displays a list of top-rated anime series using the Jikan API. Built with a clean MVVM architecture, it supports both online and offline functionality using Room and Retrofit.

![image](https://github.com/user-attachments/assets/491638ae-7cce-4439-a694-88f3f4be8322)


![image](https://github.com/user-attachments/assets/0210cf18-82cb-4d7d-8907-68d9841a5663)


---

## Core Features

###  Anime List Page (Home Screen)

- Fetches top anime from Jikan API  
- Displays **Title**, **Episodes**, **Rating**, and **Poster Image**

###  Anime Detail Page

- Plays trailer if available  
- Displays **Title**, **Synopsis**, **Genres**, **Cast**, **Episodes**, and **Rating**

### Clean MVVM Architecture

- Follows the **Model-View-ViewModel (MVVM)** pattern for better separation of concerns, testability, and scalability  
- Implements a **Repository layer** to abstract data sources (network + local database)  
- Utilizes **ViewModel** to manage UI-related data in a lifecycle-aware manner  
- Uses **StateFlow** for reactive and predictable state management between ViewModel and UI  
- Supports **unidirectional data flow** to ensure clean and maintainable UI logic


---

## Bonus Features

###  Offline Support

- Caches anime list using Room database  
- App works offline with previously fetched data



