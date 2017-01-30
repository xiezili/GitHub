"""
DataAccessObject.py
"""
from DataAccessInterface import DataAccessInterface
from flask.ext.pymongo import MongoClient

class DataAccessObject(DataAccessInterface):
    """DataAccessObject"""
    def __init__(self, name):
        self.mongo = MongoClient()[name]

    def insert_user(self, userName):
        """insert a user into the DB"""
        pass

    def get_user(self, userName):
        """grab a user from the DB"""
        pass

    def get_all_users(self):
        """return a list of all the users"""
        return "".join([result["name"] for result in self.mongo.users.find({})])
