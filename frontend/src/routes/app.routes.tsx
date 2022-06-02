import React from 'react';
import { useRoutes } from 'react-router-dom';

import HomePage from '../pages/HomePage';
// import DashBoard from '../pages/DashBoard';
// import LoginPage from 'pages/Login';
import NotFoundPage from '../pages/404';
import LoginPage from '../pages/LoginPage';
import MoviesPage from '../pages/MoviesPage';
import MoviesDetailsPage from '../pages/MoviesDetailsPage';

const AppRoutes: React.FC = () => {
  return useRoutes([
    { path: '/', element: <HomePage /> },
    { path: '/login', element: <LoginPage /> },
    { path: '/movies', element: <MoviesPage /> },
    { path: '/movies/:movieId', element: <MoviesDetailsPage /> },
    {
      path: '*',
      element: <NotFoundPage />,
    },
  ]);
};

export { AppRoutes };
