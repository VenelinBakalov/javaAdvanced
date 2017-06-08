CREATE DATABASE IF NOT EXISTS demo;
use demo;
CREATE TABLE customers(
	customer_id int NOT NULL PRIMARY KEY,
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,
	payment_number char(16) NOT NULL
);

CREATE TABLE `lines` (
	id int NOT NULL AUTO_INCREMENT,
	x1 float NOT NULL,
	y1 float NOT NULL,
	x2 float NOT NULL,
	y2 float NOT NULL,
 CONSTRAINT pk_lines PRIMARY KEY (id));
 
CREATE TABLE minions(
	id int AUTO_INCREMENT NOT NULL PRIMARY KEY,
	name varchar(50) NULL,
	age int 
);

CREATE TABLE people(
	id int AUTO_INCREMENT NOT NULL PRIMARY KEY,
	email varchar(255) NOT NULL,
	first_name varchar(50) NULL,
	last_name varchar(50) NULL,
	salary DECIMAL(19,9) NULL);

CREATE TABLE products(
	id int NOT NULL PRIMARY KEY,
	name varchar(50) NOT NULL,
	quantity int NOT NULL,
	box_capacity int NOT NULL,
	pallet_capacity int NOT NULL);

CREATE TABLE rectangles(
	id int AUTO_INCREMENT NOT NULL PRIMARY KEY,
	 a float NOT NULL,
	 b  float NOT NULL); 
	 
CREATE TABLE towns(
	id int AUTO_INCREMENT NOT NULL PRIMARY KEY,
	name varchar(50) NULL);
	
CREATE TABLE triangles(
	id int AUTO_INCREMENT nOT nULL PRIMARY KEY,
	 a float nOT NULL,
	 b  float nOT NULL,
	c float nOT nULL);
	
