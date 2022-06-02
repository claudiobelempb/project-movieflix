import { LayoutHomePage } from '../../components/LayoutHomePage';
import React from 'react';
import { FaStar } from 'react-icons/fa';

const MoviesDetailsPage: React.FC = () => {
  return (
    <LayoutHomePage>
      <div className="col">
        <h1 className="display-5 mt-4">Tela detalhes do filme id: {1}</h1>

        <div className="p-3 bg-secondary rounded-2">
          <form action="">
            <div className="mb-3">
              <label htmlFor="exampleFormControlInput1" className="form-label">
                Sua avaliação
              </label>
              <input
                type="email"
                className="form-control bg-light"
                id="exampleFormControlInput1"
                placeholder="Deixe sua avaliação aqui"
              />
            </div>
            <div className="d-grid gap-2 col-md-4 col-lg-3 mx-auto">
              <button className="btn btn-warning fw-bold" type="button">
                SALVAR AVALIAÇÃO
              </button>
            </div>
          </form>
        </div>

        <div className="p-3 bg-secondary rounded-2 mt-4">
          <h2 className="d-flex align-items-center fs-4">
            <FaStar className="text-warning me-2" /> Maria da Silva
          </h2>
          <p className="border border-1 rounded-2 pt-2 pb-5 px-3">
            {' '}
            Gostei muito do filme. Foi muito bom mesmo. Pena que durou pouco.
          </p>
        </div>
        <div className="p-3 bg-secondary rounded-2 mt-4">
          <h2 className=" d-flex align-items-center fs-4">
            <FaStar className="text-warning me-2" /> Maria da Silva
          </h2>
          <p className="border border-1 rounded-2 pt-2 pb-5 px-3">
            {' '}
            Gostei muito do filme. Foi muito bom mesmo. Pena que durou pouco.
          </p>
        </div>
      </div>
    </LayoutHomePage>
  );
};

export default MoviesDetailsPage;
