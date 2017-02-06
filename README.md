# Trivia Smack
A fast-paced 2 player trivia game.

As of right now:
A Flask-MongoDB stack running on a custom AWS EB instance.
Click start to have 3 random questions displayed. If the button flashes green, you answered correctly. If red, you answered wrong!
No score keeping right now.
Play here: http://flask-environment.kxsucgnnpx.us-west-2.elasticbeanstalk.com/

Uses AWS Codepipeline for Continuous Integration; code changes trigger deployment to our production server in AWS.
