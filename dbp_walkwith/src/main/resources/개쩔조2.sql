
DROP TABLE LikeList CASCADE CONSTRAINTS PURGE;

DROP TABLE StoreCategory CASCADE CONSTRAINTS PURGE;

DROP TABLE Category CASCADE CONSTRAINTS PURGE;

DROP TABLE Reservation CASCADE CONSTRAINTS PURGE;

DROP TABLE Pet CASCADE CONSTRAINTS PURGE;

DROP TABLE Menu CASCADE CONSTRAINTS PURGE;

DROP TABLE Review CASCADE CONSTRAINTS PURGE;

DROP TABLE Store CASCADE CONSTRAINTS PURGE;

DROP TABLE Seller CASCADE CONSTRAINTS PURGE;

DROP TABLE Customer CASCADE CONSTRAINTS PURGE;

DROP SEQUENCE category_seq;
DROP SEQUENCE pet_seq;
DROP SEQUENCE store_seq;
DROP SEQUENCE likelist_seq;
DROP SEQUENCE storecategory_seq;
DROP SEQUENCE menu_seq;
DROP SEQUENCE reservation_seq;
DROP SEQUENCE review_seq;

CREATE TABLE Category
(
	categoryId           INTEGER  NOT NULL ,
	caName               VARCHAR2(200)  NULL ,
	storeCount           INTEGER  NULL 
);

-- Category 테이블 시퀀스 생성
CREATE SEQUENCE category_seq
START WITH 1
INCREMENT BY 1;

CREATE UNIQUE INDEX XPKCategory ON Category
(categoryId   ASC);

ALTER TABLE Category
	ADD CONSTRAINT  XPKCategory PRIMARY KEY (categoryId);

CREATE TABLE Customer
(
	userId               VARCHAR2(20)  NOT NULL ,
	uName                VARCHAR2(200)  NOT NULL ,
	uPassword            VARCHAR2(200)  NOT NULL ,
	uPhone               VARCHAR2(20)  NOT NULL ,
	uMail                VARCHAR2(300)  NOT NULL 
);

CREATE UNIQUE INDEX XPKUser ON Customer
(userId   ASC);

ALTER TABLE Customer
	ADD CONSTRAINT  XPKUser PRIMARY KEY (userId);

CREATE TABLE Pet
(
	petId                INTEGER  NOT NULL ,
	pName                VARCHAR2(200)  NULL ,
	pAge                 INTEGER  NULL ,
	pCategory            VARCHAR2(200)  NULL ,
	pDetailCategory      VARCHAR2(200)  NULL ,
	userId               VARCHAR2(20)  NOT NULL ,
	pNeureting           INTEGER  NULL ,
	pImage               VARCHAR2(500)  NULL 
);

-- Pet 테이블 시퀀스 생성
CREATE SEQUENCE pet_seq
START WITH 1
INCREMENT BY 1;

CREATE UNIQUE INDEX XPKPet ON Pet
(petId   ASC,userId   ASC);

ALTER TABLE Pet
	ADD CONSTRAINT  XPKPet PRIMARY KEY (petId,userId);

CREATE TABLE Seller
(
	sellerId             VARCHAR2(20)  NOT NULL ,
	seName               VARCHAR2(200)  NOT NULL ,
	sePassword           VARCHAR2(200)  NOT NULL ,
	sePhone              VARCHAR2(20)  NOT NULL ,
	seMail               VARCHAR2(300)  NOT NULL 
);

CREATE UNIQUE INDEX XPKSeller ON Seller
(sellerId   ASC);

ALTER TABLE Seller
	ADD CONSTRAINT  XPKSeller PRIMARY KEY (sellerId);

CREATE TABLE Store
(
	storeId              INTEGER  NOT NULL ,
	sName                VARCHAR2(200)  NOT NULL ,
	sPhone               VARCHAR2(20)  NOT NULL ,
	sTime                VARCHAR2(500)  NULL , -- 변경
	sStarScore           FLOAT  NULL ,
	sDetailDescription   VARCHAR2(1000)  NULL ,
	sellerId             VARCHAR2(20)  NOT NULL ,
	openDays             VARCHAR(100)  NOT NULL ,
	likeCount            INTEGER  NULL ,
	sImage               VARCHAR(500)  NULL 
);

-- Store 테이블 시퀀스 생성
CREATE SEQUENCE store_seq
START WITH 1
INCREMENT BY 1;

CREATE UNIQUE INDEX XPKStore ON Store
(storeId   ASC);

ALTER TABLE Store
	ADD CONSTRAINT  XPKStore PRIMARY KEY (storeId);

CREATE TABLE LikeList
(
	userId               VARCHAR2(20)  NOT NULL ,
	storeId              INTEGER  NOT NULL 
);

-- LikeList 테이블 시퀀스 생성
CREATE SEQUENCE likelist_seq
START WITH 1
INCREMENT BY 1;

CREATE UNIQUE INDEX XPKLikeList ON LikeList
(userId   ASC,storeId   ASC);

