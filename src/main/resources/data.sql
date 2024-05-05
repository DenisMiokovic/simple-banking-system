INSERT INTO customer (name, address, email, phone_number) VALUES
('John Doe', '123 Elm St', 'john.doe@example.com', '123-456-7890'),
('Jane Doe', '234 Elm St', 'jane.doe@example.com', '234-567-8901'),
('Alice Johnson', '345 Maple St', 'alice.j@example.com', '345-678-9012'),
('Bob Smith', '456 Oak St', 'bob.smith@example.com', '456-789-0123'),
('Carol White', '567 Pine St', 'carol.w@example.com', '567-890-1234'),
('David Green', '678 Cedar St', 'david.g@example.com', '678-901-2345'),
('Eve Black', '789 Birch St', 'eve.b@example.com', '789-012-3456'),
('Frank Wright', '890 Willow St', 'frank.w@example.com', '890-123-4567'),
('Grace Hall', '901 Ash St', 'grace.h@example.com', '901-234-5678'),
('Henry Ford', '012 Chestnut St', 'henry.f@example.com', '012-345-6789'),
('Ian Grays', '013 Cherry St', 'ian.g@example.com', '013-456-7890'),
('Julia Ivy', '021 Maple Ave', 'julia.i@example.com', '021-456-7890'),
('Karl Joy', '031 Peach Rd', 'karl.j@example.com', '031-456-7890'),
('Laura Kind', '041 Plum Ln', 'laura.k@example.com', '041-456-7890'),
('Mike Loyal', '051 Lemon Blvd', 'mike.l@example.com', '051-456-7890'),
('Nina Mover', '061 Lime Cres', 'nina.m@example.com', '061-456-7890'),
('Oscar Nerd', '071 Mandarin Pl', 'oscar.n@example.com', '071-456-7890'),
('Patty Olive', '081 Nectarine Path', 'patty.o@example.com', '081-456-7890'),
('Quincy Peel', '091 Orange Way', 'quincy.p@example.com', '091-456-7890'),
('Rita Quiet', '101 Quince St', 'rita.q@example.com', '101-456-7890'),
('Steve Rusty', '111 Raspberry Ave', 'steve.r@example.com', '111-456-7890'),
('Tina Silky', '121 Strawberry Rd', 'tina.s@example.com', '121-456-7890'),
('Uma Tart', '131 Tangerine Ln', 'uma.t@example.com', '131-456-7890'),
('Vick Vague', '141 Tomato Blvd', 'vick.v@example.com', '141-456-7890'),
('Wendy Wax', '151 Watermelon Cres', 'wendy.w@example.com', '151-456-7890'),
('Xena Xylem', '161 Xigua Pl', 'xena.x@example.com', '161-456-7890'),
('Yuri Yummy', '171 Yuzu Path', 'yuri.y@example.com', '171-456-7890'),
('Zane Zesty', '181 Zucchini Way', 'zane.z@example.com', '181-456-7890'),
('Amy Apple', '191 Apple St', 'amy.a@example.com', '191-456-7890'),
('Ben Banana', '201 Banana Ave', 'ben.b@example.com', '201-456-7890'),
('Cathy Cherry', '211 Cherry Rd', 'cathy.c@example.com', '211-456-7890'),
('Derek Durian', '221 Durian Ln', 'derek.d@example.com', '221-456-7890'),
('Ella Elderberry', '231 Elderberry Blvd', 'ella.e@example.com', '231-456-7890'),
('Fred Fig', '241 Fig Cres', 'fred.f@example.com', '241-456-7890'),
('Gina Grape', '251 Grape Pl', 'gina.g@example.com', '251-456-7890'),
('Hank Honeydew', '261 Honeydew Path', 'hank.h@example.com', '261-456-7890'),
('Ivy Kiwi', '271 Kiwi Way', 'ivy.k@example.com', '271-456-7890'),
('Jack Lime', '281 Lime St', 'jack.l@example.com', '281-456-7890'),
('Kathy Mango', '291 Mango Ave', 'kathy.m@example.com', '291-456-7890'),
('Liam Nectarine', '301 Nectarine Rd', 'liam.n@example.com', '301-456-7890'),
('Mona Olive', '311 Olive Ln', 'mona.o@example.com', '311-456-7890'),
('Ned Peach', '321 Peach Blvd', 'ned.p@example.com', '321-456-7890'),
('Olga Plum', '331 Plum Cres', 'olga.p@example.com', '331-456-7890'),
('Pete Quince', '341 Quince Pl', 'pete.q@example.com', '341-456-7890'),
('Quinn Raspberry', '351 Raspberry Path', 'quinn.r@example.com', '351-456-7890'),
('Rosalind Strawberry', '361 Strawberry Way', 'rosalind.s@example.com', '361-456-7890'),
('Sam Tangerine', '371 Tangerine St', 'sam.t@example.com', '371-456-7890'),
('Tara Ugli', '381 Ugli Ave', 'tara.u@example.com', '381-456-7890'),
('Ursula Vanilla', '391 Vanilla Rd', 'ursula.v@example.com', '391-456-7890'),
('Vince Watermelon', '401 Watermelon Ln', 'vince.w@example.com', '401-456-7890');