CREATE TABLE triangles2(
	id int AUTO_INCREMENT nOT nULL PRIMARY KEY,
	 a float nOT NULL,
	h float nOT nULL );

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (1, 'Guy', 'Gilbert', '5645322227179083');  
INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (2, 'Kevin', 'Brown', '4417937746396076');  
INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (3, 'Roberto', 'Tamburello', '7927545745782378');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (4, 'Rob', 'Walters', '8373866836827081');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (5, 'Thierry', 'D''Hers', '6324824830110281');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (6, 'David', 'Bradley', '9814901018722947');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (7, 'JoLynn', 'Dobney', '4599692018956432');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (8, 'Ruth', 'Ellerbrock', '6122441931293978');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (9, 'Gail', 'Erickson', '1163087434114868');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (10, 'Barry', 'Johnson', '3970818232390811');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (11, 'Jossef', 'ldberg', '9151658894664016');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (12, 'Terri', 'Duffy', '6183355082422774');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (13, 'Sidney', 'Higa', '4120537582244300');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (14, 'Taylor', 'Maxwell', '1938568596870607');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (15, 'Jeffrey', 'Ford', '8915810955572860');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (16, 'Jo', 'Brown', '7273205948371278');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (17, 'Doris', 'Hartwig', '5922753170391384');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (18, 'John', 'Campbell', '1209925930853143');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (19, 'Diane', 'Glimp', '2476362479035343');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (20, 'Steven', 'Selikoff', '4815598168041326');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (21, 'Peter', 'Krebs', '3265508651416842');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (22, 'Stuart', 'Munson', '2668216470313532');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (23, 'Greg', 'Alderson', '7251223138404247');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (24, 'David', 'Johnson', '6929964196396225');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (25, 'Zheng', 'Mu', '7110549042521172');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (26, 'Ivo', 'Salmre', '9004736779009908');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (27, 'Paul', 'Komosinski', '9037774293366599');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (28, 'Ashvini', 'Sharma', '8084587447142873');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (29, 'Kendall', 'Keil', '5872696533959082');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (30, 'Paula', 'Barreto de Mattos', '8844359368419097');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (31, 'Alejandro', 'McGuel', '3109197055164785');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (32, 'Garrett', 'Young', '6519517838299156');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (33, 'Jian Shuo', 'Wang', '2363733520443413');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (34, 'Susan', 'Eaton', '9367115272055768');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (35, 'Vamsi', 'Kuppa', '4209682755728257');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (36, 'Alice', 'Ciccu', '5267558936996135');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (37, 'Simon', 'Rapier', '8970108450616046');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (38, 'Jinghao', 'Liu', '7432945187196856');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (39, 'Michael', 'Hines', '8774260387313280');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (40, 'Yvonne', 'McKay', '9616182116114934');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (41, 'Peng', 'Wu', '6179870316211712');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (42, 'Jean', 'Trenary', '5296317916849649');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (43, 'Russell', 'Hunter', '5775476574279567');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (44, 'A. Scott', 'Wright', '6518562162666714');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (45, 'Fred', 'orthup', '2300788501129671');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (46, 'Sariya', 'Harnpadoungsataya', '8148745065538021');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (47, 'Willis', 'Johnson', '1624100548057725');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (48, 'Jun', 'Cao', '2825462680946393');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (49, 'Christian', 'Kleinerman', '9625942215524469');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (50, 'Susan', 'Metters', '7040957321118931');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (51, 'Reuben', 'D''sa', '6504592353671722');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (52, 'Kirk', 'Koenigsbauer', '4891114540364065');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (53, 'David', 'Ortiz', '3868546622008669');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (54, 'Tengiz', 'Kharatishvili', '8837587181443844');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (55, 'Hanying', 'Feng', '2141729963267669');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (56, 'Kevin', 'Liu', '5682883488088952');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (57, 'Annik', 'Stahl', '5698978315073488');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (58, 'Suroor', 'Fatima', '5374955487782798');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (59, 'Deborah', 'Poe', '2877525595357834');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (60, 'Jim', 'Scardelis', '6479803552302813');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (61, 'Carole', 'Poland', '4605276124663141');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (62, 'George', 'Li', '7363210936606573');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (63, 'Gary', 'Yukish', '5138825330365260');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (64, 'Cristian', 'Petculescu', '2412910923043320');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (65, 'Raymond', 'Sam', '3077304081241467');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (66, 'Janaina', 'Bueno', '3463360976684155');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (67, 'Bob', 'Hohman', '2954138092016867');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (68, 'Shammi', 'Mohamed', '5351639369348379');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (69, 'Linda', 'Moschell', '8141750981374248');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (70, 'Mindy', 'Martin', '8883961113738272');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (71, 'Wendy', 'Kahn', '9184130564334373');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (72, 'Kim', 'Ralls', '7786327852767652');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (73, 'Sandra', 'Reategui Alayo', '5360938568407870');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (74, 'Kok-Ho', 'Loh', '4232997837143935');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (75, 'Douglas', 'Hite', '9070921883829678');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (76, 'James', 'Kramer', '2146775071463607');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (77, 'Sean', 'Alexander', '7313952826834153');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (78, 'itin', 'Mirchandani', '3296819140813283');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (79, 'Diane', 'Margheim', '5891437299591687');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (80, 'Rebecca', 'Laszlo', '8433252729699512');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (81, 'Rajesh', 'Patel', '3469434974728436');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (82, 'Vidur', 'Luthra', '5235580777351856');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (83, 'John', 'Evans', '6823267130825578');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (84, 'ancy', 'Anderson', '8505146310605636');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (85, 'Pilar', 'Ackerman', '6753723148771716');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (86, 'David', 'Yalovsky', '4216467551008706');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (87, 'David', 'Hamilton', '1856387746715488');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (88, 'Laura', 'Steele', '8130518688981523');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (89, 'Margie', 'Shoop', '5304293163488522');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (90, 'Zainal', 'Arifin', '2624734840262337');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (91, 'Lorraine', 'ay', '9187844150880843');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (92, 'Fadi', 'Fakhouri', '3495217525796088');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (93, 'Ryan', 'Cornelsen', '3533330030685704');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (94, 'Candy', 'Spoon', '4851735094141587');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (95, 'uan', 'Yu', '7205104569023977');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (96, 'William', 'Vong', '1967385880412958');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (97, 'Bjorn', 'Rettig', '9202608050797826');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (98, 'Scott', 'de', '3404229243612619');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (99, 'Michael', 'Rothkugel', '2581996622413596');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (100, 'Lane', 'Sacksteder', '3344229237743186');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (101, 'Pete', 'Male', '5971284288741676');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (102, 'Dan', 'Bacon', '8257190729424129');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (103, 'David', 'Barber', '3917930966008848');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (104, 'Lolan', 'Song', '5857117345582640');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (105, 'Paula', 'artker', '6166872648404718');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (106, 'Mary', 'Gibson', '5461160193093344');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (107, 'Mindaugas', 'Krapauskas', '9160674453776619');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (108, 'Eric', 'Gubbels', '5729184214926461');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (109, 'Ken', 'Sanchez', '5469419562316958');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (110, 'Jason', 'Watters', '1208260343171875');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (111, 'Mark', 'Harrington', '7067584113217553');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (112, 'Janeth', 'Esteves', '7410399981241001');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (113, 'Marc', 'Ingle', '3514405562796816');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (114, 'Gigi', 'Matthew', '2468248896285846');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (115, 'Paul', 'Singh', '2989836421728909');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (116, 'Frank', 'Lee', '4523905755659381');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (117, 'Francois', 'Ajenstat', '6871256525378619');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (118, 'Diane', 'Tibbott', '5064955045588475');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (119, 'Jill', 'Williams', '2141654646759205');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (120, 'Angela', 'Barbariol', '2002689182068600');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (121, 'Matthias', 'Berndt', '6158897539075660');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (122, 'Bryan', 'Baker', '5698547130333879');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (123, 'Jeff', 'Hay', '4967654749933032');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (124, 'Eugene', 'Zabokritski', '8712482264087016');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (125, 'Barbara', 'Decker', '9580409985079387');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (126, 'Chris', 'Preston', '3831669775322551');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (127, 'Sean', 'Chai', '9929334171913209');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (128, 'Dan', 'Wilson', '6700939478932423');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (129, 'Mark', 'McArthur', '7878340445148873');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (130, 'Bryan', 'Walton', '1740643346238814');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (131, 'Houman', 'Pournasseh', '7510194456852004');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (132, 'Sairaj', 'Uddin', '8695190158681069');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (133, 'Michiko', 'Osada', '4911159787986576');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (134, 'Benjamin', 'Martin', '8570977118393392');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (135, 'Cynthia', 'Randall', '5756939971236411');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (136, 'Kathie', 'Flood', '3290721568961249');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (137, 'Britta', 'Simon', '2381906229394108');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (138, 'Brian', 'Lloyd', '1740711248766858');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (139, 'David', 'Liu', '8235587346003226');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (140, 'Laura', 'orman', '2149361985017015');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (141, 'Michael', 'Patten', '3911995510381143');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (142, 'Andy', 'Ruth', '8776232010461256');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (143, 'Yuhong', 'Li', '3343820161731158');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (144, 'Robert', 'Rounthwaite', '4406318411005855');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (145, 'Andreas', 'Berglund', '4658744893493835');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (146, 'Reed', 'Koch', '3907374575549085');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (147, 'Linda', 'Randall', '7982231395055108');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (148, 'James', 'Hamilton', '4471295830796142');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (149, 'Ramesh', 'Meyyappan', '3175586359129538');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (150, 'Stephanie', 'Conroy', '6439881331627129');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (151, 'Samantha', 'Smith', '6375547258982212');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (152, 'Tawana', 'usbaum', '3048459182158799');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (153, 'Denise', 'Smith', '7837808478399498');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (154, 'Hao', 'Chen', '3334802217249823');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (155, 'Alex', 'ayberg', '7756429079268287');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (156, 'Eugene', 'Kogan', '4086963789148153');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (157, 'Brandon', 'Heidepriem', '3253528475107994');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (158, 'Dylan', 'Miller', '1288540516632469');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (159, 'Shane', 'Kim', '8855956821538612');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (160, 'John', 'Chen', '5366774723651502');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (161, 'Karen', 'Berge', '2377333681391094');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (162, 'Jose', 'Lu', '6754885286113109');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (163, 'Mandar', 'Samant', '5819705479593156');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (164, 'Mikael', 'Sandberg', '9076468191454679');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (165, 'Sameer', 'Tejani', '7866826862412857');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (166, 'Dragan', 'Tomic', '4615629477913853');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (167, 'Carol', 'Philips', '6575104672172395');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (168, 'Rob', 'Caron', '7654816883169661');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (169, 'Don', 'Hall', '3535155035887931');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (170, 'Alan', 'Brewer', '2650196510123656');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (171, 'David', 'Lawrence', '8655760568743291');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (172, 'Baris', 'Cetinok', '2139898514786702');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (173, 'Michael', 'Ray', '8429509249641955');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (174, 'Steve', 'Masters', '1628342070144010');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (175, 'Suchitra', 'Mohan', '6188517997559755');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (176, 'Karen', 'Berg', '7886378970418571');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (177, 'Terrence', 'Earls', '8766323199782798');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (178, 'Barbara', 'Moreland', '7370220735977413');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (179, 'Chad', 'iswonger', '7425858355805138');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (180, 'Rostislav', 'Shabalin', '8567117698541127');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (181, 'Belinda', 'ewman', '8856414931597261');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (182, 'Katie', 'McAskill-White', '4705557459197921');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (183, 'Russell', 'King', '8477931330353829');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (184, 'Jack', 'Richins', '9515486565451014');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (185, 'Andrew', 'Hill', '9067303105824436');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (186, 'icole', 'Holliday', '3834812797409012');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (187, 'Frank', 'Miller', '1682833375984222');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (188, 'Peter', 'Connelly', '2471590684957039');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (189, 'Anibal', 'Sousa', '2619563305965789');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (190, 'Ken', 'Myer', '4749338430682542');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (191, 'Grant', 'Culbertson', '7629594956649514');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (192, 'Michael', 'Entin', '8173737894026407');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (193, 'Lionel', 'Penuchot', '3201015830725033');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (194, 'Thomas', 'Michaels', '7055740399756014');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (195, 'Jimmy', 'Bischoff', '7751184269274076');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (196, 'Michael', 'Vanderhyde', '3683704828761364');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (197, 'Lori', 'Kane', '2284423086765347');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (198, 'Arvind', 'Rao', '4502817676389168');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (199, 'Stefen', 'Hesse', '6753159566667889');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (200, 'Hazem', 'Abolrous', '4983555554013273');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (201, 'Janet', 'Sheperdigian', '7312672663906858');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (202, 'Elizabeth', 'Keyser', '5109199883141077');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (203, 'Terry', 'Eminhizer', '1663916682167132');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (204, 'John', 'Frum', '3436395941323152');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (205, 'Merav', 'etz', '9414161918937594');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (206, 'Brian', 'LaMee', '9856480570987280');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (207, 'Kitti', 'Lertpiriyasuwat', '4967889030932488');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (208, 'Jay', 'Adams', '2162474678846241');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (209, 'Jan', 'Miksovsky', '3827477855849801');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (210, 'Brenda', 'Diaz', '6375049601935691');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (211, 'Andrew', 'Cencini', '7551222145104426');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (212, 'Chris', 'orred', '8295206528365405');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (213, 'Chris', 'Okelberry', '3873554322156931');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (214, 'Shelley', 'Dyck', '5699187148733042');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (215, 'Gabe', 'Mares', '3548517629134340');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (216, 'Mike', 'Seamans', '7862433200254898');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (217, 'Michael', 'Raheem', '2881969196514889');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (218, 'Gary', 'Altman', '8044958776746557');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (219, 'Charles', 'Fitzgerald', '3616627229403845');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (220, 'Ebru', 'Ersan', '2281862720044302');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (221, 'Sylvester', 'Valdez', '8015412453875775');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (222, 'Brian', 'ldstein', '7960731030682794');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (223, 'Linda', 'Meisner', '6387669413804769');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (224, 'Betsy', 'Stadick', '9072311615082461');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (225, 'Magnus', 'Hedlund', '513356187265664 ');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (226, 'Karan', 'Khanna', '1467373844324861');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (227, 'Mary', 'Baker', '7748242269298936');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (228, 'Kevin', 'Homer', '4693723971144217');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (229, 'Mihail', 'Frintu', '6304368978779822');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (230, 'Bonnie', 'Kearney', '3224612792496020');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (231, 'Fukiko', 'Ogisu', '8788191674725854');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (232, 'Hung-Fu', 'Ting', '9295495067368215');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (233, 'rdon', 'Hee', '7320199924209382');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (234, 'Kimberly', 'Zimmerman', '4800352323818237');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (235, 'Kim', 'Abercrombie', '4812197151649653');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (236, 'Sandeep', 'Kaliyath', '4748793070421461');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (237, 'Prasanna', 'Samarawickrama', '2762289024791270');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (238, 'Frank', 'Pellow', '2160497594005458');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (239, 'Min', 'Su', '2308226383789347');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (240, 'Eric', 'Brown', '5542743236055397');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (241, 'Eric', 'Kurjan', '6942439156361877');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (242, 'Pat', 'Coleman', '2032180111941939');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (243, 'Maciej', 'Dusza', '7115552774817070');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (244, 'Erin', 'Hagens', '9597350525931162');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (245, 'Patrick', 'Wedge', '6203220771529615');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (246, 'Frank', 'Martinez', '8077968499363265');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (247, 'Ed', 'Dudenhoefer', '3280192061526458');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (248, 'Christopher', 'Hill', '5456142539079952');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (249, 'Patrick', 'Cook', '9193514152725704');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (250, 'Krishna', 'Sunkammurali', '4241559090528010');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (251, 'Lori', 'Penor', '3857365693718829');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (252, 'Danielle', 'Tiedt', '5580568479487519');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (253, 'Sootha', 'Charncherngkha', '5760648544535256');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (254, 'Michael', 'Zwilling', '8230795123798961');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (255, 'Randy', 'Reeves', '9001872489691596');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (256, 'John', 'Kane', '2375668783096928');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (257, 'Jack', 'Creasey', '8980665575223814');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (258, 'Olinda', 'Turner', '9845222237342025');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (259, 'Stuart', 'Macrae', '4225525581998404');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (260, 'Jo', 'Berry', '9578910110647263');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (261, 'Ben', 'Miller', '8127677090764333');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (262, 'Tom', 'Vande Velde', '3235587598028158');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (263, 'Ovidiu', 'Cracium', '2629709865993472');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (264, 'Annette', 'Hill', '5755849590193404');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (265, 'Janice', 'Galvin', '3411163859555972');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (266, 'Reinout', 'Hillmann', '9088911512535358');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (267, 'Michael', 'Sullivan', '3068678529276302');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (268, 'Stephen', 'Jiang', '1995629604460464');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (269, 'Wanida', 'Benshoof', '2627950665853220');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (270, 'Sharon', 'Salavaria', '8899793310467186');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (271, 'John', 'Wood', '6580626389352327');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (272, 'Mary', 'Dempsey', '5304775438985923');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (273, 'Brian', 'Welcker', '5438585412835872');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (274, 'Sheela', 'Word', '3253710911347739');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (275, 'Michael', 'Blythe', '5615545620358899');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (276, 'Linda', 'Mitchell', '7657557974903337');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (277, 'Jillian', 'Carson', '8077218855644836');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (278, 'Garrett', 'Vargas', '1191234082922521');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (279, 'Tsvi', 'Reiter', '6059331728207257');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (280, 'Pamela', 'Ansman-Wolfe', '6129506925419558');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (281, 'Shu', 'Ito', '2544776320355089');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (282, 'Jose', 'Saraiva', '9588196742608987');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (283, 'David', 'Campbell', '1144484385805176');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (284, 'Amy', 'Alberts', '8269139678239481');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (285, 'Jae', 'Pak', '2850215548023119');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (286, 'Ranjit', 'Varkey Chudukatil', '4671543167568757');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (287, 'Tete', 'Mensa-Annan', '3643786748295126');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (288, 'Syed', 'Abbas', '3964815633391281');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (289, 'Rachel', 'Valdez', '1665977863042383');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (290, 'Lynn', 'Tsoflias', '7807260283273161');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (291, 'Svetlin', 'akov', '7773538484630196');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (292, 'Martin', 'Kulov', '3272933656756729');

