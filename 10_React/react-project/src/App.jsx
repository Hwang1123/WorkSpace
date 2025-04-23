import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import UseStateTest from './components/useState/UseStateTest'
import SignUp from './components/useState/SignUp'
import LandingPage from './components/useState/LandingPage'
import UseRefTest from './components/useRef/useRefTest'
import UseRefScroll from './components/useRef/useRefScroll'
import UseMemoTest from './components/useMemo/UseMemoTest'
import UseCallbackTest from './components/useCallback/UseCallbackTest'
import UseEffectTest from './components/useEffect/useEffectTest'
import EffectView from './components/useEffect/EffectView'


function App() {
  return (
    <>
      {/* <UseStateTest /> */}
      {/* <SignUp />  */}
      {/* <LandingPage /> */}
      {/* <UseRefTest /> */}
      {/* <UseRefScroll /> */}
      {/* <UseMemoTest/> */}
      {/* <UseCallbackTest/> */}
      <EffectView/>
    </>
  )
}

export default App