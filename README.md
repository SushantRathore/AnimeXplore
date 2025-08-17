# 📱 AnimeXplore App

A simple Android app that fetches and displays a list of top-rated anime series using the Jikan API. Built with a clean MVVM architecture, it supports both online and offline functionality using Room and Retrofit.

https://github.com/user-attachments/assets/5b3d2d2a-03a6-4c28-b304-8d6f124cf83f
<table>
  <tr>
    <td><img src="https://raw.githubusercontent.com/SushantRathore/AnimeXplore/ae82084ea93994a8501ce9be373da1b7dff566bc/HomePage1.png" alt="App Home Page 1" width="400" /></td>
    <td><img src="https://github.com/user-attachments/assets/365109f0-0772-4517-baf1-730d3d244149" alt="App Home Page 2" width="400" /></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/2211e596-45b4-43a3-a35e-f0f776890bec" alt="App Home Page 3" width="400" /></td>
    <td><img src="https://github.com/user-attachments/assets/c49f2809-a57a-4a90-9350-ff07cbdd4747" alt="App Home Page 4" width="400" /></td>
  </tr>
</table>







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



