"""
Question.py
"""

class Question(object):
    """For holding a question, it's options, and answer"""

    def __init__(self, question, options, answer):
        self.question = question
        self.options = options
        self.answer = answer
