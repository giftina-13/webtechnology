-- Create the database
CREATE DATABASE KitchenInventory;

-- Use the database
USE KitchenInventory;

-- Create the table
CREATE TABLE Appliances (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL
);

-- Insert sample data
INSERT INTO Appliances (name, type, category) VALUES 
('Toaster', 'Appliance', 'Kitchen'),
('Blender', 'Appliance', 'Kitchen'),
('Refrigerator', 'Appliance', 'Kitchen'),
('Laptop', 'Electronics', 'Office'),
('Television', 'Electronics', 'Living Room');
