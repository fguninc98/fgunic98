<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Login</title>
    </head>

    <body>
        <h1>Login</h1>
        <form action="/" method="post">
            <table style="with: 50%">
                <tr>
                    <td>First Name</td>
                    <td><input type="text" name="first_name" /></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="last_name" /></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="email" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" /></td>
                </tr>
            </table>
            <input type="submit" value="Submit" /></form>
        <br>
        <h4>Treba ti nalog? <a href="/">Registruj se</a></h4>
    </body>

    </html>