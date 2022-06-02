import React, { ReactNode } from 'react';
import { Link } from 'react-router-dom';

type LayoutHomePageProps = {
  children: ReactNode;
};

const LayoutHomePage: React.FC<LayoutHomePageProps> = ({ children }) => {
  const isLogin = false;
  return (
    <>
      <header className="bg-warning">
        <nav className="navbar navbar-expand-lg navbar-light bg-warning container">
          <div className="container">
            <a className="navbar-brand fw-bold" href="/">
              MovieFlix
            </a>

            {isLogin ? (
              <button className="btn btn-outline-dark btn-sm px-5 fw-bold">
                SAIR
              </button>
            ) : (
              <Link
                to={'/login'}
                className="btn btn-outline-dark btn-sm px-5 fw-bold"
              >
                LOGIN
              </Link>
            )}
          </div>
        </nav>
      </header>
      <main>
        <div className="container">
          <div className="row">{children}</div>
        </div>
      </main>
    </>
  );
};

export { LayoutHomePage };
