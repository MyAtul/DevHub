import { Outlet } from "react-router-dom";
import Navbar from '../../platform/components/Navbar/Navbar';

const MainLayout = () => {
  return (
    <div className="bg-black text-white min-h-screen flex flex-col justify-between">
        <header>
            <Navbar/>
        </header>

        <main>
            <Outlet/>
        </main>

        <footer>
            Footer
        </footer>
    </div>
  )
}

export default MainLayout