"""
GameController.py
"""
from web_app.business.AccessQuestions import AccessQuestions

class GameController(object):
    """Controls the game"""

    def __init__(self, max_questions):
        self.max_questions = max_questions
        self.access_questions = AccessQuestions()
        self.questions = None
        self.curr_question = None
        self.question_count = -1
        self.score = -1

    def start(self):
        """Start the game by grabing a set of questions"""
        self.question_count = 0
        self.score = 0
        self.questions =\
        self.access_questions.get_random_questions(self.max_questions)

    def get_next_question(self):
        """Return the next question"""

        if self.question_count == self.max_questions:
            self.curr_question = None
        else:
            self.curr_question = self.questions[self.question_count]
            self.question_count += 1

        return self.curr_question

    def update_score(self, answer_index):
        """Update score if the current question answer equals answer_index"""
        if answer_index == self.curr_question.answer:
            self.score += 1