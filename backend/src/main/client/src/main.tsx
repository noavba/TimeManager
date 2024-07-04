import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.tsx'
import './index.css'
import {createBrowserRouter, RouterProvider} from "react-router-dom";
import PingTest from "./components/PingTest.tsx";
import Login from "./components/Login.tsx";

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
        element: <Login />
    }

]);

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
      <RouterProvider router =  {router} />
  </React.StrictMode>,
)
