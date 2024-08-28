function scrollToNextQuestion(elementId) {

    console.log("scrolling to ", elementId)
    var x = document.getElementById(elementId);
    x.scrollIntoView({
        behavior: "smooth",
        block: "center",
        inline: "center"
    });
}

function showInstead(elementIdToShow, elementIdToHide) {

    console.log("hiding", elementIdToHide)
    console.log("showing", elementIdToShow)
    hide(elementIdToHide);
    show(elementIdToShow);

}

function hide(elementId) {
    var x = document.getElementById(elementId);
    console.log(x.style)
    x.style.display = "none";
  }

function show(elementId) {
    var x = document.getElementById(elementId);
    console.log(x.style)
    x.style.display = "block";
  }

