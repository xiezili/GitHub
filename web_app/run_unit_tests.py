"""
run_unit_tests.py
"""
import unittest
import sys
from web_app.tests.objects.QuestionTest import QuestionTest
from web_app.tests.persistence.DataAccessTest import DataAccessTest
from web_app.tests.business.GameControllerTest import GameControllerTest
from web_app.tests.business.AccessQuestionsTest import AccessQuestionsTest

def main():

    question_suite = unittest.TestLoader().loadTestsFromTestCase(QuestionTest)

    question_access_suite =\
    unittest.TestLoader().loadTestsFromTestCase(AccessQuestionsTest)

    data_access_suite =\
    unittest.TestLoader().loadTestsFromTestCase(DataAccessTest)

    game_controller_suite =\
    unittest.TestLoader().loadTestsFromTestCase(GameControllerTest)

    all_suites = unittest.TestSuite([question_suite,\
        data_access_suite,\
        game_controller_suite,\
        question_access_suite])

    runner = unittest.TextTestRunner()
    runner.run(all_suites)

if __name__ == "__main__":
    sys.exit(1)
    #main()

