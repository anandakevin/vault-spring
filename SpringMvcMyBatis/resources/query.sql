USE springjdbc
GO
UPDATE PROCEDURE findByCustomerId @custId int AS
	SELECT [CUST_ID] as custId,
		[FULL_NAME] as fullName,
		[ADDRESS] as address,
		[EMAIL] as email
	FROM [CUSTOMER]
	WHERE CUST_ID = @custId
	
--in mariadb server
CREATE OR REPLACE PROCEDURE findByCustomerId (custId int)
SELECT CUST_ID as custId,
	FULL_NAME as fullName,
	ADDRESS as address,
	EMAIL as email
FROM CUSTOMER
WHERE CUST_ID = @custId;