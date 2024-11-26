<?php
// Path to the XML file
$xmlFilePath = "sample.xml"; // Replace with the actual path to your XML file

// Check if the file exists
if (file_exists($xmlFilePath)) {
    // Load the XML file
    $xmlContent = simplexml_load_file($xmlFilePath);

    // Check if the XML content is loaded successfully
    if ($xmlContent === false) {
        echo "Failed to load XML file.";
        exit;
    }

    // Initialize an array to store kitchen appliances
    $kitchenAppliances = [];

    // Iterate through the XML elements
    foreach ($xmlContent->Item as $item) {
        // Check if the item's category is "Kitchen"
        if (strcasecmp((string)$item->Category, "Kitchen") === 0) {
            $kitchenAppliances[] = [
                'name' => (string)$item->Name,
                'type' => (string)$item->Type,
            ];
        }
    }

    // Output the extracted kitchen appliances
    if (!empty($kitchenAppliances)) {
        echo "<h2>Kitchen Appliances Found:</h2>";
        echo "<ul>";
        foreach ($kitchenAppliances as $appliance) {
            echo "<li><strong>Name:</strong> {$appliance['name']} | <strong>Type:</strong> {$appliance['type']}</li>";
        }
        echo "</ul>";
    } else {
        echo "No kitchen appliances found in the XML file.";
    }
} else {
    echo "XML file not found at the specified path.";
}
?>
