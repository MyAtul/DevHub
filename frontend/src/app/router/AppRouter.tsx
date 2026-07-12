import { createBrowserRouter, RouterProvider } from 'react-router-dom'
import MainLayout from '../layouts/MainLayout'
import HomePage from '../../platform/pages/HomePage'
import ModulePage from '../../platform/pages/ModulePage'
import AuthenticationModulePage from '../../platform/pages/AuthenticationModulePage'
import DashboardPage from '../../platform/pages/DashboardPage'
import LoginPage from '../../modules/auth/pages/LoginPage'
import RegisterPage from '../../modules/auth/pages/RegisterPage'
import PageNotFound from '../../platform/pages/PageNotFound'
import ProtectedRoute from '../../modules/auth/routes/ProtectedRoutes'

const router = createBrowserRouter([
    {
        path : "/",
        element: <MainLayout/>,
        children:[
            {
                index:true,
                element:<HomePage/>
            },
            {
                path:"modules",
                element:<ModulePage/>
            },
            {
                path:"modules/authentication",
                element:<AuthenticationModulePage/>
            },
            {
                element:<ProtectedRoute/>,
                children:[
                    {
                        path: "dashboard",
                        element: <DashboardPage />,
                    },
                ]
            },
            {
                path:"login",
                element:<LoginPage/>
            },
            {
                path:"register",
                element:<RegisterPage/>
            },
            {
                path:"*",
                element:<PageNotFound/>
            }
        ]
    }
])

const AppRouter = () => {
  return <RouterProvider router={router}/>
}

export default AppRouter