-- Insert three greenhouses in cities near Łódź, Poland
MERGE INTO greenhouses (id, name, location, size_sqm) KEY(id) VALUES (1001, 'Zgierz Greenhouse', 'Zgierz', 40.0);
MERGE INTO greenhouses (id, name, location, size_sqm) KEY(id) VALUES (1002, 'Pabianice Greenhouse', 'Pabianice', 55.0);
MERGE INTO greenhouses (id, name, location, size_sqm) KEY(id) VALUES (1003, 'Aleksandrów Greenhouse', 'Aleksandrów Łódzki', 30.0);

-- Insert three vegetables for each greenhouse, each with a different harvest date
-- Zgierz Greenhouse
MERGE INTO vegetables (id, name, variety, greenhouse_id, planting_date, expected_harvest_date, notes) KEY(id) VALUES (2001, 'Tomato', 'Roma', 1001, '2025-04-01', '2025-07-01', 'Early crop');
MERGE INTO vegetables (id, name, variety, greenhouse_id, planting_date, expected_harvest_date, notes) KEY(id) VALUES (2002, 'Cucumber', 'English', 1001, '2025-04-10', '2025-07-15', 'Needs trellis');
MERGE INTO vegetables (id, name, variety, greenhouse_id, planting_date, expected_harvest_date, notes) KEY(id) VALUES (2003, 'Pepper', 'Bell', 1001, '2025-04-15', '2025-08-01', 'Sweet variety');

-- Pabianice Greenhouse
MERGE INTO vegetables (id, name, variety, greenhouse_id, planting_date, expected_harvest_date, notes) KEY(id) VALUES (2004, 'Lettuce', 'Butterhead', 1002, '2025-03-20', '2025-05-20', 'Quick grower');
MERGE INTO vegetables (id, name, variety, greenhouse_id, planting_date, expected_harvest_date, notes) KEY(id) VALUES (2005, 'Radish', 'Cherry Belle', 1002, '2025-03-25', '2025-04-25', 'Fast harvest');
MERGE INTO vegetables (id, name, variety, greenhouse_id, planting_date, expected_harvest_date, notes) KEY(id) VALUES (2006, 'Carrot', 'Nantes', 1002, '2025-03-30', '2025-07-30', 'Thin seedlings');

-- Aleksandrów Greenhouse
MERGE INTO vegetables (id, name, variety, greenhouse_id, planting_date, expected_harvest_date, notes) KEY(id) VALUES (2007, 'Eggplant', 'Black Beauty', 1003, '2025-04-05', '2025-08-10', 'Warmth loving');
MERGE INTO vegetables (id, name, variety, greenhouse_id, planting_date, expected_harvest_date, notes) KEY(id) VALUES (2008, 'Zucchini', 'Cocozelle', 1003, '2025-04-12', '2025-07-20', 'Harvest young');
MERGE INTO vegetables (id, name, variety, greenhouse_id, planting_date, expected_harvest_date, notes) KEY(id) VALUES (2009, 'Spinach', 'Bloomsdale', 1003, '2025-03-18', '2025-05-18', 'Cool season');
