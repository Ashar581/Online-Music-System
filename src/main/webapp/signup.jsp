<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signup - Music App</title>
    <link rel="stylesheet" href="styles.css"> <!-- Optional: Link to an external stylesheet -->
    <style>
        /* General page styles */
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        /* Signup form container */
        .form-container {
            background-color: #fff;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
            margin: 20px;
        }

        /* Heading Style */
        h2 {
            text-align: center;
            color: #333;
            font-size: 24px;
            margin-bottom: 30px;
        }

        /* Input fields */
        label {
            font-size: 14px;
            color: #666;
            margin-bottom: 5px;
            display: block;
        }

        input[type="text"],
        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 12px;
            margin: 10px 0 20px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 14px;
            box-sizing: border-box;
        }

        /* Focus effect for input fields */
        input[type="text"]:focus,
        input[type="email"]:focus,
        input[type="password"]:focus {
            outline: none;
            border-color: #3498db;
            box-shadow: 0 0 5px rgba(52, 152, 219, 0.5);
        }

        /* Submit Button Style */
        button[type="submit"] {
            background-color: #3498db;
            color: white;
            border: none;
            padding: 14px 20px;
            font-size: 16px;
            border-radius: 4px;
            width: 100%;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        button[type="submit"]:hover {
            background-color: #2980b9;
        }

        /* Link style */
        .login-link {
            text-align: center;
            margin-top: 20px;
            font-size: 14px;
        }

        .login-link a {
            color: #3498db;
            text-decoration: none;
            font-weight: bold;
        }

        .login-link a:hover {
            text-decoration: underline;
        }

        /* Responsive design */
        @media (max-width: 500px) {
            .form-container {
                padding: 30px;
            }

            h2 {
                font-size: 20px;
            }
        }
    </style>
</head>
<body>

    <div class="form-container">
        <h2>Sign Up</h2>
        <form action="signup" method="post">
            <label for="username">Username: </label>
            <input type="text" id="username" name="username" required>

            <label for="email">Email: </label>
            <input type="email" id="email" name="email" required>

            <label for="password">Password: </label>
            <input type="password" id="password" name="password" required>

            <button type="submit">Sign Up</button>
        </form>

        <!-- Link to login page -->
        <div class="login-link">
            <p>Already have an account? <a href="index.jsp">Login here</a></p>
        </div>
    </div>

</body>
</html>
