package za.ac.cput.controller;

import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Student;
import za.ac.cput.repository.StudentRepository;
import za.ac.cput.util.DummyMakeData;

import java.util.List;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    //ResourceEndPoint:http://localhost:8089/api/v1/greeting/hi
    @GetMapping("/hi")
    public String sayHi() {
        // This is a simple endpoint that returns a greeting message
        return "Hi";
    }

    //ResourceEndPoint:http://localhost:8089/api/v1/greeting/hello
    @GetMapping("/hello")
    public String sayHello() {
        // This is a simple endpoint that returns a greeting message
        return "Hello";
    }

    //ResourceEndPoint:http://localhost:8089/api/v1/greeting/hello/{yourName}
    @PostMapping("/hello/{name}")
    public String sayHelloToName(@PathVariable String name) {
        // This is a simple endpoint that returns a greeting message
        System.out.println("Endpoint Triggered : " + name);
        return "Hello " + name;
    }

    //Make list if users
    //ResourceEndPoint:http://localhost:8089/api/v1/greeting/makelist
    @GetMapping("/makelist")
    public String makeList() {
        DummyMakeData.makeData();
        String response;
        //html
        response = "<html><body><h1>List Created</h1></body></html>";
        // Return styled HTML response
        return """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <title>User List Created</title>
                <style>
                    body {
                        font-family: Arial, sans-serif;
                        background-color: #f0f4f8;
                        display: flex;
                        justify-content: center;
                        align-items: center;
                        height: 100vh;
                        margin: 0;
                    }
                    .container {
                        text-align: center;
                        background-color: white;
                        padding: 40px;
                        border-radius: 10px;
                        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                        animation: fadeIn 2s ease-in-out; /* Fade-in animation */
                    }
                    @keyframes fadeIn {
                        from { opacity: 0; }
                        to { opacity: 1; }
                    }
                    h1 {
                        color: #2c3e50;
                        font-size: 2.5em;
                        margin-bottom: 20px;
                    }
                    p {
                        color: #7f8c8d;
                        font-size: 1.2em;
                    }
                    .btn {
                        display: inline-block;
                        padding: 10px 20px;
                        background-color: #3498db;
                        color: white;
                        text-decoration: none;
                        border-radius: 5px;
                        margin-top: 20px;
                        transition: background-color 0.3s;
                    }
                    .btn:hover {
                        background-color: #2980b9;
                    }
                </style>
            </head>
            <body>
                <div class="container">
                    <h1>Student List Created!</h1>
                    <p>Successfully generated a new list of users.</p>
                    <a href="/" class="btn">Back to Home</a>
                </div>
            </body>
            </html>
            """;
    }

    //get list of users
    //ResourceEndPoint:http://localhost:8089/api/v1/greeting/getlist
    @GetMapping("/getlist")
    public String getList() {
        // Fetch student list from repository
        List<Student> studentList = StudentRepository.getRepository().getAll();

        // Build HTML response with student data
        StringBuilder html = new StringBuilder("""
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <title>Student List</title>
                <style>
                    body {
                        font-family: Arial, sans-serif;
                        background-color: #f0f4f8;
                        display: flex;
                        justify-content: center;
                        align-items: center;
                        min-height: 100vh;
                        margin: 0;
                    }
                    .container {
                        text-align: center;
                        background-color: white;
                        padding: 40px;
                        border-radius: 10px;
                        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                        max-width: 800px;
                        width: 100%;
                        animation: fadeIn .5s ease-in-out;

                    }
                    @keyframes fadeIn {
                        from { opacity: .5; }
                        to { opacity: 1; }
                    }
                    h1 {
                        color: #2c3e50;
                        font-size: 2.5em;
                        margin-bottom: 20px;
                    }
                    table {
                        width: 100%;
                        border-collapse: collapse;
                        margin: 20px 0;
                    }
                    th, td {
                        padding: 12px;
                        text-align: left;
                        border-bottom: 1px solid #ddd;
                        animation: fadeIn 1.5s ease-in-out;

                    }
                      @keyframes fadeIn {
                        from { opacity: .0; }
                        to { opacity: 1; }
                    }
                    th {
                        background-color: #3498db;
                        color: white;
                    }
                    tr:nth-child(even) {
                        background-color: #f9f9f9;
                    }
                    .btn {
                        display: inline-block;
                        padding: 10px 20px;
                        background-color: #3498db;
                        color: white;
                        text-decoration: none;
                        border-radius: 5px;
                        margin-top: 20px;
                        transition: background-color 0.3s;
                    }
                    .btn:hover {
                        background-color: #2980b9;
                    }
                </style>
            </head>
            <body>
                <div class="container">
                    <h1>Student List</h1>
            """);

        // Add table for student data
        html.append("<table>");
        html.append("<tr><th>First Name</th><th>Last Name</th><th>Age</th><th>Course</th></tr>");

        // Parse and append each student's data
        if (studentList.isEmpty()) {
            html.append("<tr><td colspan='4' style='text-align: center;'>No students found.</td></tr>");
        } else {
            for (Student student : studentList) {
                html.append("<tr>")
                        .append("<td>").append(student.getFirstName()).append("</td>")
                        .append("<td>").append(student.getLastName()).append("</td>")
                        .append("<td>").append(student.getAge()).append("</td>")
                        .append("<td>").append(student.getCourse().getName()).append("</td>")
                        .append("</tr>");
            }
        }

        html.append("</table>");

        // Add back button and close HTML
        html.append("""
                    <a href="/" class="btn">Back to Home</a>
                </div>
            </body>
            </html>
            """);

        return html.toString();

    }

}
