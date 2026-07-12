import useAuth from "../../modules/auth/hooks/useAuth";
import CTASection from "../components/Home/CTASection";
import FeaturedModules from "../components/Home/FeaturedModules";
import HeroSection from "../components/Home/HeroSection";

export default function HomePage(){

  const {session} = useAuth()
  console.log(session)
  
  return (
    <>
      <HeroSection/>

      <FeaturedModules/>

      <CTASection/>
    </>
  )
}
