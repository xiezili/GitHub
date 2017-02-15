"""
__init__.py
"""
DB_NAME = "application"

def create_app(application):
    """Create an application"""

    application.config.from_object("config")

    from .main import main as main_blueprint
    application.register_blueprint(main_blueprint)