ALTER TABLE LikeList
	ADD CONSTRAINT  XPKLikeList PRIMARY KEY (userId,storeId);

CREATE TABLE StoreCategory
(
	categoryId           INTEGER  NOT NULL ,
	storeId              INTEGER  NOT NULL 
);

-- StoreCategory 테이블 시퀀스 생성
CREATE SEQUENCE storecategory_seq
START WITH 1
INCREMENT BY 1;


CREATE UNIQUE INDEX XPKStoreCategory ON StoreCategory
(categoryId   ASC,storeId   ASC);

ALTER TABLE StoreCategory
	ADD CONSTRAINT  XPKStoreCategory PRIMARY KEY (categoryId,storeId);

CREATE TABLE Reservation
(
    reservationId        INTEGER  NOT NULL,
    resDaTi              TimeStamp  NOT NULL,
    userId               VARCHAR2(20)  NOT NULL,
    storeId              INTEGER  NOT NULL,
    reComment            VARCHAR2(1000) NULL
);

-- Reservation 테이블 시퀀스 생성
CREATE SEQUENCE reservation_seq
START WITH 1
INCREMENT BY 1;


CREATE UNIQUE INDEX XPKReservation ON Reservation
(reservationId   ASC);

ALTER TABLE Reservation
	ADD CONSTRAINT  XPKReservation PRIMARY KEY (reservationId);

CREATE TABLE Menu
(
	menuId               INTEGER  NOT NULL ,
	menuName             VARCHAR2(200)  NULL ,
	menuDescrip          VARCHAR2(500)  NULL ,
	mePrice              INTEGER  NULL ,
	storeId              INTEGER  NOT NULL 
);

-- Menu 테이블 시퀀스 생성
CREATE SEQUENCE menu_seq
START WITH 1
INCREMENT BY 1;

CREATE UNIQUE INDEX XPKMenu ON Menu
(menuId   ASC);

ALTER TABLE Menu
	ADD CONSTRAINT  XPKMenu PRIMARY KEY (menuId);

CREATE TABLE Review
(
	reviewId             INTEGER  NOT NULL ,
	reContent            VARCHAR2(1000)  NULL ,
	starScore            FLOAT  NULL ,
	userId               VARCHAR2(20)  NOT NULL ,
	storeId              INTEGER  NOT NULL 
);

-- Review 테이블 시퀀스 생성
CREATE SEQUENCE review_seq
START WITH 1
INCREMENT BY 1;

CREATE UNIQUE INDEX XPKReview ON Review
(reviewId   ASC);

ALTER TABLE Review
	ADD CONSTRAINT  XPKReview PRIMARY KEY (reviewId);

ALTER TABLE Pet
	ADD (
CONSTRAINT R_1 FOREIGN KEY (userId) REFERENCES Customer (userId));

ALTER TABLE Store
	ADD (
CONSTRAINT R_3 FOREIGN KEY (sellerId) REFERENCES Seller (sellerId));

ALTER TABLE LikeList
	ADD (
CONSTRAINT R_15 FOREIGN KEY (userId) REFERENCES Customer (userId));

ALTER TABLE LikeList
	ADD (
CONSTRAINT R_16 FOREIGN KEY (storeId) REFERENCES Store (storeId));

ALTER TABLE StoreCategory
	ADD (
CONSTRAINT R_8 FOREIGN KEY (categoryId) REFERENCES Category (categoryId));

ALTER TABLE StoreCategory
	ADD (
CONSTRAINT R_9 FOREIGN KEY (storeId) REFERENCES Store (storeId));

ALTER TABLE Reservation
	ADD (
CONSTRAINT R_2 FOREIGN KEY (userId) REFERENCES Customer (userId));

ALTER TABLE Reservation
	ADD (
CONSTRAINT R_11 FOREIGN KEY (storeId) REFERENCES Store (storeId));

ALTER TABLE Menu
	ADD (
CONSTRAINT R_6 FOREIGN KEY (storeId) REFERENCES Store (storeId));

ALTER TABLE Review
	ADD (
CONSTRAINT R_10 FOREIGN KEY (userId) REFERENCES Customer (userId));

ALTER TABLE Review
	ADD (
CONSTRAINT R_14 FOREIGN KEY (storeId) REFERENCES Store (storeId));



-- Category 데이터 입력
INSERT INTO Category VALUES(category_seq.nextval, '음식점', 10);
INSERT INTO Category VALUES(category_seq.nextval, '병원', 15);

-- Customer 데이터 입력
INSERT INTO Customer VALUES('admin', '테스트', 'admin', '010-5555-6666', 'admin@example.com');
INSERT INTO Customer VALUES('user1', '이름1', 'password1', '010-1234-5678', 'user1@example.com');
INSERT INTO Customer VALUES('user2', '이름2', 'password2', '010-2345-6789', 'user2@example.com');
INSERT INTO Customer VALUES('user3', '이름3', 'password3', '010-3456-7890', 'user3@example.com');
INSERT INTO Customer VALUES('user4', '이름4', 'password4', '010-4567-8901', 'user4@example.com');
INSERT INTO Customer VALUES('user5', '이름5', 'password5', '010-5678-9012', 'user5@example.com');

