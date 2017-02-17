"""
application.py

Note that EB looks for application.py in the root dir
"""
from flask import Flask
from web_app import create_app, set_up, tear_down

# EB looks for an "application" callable by default
application = Flask(__name__, template_folder="web_app/templates")
create_app(application)

if __name__ == "__main__":
    set_up()
    application.run()
    tear_down()
