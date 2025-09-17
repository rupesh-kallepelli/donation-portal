import { RouteObject } from 'react-router-dom';
import LoginPage from '../pages/login/LoginPage';
import RegistrationPage from '../pages/registration/RegistrationPage';
import HomePage from '../pages/home/HomePage';
import DonationsPage from '../pages/donations/DonationsPage';

const routes: RouteObject[] = [
    {
        path: '/',
        element: <HomePage />,
    },{
        path: '/register',
        element: <RegistrationPage />,
    },{
        path: '/login',
        element: <LoginPage />,
    },{
        path: '/donations',
        element: <DonationsPage />,
    },
];

export default routes;