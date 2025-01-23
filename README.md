<h1>Anime App</h1>
<h3>This Android application allows users to explore and view detailed information about their favorite anime. The app is designed using the MVVM architecture with Kotlin and fetches anime data from the Jikan API.</h3>

<h1>Features</h1>
Anime Details: View detailed information about an anime, including title, synopsis, genres, main cast, episodes, rating, and trailer.<br>
Trailer Support: If a trailer is available, it will be played within the app. Otherwise, a poster image will be shown.<br>
Genres and Cast Information: Display genres and main cast for each anime.<br>
Rating and Episodes: Shows the rating and number of episodes, or "N/A" if unavailable.<br>

<h1>Tech Stack</h1>
Kotlin: Primary programming language.<br>
MVVM Architecture: To manage UI-related data in a lifecycle-conscious way.<br>
Retrofit: Used for making network calls to the Jikan API.<br>
Glide / Picasso: For loading and displaying images efficiently.<br>
ExoPlayer: Used for displaying the trailer videos if available.<br>
Coroutines: For handling asynchronous operations.<br>
