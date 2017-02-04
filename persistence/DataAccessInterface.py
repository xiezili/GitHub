"""
DataAccessInterface.py
"""
from abc import ABCMeta, abstractmethod

class DataAccessInterface(object):
    """A Python abstract base class to act as an interface"""
    __metaclass__ = ABCMeta

    @abstractmethod
    def get_question(self):
        """Grab a question from the DB"""
        pass

    @abstractmethod
    def get_questions(self):
        """Return a list of all the questions"""
        pass

    @abstractmethod
    def get_num_questions(self):
        """Return the number of questions"""
        pass
