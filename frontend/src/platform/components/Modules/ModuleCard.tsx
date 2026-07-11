import { Link } from "react-router-dom"

type ModuleCardProps = {
    title:string;
    description:string;
    path?:string;
    available?:boolean;
};

export default function ModuleCard({
    title,
    description,
    path,
    available = false,
}:ModuleCardProps){

    if(!available){
        return(
            <div className="rounded-xl border border-gray-800 p-6 opacity-50">
                <h2 className="text-xl font-semibold">{title}</h2>
                <p className="mt-2 text-gray-500">{description}</p>
                <p className="text-gray-600 mt-4 text-sm">Comming Soon</p>
            </div>
        )
    }

    return(
        <Link
            to={path!}
            className="block rounded-xl border border-gray-800 p-6 transition hover:border-white"
        >
            <h2 className="text-xl font-semibold">{title}</h2>
            <p className="mt-2 text-gray-400">{description}</p>
        </Link>
    )
}
