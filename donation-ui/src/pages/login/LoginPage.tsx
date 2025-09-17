import { useEffect, useState } from 'react';
import AppBackground from '../../components/AppBackground';
import Navigation from "../../components/Navigation";
import axios from "axios";
import Cookies from "js-cookie";
import './Login.css';

const LoginPage: React.FC = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [errors, setErrors] = useState<{ [key: string]: string }>({});
    const [apiError, setApiError] = useState('');
    const [loading, setLoading] = useState(false);
    useEffect(() => { }, []);

    const validate = () => {
        const newErrors: { [key: string]: string } = {};
        if (!email.trim()) newErrors.email = "Please enter your email address.";
        else if (!/^\S+@\S+\.\S+$/.test(email)) newErrors.email = "Please enter a valid email address.";
        if (!password) newErrors.password = "Please enter your password.";
        return newErrors;
    };

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        setApiError('');
        const validationErrors = validate();
        setErrors(validationErrors);
        if (Object.keys(validationErrors).length === 0) {
            setLoading(true);
            try {
                const response = await axios.post("/api/login", { email, password }, { withCredentials: true });
                if (response.status === 200 && response.data?.token) {
                    Cookies.set("auth_token", response.data.token, { expires: 7, secure: true });
                    alert("Login successful!");
                    // Optionally redirect or update app state here
                } else {
                    setApiError(response.data?.message || "Login failed. Please try again.");
                }
            } catch (err: any) {
                if (err.response && err.response.data && err.response.data.message) {
                    setApiError(err.response.data.message);
                } else {
                    setApiError("Network error. Please try again later.");
                }
            }
            setLoading(false);
        }
    };

    return (
        <div>
            <AppBackground />
            <Navigation />
            <form className="login-form" onSubmit={handleSubmit}>
                <h1 className="login-title">Login</h1>
                <div className="form-group">
                    <label htmlFor="email">Email</label>
                    <input
                        type="email"
                        id="email"
                        name="email"
                        className="form-control"
                        value={email}
                        onChange={e => setEmail(e.target.value)}
                    />
                    {errors.email && <div className="form-error">{errors.email}</div>}
                </div>
                <div className="form-group">
                    <label htmlFor="password">Password</label>
                    <input
                        type="password"
                        id="password"
                        name="password"
                        className="form-control"
                        value={password}
                        onChange={e => setPassword(e.target.value)}
                    />
                    {errors.password && <div className="form-error">{errors.password}</div>}
                </div>
                <label htmlFor="role">Role</label>
                <select name='role' className='form-control' style={{ marginBottom: '1rem' }}>
                    <option value=''>Select Role</option>
                    <option value='admin'>Admin</option>
                    <option value='donor'>Donor</option>
                    <option value='doctor'>Doctor</option>
                    <option value='recipient'>Recipient</option>
                </select>
                {apiError && <div className="form-error">{apiError}</div>}
                <button type="submit" className="form-submit" disabled={loading}>{loading ? "Logging in..." : "Login"}</button>
            </form>
        </div>
    );
};

export default LoginPage;