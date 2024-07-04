import { Link } from 'react-router-dom';
import './App.css'

function App() {


  return (
    <>
      <div>
        <h1>testing connections</h1>
          <Link to={'/cake'}>Visit /cake</Link>
      </div>

    </>
  )
}

export default App
