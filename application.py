"""
application.py
"""
from flask import Flask, render_template, session, redirect
from application.Services import Services
from business.AccessQuestions import AccessQuestions
from flask.ext.session import Session

# EB looks for an "application" callable by default
application = Flask(__name__)
application.config.from_object("config")
Session(application)
Services.create_data_access("application")
access_questions = AccessQuestions()

MAX_QUESTIONS = 3

@application.route("/", methods=["GET", "POST"])
def home_page():
    """The homepage"""
    session.clear()
    session["questions"] = access_questions.get_random_questions(MAX_QUESTIONS)
    session["question_count"] = 0
    return render_template("homePage.html")


@application.route("/question_page", methods=["GET", "POST"])
def question_page():
    """The questions page"""
    q_count = session["question_count"]

    if q_count >= MAX_QUESTIONS:
        return redirect("/")

    question_obj = session["questions"][q_count]

    session["question_count"] = q_count + 1

    question = question_obj.question
    options = question_obj.options
    answer = question_obj.answer

    return render_template("questionPage.html",\
       question=question,\
       options=options,\
       answer=answer)

if __name__ == "__main__":
    application.run()
