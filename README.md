<h1>Anime App</h1>
<h2>This Android application allows users to explore and view detailed information about their favorite anime. The app is designed using the MVVM architecture with Kotlin and fetches anime data from the Jikan API.</h2>

<h1>Features</h1>
Anime Details: View detailed information about an anime, including title, synopsis, genres, main cast, episodes, rating, and trailer.
Trailer Support: If a trailer is available, it will be played within the app. Otherwise, a poster image will be shown.
Genres and Cast Information: Display genres and main cast for each anime.
Rating and Episodes: Shows the rating and number of episodes, or "N/A" if unavailable.

<h1>Tech Stack</h1>
Kotlin: Primary programming language.
MVVM Architecture: To manage UI-related data in a lifecycle-conscious way.
Retrofit: Used for making network calls to the Jikan API.
Glide / Picasso: For loading and displaying images efficiently.
ExoPlayer: Used for displaying the trailer videos if available.
Coroutines: For handling asynchronous operations.
