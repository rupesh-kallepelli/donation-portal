// Stylized blood bottle
const bloodBottleStyle: React.CSSProperties = {
    position: "absolute",
    top: "75%",
    left: "30%",
    width: "28px",
    height: "60px",
    background: "#fff",
    borderRadius: "8px 8px 12px 12px / 12px 12px 20px 20px",
    boxShadow: "0 2px 8px #e53935",
    border: "2px solid #e53935",
    opacity: 0.18,
    zIndex: 0,
    display: "flex",
    alignItems: "flex-end",
};

const bloodBottleFillStyle: React.CSSProperties = {
    width: "100%",
    height: "60%",
    background: "#e53935",
    borderRadius: "0 0 12px 12px / 0 0 20px 20px",
    opacity: 0.7,
};

// Stylized heart organ
const heartOrganStyle: React.CSSProperties = {
    position: "absolute",
    top: "80%",
    right: "20%",
    width: "40px",
    height: "36px",
    background: "#e53935",
    borderRadius: "50% 50% 50% 50% / 60% 80% 80% 60%",
    opacity: 0.15,
    zIndex: 0,
};

// Stylized eye organ
const eyeOrganStyle: React.CSSProperties = {
    position: "absolute",
    top: "60%",
    right: "5%",
    width: "36px",
    height: "20px",
    background: "#fffde7",
    borderRadius: "50% 50% 50% 50% / 80% 80% 80% 80%",
    border: "2px solid #e53935",
    opacity: 0.13,
    zIndex: 0,
};
// Stethoscope icon
const stethoscopeStyle: React.CSSProperties = {
    position: "absolute",
    top: "65%",
    left: "60%",
    width: "40px",
    height: "40px",
    opacity: 0.18,
    zIndex: 0,
};

// Heart pulse icon
const heartPulseStyle: React.CSSProperties = {
    position: "absolute",
    top: "30%",
    right: "20%",
    width: "32px",
    height: "32px",
    opacity: 0.22,
    zIndex: 0,
};

// Donation ribbon
const ribbonStyle: React.CSSProperties = {
    position: "absolute",
    top: "10%",
    left: "40%",
    width: "24px",
    height: "40px",
    opacity: 0.18,
    zIndex: 0,
};
// Stylized hands
const leftHandStyle: React.CSSProperties = {
    position: "absolute",
    bottom: "0%",
    left: "15%",
    width: "60px",
    height: "40px",
    background: "#ffe082",
    borderRadius: "40% 60% 60% 40% / 80% 80% 80% 80%",
    opacity: 0.18,
    transform: "rotate(-15deg)",
    zIndex: 0,
};

const rightHandStyle: React.CSSProperties = {
    position: "absolute",
    bottom: "0%",
    right: "15%",
    width: "60px",
    height: "40px",
    background: "#ffe082",
    borderRadius: "60% 40% 40% 60% / 80% 80% 80% 80%",
    opacity: 0.18,
    transform: "rotate(15deg)",
    zIndex: 0,
};
// Stylized liver icon
const liverStyle: React.CSSProperties = {
    position: "absolute",
    bottom: "18%",
    right: "25%",
    width: "50px",
    height: "30px",
    background: "#ff7043",
    borderRadius: "60% 40% 60% 40% / 80% 60% 80% 60%",
    opacity: 0.13,
    transform: "rotate(10deg)",
    zIndex: 0,
};

// Stylized lungs icon
const lungsStyle: React.CSSProperties = {
    position: "absolute",
    bottom: "25%",
    left: "20%",
    width: "60px",
    height: "40px",
    background: "#90caf9",
    borderRadius: "50% 50% 50% 50% / 80% 80% 80% 80%",
    opacity: 0.13,
    zIndex: 0,
    display: "flex",
    justifyContent: "space-between",
};
// Blood drop pattern
const bloodDropPatternStyle: React.CSSProperties = {
    position: "absolute",
    top: "10%",
    right: "5%",
    width: "18px",
    height: "28px",
    background: "linear-gradient(180deg, #e53935 60%, #fff 100%)",
    borderRadius: "50% 50% 50% 50% / 60% 60% 100% 100%",
    opacity: 0.22,
    zIndex: 0,
};

// Medical pulse line
const pulseLineStyle: React.CSSProperties = {
    position: "absolute",
    bottom: "20%",
    left: "10%",
    width: "120px",
    height: "40px",
    opacity: 0.18,
    zIndex: 0,
};

// Stylized organ icon (kidney)
const kidneyStyle: React.CSSProperties = {
    position: "absolute",
    bottom: "5%",
    right: "10%",
    width: "60px",
    height: "40px",
    background: "#b71c1c",
    borderRadius: "60% 40% 60% 40% / 60% 80% 80% 60%",
    opacity: 0.15,
    transform: "rotate(-20deg)",
    zIndex: 0,
};
import React from "react";

