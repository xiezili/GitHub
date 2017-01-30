"""
application.py
"""
from Application.Services import Services
from Business.AccessUsers import AccessUsers
from flask import Flask

# EB looks for an "application" callable by default
application = Flask(__name__)
application.config.from_object("config")
Services.create_data_access("application")
access_users = AccessUsers()

@application.route("/", methods=["GET", "POST"])
def home_page():
    """ The homepage """
    return "Users: " + access_users.get_users()

if __name__ == "__main__":
    application.run()
