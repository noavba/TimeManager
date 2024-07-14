import {Link} from "react-router-dom";



interface LinkButtonProps{
    route: string;
    buttonText: string;
}
function LinkButton({route, buttonText}: LinkButtonProps){
    return(
        <Link to={route}>
            <button>{buttonText}</button>
        </Link>
    );
}

export default LinkButton;