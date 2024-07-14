import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.tsx'
import './index.css'
import {createBrowserRouter, RouterProvider} from "react-router-dom";
import PingTest from "./pages/PingTest.tsx";
import LoginPage from "./pages/LoginPage.tsx";
import RegisterPage from "./pages/RegisterPage.tsx";
import HomePage from "./pages/HomePage.tsx";

const router = createBrowserRouter([
    {
        path: '/',
        element: <App />,
    },
    {
        path: '/cake',
        element: <div style = {{fontSize: 150}}> 🍰</div>
    },
    {
        path: '/pingtest',
        element: <PingTest/>
    },
    {
        path: '/login',
        element: <LoginPage />
    },
    {
        path:'/register',
        element: <RegisterPage/>
    },
    {
        path:'/homePage',
        element:<HomePage/>
    }


]);

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
      <RouterProvider router =  {router} />
  </React.StrictMode>,
)
