Feature: Incident Managemnet

@smoke
Scenario: Get All incidents
When Get All incidents
Then verify status code as  200
And print the response

@sanity
Scenario: Get All incidents with Query Params
When Get All incidents with QP "sysparm_fields" as "category,state"
Then verify status code as 200
And print the response

@Regression
Scenario Outline: Create Incidents with Multiple files
When Create Incident with multiple files "<fileName>" 
Then verify status code as 201
And print the response
Examples:
|fileName|
|incident.json|
|incident2.json|