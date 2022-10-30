package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    MovieService movieService;

//    Add a movie: POST /movies/add-movie
//    Pass the Movie object as request body
//    Return success message wrapped in a ResponseEntity object
//    Controller Name - addMovie

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie (@RequestBody Movie movie) {
        movieService.addMovie(movie);
        return new ResponseEntity<>("add movie success", HttpStatus.CREATED);
    }


//    Add a director: POST /movies/add-director
//    Pass the Director object as request body
//    Return success message wrapped in a ResponseEntity object
//    Controller Name - addDirector

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director) {
        movieService.addDirector(director);
        return new ResponseEntity<>("add Director success", HttpStatus.CREATED);
    }


//
//    Pair an existing movie and director: PUT /movies/add-movie-director-pair
//    Pass movie name and director name as request parameters
//    Return success message wrapped in a ResponseEntity object
//    Controller Name - addMovieDirectorPair

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair ( @RequestParam("movieName") String movieName, @RequestParam("directorName") String directorName)
    {
        movieService.addMovieDirectorPair(movieName,directorName);
        return new ResponseEntity<>("addMovieDirectorPair success", HttpStatus.OK);
    }



//    Get Movie by movie name: GET /movies/get-movie-by-name/{name}
//    Pass movie name as path parameter
//    Return Movie object wrapped in a ResponseEntity object
//    Controller Name - getMovieByName

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name) {

                if(movieService.getMovieByName(name) !=null)
                return new ResponseEntity<>(movieService.getMovieByName(name), HttpStatus.OK);

                else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

            }




//    Get Director by director name: GET /movies/get-director-by-name/{name}
//    Pass director name as path parameter
//    Return Director object wrapped in a ResponseEntity object
//    Controller Name - getDirectorByName

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name) {

        if(movieService.getDirectorByName(name) !=null)
            return new ResponseEntity<>(movieService.getDirectorByName(name), HttpStatus.OK);

        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }




//
//    Get List of movies name for a given director name: GET /movies/get-movies-by-director-name/{director}
//    Pass director name as path parameter
//    Return List of movies name(List()) wrapped in a ResponseEntity object
//    Controller Name - getMoviesByDirectorName

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director) {
        return new ResponseEntity<>(movieService.getMoviesByDirectorName(director), HttpStatus.OK);
    }




//    Get List of all movies added: GET /movies/get-all-movies
//    No params or body required
//    Return List of movies name(List()) wrapped in a ResponseEntity object
//    Controller Name - findAllMovies

    @GetMapping("/get-all-movies")
    public  ResponseEntity<List<String>> findAllMovies() {
        return new ResponseEntity<>(movieService.findAllMovies(), HttpStatus.OK);
    }




//    Delete a director and its movies from the records: DELETE /movies/delete-director-by-name
//    Pass director’s name as request parameter
//    Return success message wrapped in a ResponseEntity object
//    Controller Name - deleteDirectorByName
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String name) {
         movieService.deleteDirectorByName(name);
        return new ResponseEntity<>("deleteDirectorByName successfull", HttpStatus.OK);
    }



//    Delete all directors and all movies by them from the records: DELETE /movies/delete-all-directors
//    No params or body required
//    Return success message wrapped in a ResponseEntity object
//    Controller Name - deleteAllDirectors
//            (Note that there can be some movies on your watchlist that aren’t mapped to any of the director. Make sure you do not remove them.)

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors() {
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("deleteAllDirectors successfull", HttpStatus.OK);
}



}
