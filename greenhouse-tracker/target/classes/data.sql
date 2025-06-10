-- Insert three greenhouses in cities near Łódź, Poland
INSERT INTO greenhouses (id, name, location, size_sqm) VALUES (1001, 'Zgierz Greenhouse', 'Zgierz', 40.0);
INSERT INTO greenhouses (id, name, location, size_sqm) VALUES (1002, 'Pabianice Greenhouse', 'Pabianice', 55.0);
INSERT INTO greenhouses (id, name, location, size_sqm) VALUES (1003, 'Aleksandrów Greenhouse', 'Aleksandrów Łódzki', 30.0);

-- Insert three vegetables for each greenhouse, each with a different harvest date
-- Zgierz Greenhouse
INSERT INTO vegetables (id, name, variety, greenhouse_id, planting_date, expected_harvest_date, notes) VALUES (2001, 'Tomato', 'Roma', 1001, '2025-04-01', '2025-07-01', 'Early crop');
INSERT INTO vegetables (id, name, variety, greenhouse_id, planting_date, expected_harvest_date, notes) VALUES (2002, 'Cucumber', 'English', 1001, '2025-04-10', '2025-07-15', 'Needs trellis');
INSERT INTO vegetables (id, name, variety, greenhouse_id, planting_date, expected_harvest_date, notes) VALUES (2003, 'Pepper', 'Bell', 1001, '2025-04-15', '2025-08-01', 'Sweet variety');

-- Pabianice Greenhouse
INSERT INTO vegetables (id, name, variety, greenhouse_id, planting_date, expected_harvest_date, notes) VALUES (2004, 'Lettuce', 'Butterhead', 1002, '2025-03-20', '2025-05-20', 'Quick grower');
INSERT INTO vegetables (id, name, variety, greenhouse_id, planting_date, expected_harvest_date, notes) VALUES (2005, 'Radish', 'Cherry Belle', 1002, '2025-03-25', '2025-04-25', 'Fast harvest');
INSERT INTO vegetables (id, name, variety, greenhouse_id, planting_date, expected_harvest_date, notes) VALUES (2006, 'Carrot', 'Nantes', 1002, '2025-03-30', '2025-07-30', 'Thin seedlings');

-- Aleksandrów Greenhouse
INSERT INTO vegetables (id, name, variety, greenhouse_id, planting_date, expected_harvest_date, notes) VALUES (2007, 'Eggplant', 'Black Beauty', 1003, '2025-04-05', '2025-08-10', 'Warmth loving');
INSERT INTO vegetables (id, name, variety, greenhouse_id, planting_date, expected_harvest_date, notes) VALUES (2008, 'Zucchini', 'Cocozelle', 1003, '2025-04-12', '2025-07-20', 'Harvest young');
INSERT INTO vegetables (id, name, variety, greenhouse_id, planting_date, expected_harvest_date, notes) VALUES (2009, 'Spinach', 'Bloomsdale', 1003, '2025-03-18', '2025-05-18', 'Cool season');
