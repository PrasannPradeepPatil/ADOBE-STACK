//DATATYPE,KEYS,FLAGS,   NORMALIZATION,ACID,QUERY OPTIMIZATION  
/* #region Main */
//DATATYPES
/*
STRING DATATYPES
                  Storage Size     characters that can be stored 
1.CHAR (x)        64 KB            x fixed characters,x max is upto n characters  -->  English = 1 byte , Europe , = 2bytes , Asian = 30 bytes
2. VARCHAR (x)    64KB             upto x characters ,x max is upto n characters        You can calculate n for each
3.TINYTEXT        255 bytes        upto n characters                                    Eg If we use CHAR (10) my sql will reserve 30 bytes for asian
4.TEXT            64KB             upto n characters                                                      
4.MEDIUMTEXT      16 MB            upto n characters                                                         
5.LONGTEXT        4 GB             upto n characters 
                                      |
                                  English = 1 byte , Europe , middle eastern = 2bytes , Asian = 30 bytes
                                  You can calculate n for each
                                                              
INTEGER DATATYPES
                          Storage Size     Number range that can be stored 
1.TINYINT(ZERO FILL)      1 byte               [-128 , 127]
2.SMALLINT(ZERO FILL)     2 byte               [-32k , 32k]
3.MEDIUINT(ZERO FILL)     3 byte               [-8M , 8M]
4.INT(ZERO FILL)          4 byte               [-2B , 2B]
5.BIGINT(ZERO FILL)       8 byte               [-9Z , 9Z]
                            |                      |
fills the values with previous 0’s               UNSIGNED DATATYPE – allows  +ve values only values [0 , max]
EG TINYINT(4) ->for vauel 1  it will store 0001  EG UNSIGNED TINYINT ->it will nit take –ve value
                    
FOLATING  DATATYPES
                                                    Storage Size    Total  digits that  be stored 
FLOAT(total digits , precision)                     4 bytes                7
DOUBLE(total digits , precision)                    8 bytes                15
DECIMAL/DEC/NUMERIC/FIXED(total digits , precision) 16 bytes               28
                                    |
                   	EG 9.222 total digits = 4 , precision = 3

DATA AND TIME
                  Storage Size    vaues that can be stored 
TIMESTAMP         4b              Date and time upto year 2038
DATETIME          8b              Date and time all years
DATE                              Date only                                       
TIME                              Time only                                       
YEAR                              Year only                                       

BOOLEAN
               Storage size    values that can be stored
BOOLEAN/BOOL   1 byte            TREU , FALSE
 

JSON
              Storage size    values that can be stored
JSON            --             '{
                              ‘key’: value,--> key are String , value can be anything
                              ‘key’: value
                              }'
                                       

BLOB
              Storage Size  Total  digits that  be stored 
TINYBLOB      255 bytes     binary upto 4 bytes
BLOB          64 KB         binary upto 64 KB
MEDIUM BLOB   16MB          binary upto 16 MB
LONG BLOB     4 GB           binary upto 4 GB
                                           |
                           BLOB IS BAD: Because blob is for binary and if you are storing binary in DB 
                           1.DB size incrases
                           2.Slower bacup
                           3.Performance problems
                           4.More code to read/write 


ENUM
                     Storage size    values that can be stored
ENUM(‘val1’,’val2’)  BAD             values listed
SET(‘val1’,’val2’)   BAD             unique values listed 
                                           |
                                    ENUM IS  BAD because if we  change listed values then SQL rebuilds entiire table
                                    EG ENUM(‘small’ , ‘medium’ , ‘large’)



*/

//KEYS
/*
Super Key     :Group of Columns for indenifying table rows uniquely
Candidate keys:Group of columns for indenifying table rows uniquely;non null columns
              Primary Key   :Single column  of candidate key that indenify table rows uniquely 
              Unique Key    :Single column  of candidate key that indenify table rows uniquely and non duplicate columns     
              Alternate Key :Remain columns of candidate key that indenify table rows uniquely     
Composite Key :Group of columns that indenify table rows uniquely  ;non null columns;group requires atleast 2 columns
Compound Key  :Group of columns for indenifying table rows uniquely;non null columns;group requires atleast 2 columns;key of group can be foreign key

                                
Foreign Key  : column in a table which is primary key of other table and links it to other table.
               The primary key is the PARENT table  and foreign key table is CHILD TABLE  

Surrogate key -->column artificially unique  not in table , because no columnname  individually or group identify rows 

Eg
Id  RollNo Name  EnrollNo Adress  DeptId               DeptId  Name
1   27     Avi   AX101    Delhi   1                     1
2   28     Ravi  AX102    Noida   1                     2
3   29     Kavi  AX103    Mumbai  2                     3
|    |            | |              |                    |
PK   |-----AK----/  UK             |------Foreign Key---|
 \          |       /
  \         |      /
   Candidate Key,Super Key    
*/

//FLAGS
/*
PK = 1-> considers the key as primary
NN = 1 ->values =  cannot be  NULL values ;NN = 0 default value = NULL
UQ = 1-->values   = unique
B = 1 -->values = Binary
UN = 1 -->values = unsigned(+ve values) 
ZF = 1 -->values = zero fill the vaues to makeall values equal length
AI = 1 -> default value = autoincrement from previous values
                    Default expression ->Default value = value written in expression


*/



//NORMALIZATION
/*
Look in SQL WORKBench Docx ka 4.Creating Database and Tables -->5.Normalization
*/

//ACID
/*
Look in TRANSACTIONA
*/

//QUERY OPTIMIZATION
/*
1.TABLES-->Use  datatypes visely
           EG  
           TINYINT rather than INT for age
           BLOB must be avouded 
         
         -->Use primary key  visely
            EG 
            Each table must have a  primary key , 
            NUMERIC rather than STRING
            TINYINT rather than INT
            BLOB must be avoided
          -->Normalization
            If a table has  many   column conseder normalizing
            and spliting  in 2 tablels with one – one relationship
            EG 
            customer table with customer_id , customer_adress
         Which doesn’t get read often , split the tablesinto customer,customer_adress
         
         -->Denormalizing
           If tables have many joins consider denormalizing
           and join the 2 tables by copying columns of table2 in table1
           EG JOIN cust1 cust2 ;  then you can copy columns  of cust2 in cust1
         -- >Caching
         If a query is expensive form a separate tablle for it and use Triggers ,Events to change that table
         EG 
         If the query to fetch the list of forums and the number of posts in each forum is expensive create
         a table called forums_summary that contains the list of forums and the number of posts
         You can use events to regularly refresh the data in this table. You may also use triggers to update 
         the counts every time there is a new post. 
 
2. INDEXES-->Use index on columns

3.LIMIT-->Use rows  as much required
          Eg: The LIMIT keyword


*/


/* #endregion */


