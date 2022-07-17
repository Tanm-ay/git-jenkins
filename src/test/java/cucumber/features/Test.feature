Feature: Amazon Verify
@top
Scenario Outline: Enter text into search box and verify result text

Given <driverType> driver is initialized
And User navigates to <site> website homepage
When User enters <text> into search box
And Clicks on search icon
Then <text> should be displayed on top of results page

Examples:
|driverType		|site		|text			|
|Chrome			|Amazon		|refrigerator	|

@bottom
Scenario Outline: Click Gift a Smile footer link and verify image text

Given <driverType> driver is initialized
And User navigates to <site> website homepage
When User clicks Gift a Smile link in footer section
Then <text2> should be present on the opened page

Examples:
|driverType		|site		|text2			|
|Chrome			|Amazon		|How this works	|
