
import {Link} from "react-router-dom";
import {useState} from "react";

function PingTest() {


    const [pingResult, setPingResult] = useState<string>('');

    const handlePing = async() => {
        try {
            const response = await fetch('http://localhost:8080/api/users/ping');
            if (response.ok) {
                const result = await response.text();
                setPingResult(result);
                console.log(result);
            } else {
                setPingResult("error: unable to fetch data");
            }
        } catch (e) {
            console.error('error: ', e);
            setPingResult("unable to fetch data");

        }
    };

    function resetPing(){

        setPingResult("NA")
    }


    return (
        <>
            <h1> Ping Test </h1>
            <div>
                <button onClick = {handlePing}>Ping Server</button>
                {pingResult && <p> server response: {pingResult}</p>}
            </div>
            <div style={{marginTop: 10}}>
                <button onClick={resetPing}>Reset Response</button>
            </div>
            <div style={{marginTop: 10}}>
                <Link to={'/'}>back to main page</Link>
            </div>
        </>
    );
}
export default PingTest;