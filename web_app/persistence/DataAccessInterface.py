"""
DataAccessInterface.py
"""
from abc import ABCMeta, abstractmethod

class DataAccessInterface(object):
    """A Python abstract base class to act as an interface"""
    __metaclass__ = ABCMeta

    @abstractmethod
    def open(self):
        pass

    @abstractmethod
    def close(self):
        pass

    @abstractmethod
    def get_question(self):
        pass

    @abstractmethod
    def get_all_questions(self):
        pass

    @abstractmethod
    def get_num_questions(self):
        pass
