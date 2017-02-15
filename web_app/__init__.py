"""
__init__.py
"""
from flask import Flask

DB_NAME = "application"

def create_app():
    """Create an application"""
    application = Flask(__name__)
    application.config.from_object("config")

    from .main import main as main_blueprint
    application.register_blueprint(main_blueprint)

    return application