//TABLENAME,COLUMNNAME
/*
1.TABLENAME, COLUMNNAME
database.tableName            -->database is not required if you have declared database in USE clause 
database.tableName.columnName -->tableName is not required if you are working on a single table

2.ALIAS
tableName as aliasName   -->alias  once declared alias must be used
columnName as aliasName  -->alias  once declared cant be used anywhere else
                            EG
                            SELECT o.customer_id , c.customerid --you cant do order.customerid as you have declared alias o)
                            FROM orders o
                            INNER JOIN customers c ON  o.customer_id =c.custome_id 


3.FN
ARITHMETIC FN
columnname +-* /10) AS newcolumnname-> return newcolumnnam and fill elements by performing arithmetic op on columns
MAX(columnname) AS newcolumnname -> returns newcolumnname with maximum value of column 
MIN(columnname) AS newcolumnname -> returns newcolumnname with minimum value of column 
AVG(columnname) AS newcolumnname -> returns newcolumnname with average value of column
SUM(columnname) AS newcolumnname -> returns newcolumnname with sum value of column
COUNT(columnname) AS newcolumnname -> returns newcolumnname with count of column items=no of rows 
DISTINCT columnname AS newcolumnname ->return newcolumnname  with DISTINT/unoque elements of column
COUNT(*)  AS newcolumnname -> no of rows includng null   values                                           
COUNT(DISTINCT columnname) AS newcolumnname-> no of rows exluding duplicates

NUMBER FN -- https://dev.mysql.com/doc/refman/8.0/en/numeric-functions.html
ROUND(column , precision optional) AS newcolumnname  -> returns newcolumnname with round of number upto precision
CEIL(column) AS newcolumnname  -> returns newcolumnname with elements being  ceil of number 
FLOOR(column) AS newcolumnname  -> returns newcolumnname with elements being  floor  of number 
ABS(column) AS newcolumnname  -> returns newcolumnname with elements being   absolute  of number 
RAND() AS newcolumnname  -> returns newcolumnname with elements being   random number 

STRING  FUNCTION(INDEX STARTS FROM 1 NOT 0) -- https://dev.mysql.com/doc/refman/8.0/en/string-functions.html
LENGTH(column) AS newcolumnname  -> returns newcolumnname with elements being  length of string
UPPER(column) AS newcolumnname  -> returns newcolumnname elements being  uppercase of string
LOWER(column) AS newcolumnname  -> returns newcolumnname  elements being  owercase of string
LTRIM(column) AS newcolumnname  -> returns newcolumnname elements being   string trimmed from left side for whitespace
RTRIM(column) AS newcolumnname  -> returns newcolumnname elements being   string trimmed from right side for whitespace
TRIM(column)  AS newcolumnname  -> returns newcolumnname elements being   string trimmed from both side for whitespace
LEFT((column , n)  AS newcolumnname  -> returns newcolumnname elements being   string with first n char from left
RIGHT(column,n) AS newcolumnname  -> returns newcolumnname elements being   string with first n char from right
REPLACE(column,‘char1’, ‘char2’) AS newcolumnname  -> returns newcolumnname with replace char1 with char2 in a string 
CONCAT(column1,’ ’ ,column2) AS newcolumnname  -> returns newcolumnname with concatenating 2 columns with space
LOCATE(‘char’ column) AS newcolumnname  -> returns newcolumnname with index of the first occurrence  character in string search is case insensitive , and if not found returns o
SUBSTRING(‘string ’,start,end) AS newcolumnname  -> returns newcolumnname elements being string from start to end both includedstart default =1  , end default = last char

DATE FUNCTIONS    -https://dev.mysql.com/doc/refman/8.0/en/date-and-time-functions.html                           
YEAR/MONTH/DAY/HOUR/MINUTE/SECOND(column) AS newcolumnname  -> returns newcolumnname with column'd year OR month OR date OR hour OR minute OR second as integer
YEARNAME/MONTHNAME/DAYNAME/HOURNAME/MINUTENAME/SECONDNAME(column) AS newcolumnname  -> returns newcolumnname with column'd year OR month OR date OR hour OR minute OR second as string
DATE_FORMAT(column , % y % Y % m % M %d %D) AS newcolumn--> returns newcolumn with colum's  Year(2 digit ) year(4 digit),month(2 digit), month(4 digti). as string                                                                                                                 
DATE_ADD(column INTERVAL n YEAR/MONTH/DAY/HOUR/MINUTE/SECOND) AS newcolumn --> returns newcolumnname with column's date + n year OR n month OR n date ORn  hour OR n minute OR n second
DATE_SUB(column INTERVAL n YEAR/MONTH/DAY/HOUR/MINUTE/SECOND) AS newcolumn ->returns newcolumnname with column's date - n year OR n month OR n date ORn  hour OR n minute OR n secondth,day,hour,minute,second
DATE_DIFF(colum1,column2 ) AS newcolumn --> returns newcolumnname with difference between 2 dates in years
TIME_TO_SEC(colum1) AS newcolumn --> returns newcolumnname converting time to seconds
NOW()   -->returns current date with tme 
EG
SELECT *
FROM orders
WHERE YEAR(order_date) = YEAR(NOW())

EG
SELECT DATE_FORMAT(now() ,  %M  %Y) -> 2019 MARCH
FROM orders



4.IFNULL , COALESCE
IFNULL(columname, ‘value’) AS newcolumname --> returns 1st non null value Ie if column1 not null return column 1 ,if column1 null return ‘value’
COALESCE(colum1,column2,… ‘value’) AS newcolumname --> returns 1st non null value  Ie if column1 not null return column1 , if column1 null return column2 , if column2 null return value
EG
USE sql_store;
SELECT order_id,IFNULL(shipper_id,’NOT ASSIGNED’)COALESCE(shipper_id,comments , ’NOT ASSIGNED’)


5.IF,CASE
IF(expression , ‘value1’, ‘value 2’) AS  columnname2--> returns value1 for true condition , value2 for false condition
CASE                                                 --> returns value acc to condition
WHEN expression THEN ‘value1’
WHEN expression THEN ‘value2’
ELSE ‘value3’
END AS columname
EG1
USE sql_store;
SELECT product_id,p.name,COUNT(*) AS orders,IF(quantity = 1 , 'ONCE' ,'MANY TIMES') AS frequency
FROM products p
JOIN order_items o USING (product_id)
GROUP BY p.product_id ,p.name
ORDER BY p.product_id

EG2
USE sql_store;
SELECT CONCAT(first_name, ' ' ,last_name) AS customer ,
    points,
    CASE
    WHEN (points < 2000) THEN 'BRONZE'
    WHEN (points >=2000 AND points <=3000) THEN 'SILVER'
    ELSE 'GOLD'
    END AS category 
FROM customers



*/


//CREATE , ALTER ,USE ,DROP(DB,TABLE,VIEW,STOREDPROCEDURE,FUNCTION,TRIGGERS,EVENTS,TRANSACTION(ACID),INDEXES)
/* #region Main */

//DATABASE
/*
Database Store Tables , views , stored procedures , functions

1.CREATE DATABASE
DROP DATABASE IF NOT EXISTS
CREATE  DATABASE  databaseName

2.ALTER DATABASE
ALTER  DATABASE  databaseName


3.USE DATABASE
Database--> Use database as a database to store table,views,stored procedures, functions

4.DROP DATABASE
DROP DATABASE IF NOT EXISTS
*/