const backgroundStyle: React.CSSProperties = {
    minHeight: "100vh",
    width: "100vw",
    background: "linear-gradient(135deg, #ff6f61 0%, #ffe082 100%)",
    position: "fixed",
    top: 0,
    left: 0,
    zIndex: -1,
    overflow: "hidden",
};

const heartStyle: React.CSSProperties = {
    position: "absolute",
    top: "20%",
    left: "10%",
    width: "120px",
    height: "120px",
    background: "red",
    clipPath:
        "polygon(50% 0%, 100% 35%, 80% 100%, 50% 80%, 20% 100%, 0% 35%)",
    opacity: 0.15,
};

const dropStyle: React.CSSProperties = {
    position: "absolute",
    top: "60%",
    right: "15%",
    width: "80px",
    height: "120px",
    background: "linear-gradient(180deg, #e53935 60%, #fff 100%)",
    borderRadius: "50% 50% 50% 50% / 60% 60% 100% 100%",
    opacity: 0.18,
};

const crossStyle: React.CSSProperties = {
    position: "absolute",
    top: "40%",
    left: "70%",
    width: "60px",
    height: "60px",
    background: "#fff",
    borderRadius: "12px",
    boxShadow: "0 0 8px 2px #e53935",
    display: "flex",
    alignItems: "center",
    justifyContent: "center",
    opacity: 0.18,
    zIndex: 0,
};

const crossInnerStyle: React.CSSProperties = {
    width: "40px",
    height: "40px",
    background: "#e53935",
    clipPath: "polygon(40% 0, 60% 0, 60% 40%, 100% 40%, 100% 60%, 60% 60%, 60% 100%, 40% 100%, 40% 60%, 0 60%, 0 40%, 40% 40%)"
};

const organStyle: React.CSSProperties = {
    position: "absolute",
    bottom: "10%",
    left: "50%",
    width: "80px",
    height: "60px",
    background: "#ff8a65",
    borderRadius: "50% 60% 60% 50% / 60% 80% 80% 60%",
    opacity: 0.13,
    transform: "translateX(-50%)",
    zIndex: 0,
};

const AppBackground: React.FC = () => (
    <div style={backgroundStyle}>
        <div style={heartStyle} />
        <div style={dropStyle} />
        <div style={crossStyle}>
            <div style={crossInnerStyle} />
        </div>
        <div style={organStyle} />
        <div style={bloodDropPatternStyle} />
        <svg style={pulseLineStyle} viewBox="0 0 120 40">
            <polyline points="0,20 20,20 30,10 40,30 50,20 70,20 80,5 90,35 100,20 120,20" stroke="#e53935" strokeWidth="3" fill="none" />
        </svg>
        <div style={kidneyStyle} />
        <div style={liverStyle} />
        <div style={lungsStyle}>
            <div style={{ width: '28px', height: '40px', background: '#90caf9', borderRadius: '50% 50% 50% 50% / 80% 80% 80% 80%', opacity: 0.18 }} />
            <div style={{ width: '28px', height: '40px', background: '#90caf9', borderRadius: '50% 50% 50% 50% / 80% 80% 80% 80%', opacity: 0.18 }} />
        </div>
        <svg style={{ position: 'absolute', top: '50%', left: '50%', width: '160px', height: '40px', transform: 'translate(-50%, -50%)', opacity: 0.22, zIndex: 0 }} viewBox="0 0 160 40">
            <polyline points="0,20 20,20 30,10 40,30 50,20 70,20 80,5 90,35 100,20 120,20 130,30 140,10 150,20 160,20" stroke="#e53935" strokeWidth="3" fill="none" />
        </svg>
        <div style={leftHandStyle} />
        <div style={rightHandStyle} />
        {/* Stethoscope icon */}
        <svg style={stethoscopeStyle} viewBox="0 0 40 40">
            <circle cx="20" cy="30" r="7" stroke="#1976d2" strokeWidth="3" fill="none" />
            <path d="M20 23 V10 M20 10 Q25 10 25 15" stroke="#1976d2" strokeWidth="3" fill="none" />
        </svg>
        {/* Heart pulse icon */}
        <svg style={heartPulseStyle} viewBox="0 0 32 32">
            <path d="M16 29 Q4 18 8 12 Q12 6 16 10 Q20 6 24 12 Q28 18 16 29 Z" fill="#e53935" opacity="0.7" />
            <polyline points="8,18 12,14 16,20 20,12 24,18" stroke="#fff" strokeWidth="2" fill="none" />
        </svg>
        {/* Donation ribbon */}
        <svg style={ribbonStyle} viewBox="0 0 24 40">
            <path d="M12 5 Q18 15 12 35 Q6 15 12 5 Z" fill="#e53935" opacity="0.7" />
            <rect x="10" y="20" width="4" height="10" fill="#fff" opacity="0.7" />
        </svg>
        {/* Blood bottle */}
        <div style={bloodBottleStyle}>
            <div style={bloodBottleFillStyle} />
        </div>
        {/* Heart organ */}
        <div style={heartOrganStyle} />
        {/* Eye organ */}
        <div style={eyeOrganStyle} />
    </div>
);

export default AppBackground;