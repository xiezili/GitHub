"""
__init__.py
"""

from flask.ext.session import Session

DB_NAME = "application"

def create_app(application):
    """Create the application"""

    application.config.from_object("web_app.config")

    from .main import main as main_blueprint
    application.register_blueprint(main_blueprint)
    Session(application)
