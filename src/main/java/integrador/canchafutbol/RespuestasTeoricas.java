/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.canchafutbol;

/**
 *
 * @author Lisandro
 * respuesta  EJERCICIO 4 interpretacion diagrama:
 * 
 * A - Falso. las reservas pueden tener una sola cancha (1 a 1). Las canchas pueden tener multples reservas (N a 1) 
 * 
 * B - Verdadero
 * 
 * C - Falso, la relacion es 1 a N
 * 
 * D - Falso, es Reserva_idReserva
 * 
 * E - Verdadero
 * 
 * F - Verdadero
 * 
 * G - Verdadero
 * 
 * respuesta EJERCICIO 5 Consulta SQL
 * 
 * SQL = "SELECT * FROM Reserva LEFT JOIN Cancha ON Reserva.Cancha_idCancha = Cancha.idCancha COUNT(Cancha.ciudad) FROM Cancha GROUP BY Cancha.ciudad HAVING COUNT(Cancha.ciudad) ORDER BY Cancha.ciudad DESC"
 * 
 */
public class RespuestasTeoricas {
    
}
