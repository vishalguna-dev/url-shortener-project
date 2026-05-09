INSERT INTO users (email, password, name, role)
VALUES ('vishal.guna@gmail.com', 'pass123', 'Vishal Guna', 'ROLE_ADMIN'),
       ('arun.kumar@gmail.com', 'pass123', 'Arun Kumar', 'ROLE_USER'),
       ('priya.sharma@gmail.com', 'pass123', 'Priya Sharma', 'ROLE_USER'),
       ('rahul.verma@gmail.com', 'pass123', 'Rahul Verma', 'ROLE_USER'),
       ('sneha.reddy@gmail.com', 'pass123', 'Sneha Reddy', 'ROLE_USER'),
       ('karthik.raj@gmail.com', 'pass123', 'Karthik Raj', 'ROLE_USER'),
       ('meena.iyer@gmail.com', 'pass123', 'Meena Iyer', 'ROLE_USER'),
       ('john.doe@gmail.com', 'pass123', 'John Doe', 'ROLE_USER'),
       ('alice.williams@gmail.com', 'pass123', 'Alice Williams', 'ROLE_USER'),
       ('mohan.krishna@gmail.com', 'pass123', 'Mohan Krishna', 'ROLE_USER');



INSERT INTO short_urls (short_key, original_url, is_private, expires_at, created_by, click_count)
VALUES ('abc123', 'https://www.google.com', FALSE, NULL, 1, 15),
       ('def456', 'https://www.youtube.com', FALSE, NULL, 2, 30),
       ('ghi789', 'https://www.github.com', TRUE, NULL, 3, 5),
       ('jkl012', 'https://stackoverflow.com', FALSE, NOW() + INTERVAL '7 days', 4, 12),
       ('mno345', 'https://spring.io', FALSE, NULL, 5, 20),
       ('pqr678', 'https://aws.amazon.com', TRUE, NOW() + INTERVAL '1 day', 6, 3),
       ('stu901', 'https://leetcode.com', FALSE, NULL, 7, 50),
       ('vwx234', 'https://netflix.com', TRUE, NULL, 8, 8),
       ('yz5678', 'https://linkedin.com', FALSE, NOW() + INTERVAL '30 days', 9, 25),
       ('lmn890', 'https://twitter.com', FALSE, NULL, 10, 40);