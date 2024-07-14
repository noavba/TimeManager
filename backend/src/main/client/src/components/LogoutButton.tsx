import React from 'react';
import { useNavigate } from 'react-router-dom';
import axios, { AxiosError } from 'axios';

interface LogoutResponse {
    message: string;
}

const LogoutComponent: React.FC = () => {
    const navigate = useNavigate();

    const handleLogout = async () => {
        try {
            const token = localStorage.getItem('jwtToken');
            const userId = localStorage.getItem('userId');

            if (!token || !userId) {
                console.error('Token or userId not found in localStorage');
                navigate('/login');
                return;
            }

            const response = await axios.post<LogoutResponse>(
                'http://localhost:8080/api/auth/signout',
                { userId },
                {
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization': `Bearer ${token}`
                    }
                }
            );

            console.log('Logout successful', response.data);

            // Clear local storage
            localStorage.removeItem('jwtToken');
            localStorage.removeItem('userId');

            // Clear the Authorization header for future requests
            delete axios.defaults.headers.common['Authorization'];

            // Redirect to login page
            navigate('/login');
        } catch (error) {
            const axiosError = error as AxiosError;
            console.error('Logout failed', axiosError.response?.data);
            alert(axiosError.response?.data || 'Logout failed');
        }
    };

    return (
        <button onClick={handleLogout}>Logout</button>
    );
}

export default LogoutComponent;