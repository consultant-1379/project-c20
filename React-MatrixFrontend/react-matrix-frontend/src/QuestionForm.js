import { Button, Card, Spinner } from 'react-bootstrap'
import React, { useEffect, useState } from 'react'
import { getQuestionset, postQuestionSet } from './services/requests'
import TopLevelQuestion from './TopLevelQuestion'
import LowLevelQuestion from './LowLevelQuestion'
import { useDispatch, useSelector } from 'react-redux'
import { addQuestionSet } from './store/questionSet/questionset'
import { useNavigate } from "react-router-dom";


export default function QuestionForm() {
    const dispatch = useDispatch()
    const questionSet = [...useSelector(state => state.questionSet)].sort((a, b) => {
        return a.id > b.id ? 1 : -1
    })
    const navigate = useNavigate()

    useEffect(() => {
        getQuestionset()
        .then(response => response.json())
        .then(data =>  dispatch(addQuestionSet(data.sections)))
    }, [])

    useEffect(() => {
        window.addEventListener('keypress', e => {
            if (e.key === "Enter") {
                document.getElementById("submit").click()
            }
        });
      }, []);

    const onFormSubmit = (questionSet) => {
        console.log("submitting form", questionSet)
        postQuestionSet(questionSet)
        .then(response => response.json())
        .then(data =>
            navigate(
            '/matrixreview',
            {state: {matrix: data.rows}}
        ))
    }

    return (
        <div>
        {questionSet
            ? <div id="questionSet" className="questionForm">
                {questionSet.map((section, index) => {
                    console.log(section)
                    return (
                    <div id={section.id} className="SectionContainer" key={index}>
                        <div className="sectionInfoContainer">
                            <div className="sectionNumberContainer" >{index + 1} →</div>
                            <div className="sectionStageContainer"><h4><strong>{section.stage}</strong></h4></div>
                            <div><h4>{section.prompt}</h4></div>
                        </div>
                        
                        <div className="questionContainer">

                        {section.topLevelQuestion.qItem.answer === true
                        ?   <TopLevelQuestion
                                sectionId={section.id}
                                id={section.topLevelQuestion.id}
                                qItem={section.topLevelQuestion.qItem}
                            /> 
                        :   <LowLevelQuestion
                                sectionId={section.id}
                                id={section.lowLevelQuestion.id}
                                qItems={section.lowLevelQuestion.qItems}
                            />
                            }
                        </div>
                    </div>)

                })}
                <div className="submitButtonBlockContainer">
                    <div className="submitButtonContainer">
                        <Button id="submit" className="submitButtom" onClick={() => {onFormSubmit(questionSet)}}>
                            Submit
                        </Button>
                    </div>
                
                <div className="submitInfoContainer">
                    press{" "}
                    <strong>
                        Enter
                    </strong>
                    ↵
                </div>
                    </div>
                
                </div>
        : 
            <div>
                <Spinner animation="border" role="status">
                    <span className="visually-hidden">Loading...</span>
                </Spinner>
            </div>
        }

        </div>
    )
}
