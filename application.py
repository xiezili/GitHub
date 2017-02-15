"""
application.py
"""
from flask import Flask
from web_app.application.Services import Services
from flask.ext.session import Session
from web_app import create_app, DB_NAME

Services.create_data_access(DB_NAME)

# EB looks for an "application" callable by default
application = Flask(__name__, template_folder="web_app/templates")
create_app(application)
Session(application)

if __name__ == "__main__":
    application.run()
    Services.close_data_access()
