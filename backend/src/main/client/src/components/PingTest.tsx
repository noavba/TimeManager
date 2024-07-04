
import {useEffect} from "react";
function PingTest(){
    useEffect(()=> {
        fetch('http://localhost:8080/api/ping')
            .then(response => response.text())
            .then(body => console.log(body));


    },[]);
    return(
    <h1>Check Console Log</h1>
    );
}
export default PingTest;