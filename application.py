"""
application.py
"""

from flask import Flask
from flask.ext.pymongo import PyMongo

# EB looks for an 'application' callable by default.
application = Flask(__name__)
mongo = PyMongo(application)
application.config.from_object('config')

@application.route("/", methods=['GET', 'POST'])
def home_page():
    """ The homepage """
    users = mongo.db.users.find()
    return "".join([result["name"] for result in users])

# run the app.
if __name__ == "__main__":
    application.run()
