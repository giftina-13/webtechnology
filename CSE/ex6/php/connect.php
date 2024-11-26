<?php
// Database connection settings
$host = "localhost"; // Database host
$username = "root"; // Database username
$password = ""; // Database password
$database = "KitchenInventory"; // Database name

// Create a connection
$conn = new mysqli($host, $username, $password, $database);

// Check the connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
echo "Connected successfully.<br>";

// Fetch kitchen appliances from the database
$sql = "SELECT name, type FROM Appliances WHERE category = 'Kitchen'";
$result = $conn->query($sql);

// Check and display results
if ($result->num_rows > 0) {
    echo "<h2>Kitchen Appliances:</h2>";
    echo "<ul>";
    while ($row = $result->fetch_assoc()) {
        echo "<li><strong>Name:</strong> " . $row['name'] . " | <strong>Type:</strong> " . $row['type'] . "</li>";
    }
    echo "</ul>";
} else {
    echo "No kitchen appliances found.";
}

// Close the connection
$conn->close();
?>
