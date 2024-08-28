import React from 'react'
import QuestionAnswerItem from './QuestionAnswerItem'

export default function TopLevelQuestion({sectionId, id, qItem}) {
    return (
        <div>
            <QuestionAnswerItem 
            sectionId={sectionId}
            questionType="topLevelQuestion"
            questionId={id}
            qItem={qItem}/>
        </div>
    )
}
