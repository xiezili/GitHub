"""
application.py
"""

from flask import Flask

# EB looks for an 'application' callable by default.
application = Flask(__name__)
application.config.from_object('config')

@application.route("/", methods=['GET', 'POST'])
def home_page():
    """ The homepage """
    return "hi y'all!! :)"


# run the app.
if __name__ == "__main__":
    application.run()
