"""
AccessUsers.py
"""
from Application.Services import Services

class AccessUsers(object):
    """For accessing Users using the database defined in Services"""
    def __init__(self):
        self.data_access = Services.get_data_access()

    def get_users(self):
        """get_users"""
        return self.data_access.get_all_users()
