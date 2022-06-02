import React from 'react';
import { LayoutHomePage } from '../../components/LayoutHomePage';

import ImgBackgrond from '../../assets/images/background.svg';

const LoginPage: React.FC = () => {
  return (
    <LayoutHomePage>
      <div className="col d-none d-lg-block mt-5">
        <h1 className="display-2 fw-bold mt-5">Avalie Filmes</h1>
        <p className="lead mt-3">Diga o que você achou do seu filme favorito</p>
        <img
          className="img-fluid mt-5 d-flex w-75"
          src={ImgBackgrond}
          alt="background"
        />
      </div>
      <div className="col mt-5">
        <div className="bg-secondary m-3 p-3 rounded-2">
          <h1 className="text-center mt-5">LOGIN</h1>
          <form className="m-4" action="">
            <div className="mb-3">
              <label htmlFor="email" className="form-label">
                Email
              </label>
              <input
                type="email"
                className="form-control bg-light"
                id="email"
                placeholder="name@example.com"
              />
            </div>
            <div className="mb-3">
              <label htmlFor="password" className="form-label">
                Senha
              </label>
              <input
                type="password"
                className="form-control bg-light"
                id="password"
                placeholder="Senha"
              />
            </div>
            <div className="d-grid gap-2 mx-auto">
              <button className="btn btn-warning btn-lg mt-5 fw-bold">
                FAZER LOGIN
              </button>
            </div>
          </form>
        </div>
      </div>
    </LayoutHomePage>
  );
};

export default LoginPage;
