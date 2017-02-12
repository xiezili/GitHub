"""
application.py
"""
from flask import Flask
from web_app.application.Services import Services
from flask.ext.session import Session

DB_NAME = "application"

# EB looks for an "application" callable by default
application = Flask(__name__)
application.config.from_object("config")
Session(application)
Services.create_data_access(DB_NAME)

from web_app.views import home_page, question_page

application.add_url_rule("/", view_func=home_page)
application.add_url_rule\
("/question_page", methods=["GET", "POST"], view_func=question_page)

if __name__ == "__main__":
    application.run()
    Services.close_data_access()
