import React from 'react'
import UseEffectTest from './useEffectTest'

const EffectView = () => {
    const [isView, setIsView] = useState(true);
  return (
    <div>
      <button onClick={()=> setIsView(prev => !prev)}>
        화면보기
      </button>
      {
        isView
      }
    </div>
  )
}

export default EffectView