//TABLE
/*
Table stores Indexes and Triggers

1.CREATE TABLE
USE database_name ;                        -->Create tablename
DROP TABLE IF EXISTS foreignkeytable;      -->foreignkey table must be dropped first
DROP TABLE IF EXISTS primarykeytable;      
CREATE TABLE table_name(                              
       columnName  DATATYPE  FLAGS/KEYS     --> DATATYPE (Look in datatypes,keys,flags)    
);                                             CHAR (x)  , VARCHAR (x),  TINYTEXT, TEXT ,MEDIUMTEXT ,LONGTEXT TINYINT(ZF)   ,SMALLINT(ZF) 
                                               MEDIUINT(ZF) , INT(ZF) ,BIGINT(ZF) FLOAT(d , p)  , DOUBLE(d , p) ,  DECIMAL/DEC/NUMERIC/FIXED(d , p)    
                                               TIMESTAMP, DATETIME . DATE . TIME , YEAR
                                               BOOLEAN/BOOL 
                                               JSON  
                                               TINYBLOB BLOB, MEDIUM BLOB , LONG BLOB  
                                               ENUM(‘val1’,’val2’)   , SET(‘val1’,’val2’)                            

                                               FLAGS(Look in datatypes,keys,flags)
                                               NOT NULL , UNIQUE ,BINARY ,AUTO_INCREMENT , DEFAULT VALUE

                                               KEYS(Look in datatypes,keys,flags)
                                               Primary key-> columNname  PRIMARY KEY  NOT NULL  AUTO_INCREMENT(optional)
                                               Foreign Key->FOREIGN KEY  fk_foreignKeyTable_primaryKeyTable(primary_key)
                                                           REFERENCES primaryKeyTable(primary_key)
                                                           ON UPDATE  NO ACTION/RESTRICT/SET NULL/CASCADE   choose cascade
                                                           ON DELETE NO ACTION/RESTRICT/SET NULL/CASCADE      choose  restrict

2.ALTER  TABLE 
ALTER TABLE tableName                                                          --> alters table
      ADD columnName DATATYPE FLAGS/KEYS   AFTER column_name, DATATYPE:        -->DATATYPE (Look in datatypes,keys,flags)  
      MODIFY columnName DATATYPE   FLAG/KEYS ,                                    same as create
      DROP column_name                                                                            
;                                                                                 FLAGS(Look in datatypes,keys,flags)
                                                                                  Same as create
                                                    
                                                                                   KEYS(Look in datatypes,keys,flags)                               
                                                                                   Primary key->ADD PRIMARY KEY (columnames which are primary key)
                                                                                                DROP PRIMARY KEY 
                                                                                    FOREIGN  KEY-->ADD/DROP FOREIGN KEY  fk_FKTable_PKTable(primary_key)
                                                                                                   REFERENCES primaryKeyTable(primary_key)
                                                                                                   ON UPDATE  NO ACTION/RESTRICT/SET NULL/CASCADE   --choose cascade
                                                                                                   ON DELETE NO ACTION/RESTRICT/SET NULL/CASCADE    --choose restrict


3.USE  TABLE 
tablename--> Use the tablename iin queries

4.DROP TABLE 
DROP TABLE IF EXISTS foreign_key_table






EG             
1.CREATE TABLE           
USE sql_store;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS customers;

CREATE TABLE customers(
Customer_id  INT         PRIMARY KEY  NOT NULL  AUTO_INCREMENT,
first_name   VARCHAR(50)  NOT NULL,
points       INT          NOT NULL  DEFAULT 0,
first_name   VARCHAR(50)  NOT NULL UNIQUE
);


CREATE TABLE orders (
order_id     INT   PRIMARY KEY  NOT NULL  AUTO_INCREMENT,
customer_id  INT   NOT NULL,
FOREIGN KEY  fk_orders_customers(customer_id)
            REFERENCES customers(customer_id)
            ON UPDATE  CASCADE
            ON DELETE RESTRICT
);

2.ALTER TABLE
USE sql_store
ALTER  TABLE customers(
ADD       last_name  VARCHAR(50) NOT NULL             AFTER first_name , 
ADD       city       VARCHAR(50) NOT NULL  DEFAULT 0,
MODIFY first_name    VARCHAR(50) NOT NULL DEFAULT '',
DROP points
;

ALTER TABLE orders
ADD PRIMARY KEY(order_id),
DROP PRIMARY KEY,
ADD FOREIGN KEY  fk_orders_customers(customer_id)
                 REFERENCES customers(customer_id)
                 ON UPDATE  CASCADE
                 ON DELETE RESTRICT
;



*/

//VIEW
/*
Store “query which returns a table”  in view  ; view  can be used as a table
1.Simplifying queries: complex subquery in view , we can further use  the view in place of subquery
2.Changes :Table has 10 queries depending on it; and if we change a columname in table  then we need to change all the  10 queries.
           Instead if all 10 queries depend on  view; we  need to change columname in views code only  
3.Security:We can update views and keep main table safe

1.CREATE VIEW
USE databaseMame;
CREATE  OR REPLACE viewTableName AS 
QUERY                                  --> Query used   doesn’t have DISTINCT , AGGREGATE FNS , GROUP BY , HAVING , UNION                                                             
WITH CHECK OPTION                      -->updating view causes some rows to vanish due to some default behaviour ; .So if  WITH CHECK        
                                           prevents this and instead throws  err.So for updatig WITH HECK should not throw error
2.ALTERING VIEW  
No command for altering stored procedure
But can be done in SQL WorkBench

3.USING   VIEW 
USE databaseMame;
tablename                               -->View can be used as a table for SELECT ;INSERT , UPDATE , DELETE etc  but it must be updatable and must have 2  things 


4.DROPPING VIEW
USE databaseMame;
DROP VIEW IF EXISTS viewTableName;      -->DROPS the VIEW if it exists




EG 1
1.CREATING
USE sql_invoicing;
CREATE VIEW balance_table AS 
   SELECT c.client_id,
   c.name,
   SUM(i.payment_total - i.invoice_total) AS difference
   FROM clients c
   JOIN invoices i USING (client_id) 
   GROUP  BY c.client_id, c.name 
   ORDER BY c.client_id
   WITH CHECK OPTION

3.USING
SELECT *
FROM balance_table

UPDATE balance_table
SET name =’prasann’
WHERE client_id = 1
*/


