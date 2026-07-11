import React, { type ReactNode } from 'react'

type AppProvidersProps = {
    children:ReactNode
}

const AppProviders = ({
    children,
}:AppProvidersProps) => {
  return (
    <>{children}</>
  )
}

export default AppProviders