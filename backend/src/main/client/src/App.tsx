import { Link } from 'react-router-dom';
import './App.css'
import LinkButton from "./components/LinkButton.tsx";

function App() {


  return (
    <>
        <div>
          <h1>testing connections</h1>
            <div>
              <Link to={'/cake'}>Visit /cake</Link>
            </div>
            <h1>yeah</h1>
            <div>
              <Link to={'/pingtest'}>Visit /pingtest</Link>
            </div>
            <div>
              <Link to={'/login'}>Login here </Link>
            </div>
            <div>
              <LinkButton route={"/register"} buttonText={"Register Here"}></LinkButton>
            </div>
        </div>
    </>
  )
}

export default App
