This is a Java Spring Boot application for managing notifications. It supports creating notifications, sending them via email, and listing all sent notifications with filters. The application uses Factory and Strategy design patterns.

APIs
Create Notification
    URL: /notifications
    Method: POST
    Request Parameters:
        type (String): Type of the notification (e.g., email)
        content (String): Content of the notification
        userId (String): ID of the user to whom the notification will be sent
    Response: Returns the created Notification object

Send Notification
    URL: /notifications/{id}/send
    Method: POST
    Path Variable:
        id (Long): ID of the notification to be sent
    Response: Sends the notification and updates its status to “SENT”
List All Notifications
    URL: /notifications
    Method: GET
    Request Parameters (Optional):
        userId (String): Filter notifications by user ID
        status (String): Filter notifications by status (e.g., PENDING, SENT)
    Response: Returns a list of Notification objects
Delete Notification
    URL: /notifications/{id}
    Method: DELETE
    Path Variable:
        id (Long): ID of the notification to be deleted
    Response: Deletes the notification
