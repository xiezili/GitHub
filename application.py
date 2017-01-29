"""
application.py
"""

from flask import Flask
from flask.ext.pymongo import MongoClient

# EB looks for an "application" callable by default.
application = Flask(__name__)
client = MongoClient()
db = client["application"]

application.config.from_object("config")

@application.route("/", methods=["GET", "POST"])
def home_page():
    """ The homepage """
    users = db.users.find({})
    return "Users: " + "".join([result["name"] for result in users])

# run the app.
if __name__ == "__main__":
    application.run()
