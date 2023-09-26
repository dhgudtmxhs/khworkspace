import React, { useContext } from 'react';
import { MovieContext } from '../App';

const MovieList = () => {
  const { movies, addMovie, deleteMovie} = useContext(MovieContext);

  const handleDeleteMovie = (movieId) => {
    deleteMovie(movieId);
  };

  let keyindex = 0;

  return (
    
    <div>
      <h2>Movies</h2>
      
      <table>
        
        <thead>
          <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Genre</th>
            <th>Release Date</th>
            <th>Action</th>
          </tr>
        </thead>

        <tbody>

          {movies.map((movie, keyindex) => (

            <tr key={keyindex++}>
              <td>{movie.movieId}</td>
              <td>{movie.movieTitle}</td>
              <td>{movie.movieGenre}</td>
              <td>{movie.movieRelDate}</td>
              <td>
                <button onClick={() => handleDeleteMovie()}>Delete</button>
              </td>
            </tr>

          ))}
        </tbody>
      </table>
    </div>
  );
};

export default MovieList;