//STORED PROCEDURE
/*
store “query which returns a table” in stored procedure ;stored proc can be called 
1.Store, organise : Store procedure  are used to store and organise SQL 
2. Optimization: stored procedure contains code that is ised for faster optimization
3.Security : We can update store procedures and keep main table safe


1.CREAING STORED PROCEDURES
USE databaseName;
DELIMITER $$                                       --> Select of query retutns a table ,wich   is stored as a view in “STORED PROCEDURE” section                                                   
DROP PROCEDURE IF EXISTS  fnname;                   
CREATE PROCEDURE fnname(parameter datatype)                      
BEGIN                         |
     Query;                   |
END $$      |                 |
DELIMITER ; |                 |
OR          |                 |
            |                 |
            |                 |---------------------------------------------------------------------------
            |                                                                                             |
; -->Every query ends with a semicolon as usual                                                           |
    Also last query must end with semicolon, unlike usual                                                 |
$$-->We reset the DELIMITIR(end of query symbol) to some random value                                     |
      As we are using ; in  query and then we again reset DELIMITIR to org value ;                        |
                                                                                                          |
                                                                                                          |
                                                PARAMETERS: 
                                                1.Parameter clash-->To prevent parameter and columname in query clash either write parameter as 
                                                                     p_parameter  OR use tablename.columname in subquery
                                                                     EG 2 
                                                2.Parameter = invalid-->IF parameter _condition THEN   
                                                                        SIGNAL SQLSTATE'22030’ ('Out of bound error’)  https://www.ibm.com/support/knowledgecenter/SSEPEK_11.0.0/codes/src/tpc/db2z_sqlstatevalues.html
                                                                        SET MESSAGE_TEXT =  'invalid amount';
                                                                        END IF ;
                                                                        EG 3
                                                3.Parameter = NULL-->IF parameter IS NULL THEN 
                                                                     SET parameter = default value
                                                                     END IF;
                                                                     OR 
                                                                     WHERE columnn1 = ISNULL(column2,defaultvalue)
                                                                     default value = column1 if you want to SELECT * for NULL parameter
                                                                     EG 4

                                               DATATYPE (Look in datatypes,keys,flags)    
                                               CHAR (x)  , VARCHAR (x),  TINYTEXT, TEXT ,MEDIUMTEXT ,LONGTEXT TINYINT(ZF)   ,SMALLINT(ZF) 
                                               MEDIUINT(ZF) , INT(ZF) ,BIGINT(ZF) FLOAT(d , p)  , DOUBLE(d , p) ,  DECIMAL/DEC/NUMERIC/FIXED(d , p)    
                                               TIMESTAMP, DATETIME . DATE . TIME , YEAR
                                               BOOLEAN/BOOL 
                                               JSON  
                                               TINYBLOB BLOB, MEDIUM BLOB , LONG BLOB  
                                               ENUM(‘val1’,’val2’)   , SET(‘val1’,’val2’)                            
           
                                                USER SESSION VARIABLES-
                                                Until you diconnect from server
                                                SET @variablename = value

                                                LOCAL VARIABLE-
                                                Only for stored procedures
                                                DECLARE variablename datatype = value DEFAULT defaultvalue
                                                SELECT FN(columname),FN(columname2) INTO variablename1,variablename2
                                                SET variablename = value;
                                                                     
2.ALTERING STORED PROCEDURE CODE 
No command for altering stored procedure
But can be done in SQL WorkBench

        
3.USING STORED PROCEDURES
USE database_name;
CALL fnname()                                  --> call the stored procedure as function() 


4.DROPPING STORED PROCEDURE
USE database_name;
DROP PROCEDURE IF EXISTS fn_name;              -->DROPS the STORED PROCEDURE  if it exists



EG1
1.CREATE STORED PROCEDURE
DROP PROCEDURE IF EXISTS get_invoice_balance
USE sql_invoicing;
DELIMITER  $$
CREATE PROCEDURE get_invoice_balance()
BEGIN
	SELECT * 
	FROM invoices 
	WHERE payment_total  - invoice_total > 0 ;
END$$
DELIMITER ;

3.USE 
USE sql_invoicing;
call get_invoice_balance();

EG 2
1.CREATE STORED PROCEDURE
DROP PROCEDURE IF EXIST get_clients_invoices()
DELIMITER $$                                             
CREATE PROCEDURE get_clients_invoices(
           client_id INT 
          )
BEGIN
	SELECT * 
	FROM invoices i 
	WHERE i.client_id = client_id;
END $$
DELIMITER $$

3.USE 
USE sql_invoicing;
call get_invoice_balance(1);

EG 3 
1.CREATE STORED PROCEDURE
 USE sql_invoicing;
DROP PROCEDURE IF EXISTS make_payments;
DELIMITER $$
CREATE PROCEDURE make_payments(
	invoice_id INT,
   payment_amount DECIMAL(9,2),
   payment_date DATE
)
BEGIN
   IF payment_amount <=0 THEN 
      SIGNAL SQLSTATE '22030'
      SET MESSAGE_TEXT =  'invalid amount';
   END IF ;

   UPDATE invoices i 
   SET 
      i.payment_total = payment_amount,
      i.payment_date = payment_date
   WHERE i.invoice_id = invoice_id; 
END $$
DELIMITER;


3.USE 
USE sql_invoicing;
call make_payments(2,100,’2019-12-22’)

EG 4
1.CREATE STORED PROCEDURE
USE sql_invoicing;
DROP PROCEDURE IF EXISTS get_cients_by_state;
DELIMITER $$
CREATE PROCEDURE make_payments(
	State  CHAR(2)
)
BEGIN
   IF state IS NULL  THEN 
         SET state = ‘CA’	
   END IF ;
   SELECT * 
   FROM clients c
   WHERE c.state = state
   OR
   SELECT * 
   FROM clients c
   WHERE c.state = IFNULL(state , ‘CA’ if you want default value CA / c.state if you want default value *)
END $$
DELIMITER ;

3.USE 
USE sql_invoicing;
call make_payments(2,100,’2019-12-22’)

EG 5
1.CREATE STORED PROCEDURE
USE sql_invoicing;
DROP PROCEDURE IF EXISTS get_risk_factor;
DELIMITER $$
CREATE PROCEDURE get_risk_factor ()
BEGIN
   DECLARE invoice_count INT;
   DECLARE invoice_total DECIMAL(9,2);
   DECLARE risk_factor DECIMAL(9,2) DEFAULT 0;

   SELECT Ccount(*) , SUM(invoice_total) INTO  invoice_count , invoice_total FROM invoices;
   SET risk_factor = invoice_total/invice_count * 5;


   SELECT risk;--> return table with nly risk column
END $$
DELIMITER ;

3.USE 
USE sql_invoicing;
call get_risk_factor()


*/

//FUNCTION
/*
Store “query which returns a single value” in function ;function can be called
1.User defined fns : We cab use User defined fns just like inbuilt SUM() , COUNT() etc


1.CREAING FUNCTIONS
USE database_name;
DELIMITER $$                                                    
DROP FUNCTION  IF EXISTS  fnname;                  --> Select of query retutns a value not table ,wich   is stored as a view in “FUNCTION”
CREATE PROCEDURE fnname(parameter datatype) 
ATTRIBUTE CLAUSES        |                                          
BEGIN            |______ |                                   
     Query;              |                            
RETURN 1;    |           |                                 
END $$       |           |
DELIMITER ;  |           |                              
             |           |                             
             |           |
; $$ :Same as            |                                               
      Store Procedure    |
                         |
                 PARAMETER
                 Same as Stored Procedure
       
                 CLAUSES
                  1.COMPULSARY CLAUSE:
                  RETURN  RETURNTYE--> tells type of value fn returns 
                  RETURN 1;      --> FN must return atleast atleast 1 value so we return 1 for returntype INTEGER before END

                  2.ATLEAST 1 OF BELOW CLAUSE MUST BE USED :
                  DETERMINISTC; --> Fn  takes attribute and returns op detirministicly EG fn (income){tax = income/10;return tax }
                  READS SQL DATA--> Fn has SELECT statement to read some data
                  MODIFIES SQL DATA --.> Fn has INSERT , UPDATE , DELETE statement to modify data

2.ALTERING FUNCTIONS 
No command for altering stored procedure
But can be done in SQL WorkBench

                                                                                                               
        
3.USING FUNCTIONS
USE database_name;
fnname(columname)                                  --> call the functions just like SUM() , COUNT() 


4.DROPPING  FUNCTIONS
USE database_name;
DROP FUNCTION  IF EXISTS unctionname;              -->DROPS the FUNCTION  if it exists



EG 1
1.CREATE FUNCTION
USE sql_invoicing;
DROP FUNCTION  IF EXISTS get_risk_factor_for_client;
DELIMITER $$
CREATE FUNCTION get_risk_factor_for_client (
                 Client_id INT )
RETURNS INTEGER
READS SQL DATA
BEGIN
   DECLARE invoice_count INT,
   DECLARE invoice_total DECIMAL(9,2),
   DECLARE risk_factor DECIMAL(9,2) DEFAULT 0

   SELECT Ccount(*) , SUM(invoice_total) 
   INTO  invoice_count , invoice_total 
   FROM invoices i
   WHERE i.client_id = client_id;

   SET risk_factor = invoice_total/invice_count * 5;

   RETURN risk;--> return table with only risk value
END $$
DELIMITER ;

3.USE 
USE sql_invoicing;
SELECT client_id,
      name,
      get_risk_factor_for_client ( Client_id INT ) AS risk_factor
FROM clients


*/

//TRIGGERS
/*

Block of code that triggers before/after INSERT,UPDATE,DELETE

1.CREAING TRIGGERS
USE database_name;
DELIMITER $$                                                    
DROP TRIGGER  IF EXISTS  trigger_name;                  --> Trigger  query before/after an INSERT , UDATE , DELETE 
CREATE TRIGGER trigger_name                                 MY SQL WRAPS EVERY INSERT ,UPDATE ,DELETE IN TRIGGER BY DEFAULT
AFTER/BEFORE INSERTS/UPDATE/DELETE ON tablename  FOR EACH ROW
BEGIN            |                                      
     Query;OLD/NEW                                       
END $$          |
DELIMITER;      |
                |            
; $$ :Same as   |                                                          
     stored prc |  
               AFTER /BEFORE
               We want to trigger query After/ Before  INSERT   ,UPDATE , DELETE

               NEW/OLD 
               NEW = tablename  if you want to trigger query  AFTERBEFORE  INSERT   ,UPDATE 
               OLD= tablename  if you want to trigger query  AFTERBEFORE DELETE

               Tablename :
               able after INSERT/UPDATE/DELETE  , this table cant be the table used in query
                                                                                                                
2.ALTERING TRIGGER 
No command for altering stored procedure
But can be done in SQL WorkBench

      
3.USING TRIGGERS
USE database_name;
INSERT/UPDATE/DELETE tablename--> Triggers the query 


4.DROPPING TRIGGERS
USE database_name;
DROP TRIGGER IF EXISTS  trigger_name;           -->DROPS the TRIGGER   if it exists



EG
1.DECLARING TRIGGERS
USE sql_invoicing;
DROP TRIGGER  IF EXISTS  payments_after_insert
DELIMITER $$
CREATE TRIGGER AFTER INSERT ON payments FOR EACH ROW
BEGIN
   UPDATE invoices i
   SET i.payment_tota = i.payment_total + NEW.amount
   WHERE  i.invoice_id = NEW.invoice_id;
END $$
DELIMITER ;

3.USE
INSERT INTO payments
VALUE(DEFAULT , 5 , 3 , ‘2019-01-01’,10,1)


*/

