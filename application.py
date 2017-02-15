"""
application.py

Note that EB looks for application.py in the root dir,
so this can't be renamed or moved.
"""

from flask import Flask
from web_app.application.Services import Services

from web_app import create_app, DB_NAME

Services.create_data_access(DB_NAME)

# EB looks for an "application" callable by default
application = Flask(__name__, template_folder="web_app/templates")
create_app(application)

if __name__ == '__main__':
    application.run()
    Services.close_data_access()
