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
        doc = None
        num_qs = self.get_num_questions()
        rq_num = random.randint(0, num_qs-1) if num_qs > 0 else 0
        doc_cursor = self.mongo.questions.find().limit(1).skip(rq_num)

        if doc_cursor.count() > 0:
            doc = DataAccessObject._serialize(doc_cursor[0])

        return doc

    def get_all_questions(self):
        """Return a list of all the questions"""
        result = []
        for doc in self.mongo.questions.find():
            result.append(DataAccessObject._serialize(doc))
        return result

    def get_num_questions(self):
        """Return the number of questions"""
        return self.mongo.questions.count()

