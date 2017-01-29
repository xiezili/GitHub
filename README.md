# Trivia-Game
As of right now:
A Flask-MongoDB stack running on a custom AWS EB instance.
The Flask server just grabs a collection named 'users' from the mongoDB and prints them:
http://flask-environment.kxsucgnnpx.us-west-2.elasticbeanstalk.com/

Uses AWS Codepipeline for Continuous Integration; code changes trigger deployment to our instance in AWS.
