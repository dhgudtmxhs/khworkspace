import React, { useState, createContext } from 'react';
import CreateMovie from './component/CreateMovie';
import MovieList from './component/MovieList';

export const MovieContext = createContext();

function App() {
  const [movies, setMovies] = useState([
    {movieId : '1', movieTitle: 'Movie 1', movieGenre : 'Drama' , movieRelDate : '2023-04-14'},
    {movieId : '2', movieTitle : 'Movie 2', movieGenre : 'Action' , movieRelDate : '2023-10-06'},
    {movieId : '3', movieTitle : 'Movie 3', movieGenre : 'Comedy' , movieRelDate : '2023-10-10'}
  ]);

  const addMovie = (newMovie) => {
    setMovies([...movies, newMovie]);
  };
  
  const deleteMovie = (movieId) => {

    

    };


  return (
    <MovieContext.Provider value={{ movies, addMovie, deleteMovie }}>
        <CreateMovie/>
        <MovieList/>
    </MovieContext.Provider>
  );
}

export default App;