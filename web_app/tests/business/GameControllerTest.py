"""
GameControllerTest.py
"""
import unittest
from ..persistence.DataAccessStub import DataAccessStub
from web_app.application.Services import Services
from web_app.business.GameController import GameController

class GameControllerTest(unittest.TestCase):
    """Unit tests for the Question class"""

    @classmethod
    def setUpClass(cls):
        """Call once"""
        Services.close_data_access()
        Services.create_data_access(\
            altDataAccessService=DataAccessStub("application"))

    @classmethod
    def tearDownClass(cls):
        """Call once"""
        Services.close_data_access()

    def setUp(self):
        """Call before every test case"""
        self.max_questions = 3
        self.game_controller = GameController(self.max_questions)

    def tearDown(self):
        """Call after every test case"""
        self.game_controller = None

    def test_init(self):
        """Test Question initialization"""
        print "Testing GameController: Constructor"


    def test_mutation(self):
        """Test mutators"""
        print "Testing GameController: Mutators"



    def test_failure(self):
        """Test for failure"""
        print "Testing Question: Invalid Args"
        try:
            GameController()
            self.fail("Expected typeError")
        except TypeError:
            pass
