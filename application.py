"""
application.py
"""
from web_app.application.Services import Services
from flask.ext.session import Session

from web_app import create_app, DB_NAME

Services.create_data_access(DB_NAME)
application = create_app()
Session(application)

if __name__ == '__main__':
    application.run()
    Services.close_data_access()
