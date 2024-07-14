import React, { useState, FormEvent, ChangeEvent } from 'react';
import axios, { AxiosError } from 'axios';
import { useNavigate } from 'react-router-dom';

interface LoginFormData {
    username: string;
    password: string;
}

interface LoginResponse {
    token: string;
    id: number;
    username: string;
    email: string;
    roles: string[];
}

const LoginForm: React.FC = () => {
    const [formData, setFormData] = useState<LoginFormData>({
        username: '',
        password: '',
    });
    const navigate = useNavigate();

    const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
        const { name, value } = e.target;
        setFormData(prevData => ({
            ...prevData,
            [name]: value,
        }));
    };

    const handleSubmit = async (e: FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        try {
            const response = await axios.post<LoginResponse>('http://localhost:8080/api/auth/signin', formData, {
                headers: {
                    'Content-Type': 'application/json',
                }
            });
            console.log('Signin successful', response.data);

            // Store the token in localStorage
            localStorage.setItem('jwtToken', response.data.token);

            // Set the token for future axios requests
            axios.defaults.headers.common['Authorization'] = `Bearer ${response.data.token}`;

            navigate("/homePage");
        } catch (error) {
            const axiosError = error as AxiosError;
            console.error('Signin failed', axiosError.response?.data);
            alert(axiosError.response?.data || 'Signin failed');
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <input
                type="text"
                name="username"
                value={formData.username}
                onChange={handleChange}
                placeholder="Username"
                required
            />
            <input
                type="password"
                name="password"
                value={formData.password}
                onChange={handleChange}
                placeholder="Password"
                required
            />
            <button type="submit">Login</button>
        </form>
    );
}

export default LoginForm;