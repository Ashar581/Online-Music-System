<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="org.ashar.Entity.Music" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Music Homepage</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            background-color: #fafafa;
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        .header {
            background-color: #333;
            color: #fff;
            padding: 20px 0;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            display: flex;
            justify-content: space-between;  /* Keep buttons on the left and right */
            align-items: center;
            padding: 10px 40px;
            position: relative;
        }

        .header h1 {
            font-size: 2.5em;
            margin: 0;
            text-align: center;  /* Center the title */
            flex-grow: 1;  /* Allow h1 to take up remaining space */
        }

        .header .add-music-btn,
        .header .logout-btn {
            background-color: #007bff;  /* Blue color for both buttons */
            color: white;
            padding: 12px 20px;
            font-size: 1em;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            text-decoration: none;
            transition: background-color 0.3s ease;
            margin-left: 20px;  /* Adds space between buttons */
        }

        .header .add-music-btn:hover,
        .header .logout-btn:hover {
            background-color: #0056b3;
        }

        .header .logout-btn {
            background-color: #dc3545;  /* Red color for logout button */
        }

        .header .logout-btn:hover {
            background-color: #c82333;  /* Darker red for hover */
        }



        .username {
            text-align: center;
            font-size: 1.2em;
            margin-top: 20px;
            color: #333;
        }

        .content {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
            gap: 20px;
            padding: 40px;
            max-width: 1200px;
            margin: 0 auto;
        }

        .music-item {
            background-color: #fff;
            border-radius: 12px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.1);
            padding: 20px;
            text-align: center;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }

        .music-item:hover {
            transform: translateY(-10px);
            box-shadow: 0 15px 30px rgba(0, 0, 0, 0.2);
        }

        .music-item img {
            width: 100%;
            height: auto;
            border-radius: 10px;
            object-fit: cover;
        }

        .music-item h3 {
            font-size: 1.4em;
            margin: 15px 0 10px;
            color: #333;
        }

        .music-item p {
            font-size: 1em;
            color: #555;
            margin-bottom: 15px;
        }

        .music-player {
            display: flex;
            justify-content: center;
        }

        .music-player audio {
            width: 100%;
            border-radius: 10px;
            outline: none;
        }

        @media (max-width: 768px) {
            .content {
                grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
            }

            .music-item h3 {
                font-size: 1.2em;
            }

            .music-item p {
                font-size: 0.9em;
            }
        }

        @media (max-width: 480px) {
            .header h1 {
                font-size: 1.8em;
            }

            .username {
                font-size: 1em;
            }
        }
    </style>
</head>
<body>
    <div class="header">
        <!-- Logout Button (Visible for any logged-in user) -->
        <%
            if (session.getAttribute("username") != null) {
        %>
            <form action="logout" method="post">
                <button type="submit" class="logout-btn">Logout</button>
            </form>
        <%
            }
        %>

        <h1>Music Player</h1>

        <!-- Add Music Button (Visible if user is an Admin) -->
        <%
            Integer isAdmin = (Integer) session.getAttribute("isAdmin");
            if (isAdmin != null && isAdmin == 1) {
        %>
            <a href="admin.jsp" class="add-music-btn">Add Music</a>
        <%
            }
        %>
    </div>


    <div class="content">
        <%
            List<Music> musicList = (List<Music>) request.getAttribute("musicList");
            for (Music music : musicList) {
        %>
            <div class="music-item">
                <h3><%= music.getTitle() %> by <%= music.getArtist() %></h3>
                <p>Genre: <%= music.getGenre() %></p>

                <!-- Music Player -->
                <div class="music-player">
                    <audio controls>
                        <source src="<%= request.getContextPath() + "/music?id=" + music.getMusic_id() %>" type="audio/mp3">
                        Your browser does not support the audio element.
                    </audio>
                </div>
            </div>
        <%
            }
        %>
    </div>
</body>
</html>