//EVENTS
/*
Block of code that triggers at given event


1.CREAING ENEVTS
USE database_name;
DROP EVENTS IF EXISTS  event_name;                  --> Trigger  query scheduled for event 
DELIMITER $$                                                    
CREATE EVENT  event_name
ON SCHEDULE----
DO BEGIN       |                                      
     Query;    |
END $$         |
DELIMITER ;    |
               |             
               |            
; $$ :Same as  |                                                              
    store proc |  
              ON SCHEDULE
              ON SCHEDULE 
              AT  ‘YYYY-MM-DD’ :->Triggers query at given year
              EVERY  n YEAR/MONTH/DAY/HOUR/MINUTE/SECOND                     -->Triggers query at interval of n year,month….
              EVERY  n YEAR/MONTH/.  STARTS ‘YYYY/MM/DD’ ENDS  ‘YYYY/MM/DD’  -->Triggers query at interval of n 
                                                                                 year,month…. Starting fro datee1 till date2




2.ALTERING EVENTS 
No command for altering stored procedure
But can be done in SQL WorkBench

3.USING EVENTS
USE database_name;
triggers--> Triggers automatically at set event 


4.DROPPING EVENTS
USE database_name;
DROP EVENT IF EXISTS  event_name;            -->DROPS the EVENT   if it exists


EG
1.DECLARING TRIGGERS
DROP EVENTS IF EXISTS  yearly_delete_sale_audit_rows;                   
DELIMITER $$                                                    
CREATE EVENT  yearly_deletesale_audit_rows
ON SCHEDULE
EVERY 1 YEAR STARTS  ’2019-01-01’  ENDS ‘2029-01-01’
DO BEGIN                                             
   UPDATE customer SET value = ‘VA’ where cust_id = 1;          
   UPDATE order SET status = 1 where order_id = 1
END $$          
DELIMITER ;  

3.USE
Trigger as per schedule


*/

//TRANSACTION
/*
1. ACID PROPERTIES 
Consistency – Databas remains consistent
Durability  –Changes made after commiting  transaction are permanent 
Atomicity    –Each transaction is a an unit and all all statements must be sucessful for transaction to be sucessful 
              So if 2nd statement fails due to err,pow failure , disconnection etc we ROLLBACK and  1st statement is undone.
Isolation   – Multiple Transactions running in concurrency are isolated from each other based on different levels
              So  is 2 transactions update the table then they are seperated from each othern
               1.CONCURRENCY ISSUES
               a.LOST UPDATES -->transactionn updatescolumn with  values which are  lost
               Name = JOHN ,State = NY, points = 10
               TA                     TB
               Update sate = ‘VA’     ---                              
               ---                   Update sate = ‘NY’.-->TA updates ‘state = VA;’ TB updates ‘pts = 20’,state =’NY’ 
               ---                   Update pts = 20       TA has not commited  yet and TB overwrites the ‘state’
              COMMIT                   COMMIT                so state = ‘VA update lost’       
                                    

               b.DIRT READS-->transaction reads column  and gets value  that doesn’t exists 
               Name = JOHN ,State = NY, points = NULL
               TA                TB
               Update pts = 10   ----
               ----             SELECT points ->TA updates pts = 10;TB reads the points  but later TA rollsback due 
               ROLLCAKS          COMMIT          but later TA rollsback due  to err and due to atomicitty UPDATE is 
                                                undone so TB reads data that’s not there at all

               c.NON REPEATABL READS/INCONSISTENT READS transaction read same col twice and get 
               Name = JOHN ,State = NY, points = 10                            different values
               TA                   TB
               SELECT points        ---
               ---                  UPDATES points -->TA reads points  ;TB updates points ; TA reads points
               READS points         ----                and this time gets different value compared to 1st read
               COMMIT               COMMIT

               d.PHANTOM  READS transaction reads column and value gets  skipped or unnecessary
               Name = JOHN ,State = NY, points = 10     value appears                       
               TA                   TB
               SELECT  points>10    ----
                                    UPDATES points--> TA readsvalues for  points>10 , TB updates points ,
               Give them discount   -----             TA give discount to points > 10 but TB has updated
               READS points          ----             points so people who are < 10 get discount and
               COMMIT               COMMIT           People > 10 might get skipped

               
            **Rollback meaning:if there is err in statement2 rollback and undo statement1;
            COMMIT:Rollback when there is an err
            ROLLBACK:roillback manually
                                                                                                   
        
            2.ISOLATION  TYPES(LEVELS OF ISOLATION)
            READS UNCOMMITED         --> reads any data
            READ COMMITED            --> reads commited data only
            REPEATABLE READ(DEFAULT) -->reads initial data only don’t look at changed data
            SERIAZIBLE               --> Transactions run serially so until T1 doesn’t commit T2 doesn’t allow to do 
                                       anything and it shows waiting sign
                                      LostUpdates  DirtyReads NonRepeatingReads PhantomReads
              READS UNCOMMITED  
              READ COMMITED                          Y
              REPEATABLE READ(DEFAULT) Y             Y        Y                 
              SERIAZIBLE               Y             Y        Y                 Y

              AS we go down we concurrency protection  inc    
              but mem and time requirements also increase 

              3.ISOLATION SESSIONS
               --(nothing written)  -next immediate transaction
               SESSION              –transaction for session till DB disconnects    
               GLOBAL - transaction for all future sessions



   
2. ACID PROPERTIES USING TRANSACTION
SET  ISOLATIONSESSIONS TRANSACTION ISOLATION LEVEL ISOLATIONTYPES--> set the isolation configurations
START TRANSACTION  --> create a transaction 
    Query; 	                                      
COMMIT/ROLLBACK;  -->ISOLATIONSESSIONS
                  Explaned above in ISOLATION

                  ISOLATION LEVEL
                  This is a keyword and part of the command

                  ISOLATIONTYPES
                  Explaned above in ISOLATION

                  COMMIT/ROLLBACK
                  Rollback meaning:if there is err in statement2 rollback and undo statement1;
                  COMMIT:Rollback when there is an err                                           
                  ROLLBACK:roillback manually


                  a.ATOMICITY
                  COMMIT/ROLLBACK:  MY SQL wraps INSERT , UPDATE , DELETE in transactions by default and COMMITS/ROLLBACKS
                                    commit/rollback rollbacks when there is err in statement2 and undo statement1
                                    EG 
                                    SET   TRANSACTION ISOLATION LEVEL READ UNCOMMITTED
                                    USE sql_store;
                                    START TRANSACTION                             
                                       INSERT INTO orders(customer_id,order_date,status)
                                       VALUES(1,’2019-01-01’,1);

                                       INSERT INTO order_items
                                       VALUES(LAST_INSERT_ID(), 1,1,1);    
                                    COMMIT;                                
                                    --> If  2nd  INSERT  fails or If while executing 2nd INSERT we 
                                       disconnect to DB  it will ROLLBACK and undo 1st    INSERT

                  b.ISOLATION
                  LOCK    :MY SQL wraps INSERT , UPDATE , DELETE in transactions by default and puts a LOCK on them    
                           Lock doesn’t allow other transaction’s to performoperation INSERT , UPDATE , DELETE unless current transaction COMMITS or ROLLSBACK
                           EG1
                  DEADLOCK:If the lock of 2 transaction are  dependant usually due to reverse order of statement  then we get deadlock ,
                           In that case MYSQL considers one transaction  as victim and exists deadlock with err message
                           EG2

                           EG1 
                           TA                                         TB 
                           USE sql_tore;                              USE sql_store;
                           START TRANSACTION;                         START TRANSACTION;
                              INSERT INTO orders(customer_id, status)    INSERT INTO orders(customer_id,date,status)
                              VALUES(1,1);                               VALUES(1,1);
                           COMMIT;                                    COMMIT;
                           -->TA execute line1  , execute line 2 , execute line 3(LOCK for INSERT orders) ;not executed commit yet
                              TB execute line 1 ,  execute line 2 ; cant execute line 3 due to lock for INSERT order
                              TA execute line 4 and commit(UNLOCK for INSERT order)
                              TB execute line 3(LOCK for INSERT order) , execute line  4 and commit(unlock for INSERT order)

                           EG2
                           TA                                                     TB
                           USE sql_store;                                        USE sql_store;
                           START TRANSACTION;                                    START TRANSACTION;
                           UPDATE customer SET value = ‘VA’ where cust_id = 1;   UPDATE order SET status = 1 where order_id = 1;
                           UPDATE order SET status = 1 where order_id = 1;       UPDATE customer SET value = ‘VA’ where cust_id = 1;
                           COMMIT;	 				       COMMIT;							
                           -->TA execute line 1 , line 2 , line 3(LOCK for the  UPDATE customers) , 
                              TB execute line 1 , line  2  , line 3 (LOCK for the UPDATE orders) , 
                              TA cant  execute line 4  cant due to LOCK for UPDATE orders
                              TB cant  execute line 4  cant due to LOCK for UPDATE customers	




*/

