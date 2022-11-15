Feature: Change Request

Scenario: Get All Request
When Get All incidents
Then verify status code as 200
And print the response