<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Music</title>
    <link rel="stylesheet" href="styles.css"> <!-- Link to external stylesheet -->
    <style>
        /* General body styling */
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f0f2f5;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        /* Form container styling */
        .form-container {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
            width: 90%;
            max-width: 500px;
            margin: 20px;
        }

        /* Heading styling */
        h2 {
            text-align: center;
            color: #333;
            font-size: 24px;
            margin-bottom: 20px;
            font-weight: 600;
        }

        /* Label styling */
        label {
            font-size: 14px;
            color: #555;
            margin-bottom: 5px;
            display: block;
        }

        /* Input fields styling */
        input[type="text"],
        input[type="file"] {
            width: 100%;
            padding: 12px;
            margin: 10px 0 20px 0;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 16px;
            box-sizing: border-box;
            transition: all 0.3s ease;
        }

        /* Focus effect for input fields */
        input[type="text"]:focus,
        input[type="file"]:focus {
            border-color: #3498db;
            box-shadow: 0 0 8px rgba(52, 152, 219, 0.5);
        }

        /* Submit button styling */
        button[type="submit"],
        button[type="button"] {
            background-color: #3498db;
            color: white;
            border: none;
            padding: 14px;
            font-size: 16px;
            border-radius: 6px;
            width: 100%;
            cursor: pointer;
            transition: background-color 0.3s ease, transform 0.2s ease;
            margin-top: 10px;
        }

        /* Hover effect for buttons */
        button[type="submit"]:hover,
        button[type="button"]:hover {
            background-color: #2980b9;
            transform: scale(1.05);
        }

        /* Responsive design */
        @media (max-width: 600px) {
            .form-container {
                padding: 20px;
            }
            h2 {
                font-size: 20px;
            }
            input[type="text"],
            input[type="file"] {
                font-size: 14px;
                padding: 10px;
            }
        }
    </style>
</head>
<body>

    <div class="form-container">
        <h2>Add Music to Collection</h2>
        <form action="music" method="post" enctype="multipart/form-data">

            <label for="title">Title:</label>
            <input type="text" id="title" name="title" placeholder="Enter music title" required>

            <label for="artist">Artist:</label>
            <input type="text" id="artist" name="artist" placeholder="Enter music artist" required>

            <label for="genre">Genre:</label>
            <input type="text" id="genre" name="genre" placeholder="Enter music genre" required>

            <label for="audio_file">Audio File:</label>
            <input type="file" id="audio_file" name="music_file" accept="audio/*" required>

            <button type="submit">Add Music</button>
        </form>

        <!-- Redirect button to music.jsp -->
        <form action="login" method="post" style="margin-top: 15px;">
            <button type="submit">Go to Music List</button>
        </form>
    </div>

</body>
</html>
