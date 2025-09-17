import React from "react";
import AppBackground from "../../components/AppBackground";
import Navigation from "../../components/Navigation";
import "./HomePage.css";

const MOTIVATIONAL_QUOTES = [
    "The gift of blood is the gift of life.",
    "Donate organs, save lives, be a hero.",
    "A single pint can save three lives, a single gesture can create a million smiles.",
    "Be the reason someone lives. Donate today.",
    "Your donation is hope for someone in need.",
    "Heroes aren't born, they're donors.",
    "Small act, big impact: donate blood and organs.",
    "You have the power to save lives. Use it!",
    "Every drop counts. Every organ matters.",
    "Live life, give life. Become a donor."
];

const HomePage: React.FC = () => {
    return (
        <div>
            <AppBackground />
            <Navigation />
            <div className="home-content">
                <h1 className="home-title">Welcome to Donation Portal</h1>
                <p className="home-subtitle">Saving lives, one donation at a time.</p>
                <div className="quotes-section">
                    <ul className="quotes-list">
                        {MOTIVATIONAL_QUOTES.map((quote, idx) => (
                            <li key={idx} className="quote-item">{quote}</li>
                        ))}
                    </ul>
                </div>
            </div>
        </div>
    );
};

export default HomePage;
