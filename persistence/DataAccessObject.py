"""
DataAccessObject.py
"""
import random
from json import dumps, loads
from bson import json_util
from persistence.DataAccessInterface import DataAccessInterface
from flask.ext.pymongo import MongoClient

class DataAccessObject(DataAccessInterface):
    """For directly querying the MongoDB"""
    def __init__(self, name):
        try:
            self.mongo = MongoClient()[name]
        except pymongo.errors.ConnectionFailure, e:
            raise "Could not connect to MongoDB: {}".format(e)

    @staticmethod
    def _serialize(doc):
        """Mongo ObjectIDs are not json serializable,
           so we must encode/decode documents"""
        return loads(dumps(doc, default=json_util.default))

    def get_question(self):
        """Grab a random question from the DB"""
        rq_num = random.randint(0, self.get_num_questions()-1)
        doc = self.mongo.questions.find().limit(1).skip(rq_num)[0]

        return DataAccessObject._serialize(doc)

    def get_all_questions(self):
        """Return a list of all the questions"""
        return [result for result in self.mongo.questions.find()]

    def get_num_questions(self):
        """Return the number of questions"""
        return self.mongo.questions.count()

