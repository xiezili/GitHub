"""
DataAccessInterface.py
"""
from abc import ABCMeta, abstractmethod

class DataAccessInterface(object):
    """A Python abstract base class to act as an interface"""
    __metaclass__ = ABCMeta

    @abstractmethod
    def insert_user(self, userName):
        """Insert a user into the DB"""
        pass

    @abstractmethod
    def get_user(self, userName):
        """Grab a user from the DB"""
        pass

    @abstractmethod
    def get_all_users(self):
        """Return a list of all the users"""
        pass
