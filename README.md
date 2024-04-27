User Validation and Information Registration

This task involves creating a service that performs the following:

1. User Validation:

    The service receives a user identifier (e.g., username).
    It utilizes WebClient to call an external API for user validation.
    The external API endpoint is http://localhost:8080/appName/userDetail?user={user} where {user} is replaced with the received identifier.

2. User Information Registration (Conditional):

    If the user is valid according to the external API response:
    The service retrieves configuration details (user types, base URL, and base URI) from the application.properties file.
    It constructs an internal call to another service named ADD_USER_SERVICE located at http://localhost:8081/appName2/addUserInfo.
    This internal call is intended to register the user's information.

Additional Notes:

Consider using environment variables for sensitive information like the base URL or URI in the application.properties file for improved security.
