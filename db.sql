CREATE TABLE Owner (
    owner_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(255),
    phone_number VARCHAR(15)
);


CREATE TABLE Vehicle (
    vehicle_id INT PRIMARY KEY,
    registration_number VARCHAR(50) UNIQUE NOT NULL,
    engine_number VARCHAR(50) UNIQUE,
    chassis_number VARCHAR(50) UNIQUE,
    owner_id INT,
    model VARCHAR(100),
    color VARCHAR(50),
    FOREIGN KEY (owner_id) REFERENCES Owner(owner_id)
);


INSERT INTO Owner (owner_id, name, address, phone_number)
VALUES
(1, 'John Doe', '123 Elm Street, Bangalore, KA', '9876543210'),
(2, 'Jane Smith', '456 Oak Avenue, Mysore, KA', '8765432109'),
(3, 'Robert Brown', '789 Pine Road, Mangalore, KA', '7654321098'),
(4, 'Emily Davis', '321 Maple Street, Hubli, KA', '6543210987'),
(5, 'Michael Johnson', '654 Cedar Lane, Belgaum, KA', '5432109876'),
(6, 'Sarah Wilson', '987 Willow Drive, Tumkur, KA', '4321098765'),
(7, 'David Miller', '111 Birch Court, Shimoga, KA', '3210987654'),
(8, 'Jessica Taylor', '222 Spruce Street, Udupi, KA', '2109876543'),
(9, 'James Anderson', '333 Poplar Avenue, Hassan, KA', '1098765432'),
(10, 'Laura Thomas', '444 Palm Road, Raichur, KA', '9988776655'),
(11, 'William Moore', '555 Bamboo Boulevard, Bijapur, KA', '8877665544'),
(12, 'Linda Jackson', '666 Pinecone Place, Gulbarga, KA', '7766554433'),
(13, 'Christopher White', '777 Rosewood Way, Bellary, KA', '6655443322'),
(14, 'Patricia Harris', '888 Cypress Drive, Kolar, KA', '5544332211'),
(15, 'Thomas Martin', '999 Sequoia Street, Davangere, KA', '4433221100'),
(16, 'Nancy Lewis', '123 Aspen Boulevard, Chitradurga, KA', '9988001122'),
(17, 'Daniel Walker', '234 Redwood Road, Bagalkot, KA', '8877002233'),
(18, 'Karen Hall', '345 Magnolia Avenue, Chikmagalur, KA', '7766003344'),
(19, 'Anthony Allen', '456 Elmwood Drive, Mandya, KA', '6655004455'),
(20, 'Barbara Young', '567 Acorn Street, Bidar, KA', '5544005566'),
(21, 'Kevin Scott', '678 Beech Lane, Chamarajanagar, KA', '4433006677'),
(22, 'Donna King', '789 Dogwood Court, Haveri, KA', '3322007788'),
(23, 'Paul Wright', '890 Maplewood Way, Gadag, KA', '2211008899'),
(24, 'Michelle Green', '901 Cedarwood Road, Dharwad, KA', '1100223344'),
(25, 'George Adams', '102 Fir Lane, Karwar, KA', '9988112233');


INSERT INTO Vehicle (vehicle_id, registration_number, engine_number, chassis_number, owner_id, model, color)
VALUES
(1, 'KA01AB1234', 'EN12345', 'CH12345', 1, 'Toyota Corolla', 'Red'),
(2, 'KA02CD5678', 'EN67890', 'CH67890', 2, 'Honda Civic', 'Blue'),
(3, 'KA03EF9101', 'EN91011', 'CH91011', 3, 'Hyundai i20', 'White'),
(4, 'KA04GH2345', 'EN23456', 'CH23456', 4, 'Maruti Swift', 'Black'),
(5, 'KA05IJ6789', 'EN67891', 'CH67891', 5, 'Ford EcoSport', 'Silver'),
(6, 'KA06KL1112', 'EN11121', 'CH11121', 6, 'Nissan Magnite', 'Yellow'),
(7, 'KA07MN3456', 'EN34567', 'CH34567', 2, 'Kia Seltos', 'Red'),  -- Owner 2 has another vehicle
(8, 'KA08OP7890', 'EN78901', 'CH78901', 8, 'Tata Nexon', 'Blue'),
(9, 'KA09QR1122', 'EN11223', 'CH11223', 9, 'Volkswagen Polo', 'White'),
(10, 'KA10ST3344', 'EN33445', 'CH33445', 10, 'Mahindra Thar', 'Black'),
(11, 'KA11UV5566', 'EN55667', 'CH55667', 11, 'Renault Kwid', 'Silver'),
(12, 'KA12WX7788', 'EN77889', 'CH77889', 4, 'Skoda Rapid', 'Yellow'),  -- Owner 4 has another vehicle
(13, 'KA13YZ9910', 'EN99101', 'CH99101', 13, 'MG Hector', 'Red'),
(14, 'KA14AB2233', 'EN22334', 'CH22334', 14, 'Jeep Compass', 'Blue'),
(15, 'KA15CD4455', 'EN44556', 'CH44556', 5, 'Hyundai Creta', 'White'),  -- Owner 5 has another vehicle
(16, 'KA16EF6677', 'EN66778', 'CH66778', 16, 'Honda City', 'Black'),
(17, 'KA17GH8899', 'EN88990', 'CH88990', 17, 'Toyota Fortuner', 'Silver'),
(18, 'KA18IJ0011', 'EN00112', 'CH00112', 18, 'Suzuki Baleno', 'Yellow'),
(19, 'KA19KL2234', 'EN22345', 'CH22345', 19, 'Ford Figo', 'Red'),
(20, 'KA20MN4456', 'EN44567', 'CH44567', 6, 'Renault Triber', 'Blue'),  -- Owner 6 has another vehicle
(21, 'KA21OP6678', 'EN66789', 'CH66789', 21, 'Tata Altroz', 'White'),
(22, 'KA22QR8890', 'EN88901', 'CH88901', 5, 'Mahindra XUV500', 'Black'),  -- Owner 5 has another vehicle
(23, 'KA23ST1123', 'EN11234', 'CH11234', 23, 'Kia Sonet', 'Silver'),
(24, 'KA24UV3345', 'EN33456', 'CH33456', 24, 'Maruti Celerio', 'Yellow'),
(25, 'KA25WX5567', 'EN55678', 'CH55678', 1, 'Hyundai Verna', 'Red');  -- Owner 1 has another vehicle

select * from Vehicle;


