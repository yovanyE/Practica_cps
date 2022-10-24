CREATE OR ALTER PROCEDURE spc_cotiza(
@peso decimal(18,2),
@tarifa decimal(18,2),
@alto decimal(18,2),
@largo decimal(18,2),
@ancho decimal(18,2)
)
AS
BEGIN 
DECLARE @total_cotiza DECIMAL(18,2)=0.00;
DECLARE @descuento_cliente DECIMAL(18,2)=1.5;
	---1.5 Descuento cliente considerando constante por el momento
	SET @total_cotiza=(@peso*@tarifa)+(1.66 *@alto*@largo*@ancho)-(@descuento_cliente*0.5*@peso)
	SELECT ROUND(@total_cotiza,2) AS total_cotiza;
END 