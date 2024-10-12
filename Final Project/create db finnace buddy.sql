CREATE DATABASE financebuddy;

USE financebuddy;

CREATE TABLE staff(
    ID int(10) PRIMARY KEY NOT NULL,
    Username varchar(100) NOT NULL,
    Password varchar(100) NOT NULL
);

CREATE TABLE Bank(
    AccountNumber varchar(50) PRIMARY KEY NOT NULL,
    AccountName varchar(50) NOT NULL,
    BankName varchar(50) NOT NULL
);

CREATE TABLE Trans(
    TransID int(5) AUTO_INCREMENT PRIMARY KEY,
    Category varchar(11) NOT NULL,
    Description varchar(50) NOT NULL,
    TransDate DATE NOT NULL, 
    Amount int(20) NOT NULL,
    id int(10) NOT NULL,
    AccountNumber varchar(50) NOT NULL REFERENCES Bank(AccountNumber),
    FOREIGN KEY (id) REFERENCES staff(ID) ON UPDATE CASCADE,
	FOREIGN KEY (AccountNumber) REFERENCES Bank(AccountNumber) ON UPDATE CASCADE
);



INSERT INTO staff (ID, Username, Password) VALUES ('1', 'Budi', '12345678'), ('2', 'Charlie', '87654321'), ('3', 'Anto', '12344321');

INSERT INTO Bank (AccountNumber, AccountName, BankName) VALUES ('58839210', 'Wanto', 'BCA'), ('281731731', 'Kris', 'Mandiri');

INSERT INTO Trans (TransID, Category, Description, TransDate, Amount, id, AccountNumber) VALUES
    (00001, 'Pemasukan', 'Gaji Karyawan', '2023-11-15', 500000000, 1, '58839210'),
    (00002, 'Pengeluaran', 'Pembelian barang', '2023-11-15', 200000000, 2, '281731731');
