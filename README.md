# Tv shows

This application displays a list of TV shows. It fetches its data form an online database made available 
by themoviedb.org . 

## Built With

Gradle

## Design Decisions & Issues

The application follows the MVVM design pattern.

For networking and Rest API consumption it makes use of Retrofit, okhttp and Gson.

The main components of the UI are the RecyclerView and the CardView.
The picasso library is being used to download the images into the views.

Pagination and infinite scroll is implemented by using android's paging library.

The observer design pattern is implemented by the help of LiveData.
