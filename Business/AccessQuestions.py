"""
AccessQuestions.py
"""
from Application.Services import Services

class AccessQuestions(object):
    """For accessing questions using the database defined in Services"""
    def __init__(self):
        self.data_access = Services.get_data_access()

    def get_question(self):
        """Grab a question from the DB"""
        return self.data_access.get_question()

    def get_questions(self):
        """get_questions"""
        return self.data_access.get_questions()

    def get_num_questions(self):
        """Return the number of questions"""
        return self.data_access.get_num_questions()
