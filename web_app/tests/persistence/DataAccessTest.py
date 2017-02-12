"""
DataAccessTest.py
"""
import unittest
from DataAccessStub import DataAccessStub
from server.application.Services import Services

class DataAccessTest(unittest.TestCase):

    def setUpClass(self):
        """Call once"""
        Services.close_data_access()
        dataAccess = Services.create_data_access(DataAccessStub("hi"))

    def tearDown(self):
        """Call after every test case"""
        pass
