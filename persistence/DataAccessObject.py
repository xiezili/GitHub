"""
DataAccessObject.py
"""
import random
from Persistence.DataAccessInterface import DataAccessInterface
from flask.ext.pymongo import MongoClient

class DataAccessObject(DataAccessInterface):
    """For directly querying the MongoDB"""
    def __init__(self, name):
        try:
            self.mongo = MongoClient()[name]
        except pymongo.errors.ConnectionFailure, e:
            raise "Could not connect to MongoDB: {}".format(e)

    def get_question(self):
        """Grab a question from the DB"""
        rq_num = random.randint(0, self.get_num_questions()-1)
        return [r for r in self.mongo.questions.find().limit(1).skip(rq_num)][0]

    def get_questions(self):
        """Return a list of all the questions"""
        return [result for result in self.mongo.questions.find()]

    def get_num_questions(self):
        """Return the number of questions"""
        return self.mongo.questions.count()
