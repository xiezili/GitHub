"""
Services.py
"""
import sys
from persistence.DataAccessObject import DataAccessObject

class Services(object):
    """Services"""
    dataAccessService = None

    @staticmethod
    def create_data_access(dbName):
        """create_data_access"""
        Services.dataAccessService = DataAccessObject(dbName)

    @staticmethod
    def get_data_access():
        """get_data_access"""
        if Services.dataAccessService is None:
            print "Connection to data access has not been established"
            sys.exit(0)

        return Services.dataAccessService
