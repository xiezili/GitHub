"""
GameController.py
"""
from web_app.business.AccessQuestions import AccessQuestions

class GameController(object):
    """Controls the game"""

    INSTANCE = None
    MAX_QUESTIONS = 3

    def __init__(self):
        self.access_questions = AccessQuestions()
        self.questions = None
        self.curr_question = None
        self.question_count = -1
        self.score = -1
        self.is_started = False

    @classmethod
    def get_instance(cls):
        """Fetch the one and only instance"""
        if GameController.INSTANCE is None:
            GameController.INSTANCE = GameController()

        return GameController.INSTANCE

    @classmethod
    def destroy(cls):
        """Destroy the single INSTANCE"""
        GameController.INSTANCE = None

    def start(self):
        """Start the game by grabing a set of questions"""
        self.question_count = 0
        self.score = 0
        self.questions =\
        self.access_questions.get_random_questions(GameController.MAX_QUESTIONS)
        self.is_started = True

    def get_next_question(self):
        """Return the next question"""

        if self.question_count == GameController.MAX_QUESTIONS:
            self.curr_question = None
        else:
            self.curr_question = self.questions[self.question_count]
            self.question_count += 1

        return self.curr_question

    def increase_score(self):
        self.score += 1

    def evaluate_answer(self, answer_index):
        """Check if the current question answer equals answer_index"""
        result = True if answer_index == self.curr_question.answer else False
        return result

    def is_finished(self):
        """Check if the game is finished"""
        return GameController.MAX_QUESTIONS == self.question_count
