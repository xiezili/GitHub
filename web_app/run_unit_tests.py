"""
run_unit_tests.py
"""
import unittest
from web_app.tests.objects.QuestionTest import QuestionTest
from web_app.tests.persistence.DataAccessTest import DataAccessTest
from web_app.tests.business.GameControllerTest import GameControllerTest

def main():
    """Grab all the test suites, run them"""
    question_suite = unittest.TestLoader().loadTestsFromTestCase(QuestionTest)

    data_access_suite =\
    unittest.TestLoader().loadTestsFromTestCase(DataAccessTest)

    game_controller_suite =\
    unittest.TestLoader().loadTestsFromTestCase(GameControllerTest)

    all_suites = unittest.TestSuite([question_suite,\
        data_access_suite,\
        game_controller_suite])

    runner = unittest.TextTestRunner()
    runner.run(all_suites)

if __name__ == "__main__":
    main()