INSERT customers (customer_id, first_name, last_name, payment_number) VALUES (293, 'George', 'Denchev', '5845520684874546');




INSERT `lines` (id, x1, y1, x2, y2) VALUES (1, 0, 0, 10, 0);

INSERT `lines` (id, x1, y1, x2, y2) VALUES (2, 0, 0, 5, 3);

INSERT `lines` (id, x1, y1, x2, y2) VALUES (4, -1, 5, 8, -3);

INSERT `lines` (id, x1, y1, x2, y2) VALUES (5, 18, 23, 8882, 134);



INSERT products (id, name, quantity, box_capacity, pallet_capacity) VALUES (1, 'Perlenbacher 500ml', 108, 6, 18);

INSERT products (id, name, quantity, box_capacity, pallet_capacity) VALUES (2, 'Perlenbacher 500ml', 10, 6, 18);

INSERT products (id, name, quantity, box_capacity, pallet_capacity) VALUES (3, 'Chocolate Chips', 350, 24, 3);

INSERT products (id, name, quantity, box_capacity, pallet_capacity) VALUES (4, 'Oil Pump', 100, 1, 12);

INSERT products (id, name, quantity, box_capacity, pallet_capacity) VALUES (5, 'OLED TV 50-Inch', 13, 1, 5);

