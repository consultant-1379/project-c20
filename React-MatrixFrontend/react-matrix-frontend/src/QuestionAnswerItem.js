import React, { useState } from 'react'
import { Button } from 'react-bootstrap'
import { useDispatch, useSelector } from 'react-redux'
import { addQuestionSet, setAnswerValue, toggleAnswerValue } from './store/questionSet/questionset'

export default function QuestionAnswerItem({sectionId, questionType, questionId, qItem}) {
    const dispatch = useDispatch()
    const [checked, setChecked] = useState(qItem.answer)

    const scrollToNextQuestion = () => {
        document.getElementById(sectionId < 9 ? (sectionId + 1) : "submit")
        .scrollIntoView({
            behavior: "smooth",
            block: "center",
            inline: "center"
          })
    }

    return (
    <>
    {questionType === "lowLevelQuestion" 
    ?   <>
            <input
                onClick={() => dispatch(toggleAnswerValue(sectionId, qItem.id))}
                checked={checked}
                onChange={() => {setChecked(!checked)}}
                value={qItem.answer}
                className="nodisplay"
                type="checkbox"
                id={" " + qItem.id + questionId + questionType + sectionId}
            />
            <label style={{cursor: "pointer", display: "block"}} htmlFor={" " + qItem.id + questionId + questionType + sectionId}>{qItem.id + ". " + qItem.questionText}</label>
        </>
    :   <>
        <div className="questionTextContainer">
            <h1>{qItem.questionText}</h1>
        </div>
        <div className="yesNoButtonsContainer">
            <Button 
                className="topLevelQuestionYesButton" 
                onClick={() => 
                    dispatch(setAnswerValue(sectionId, true)),
                    scrollToNextQuestion
                }
                >
                Yes ✓
            </Button>
            <Button className="topLevelQuestionNoButton" onClick={() => dispatch(setAnswerValue(sectionId, false))}>No ⨯</Button>
        </div>
        </>
    }
    
     
    </>
    )
}
