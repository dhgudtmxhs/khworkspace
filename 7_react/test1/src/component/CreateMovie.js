import React, { useState, useContext } from 'react';
import { MovieContext } from '../App';

const CreateMovie = () => {

    const { addMovie } = useContext(MovieContext);
  
    const [movieId, setMovieId] = useState('');
    const [movieTitle, setMovieTitle] = useState('');
    const [movieGenre, setMovieGenre] = useState('');
    const [movieRelDate, setMovieRelDate] = useState('');
    
    const [idValidation, setIdValidation] = useState(false);

    const handleAddMovie = () => {
      const newMovie = {
        movieId: movieId,
        movieTitle: movieTitle,
        movieGenre: movieGenre,
        movieRelDate: movieRelDate,
      };
      if(movieId === '' || movieTitle === '' || movieGenre === '' || movieRelDate === ''){
        alert("모든 값은 입력되어야 합니다.");
        setMovieId('');
        setMovieTitle('');
        setMovieGenre('');
        setMovieRelDate('');
        return;
      }
      

      addMovie(newMovie);
        
      setMovieId('');
      setMovieTitle('');
      setMovieGenre('');
      setMovieRelDate('');

    };
  
    return (
      <>
        <h1>Create Movie</h1>
        <input type="text" placeholder="Input movie id" value={movieId}
          onChange={(e) => setMovieId(e.target.value)}/> <br/>

        <input type="text" placeholder="Input movie title" value={movieTitle}
          onChange={(e) => setMovieTitle(e.target.value)}/> <br/>

        <input type="text" placeholder="Input movie genre" value={movieGenre}
         onChange={(e) => setMovieGenre(e.target.value)}/> <br/>
        출시일 :
        <input type="date" value={movieRelDate}
          onChange={(e) => setMovieRelDate(e.target.value)}/> <br/>

        <button onClick={handleAddMovie}>Add movie</button>
        
        <hr/>
      </>
    );
  };
  
  export default CreateMovie;
  