INSERT INTO account (customer_id, account_number, account_type, balance) VALUES
(1, 'ACC1001', 'CHK', 1200.50),
(1, 'ACC1002', 'SAV', 1500.75),
(2, 'ACC2001', 'CHK', 950.30),
(2, 'ACC2002', 'SAV', 1650.00),
(2, 'ACC2003', 'INV', 3200.40),
(3, 'ACC3001', 'CHK', 2430.45),
(3, 'ACC3002', 'INV', 1247.30),
(3, 'ACC3003', 'SAV', 2145.67),
(4, 'ACC4001', 'CHK', 1150.75),
(4, 'ACC4002', 'SAV', 2750.55),
(5, 'ACC5001', 'CHK', 1420.00),
(5, 'ACC5002', 'SAV', 5000.20),
(5, 'ACC5003', 'INV', 2110.10),
(6, 'ACC6001', 'CHK', 2640.00),
(6, 'ACC6002', 'SAV', 1350.40),
(7, 'ACC7001', 'CHK', 890.15),
(7, 'ACC7002', 'SAV', 1900.88),
(7, 'ACC7003', 'INV', 400.08),
(8, 'ACC8001', 'CHK', 1005.25),
(8, 'ACC8002', 'SAV', 2040.50),
(8, 'ACC8003', 'INV', 3500.75),
(9, 'ACC9001', 'CHK', 1225.95),
(9, 'ACC9002', 'SAV', 1985.30),
(10, 'ACC10001', 'CHK', 1520.10),
(10, 'ACC10002', 'SAV', 2980.55),
(10, 'ACC10003', 'INV', 12.87),
(11, 'ACC11001', 'CHK', 1450.00),
(11, 'ACC11002', 'SAV', 2450.55),
(12, 'ACC12001', 'CHK', 2300.45),
(13, 'ACC13001', 'SAV', 1235.20),
(13, 'ACC13002', 'CHK', 229.45),
(13, 'ACC13003', 'INV', 1897.13),
(14, 'ACC14001', 'INV', 3340.75),
(14, 'ACC14002', 'CHK', 860.50),
(15, 'ACC15001', 'SAV', 2870.15),
(15, 'ACC15002', 'CHK', 1650.00),
(16, 'ACC16001', 'CHK', 1920.40),
(17, 'ACC17001', 'INV', 2110.20),
(17, 'ACC17002', 'CHK', 985.75),
(18, 'ACC18001', 'SAV', 2215.00),
(18, 'ACC18002', 'CHK', 1050.55),
(19, 'ACC19001', 'INV', 3200.60),
(19, 'ACC19002', 'CHK', 134.14),
(19, 'ACC19003', 'SAV', 1572.67),
(20, 'ACC20001', 'CHK', 1580.35),
(20, 'ACC20002', 'SAV', 2765.90),
(21, 'ACC21001', 'CHK', 1340.80),
(22, 'ACC22001', 'SAV', 1950.45),
(23, 'ACC23001', 'CHK', 1105.65),
(23, 'ACC23002', 'SAV', 3450.75),
(24, 'ACC24001', 'INV', 2900.20),
(25, 'ACC25001', 'SAV', 1560.45),
(25, 'ACC25002', 'CHK', 875.25),
(26, 'ACC26001', 'CHK', 2030.65),
(27, 'ACC27001', 'SAV', 1435.55),
(28, 'ACC28001', 'INV', 2600.75),
(29, 'ACC29001', 'CHK', 1745.25),
(29, 'ACC29002', 'SAV', 29.17),
(29, 'ACC29003', 'INV', 3024.59),
(30, 'ACC30001', 'SAV', 1890.60),
(30, 'ACC30002', 'CHK', 1550.45),
(31, 'ACC31001', 'INV', 3205.75),
(32, 'ACC32001', 'SAV', 1925.35),
(33, 'ACC33001', 'CHK', 1380.90),
(33, 'ACC33002', 'INV', 2550.60),
(34, 'ACC34001', 'SAV', 1700.45),
(35, 'ACC35001', 'CHK', 1905.25),
(35, 'ACC35002', 'SAV', 2050.55),
(36, 'ACC36001', 'INV', 3150.75),
(36, 'ACC36002', 'CHK', 421.17),
(36, 'ACC36003', 'SAV', 1572.13),
(37, 'ACC37001', 'INV', 1585.60),
(37, 'ACC37002', 'SAV', 2604.28),
(37, 'ACC37003', 'CHK', 1308.49),
(38, 'ACC38001', 'SAV', 2750.45),
(38, 'ACC38002', 'INV', 122.47),
(38, 'ACC38003', 'CHK', 6581.20),
(39, 'ACC39001', 'INV', 2200.75),
(39, 'ACC39002', 'SAV', 4579.99),
(39, 'ACC39003', 'CHK', 201.13),
(40, 'ACC40001', 'SAV', 2450.35),
(40, 'ACC40002', 'CHK', 1150.90),
(41, 'ACC41001', 'INV', 3250.60),
(41, 'ACC41002', 'CHK', 328.48),
(41, 'ACC41003', 'SAV', 1208.10),
(42, 'ACC42001', 'SAV', 2025.45),
(43, 'ACC43001', 'CHK', 1450.25),
(44, 'ACC44001', 'INV', 3100.75),
(45, 'ACC45001', 'SAV', 1785.35),
(46, 'ACC46001', 'CHK', 1600.90),
(47, 'ACC47001', 'INV', 2950.60),
(47, 'ACC47002', 'CHK', 6214.98),
(47, 'ACC47003', 'SAV', 1320.18),
(48, 'ACC48001', 'INV', 2100.45),
(48, 'ACC48002', 'SAV', 28.55),
(48, 'ACC48003', 'CHK', 495.28),
(49, 'ACC49001', 'INV', 1850.25),
(49, 'ACC49002', 'SAV', 487.19),
(49, 'ACC49003', 'CHK', 2847.67),
(50, 'ACC50001', 'SAV', 2400.35);