-- Pet 데이터 입력
INSERT INTO Pet VALUES(pet_seq.nextval, 'Max', 3, 'Dog', 'Poodle', 'user1', 1, NULL);
INSERT INTO Pet VALUES(pet_seq.nextval, 'Bella', 2, 'Cat', 'Persian', 'user2', 0, NULL);
INSERT INTO Pet VALUES(pet_seq.nextval, 'Charlie', 1, 'Bird', 'Parrot', 'user3', 1, NULL);
INSERT INTO Pet VALUES(pet_seq.nextval, 'Lucy', 4, 'Dog', 'Labrador', 'user4', 1, NULL);
INSERT INTO Pet VALUES(pet_seq.nextval, 'Milo', 2, 'Cat', 'Siamese', 'user5', 0, NULL);

-- Seller 데이터 입력
INSERT INTO Seller VALUES('admin2', '테스트2', 'admin2', '010-6666-7777', 'admim2@example.com');
INSERT INTO Seller VALUES('seller1', '판매자1', 'password1', '010-4567-8901', 'seller1@example.com');
INSERT INTO Seller VALUES('seller2', '판매자2', 'password2', '010-5678-9012', 'seller2@example.com');
INSERT INTO Seller VALUES('seller3', '판매자3', 'password3', '010-6789-0123', 'seller3@example.com');
INSERT INTO Seller VALUES('seller4', '판매자4', 'password4', '010-7890-1234', 'seller4@example.com');
INSERT INTO Seller VALUES('seller5', '판매자5', 'password5', '010-8901-2345', 'seller5@example.com');

-- Store 데이터 입력
INSERT INTO Store VALUES(store_seq.nextval, '테스트', '02-123-4567', '09:00:00 - 18:00:00', 4.5, '테스트상점', 'admin2', '월,수,금', 50, NULL);
INSERT INTO Store VALUES(store_seq.nextval, 'Store1', '02-123-4567', '09:00:00 - 18:00:00', 4.5, '상점설명1', 'seller1', '월,화,수,목', 100, NULL);
INSERT INTO Store VALUES(store_seq.nextval, 'Store2', '02-234-5678', '10:00:00 - 19:00:00', 4.3, '상점설명2', 'seller2', '화,수,목,금', 200, NULL);
INSERT INTO Store VALUES(store_seq.nextval, 'Store3', '02-345-6789', '11:00:00 - 20:00:00', 4.7, '상점설명3', 'seller3', '수,목,금,토', 300, NULL);
INSERT INTO Store VALUES(store_seq.nextval, 'Store4', '02-456-7890', '12:00:00 - 21:00:00', 4.2, '상점설명4', 'seller4', '목,금,토,일', 400, NULL);
INSERT INTO Store VALUES(store_seq.nextval, 'Store5', '02-567-8901', '13:00:00 - 22:00:00', 4.8, '상점설명5', 'seller5', '금,토,일,월', 500, NULL);


-- LikeList 테이블에 넣을 데이터
INSERT INTO LikeList VALUES('user1', 1);
INSERT INTO LikeList VALUES('user2', 2);
INSERT INTO LikeList VALUES('user3', 3);
INSERT INTO LikeList VALUES('user4', 4);
INSERT INTO LikeList VALUES('user5', 5);

-- Reservation 테이블에 넣을 데이터
INSERT INTO Reservation VALUES(reservation_seq.nextval, TO_DATE('2023-12-25 19:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'user1', 1, '첫번째 예약');
INSERT INTO Reservation VALUES(reservation_seq.nextval, TO_DATE('2023-12-26 20:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'user2', 2, '두번째 예약');
INSERT INTO Reservation VALUES(reservation_seq.nextval, TO_DATE('2023-12-27 21:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'user3', 3, '세번째 예약');
INSERT INTO Reservation VALUES(reservation_seq.nextval, TO_DATE('2023-12-28 22:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'user4', 4, '네번째 예약');
INSERT INTO Reservation VALUES(reservation_seq.nextval, TO_DATE('2023-12-29 23:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'user5', 5, '다섯번째 예약');

-- Review 테이블에 넣을 데이터
INSERT INTO Review VALUES(review_seq.nextval, '매우 만족합니다.', 5.0, 'user1', 1);
INSERT INTO Review VALUES(review_seq.nextval, '다음에 또 방문하고 싶습니다.', 4.5, 'user2', 2);
INSERT INTO Review VALUES(review_seq.nextval, '서비스가 좋았습니다.', 4.0, 'user3', 3);
INSERT INTO Review VALUES(review_seq.nextval, '메뉴가 다양해서 좋았습니다.', 4.5, 'user4', 4);
INSERT INTO Review VALUES(review_seq.nextval, '위치가 좋아서 찾기 쉬웠습니다.', 5.0, 'user5', 5);
