import WelcomeCard from "../components/Dashboard/WelcomeCard";
import QuickActions from "../components/Dashboard/QuickActions";
import ModuleOverview from "../components/Dashboard/ModuleOverview";
import RecentActivity from "../components/Dashboard/RecentActivity";

export default function DashboardPage() {

  console.log("In dashboard")
    return (

        <div className="mx-auto flex max-w-7xl flex-col gap-10 px-6 py-10">

            <WelcomeCard />

            <QuickActions />

            <ModuleOverview />

            <RecentActivity />

        </div>

    );
}