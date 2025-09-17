import React from 'react';
import Logo from './Logo';
import { Link } from 'react-router-dom';
import './Navigation.css';

const leftNavItems = [
    { name: 'Donations', href: '/donations' },
];

const rightNavItems = [
    { name: 'About', href: '/about' },
    { name: 'Contact', href: '/contact' },
    { name: 'Become a Donor', href: '/register' },
     { name: 'Login', href: '/login' },
];

const Navigation: React.FC = () => (
    <nav
        className="navigation"
        style={{
            background: 'rgba(255,255,255,0.08)',
            padding: '1rem 2rem',
            display: 'flex',
            alignItems: 'center',
        }}
    >
        <div className="navigation-logo">
            <Link to="/">
                <Logo />
            </Link>
        </div>
        <ul className="navigation-list">
            {leftNavItems.map(item => (
                <li key={item.name} style={{ marginRight: '2rem' }}>
                    <Link
                        to={item.href}
                        className="navigation-link"
                    >
                        {item.name}
                    </Link>
                </li>
            ))}
        </ul>
        <span className="navigation-title">A Piece of you can save lives</span>
        <ul className="navigation-list right">
            {rightNavItems.map(item => (
                <li key={item.name} style={{ marginRight: '2rem' }}>
                    <Link
                        to={item.href}
                        className="navigation-link"
                    >
                        {item.name}
                    </Link>
                </li>
            ))}
        </ul>
    </nav>
)
export default Navigation;