"""
application.py
"""
from flask import Flask, render_template, flash, request, session, redirect
from application.Services import Services
from business.AccessQuestions import AccessQuestions

# EB looks for an "application" callable by default
application = Flask(__name__)

application.config.from_object("config")
Services.create_data_access("application")
access_questions = AccessQuestions()

MAX_QUESTIONS = 3
RIGHT = "right"

@application.route("/")
def home_page():
    """The homepage"""

    score = session["score"] if "score" in session.keys() else None

    session.clear()
    session["questions"] = access_questions.get_random_questions(MAX_QUESTIONS)
    session["question_count"] = 0
    session["score"] = 0

    if session["questions"] == []:
        raise Exception("No questions found!")

    return render_template("homePage.html", score=score)

@application.route("/question_page", methods=["GET", "POST"])
def question_page():
    """The questions page"""

    if request.method == "POST":
        session["score"] += 1

    q_count = session["question_count"]

    if q_count >= MAX_QUESTIONS:
        return redirect("/")

    question_doc = session["questions"][q_count]
    session["question_count"] = q_count + 1

    question = question_doc["question"]
    options = [str(o) for o in question_doc["options"]]
    answer = str(options[question_doc["answer"]])

    return render_template("questionPage.html",\
       question=question,\
       options=options,\
       answer=answer)

if __name__ == "__main__":
    application.run()
