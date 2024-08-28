import React, { useEffect } from 'react'
import { Button } from 'react-bootstrap'
import { useNavigate } from "react-router-dom";

export default function Homepage() {
    const navigate = useNavigate()

    useEffect(() => {
        window.addEventListener('keypress', e => {
            if (e.key === "Enter") {
                handleSubmit()
            }
        });
      }, []);

    // const handleKeyPress = (e) => {
    //     console.log(e)
    //     if (e.key === "Enter") {
    //         handleSubmit()
    //     }
    // }

    const handleSubmit = () => {
        navigate(
            '/questionform',
        )
    }

    return (
        <div className="homePageContainer">
            <div className="titleContainer">
            <h3><strong>The Cloud Native Maturity Assesment</strong></h3>
            <h4>Where are you in your Cloud Native journey?</h4>
            </div>
            <div className="startBlockContainer">
                <div className="StartButtonContainer">
                <Button className="startButton" onClick={() => {handleSubmit()}}>Start</Button>
                </div>
                <div className="startInfoContainer">
                    press{" "}
                    <strong>
                        Enter
                    </strong>
                    ↵
                </div>
            </div>
            <div className="timeInfoContainer">
            ⏲ Takes 3 min
            </div>
            
        </div>
    )
}
