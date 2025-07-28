Policy and Compliance Document Management System

A Spring Boot application that helps organizations manage, store, and access internal policy and compliance documents securely. It supports features like user registration, login, document upload, view, update, and delete.


1. Download the zip file

2. Extract the file

3. Open that project folder in Spring Boot

4. Run the Application

5. Then Verify in Postman


Step-by-Step Process to Execute in Postman :


1. Register a User
   
        Method: POST
     
        URL: http://localhost:8080/api/auth/register
     
        Body → raw → JSON:

       Example:
   
           {
            "fullName" : "Robert De Niro",
            "email" : "robert@gmail.com",
            "password" : "robert123"
           }
2. Login to Get JWT Token

        Method: POST
    
        URL: http://localhost:8080/api/auth/login
    
        Body → raw → JSON:

       Example :

              {
                "email": "robert@example.com",
                "password": "yourpassward"
              }
    We will get JWT Token as Response.
   Copy the token for next steps.

3. Create a Policy Document

       Method: POST
  
       URL: http://localhost:8080/api/documents
  
        create Header:

                 Authorization: Bearer Paste_JWT_TOKEN

        Body → raw → JSON:

          Example :

               {
                "title": "Leave Policy",
                "content": "Employees get 15 days leave",
                "category": "HR"
               }
4. To Get All Documents

        Method: GET

        URL: http://localhost:8080/api/documents

5. To Get All Users

         Method : GET

         URL : http://localhost:8080/api/auth/users

6. To Update a Document

        Method: PUT
  
        URL: http://localhost:8080/api/documents/1

           Update Body:
                {
                  "title": "Updated Leave Policy",
                  "content": "Employees now get 18 days leave",
                  "category": "HR"
                }
7. To Delete a Document

        Method: DELETE
    
        URL: http://localhost:8080/api/documents/{id}

        Example:
            URL: http://localhost:8080/api/documents/1





         
