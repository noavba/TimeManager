import React, { useState, FormEvent, ChangeEvent } from 'react';
import axios, { AxiosError } from 'axios';
import { useNavigate } from 'react-router-dom';

interface RegisterFormData {
    username: string;
    password: string;
    email: string;
}

const RegisterForm: React.FC = () => {
    const [formData, setFormData] = useState<RegisterFormData>({
        username: '',
        password: '',
        email: '',
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
            const response = await axios.post('http://localhost:8080/api/auth/register', formData, {
                headers: {
                    'Content-Type': 'application/json',
                }
            });
            console.log('registration successful', response.data);
            navigate("/homePage");
        } catch (error) {
            const axiosError = error as AxiosError;
            console.error('Register failed', axiosError.response?.data);
            console.log(error);
            alert(axiosError.response?.data || 'Registration failed');
            navigate("/register");
        }
    };

    return (
        <>
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
                <input
                    type="email"
                    name="email"
                    value={formData.email}
                    onChange={handleChange}
                    placeholder="Email"
                    required
                />
                <button type="submit">Register</button>
            </form>
        </>
    );
}

export default RegisterForm;