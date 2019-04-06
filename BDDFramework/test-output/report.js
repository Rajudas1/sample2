$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("01_login.feature");
formatter.feature({
  "line": 1,
  "name": "GovernancePortal Application Login Test",
  "description": "",
  "id": "governanceportal-application-login-test",
  "keyword": "Feature"
});
formatter.before({
  "duration": 27293367870,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "GovernancePortal Login Page Test",
  "description": "",
  "id": "governanceportal-application-login-test;governanceportal-login-page-test",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@login"
    }
  ]
});
formatter.step({
  "line": 10,
  "name": "user opens browser",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "users logs in to the app",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginPageSteps.user_opens_browser()"
});
formatter.result({
  "duration": 86445892,
  "status": "passed"
});
formatter.match({
  "location": "LoginPageSteps.users_enters_username_and_password()"
});
formatter.result({
  "duration": 2322850981,
  "status": "passed"
});
formatter.after({
  "duration": 86146,
  "status": "passed"
});
formatter.after({
  "duration": 1041467059,
  "status": "passed"
});
formatter.uri("02_home.feature");
formatter.feature({
  "line": 1,
  "name": "GovernancePortal Application Home Test",
  "description": "",
  "id": "governanceportal-application-home-test",
  "keyword": "Feature"
});
formatter.before({
  "duration": 33030546408,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "GovernancePortal Home Page Test",
  "description": "",
  "id": "governanceportal-application-home-test;governanceportal-home-page-test",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@home"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "user opens browser by hit the url",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "users logs in to the app and land in to home",
  "keyword": "Then "
});
formatter.match({
  "location": "HomePageSteps.user_opens_browser()"
});
formatter.result({
  "duration": 952583,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.users_enters_username_and_password()"
});
formatter.result({
  "duration": 2176421597,
  "status": "passed"
});
formatter.after({
  "duration": 43851,
  "status": "passed"
});
formatter.after({
  "duration": 942899758,
  "status": "passed"
});
});