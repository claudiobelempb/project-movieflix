import { LayoutHomePage } from '../../components/LayoutHomePage';
import React from 'react';
import { Link } from 'react-router-dom';

const MoviesPage: React.FC = () => {
  return (
    <LayoutHomePage>
      <h1 className="display-4 mt-4">Tela listagem de filmes</h1>
      <div>
        <Link
          className="btn btn-link text-decoration-none text-light"
          to={'/movies/1'}
        >
          Acessar /movies/{'1'}
        </Link>
      </div>
      <div>
        <Link
          className="btn btn-link text-decoration-none text-light"
          to={'/movies/1'}
        >
          Acessar /movies/{'1'}
        </Link>
      </div>
    </LayoutHomePage>
  );
};

export default MoviesPage;
