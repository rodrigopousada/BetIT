import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom'
import './App.css'
import Home from './pages/Home'
import Cadastro from './pages/Cadastro'

function App() {
  const [count, setCount] = useState(0)

  return (
    <Router>
        <Routes>
            <Route path="/" element={<Home />}/>
            <Route path="/cadastro" element={<Cadastro />}/>
        </Routes>
    </Router>

  )
}

export default App
