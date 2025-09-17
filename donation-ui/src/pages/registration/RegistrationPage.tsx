import React, { useState } from "react";
import axios from "axios";
import AppBackground from "../../components/AppBackground";
import Navigation from "../../components/Navigation";
import './Registration.css';
import { countryCodeExtensions } from "../../consts";



const RegistrationPage: React.FC = () => {
    const [form, setForm] = useState({
        name: '',
        email: '',
        mobile: '',
        mobileExt: '',
        password: '',
        confirmPassword: '',
        bloodType: '',
        organDonor: false,
        termsAccepted: false,
    });
    const [showTerms, setShowTerms] = useState(false);
    const [errors, setErrors] = useState<{ [key: string]: string }>({});

    const validate = () => {
        const newErrors: { [key: string]: string } = {};
        if (!form.name.trim()) newErrors.name = "Please enter your name.";
        if (!form.email.trim()) newErrors.email = "Please enter your email address.";
        else if (!/^\S+@\S+\.\S+$/.test(form.email)) newErrors.email = "Please enter a valid email address.";
        if (!form.mobileExt.trim()) newErrors.mobileExt = "Please select your mobile extension.";
        else if (!countryCodeExtensions.some(e => e.dial_code === form.mobileExt)) newErrors.mobileExt = "Invalid extension.";
        if (!form.mobile.trim()) newErrors.mobile = "Please enter your mobile number.";
        else if (!/^\d{10}$/.test(form.mobile)) newErrors.mobile = "Please enter a valid 10-digit mobile number.";
        if (!form.password) newErrors.password = "Please enter a password.";
        else if (form.password.length < 6) newErrors.password = "Password must be at least 6 characters.";
        if (!form.confirmPassword) newErrors.confirmPassword = "Please confirm your password.";
        else if (form.password !== form.confirmPassword) newErrors.confirmPassword = "Passwords do not match.";
        if (!form.bloodType) newErrors.bloodType = "Please select your blood type.";
        if (!form.termsAccepted) newErrors.termsAccepted = "You must accept the terms and conditions.";
        return newErrors;
    };

    const handleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement>) => {
        const target = e.target as HTMLInputElement | HTMLSelectElement;
        const { name, value, type } = target;
        setForm(prev => ({
            ...prev,
            [name]: type === 'checkbox' ? target.checked : value,
        }));
    };

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        const validationErrors = validate();
        setErrors(validationErrors);
        if (Object.keys(validationErrors).length === 0) {
            try {
                // Only send fields required by backend
                const payload = {
                    name: form.name,
                    email: form.email,
                    mobile: form.mobile,
                    mobileExt: form.mobileExt,
                    password: form.password,
                    bloodType: form.bloodType,
                    organDonor: form.organDonor,
                    createdAt: new Date().toISOString()
                };
                console.log("Submitting registration with payload:", payload);
                
                const response = await axios.post("http://localhost:8080/users/register", payload);
                console.log("Registration response:", response);
                if (response.status === 200) {
                    alert("Registration successful!");
                } else {
                    alert("Registration failed: " + (response.data?.message || "Unknown error"));
                }
            } catch (err: any) {
                console.error("Registration error:", err);
                if (err.response?.data?.message) {
                    alert("Registration failed: " + err.response.data.message);
                } else {
                    alert("Network error. Please try again later.");
                }
            }
        }
    };

    return (
        <div>
            <AppBackground />
            <Navigation />
            <form className="registration-form" onSubmit={handleSubmit}>
                <h1 className="registration-title">Become a Donor</h1>
                <div className="form-group">
                    <label htmlFor="name">Name</label>
                    <input type="text" id="name" name="name" maxLength={32} className="form-control" value={form.name} onChange={handleChange} />
                    {errors.name && <div className="form-error">{errors.name}</div>}
                </div>
                <div className="form-group">
                    <label htmlFor="email">Email</label>
                    <input type="email" id="email" name="email" maxLength={64} className="form-control" value={form.email} onChange={handleChange} />
                    {errors.email && <div className="form-error">{errors.email}</div>}
                </div>
                <div className="form-group">
                    <label htmlFor="mobile">Mobile Number</label>
                    <div className="mobile-row">
                        <div className="mobile-ext-container">
                            <img
                                src="data:image/svg+xml;utf8,<svg xmlns='http://www.w3.org/2000/svg' width='24' height='24'><text x='0' y='18' font-size='18'>🌐</text></svg>"
                                alt="Globe icon"
                                className="mobile-flag"
                            />
                            <select id="mobileExt"
                                name="mobileExt"
                                className="form-control mobile-ext-select"
                                value={form.mobileExt}
                                onChange={handleChange}>
                                <option value=""></option>
                                {countryCodeExtensions
                                    .toSorted((a, b) => {
                                        const codeA = a.code || "";
                                        const codeB = b.code || "";
                                        return codeA.localeCompare(codeB);
                                    })
                                    .map(({ code, dial_code, name }) => {
                                        // Convert country code to flag emoji
                                        const flag = code && code.length === 2
                                            ? String.fromCodePoint(...code.toUpperCase().split('').map(c => 127397 + c.charCodeAt(0)))
                                            : "🌐";
                                        return (
                                            <option key={dial_code} value={dial_code}>
                                                {flag} {dial_code}
                                            </option>
                                        );
                                    })}
                            </select>
                        </div>
                        <input type="tel"
                            id="mobile"
                            name="mobile"
                            maxLength={10}
                            placeholder="Mobile"
                            className="form-control"
                            value={form.mobile}
                            onChange={handleChange}
                        />
                    </div>
                    {errors.mobileExt && <div className="form-error">{errors.mobileExt}</div>}
                    {errors.mobile && <div className="form-error">{errors.mobile}</div>}
                </div>
                <div className="form-group">
                    <label htmlFor="password">Password</label>
                    <input type="password" id="password" name="password" maxLength={32} className="form-control" value={form.password} onChange={handleChange} />
                    {errors.password && <div className="form-error">{errors.password}</div>}
                </div>
                <div className="form-group">
                    <label htmlFor="confirmPassword">Confirm Password</label>
                    <input type="password" id="confirmPassword" name="confirmPassword" maxLength={32} className="form-control" value={form.confirmPassword} onChange={handleChange} />
                    {errors.confirmPassword && <div className="form-error">{errors.confirmPassword}</div>}
                </div>
                <div className="form-group">
                    <label htmlFor="bloodType">Blood Type</label>
                    <select id="bloodType" name="bloodType" className="form-control" value={form.bloodType} onChange={handleChange}>
                        <option value="">Select</option>
                        <option value="A+">A+</option>
                        <option value="A-">A-</option>
                        <option value="B+">B+</option>
                        <option value="B-">B-</option>
                        <option value="AB+">AB+</option>
                        <option value="AB-">AB-</option>
                        <option value="O+">O+</option>
                        <option value="O-">O-</option>
                    </select>
                    {errors.bloodType && <div className="form-error">{errors.bloodType}</div>}
                </div>
                <div className="form-group">
                    <label>
                        <input type="checkbox" name="organDonor" className="form-checkbox" checked={form.organDonor} onChange={handleChange} /> I want to be an organ donor
                    </label>
                </div>
                <div className="form-group">
                    <label className="terms-label">
                        <input type="checkbox" name="termsAccepted" className="form-checkbox" checked={form.termsAccepted} onChange={handleChange} />
                        <span>
                            {" "}I accept the <button type="button" className="terms-link" onClick={() => setShowTerms(true)}>terms and conditions</button>
                        </span>
                    </label>
                    {errors.termsAccepted && <div className="form-error">{errors.termsAccepted}</div>}
                    {showTerms && (
                        <button
                            type="button"
                            className="terms-modal-overlay"
                            aria-label="Close terms and conditions"
                            onClick={() => setShowTerms(false)}
                            onKeyDown={e => {
                                if (e.key === "Enter" || e.key === " ") {
                                    setShowTerms(false);
                                }
                            }}
                            style={{ all: "unset", display: "block", width: "100%", height: "100%", position: "fixed", top: 0, left: 0, zIndex: 1000 }}
                        >
                            <dialog
                                className="terms-modal"
                                open
                                aria-modal="true"
                                aria-labelledby="terms-title"
                                onClose={() => setShowTerms(false)}
                            >
                                <h2 id="terms-title">Terms and Conditions</h2>
                                <div className="terms-content">
                                    <p>By registering, you agree to donate blood and/or organs as per your selection. You confirm that all information provided is accurate and you accept the privacy policy. Please consult with your healthcare provider before making any medical decisions. Your data will be handled securely and not shared with third parties except as required by law.</p>
                                    <ul>
                                        <li>You are voluntarily registering as a donor.</li>
                                        <li>All information must be truthful and accurate.</li>
                                        <li>You may withdraw consent at any time.</li>
                                        <li>For more details, contact our support team.</li>
                                    </ul>
                                </div>
                                <button className="terms-close" onClick={() => setShowTerms(false)}>Close</button>
                            </dialog>
                        </button>
                    )}
                </div>
                <button type="submit" className="form-submit">Register</button>
            </form>
        </div>
    );
}
export default RegistrationPage;