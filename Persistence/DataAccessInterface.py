"""
DataAccessInterface.py
"""
from abc import ABCMeta, abstractmethod

class DataAccessInterface(object):
    """DataAccess"""
    __metaclass__ = ABCMeta

    @abstractmethod
    def insert_user(self, userName):
        """insert a user into the DB"""
        pass

    @abstractmethod
    def get_user(self, userName):
        """grab a user from the DB"""
        pass

    @abstractmethod
    def get_all_users(self):
        """return a list of all the users"""
        pass
