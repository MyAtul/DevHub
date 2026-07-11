import DownloadSection from "../components/Authentication/DownloadSection"
import FeatureSection from "../components/Authentication/FeatureSection"
import ModuleHero from "../components/Authentication/ModuleHero"
import TechStack from "../components/Authentication/TechStack"

const AuthenticationModulePage = () => {
  return (
    <div className="mx-auto max-w-7xl px-6">

      <ModuleHero/>

      <FeatureSection/>

      <TechStack/>

      <DownloadSection/>

    </div>
  )
}

export default AuthenticationModulePage