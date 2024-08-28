import React from 'react'
import { Button } from 'react-bootstrap'
import QuestionAnswerItem from './QuestionAnswerItem'
import { setAnswerValue } from './store/questionSet/questionset'
import { useDispatch } from 'react-redux'


export default function LowLevelQuestion({ sectionId, id, qItems}) {
    const dispatch = useDispatch()

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
            <h4>In our company...</h4>
            <p style={{"color" : "rgb(33, 55, 224)"}}>Choose as many as you like</p>
            {qItems.map((qItem, index) => {
                return (
                    <div className={qItem.answer === true ? "selectedLowLevelQuestionContainer" : "lowLevelQuestionContainer"} key={index}>
                        <div >
                            <QuestionAnswerItem
                                sectionId={sectionId}
                                questionType="lowLevelQuestion"
                                questionId={id}
                                qItem={qItem}
                            />
                        </div>
                    </div>
                )
            })}
            <div style={{'margin-top': "2%"}}>
            <Button className="lowLevelNextQuestionButton" onClick={scrollToNextQuestion} >Ok ✓</Button>
            <Button className="backtoTopLevelQuestionButton" onClick={() => {dispatch(setAnswerValue(sectionId, true))}}>Answer Top Level Question</Button>
            </div>
        </>
    )
}
