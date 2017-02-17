"""
__init__.py
"""
from flask.json import JSONEncoder
from flask.ext.session import Session
from web_app.business.MyJSONEncoder import MyJSONEncoder

DB_NAME = "application"

def create_app(application):
    """Create the application"""

    application.config.from_object("web_app.config")

    application.json_encoder = MyJSONEncoder

    from .main import main as main_blueprint
    application.register_blueprint(main_blueprint)

    Session(application)
