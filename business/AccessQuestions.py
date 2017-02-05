"""
AccessQuestions.py
"""
from json import dumps, loads
from bson import json_util
from application.Services import Services

class AccessQuestions(object):
    """For accessing questions using the database defined in Services"""
    def __init__(self):
        self.data_access = Services.get_data_access()

    def get_random_questions(self, set_size):
        """Grab a random subset of questions from the DB"""
        num_questions = self.get_num_questions()
        set_size = set_size if num_questions >= set_size else num_questions

        questions = []
        seen = set()

        while len(seen) < set_size:
            question = self.data_access.get_question()
            _id = question["_id"]

            if _id not in seen:
                seen.add(_id)
                questions.append(question)

        #ObjectID is not json serializable, so we must encode/decode the docs
        return [loads(dumps(doc, default=json_util.default)) for doc in questions]

    def get_all_questions(self):
        """Grab all questions from the DB"""
        return self.data_access.get_all_questions()

    def get_num_questions(self):
        """Return the number of questions"""
        return self.data_access.get_num_questions()