INSERT products (id, name, quantity, box_capacity, pallet_capacity) VALUES (6, 'Penny', 1, 2239488, 1);




INSERT rectangles (id, A,  b ) VALUES (1, 2, 4);

INSERT rectangles (id, A,  b ) VALUES (2, 1, 18);

INSERT rectangles (id, A,  b ) VALUES (3, 4.5, 3);

INSERT rectangles (id, A,  b ) VALUES (4, 8, 12);

INSERT rectangles (id, A,  b ) VALUES (5, 3, 5);


INSERT triangles (id, A,  b , C) VALUES (1, 3, 4, 5);

INSERT triangles (id, A,  b , C) VALUES (2, 2, 5, 4);

INSERT triangles (id, A,  b , C) VALUES (3, 1.5, 1.5, 2);

INSERT triangles (id, A,  b , C) VALUES (4, 3.5, 4.15, 6);

INSERT triangles (id, A,  b , C) VALUES (5, 4, 2, 4);


INSERT triangles2 (id, A, H) VALUES (1, 2, 4);

INSERT triangles2 (id, A, H) VALUES (2, 1, 18);

INSERT triangles2 (id, A, H) VALUES (3, 4.5, 3);

INSERT triangles2 (id, A, H) VALUES (4, 8, 12);

INSERT triangles2 (id, A, H) VALUES (5, 3, 5);