//INDEXES
/*
Optimize query:Store the column in  binary tree  in ascending order  as a result we have 
               provides faster lookup  , faster sorting
               Increase database , Slow down writing 
               Eg
               Id   first_name   last_name    state --> To find state = ‘CA’ we have to move across all states
                                                         To order by state we have to use  FILESORT which is expensive 
                                                         Extra database apart from table not require
                                                         Writing is fast
                                                                                                          

               Id   first_name   last_name    state  Index  = state  --> To find state = ‘CA’ we have to look in binary which is fast 
                                                                         To order by state we have to use index which is already sorted 
                                                                         Extra database required for storing index
                                                                         Writing is slow as we have to reference through index

Dint understand Indexes.
I have kept Indexes in SQL WorkBench Docs at the very bottom
*/

//


/* #endregion */


//USE,SELECT,INSERT,UPDATE,DELETE,SUBQUERY
/* #region Main */


//USE
/*
USE databaseName -->Database to be used 
*/

//SELECT
/* #region Main */

/*
(
SELECT columnname
FROM tablname
JOINTYPE JOIN tablname ON cond
WHERE cond             
GROUP BY col1,col2     
HAVING cond            
ORDERBY col1,col2      
LIMIT offset ,n OR  LIMIT n,OFFSET
UNION 
)
*/

//SELECT
/*
SELECT columnname -->select column from table 
*/                                                      

//FROM
/*
FROM tablname --> selectfrom table from database 
*/

//JOIN --https://dk81.github.io/dkmathstats_site/set-theory-sql.html 
/*
FROM table1                                          
INNER       JOIN table2 ON table1.column = table2.column  -->join table2 after table1 with records that have matching values in both tables                                  
LEFT OUTER  JOIN table2 ON table1.column = table2.column --> Join table2 after table1 with records that have matching values in both tables and all records of table1
RIGHT OUTER JOIN table2 ON table1.column = table2.column --> Join table2 after table1 with records that have matching values in both tables and all records of table2
FULL OUTER  JOIN table2 ON table1.column = table2.column --> Join table2 after table1 with records that have matching values in both tables and all records of table1 and table 2
CROSS       JOIN table2                                  --> Join table2 after table1 by joining every row in t1 to every row in t2
NATURAL     JOIN table2                                  -->join table2 after table1 by finding common column name and performing inner join; 
                                                            the only diff is that in inner join the common columnName is repeated twice in the joined table(one of t1 other of t2) 
                                                            but in natural join we have only 1 column
                 
                                                         -->SELF  JOIN, NORMALJOIN ,COMPOUND JOIN ,MULTIPLE JOIN 
                                                            table1 ON table1.column = table1.column   -->Join same table           
                                                            table2 ON table1.column = table2.column   -->Join 2 table 
                                                            table2 ON table1.column1 = table2.column1 -->Join 2 table when table1 ka col1 does not have unique elements so you use col2 along with col1 to forn unique key(COMPOSITE KEY)
                                                            table2 ON table1.column2 = table2.column2   
                                                            table2 ON table1.column = table2.column   -->Join multiple table 
                                                            table3 ON table1.column = table3.column  

                                                         -->WHERE CLAUSE,USING CLAUSE
                                                            FROM t1                          -->FROM t1  ,t2             --> Replace  condition after ON with WHERE  and shif table2 to FROM (Only for inner joins)
                                                            JOIN t2  ON t1.column = t2.column  WHERE t1.column = t2.column 

                                                            FROM  t1                          --> FROM table t1           -->Replace Join condition  with common columnname   by USING(columnname , columnname)                                                                    
                                                            JOIN t2 ON t1.column = t2.column     JOIN customers t2 USING(cust_id)
                                                            

                                                            EG(INNER JOIN):
                                                            orders table  has customer_id; customers_table  has customer_id
                                                            Join orders table and customers_table for matching customers_id an
                                                            SELECT orders.customer_id
                                                            FROM orders 
                                                            INNER JOIN customers  ON  orders.cust_id =customers.cust_id 

                                                            EG(OUTER JOIN):
                                                            orders table  has customer_id; customers_table  has customer_id
                                                            Join orders table and customers_table for matching customers_id and include all rows of customer table and order by orders table cust_id
                                                            SELECT *
                                                            FROM orders o
                                                            LEFT OUTER JOIN  customer c   ON o.customer_id  = c.customer_id 
                                                            ORDER BY o.customer_id

                                                            EG(CROSS JOIN):
                                                            orders table and products table 
                                                            Join every row in orders table to every row in  products table 
                                                            SELECT c.first_name , p.first_name
                                                            FROM  customer c
                                                            CROSS JOIN products p 

                                                            EG(COMPOUND JOIN):
                                                            order_items table which has order_id (does not have uniqueelements) ,product_id ; Order_item_notes table has note order_id , product_id.
                                                            Join  order_items with order_id
                                                            SELECT oi.order_Id,oi.product_id,oin.order_Id
                                                            FROM order_items oi
                                                            JOIN order_item_notes oin ON oi.order_Id = oin.order_Id
                                                                                    AND oi.product_id = oin.product_id


                                                            EG(MULTIPLE JOIN):
                                                            orders table  has customer_id,status ; customers_table  has customer_id; order_status table  has order_status_id.
                                                            Join orders table with  customers table acc to customer_id and join orders table with order_status  table acc to status and order_status_id.
                                                            SELECT o.customer_id ,c.customer_id,os.order_status_id
                                                            FROM orders o
                                                            INNER JOIN customers c ON o.customer_id = c.customer_id
                                                            INNER JOIN order_statuses os ON o.status = os.order_status_id

                                                            EG(MULTIPLE JOIN):
                                                            Customer table which has customers_id;Orders table has customer_id, shipper_id;Shipper table tas shipper_id
                                                            Join orders table with customer table acc to customer_id  include all rows of customes table ; Join shipper table with orders table acc to shipper_id  include all rows of orders table
                                                            SELECT *
                                                            FROM customers c
                                                            LEFT OUTER JOIN  orders o ON c.customer_id  = o.customer_id 
                                                            LEFT OUTER JOIN  shippers s ON o.shipper_id = s.shipper_id

                                                            EG(WHERE CLAUSE)
                                                            SELECT *                                            SELECT*                    
                                                            FROM orders o                                   --> FROM orders o  ,customerc
                                                            JOIN customers c  ON o.cust_id = c.cust_id          WHERE o.cust_id = c.cust_id

                                                            EG(USING CLAUSE)                       
                                                            FROM orders o                                   --> FROM orders o                                                                           
                                                            JOIN customers c ON o.cust_id = c.cust_id           JOIN customers c USING(cust_id)

                                                            EG(USING CLAUSE)                                                                           
                                                            FROM order_items  oi                                         --> FROM order_items  oi                                                                                                                                                  
                                                            JOIN order_item_notes oin  ON oi.order_id = oin.order_id          JOIN order_item_notes oin  
                                                            AND oi.productid = oin.product_id                                 USING(order_id,product_id)
*/

