export const getQuestionset = () => {

    const url = "http://localhost:8080/questionSet"

    return fetch(url, {
        method: "GET",
    })

}

export const postQuestionSet = (questionSet) => {

    const url = "http://localhost:8080"

    return fetch(url, {
        method: "POST",
        headers:
            {"Content-Type" : "application/json"},
        body: JSON.stringify({sections: questionSet})
    })

}