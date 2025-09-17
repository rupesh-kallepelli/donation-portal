import React from 'react';
import logo from '../assets/logo.png';

const Logo: React.FC = () => (
    <img 
        src={logo} 
        alt="Logo" 
        style={{ width: 64, height: 64, marginRight: '1rem', borderRadius: '12px' }} 
    />
);

export default Logo;
