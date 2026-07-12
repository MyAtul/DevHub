import React, { type ReactNode } from 'react'
import AuthProvider from '../../modules/auth/context/AuthContext'

type AppProvidersProps = {
    children:ReactNode
}

const AppProviders = ({
    children,
}:AppProvidersProps) => {
  return (
    <AuthProvider>
      {children}
    </AuthProvider>
  )
}

export default AppProviders