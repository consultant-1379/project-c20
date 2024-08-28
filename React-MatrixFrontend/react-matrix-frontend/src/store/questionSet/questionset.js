import {combineReducers} from 'redux'
const ADD_QUESTIONSET = 'ADD_QUESTIONSET'
const SET_ANSWER_VALUE = 'SET_ANSWER_VALUE'
const TOGGLE_ANSWER_VALUE = 'TOGGLE_ANSWER_VALUE'

export function addQuestionSet(questionSet) {
    console.log("from add question set func",questionSet)
    return {
        type: "ADD_QUESTIONSET",
        payload: questionSet,
    }
}

export function setAnswerValue(sectionId, answer) {
    return {
        type: 'SET_ANSWER_VALUE',
        payload: {
            sectionId,
            answer
        }

    }
}

export function toggleAnswerValue(sectionId, questionId) {
    return {
        type: "TOGGLE_ANSWER_VALUE",
        payload: {
            sectionId,
            questionId
        }
    }
}

const defaultQuestionSet = []

function questionSet(state=defaultQuestionSet, action) {
    switch (action.type) {
        case ADD_QUESTIONSET:
            return (
                action.payload.map((section, index) => {
                    // console.log(section)
                    return {
                        id: section.id,
                        stage: section.stage,
                        prompt: section.prompt,
                        topLevelQuestion: section.topLevelQuestion,
                        lowLevelQuestion: section.lowLevelQuestion
                    }
                })
            )
    
        case SET_ANSWER_VALUE:
            let setAnswerSection = state.find(s => s.id === action.payload.sectionId)
            let setAnswersections = state.filter(s => s.id !== action.payload.sectionId)

            console.log(setAnswerSection)

            let topLevelQuestionItem = setAnswerSection.topLevelQuestion.qItem
            topLevelQuestionItem.answer = action.payload.answer

            return [
                ...setAnswersections,
                {
                    ...setAnswerSection,
                }
            ]
            
        case TOGGLE_ANSWER_VALUE:
            console.log("action",action)
            console.log("state",state)
            let toggleAnswerSection = state.find(s => s.id === action.payload.sectionId)
            let lowLevelQitems = toggleAnswerSection.lowLevelQuestion.qItems
            lowLevelQitems[action.payload.questionId - 1].answer = !lowLevelQitems[action.payload.questionId - 1].answer
            console.log("booo", lowLevelQitems)
            let toggleAnswerSections = state.filter(s => s.id !== action.payload.sectionId)
            console.log(toggleAnswerSection, "section")
            console.log(toggleAnswerSections, "the rest")
            
            return [
                ...toggleAnswerSections,
                {
                    ...toggleAnswerSection,

                }
            ]



        default:
            return state
    }
}

const questionSetApp = combineReducers({
    questionSet
  });
  
  export default questionSetApp;