//WHERE , HAVING , GROUPBY
/*
WHERE  condition -> 1.condition is applied on single column ie columnName
                    2.The column in condition must not necessarily be in SELECT statement
HAVING  condition ->1.condition  is applied on group ie fn(columnName)
                    2.The column in condition must be in SELECT statement
GROUPBY columnname->1.Groups same values in columnname together and convert them to  single row by using an aggregate fn 
                      in HAVING or SELECT clause
                    2.columnName must be in select statement 
                  ->CONDITION
                    <.>,<=,>=,!= or <>, : Returns rows where columname elements in Arithmetc operations
                    AND ,OR ,NOT        : Returns rows where columname elements  in Logical operators
                                         Eg :WHERE price NOT(a> b and c<=d) -> a <=b OR c > d)
                    IN (attributes)     : Returns rows where columname elements In List of attributes
                                          Eg WHERE State IN (‘MH’,’GJ’,’TN’)
                    BETWEEN(attr1 and attr2): Returns rows where columname elements lies  between attributes
                                             Eg WHERE  Points BETWEEN (1000 AND 2000) 1000 and 2000 inclusive 
                    IS NULL             :Returns rows where columname elements are NULL
                                         Eg:WHERE phone IS NULL –> returns where phone number is null
                                            WHERE shipped_date IS NULL –> returns whereshipped_date is null ie not shippe
                    IS NOT NULL         :Returns rows where columname elements are not  NULL
                                          Eg : WHERE phone IS NOT NULL
                    LIKE OPERATOR       :Returns rows where columname elements are LIKE  ‘RE’
                                         % - matches any no of  characters
                                         _ - matches single character
                                        EG :WHERE last_name LIKE ‘b%’ -> starts with b(case doesn’t matter) followed by any char
                                                WHERE last_name LIKE ‘%b’ -> any char and ends with b
                                                WHERE last_name LIKE ‘%b%’ -> has a character b 
                                                WHERE last_name LIKE ‘_y’ -> 1 character followed by y 
                                                WHERE last_name LIKE ‘____y’ -> 4 character followed by y
                    REGEX  OPERATOR : Returns rows where columname elements  are REGEXP  ‘RE’
                                     'anchor char modifier’--> anchor=$  ;   ^     
                                                               character = .   [char]  user_char
                                                               modifier = . *  +   ?  { }   <>     ()  |                 
                                                               supressions ,special character: \re gexpchar  \specialchar 
                                                               space , incomplete , number of characters           
                                                              -->LOOK IN PYTHON REGEX mostly used are *,$ ,[char],[char1-char2], |                                      
                                        EG :WHERE last_name REGEXP ‘field’ -> sring that have field anywhere
                                        WHERE last_name REGEXP ‘^field’ -> sring that  startswith field
                                        WHERE last_name REGEXP ‘field$’ -> sring that endswithwith field
                                        WHERE last_nameREGEXP ‘^fied|mac|r’ -> sring that startwith field or has mac or r
                                        WHERE last_name REGEXP ‘[gim]e’ -> string that has char g or i or m followed by e
                                        WHERE last_name REGEXP ‘[a-h]e’ -> string that has char a to h followed by e
                                        WHERE last_name REGEXP ‘(EY$)|(ON$)’ -> string that ends with EY or ON
                                        WHERE last_name REGEXP ‘(^MY)|(SE)’ -> string that starts with MY or contains SE
                                        WHERE last_name REGEXP ‘B[RU]’ -> string that cotains B followed by R or U

                    
                      
                    EG:
                    emp_id name  working_hour 
                    101    Bryan  12
                    103    Mike   10
                    104    Daren  5
                    105    Marie  8
                    106    Marco  9
                    107    Daren  12
                    108    Mike   10
                    109    Marco  6
                    110    Bryan  5

                    Eg:
                    SELECT * 
                    FROM employees  
                    WHERE working_hour > 9;     -->condition is applied on single column ie working_hour;working_hour not required in select    
                    emp_id name  working_hour 
                    101    Bryan  12
                    103    Mike   10
                    107    Daren  12
                    108    Mike   10

                    Eg:
                    SELECT name,SUM(working_hours)AS "Total working hours" 
                    FROM employees     
                    GROUP BY name;                -->Group all same name together then convert then to single row by using SUM in SELECT;name is required in  SELECT  
                    name  total_working_hour 
                    Bryan  17
                    Mike   20
                    Daren  17
                    Marie  8
                    Marco  15

                    Eg:
                    SELECT name,SUM(working_hours)AS "Total working hours" 
                    FROM employees     
                    GROUP BY name;                 -->Group all same name together then convert then to single row by using SUM in SELECT;name is require din  SELECT 
                    HAVING SUM(working_hours)>10   -->condition is applied on group ie SUM(working_hours) ; SUM(working_hours) required in select   
                    name  total_working_hour 
                    Bryan  17
                    Mike   20
                    Daren  17
                    Marco  15






*/

//ORDERBY
/*
ORDER BY columnname1,columnname2 ASC/DESC -->1.Order  elements acc to columnname1 in  ASC/DESC  order 
                                             and if columnname1 has same elements then for those same elements                                                                                                
                                             arrange acc to  columnname2 in ASC/DESC
                                            2.Column name can be 1 , 2 which are 1st , 2nd columnnames of SELECT
                                            
                                            EG:
                                            SELECT first_name,last_name,points*10 AS  score -->Order in asc order acc to 
                                            ORDER BY  score                                   score column
                                            
                                            EG:
                                            SELECT first_name,last_name,points*10 AS score -->Order acc to first_name in asc 
                                                                                            ORDER BY  1,2 DESC                                                              then last_name in desc


*/

//LIMIT
/*
LIMIT offset ,n OR  LIMIT n,OFFSET offset --> Skip rows upto offsets(defaut is 0) , then take   n rows
                                              Eg LIMIT 3 ->Take 1st 3 rows
                                                 LIMIT 7, 5 ->Skip 1st 7 rows , take next 5 rows
                                                 LIMIT 5,OFFSET 7   ->Skip 1st 7 rows , take next 5 rows


*/


//UNION
/*
Query1            -->combines columns returned by query1 and query2 vertically provided the column returned by both queries are equal number 
UNION                and  and the name of resulting column will be  column names returned by query1 ,            
Query2               ie in other words combines rows
                    Eg
                    USE sql_store;
                    SELECT first_name  --> give column named “first_name” with elements of first_name of  customers table followed by elements of  
                    FROM customers          name column from shippers table
                    UNION
                    SELECT name
                    FROM shippers



*/


/* #endregion */


