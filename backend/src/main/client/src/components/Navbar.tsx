import {Link} from "react-router-dom";
import "./Navbar.css"
function Navbar(){

    return(

        <nav className={"navbar"}>

            <div className={"navbar-left"}>
                <Link to={"/"} className={"icon"}>
                    <img src={"/home.svg"} alt={"Home Icon"}/>

                </Link>
            </div>

        </nav>
    )

}

export default Navbar;