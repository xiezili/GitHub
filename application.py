"""
application.py
"""
from flask import Flask, render_template, flash, request
from Application.Services import Services
from Business.AccessQuestions import AccessQuestions

# EB looks for an "application" callable by default
application = Flask(__name__)
application.config.from_object("config")
Services.create_data_access("application")
access_questions = AccessQuestions()

@application.route("/", methods=["GET", "POST"])
def home_page():
    """ The homepage """
    question_doc = access_questions.get_question()
    answer = question_doc["answer"]

    if request.method == "POST":
        print request.form["btn"]

    return render_template("homePage.html",\
       question=question_doc["question"],\
       options=question_doc["options"],\
       answer=question_doc["options"][answer])

if __name__ == "__main__":
    application.run()