//INSERT
/*
INSERT INTO tableName (columnnName1,columnName2)   --> insert "rows"  by giving  column some values
VALUES            (value1,value2),                 COLUMN
                  (value1,value2),                 If all colums of table  are to be included then column is optional
                                                   If column has a Default valuthen column is optional(Look at EG1)

                                                   VALUE 
                                                   Depending on dataType of column we give values
                                                   CHAR , VARCHAR–> ''
                                                   INT ->1,2,3,4
                                                   DATE -> 'YYYY-MM-DD'
                                                   DEFAULT-->Default value goven by MYSQL(Look at EG1)
                
                                                 ** Default value is given if
                                                    AI = 1(Default value is increase compared to previou value)
                                                    NN = 0 (Default value is null)
                                                    Default expression  has a value (Default value is value written)


                                                    EG1
                                                    Orders table :order_id(AI = 1) , customer_id , order_date , status(default =1))                                              

                                                    INSERT INTO orders (order_id,customer_id,order_date ,status )             
                                                    VALUE             (DEFAULT ,  10 , '2019-11-10', DEFAULT)
                                                    OR
                                                    INSERT INTO orders (customer_id ,  order_date )
                                                    VALUE              ( 10,'2019-11-10')


*/

//UPDATE
/* 
UPDATE tablename        -->Update  "rows"  for the tablename by giving column some values  for the given WHERE condition(optional) 
SET colum1 = value1,       COLUMN
    column2  = value2      same as insert  
WHERE condition            VALUES                
                           Same as insert
                            EG1
                            UPDATE invoices
                            SET  payment_total = 10 , 
                                Payment_date = ‘2019-12-11’
                            WHERE invoice_id = 1


                            EG2
                            UPDATE invoices
                            SET  payment_total = invoice_total*0.5 , 
                                 Payment_date = due_date
                            WHERE invoice_id = 1


                            EG3
                            UPDATE invoices
                            SET  payment_total = invoice_total*0.5 , 
                                 Payment_date = due_date
                            WHERE invoice_id IN (1,2)

                            EG4
                            Sql_store has
                            Orders table which has customer_id and comments
                            Customers table has customer_id and points
                            Update comments table as ‘GOLD CUSTOMER’ for points > 5000
                            USE sql_store;
                            UPDATE orders
                            SET comments = 'gold_customer'
                            WHERE customer_id IN (SELECT customer_id
                                        FROM customers
                                        WHERE points >=3000)

*/

//DELETE
/*
DELETE  FROM tablename    -->Delete "rows" for  the tablename for given WHERE condition(optional if not given entire table deleted)            
WHERE condition             
                            EG1
                            DELETE invoices
                            WHERE invoice_id = 1

                            EG2
                            DELETE FROM  invoices
                            WHERE invoice_id IN (1,2)

                            EG3
                            Sql_store has
                            Orders table which has customer_id and comments
                            Customers table has customer_id and points
                            DELETE comments table  for points > 5000
                            USE sql_store;
                            DELETE FROM  orders
                            WHERE customer_id IN (SELECT customer_id
                                        FROM customers
                                        WHERE points >=3000)


*/

//SUBQUERY
/*
1.WHERE/HAVING
WHERE  columnName operator                                     
                  (Subquery that returns single value)          -- columnName satisfies value returned by subquery               EG1          
                  ALL   (Subquery that returns list of  value)  -- columnName satisfies all list of value  returned by subquery  EG2,3
                  ANY   (Subquery that returns list of  value)  -- columnName satisfies any list of value  returned by subquery  EG4
                  IN    (Subquery that returns list of  value)  -- columnName present in list of value  returned by subquery     EG 4  
                  EXISTS(Subquery that returns list of  value)  -- columnName exists in list of value  returned by subquery      EG 4  
                                                                  ** columnName = ANY(subquery) == columnName IN(subquery) == columnName EXISTS(subquery)
                                                                  **IN first executes subquery iand the list of values obtained as its result is used by the outer query
                                                                    and EXISTS takes every row in outer query and executes subquery for that row
                                                                    hence IN is faster 

2.SELECT
SELECT (subQuery) AS newColumnName --columnName is replaced with column returned by subquery EG 5

3.FROM
SELECT *
FROM (subquery) -- tableName is replaced by table returned by subquery  EG 6



Products                           OrderDetails        
PId Name	   SId CId Price         ODId	OId	PID Quantity
1	 Chais	1	 1	  18             1	10248	 1	 12
2	 Chang	1	 1	  19             2	10248	 2	 10
3	 Aniseed 1	 2	  10             3	10248	 3	 15
4	 Cajun 	2	 2	  22             4	10249	 1	 8
5	 Gumbo 	2	 2	  21             5	10249	 4	 4
6	 Spread	3	 2	  25             6	10249	 5	 6
7	 Pears	3	 7	  30             14  10249  9  4 
8	 Sauce	3	 2	  40             7	10250	 3	 5 
9	 Niku   	4	 6	  97             8	10250	 4	 18 
                                   13  10250  9  20
                                   9	10251	 5	 2
                                   10	10251	 6	 8
                                   11  10252  7  9 
                                   12  10252  8  9                                
EG1:
SELECT *                                             
FROM Products
WHERE PId < ALL (SELECT AVG(PID)                     --If PId < 57/14(4.1)
                 FROM OrderDetails);
PId Name	   SId CId Price 
1	 Chais	1	 1	  18  
2	 Chang	1	 1	  19 
3	 Aniseed 1	 2	  10
4	 Cajun 	2	 2	  22  

EG2(ALL)
SELECT *                                             
FROM Products
WHERE PId = ALL (SELECT PID                          --If PId = all values of list [5,5]
                 FROM OrderDetails                     
                 WHERE Quantity = 6 OR Quantity = 2);
PId Name	   SID CID Price
5	 Gumbo 	2	 2	  21  
                                 

EG3(ALL)
SELECT OId                                           
FROM OrderDetails 
GROUP BY OId                                       --Group by Oid
HAVING max(Quantity) > ALL (SELECT avg(Quantity)   --if max(Quantity) for the group > all values of list[37/3(12.33), 18/3(6),29/3(9.66) ,43/3(14.3),10/2(5),18/2(9)]   
                            FROM OrderDetails                                           
                            GROUP BY OId);  
OId
10248
10250


EG4(ANY)
SELECT  *
FROM Products 
WHERE PId = ANY (SELECT PId          --If Pid =any value of [7,8]
                FROM OrderDetails
               WHERE Quantity = 9);
OR
WHERE PId IN(SELECT PId          --If Pid is inside of  [7,8]
                FROM OrderDetails
               WHERE Quantity = 9);
OR
WHERE PId EXISTS(SELECT PId          --If Pid exists  inside of [7,8]
                FROM OrderDetails
               WHERE Quantity = 9);

PId Name	   SId CId Price  
7	 Pears	3	 7	  30 
8	 Sauce	3	 2	  40 


EG 5
We have clients tabe and invoices table 
DSelect columnNames as follows 
client_id; name ;total sales = SUM(invoice_total for that client);average = AVG(invoice_total for that client); difference = total sales – average

USE sql_invoicing;
SELECT client_id,name,
      (SELECT SUM(invoice_total)
		 FROM invoices
		 WHERE client_id = c.client_id) AS atotal_sales,

      (SELECT AVG(invoice_total)
		 FROM invoices
		 WHERE client_id = c.client_id) AS average_sales ,
        
      (SELECT total_salesT average_sales) AS difference

FROM clients c

EG 6
We have clients tabe and invoices table 
Select columnNames from a table with following columns 
client_id; name ;total sales = SUM(invoice_total for that client);average = AVG(invoice_total for that client); difference = total sales – average


SELECT * 
FROM(
      SELECT client_id, name,
      (SELECT SUM(invoice_total)
		 FROM invoices
		 WHERE client_id = c.client_id) AS atotal_sales,
        
      (SELECT AVG(invoice_total)
		 FROM invoices
		 WHERE client_id = c.client_id) AS average_sales 
        
      (SELECT total_sales - average_sales) AS difference

      FROM clients c
   ) AS tablename





*/


/* #endregion */