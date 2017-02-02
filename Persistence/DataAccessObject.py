"""
DataAccessObject.py
"""
from Persistence.DataAccessInterface import DataAccessInterface
from flask.ext.pymongo import MongoClient

class DataAccessObject(DataAccessInterface):
    """For directly querying the MongoDB"""
    def __init__(self, name):
        self.mongo = MongoClient()[name]

    def get_all_users(self):
        """Return a list of all the users"""
        return "".join([result["name"] for result in self.mongo.users.find({})])
