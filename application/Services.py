"""
Services.py
"""
import sys
from persistence.DataAccessObject import DataAccessObject

class Services(object):
    """Services"""
    dataAccessService = None

    @staticmethod
    def create_data_access(dbName, alternateDataAccessService=None):
        """create_data_access"""
        if Services.dataAccessService is None:
            if alternateDataAccessService:
                Services.dataAccessService = alternateDataAccessService
            else:
                Services.dataAccessService = DataAccessObject(dbName)

            Services.dataAccessService.open()

    @staticmethod
    def get_data_access():
        """get_data_access"""
        if Services.dataAccessService is None:
            print "Connection to data access has not been established"
            sys.exit(0)

        return Services.dataAccessService

    @staticmethod
    def close_data_access():
        """Close the database service"""
        if Services.dataAccessService != None:
            Services.dataAccessService.close()

        Services.dataAccessService = None
