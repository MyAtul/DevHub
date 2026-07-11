import React from 'react'

import { Outlet } from "react-router-dom";

const MainLayout = () => {
  return (
    <>
        <header>
            Navbar
        </header>

        <main>
            <Outlet/>
        </main>

        <footer>
            Footer
        </footer>
    </>
  )
}

export default MainLayout