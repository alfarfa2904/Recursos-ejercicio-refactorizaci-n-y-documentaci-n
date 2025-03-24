public class Reserva {
	/**
	 * Clase que representa una reserva deportiva.
	 * Contiene información sobre la pista, fecha y duración de la reserva.
	 * 
	 * @author [Jaime Peinado]
	 */
    private int idPista;
    private String fecha;
    private int duracion;
    
    /**
     * Constructor para crear una nueva reserva.
     * 
     * @param idPista Identificador de la pista.
     * @param fecha Fecha de la reserva.
     * @param duracion Duración de la reserva en horas.
     */

    public Reserva(int idPista, String fecha, int duracion) {
        this.idPista = idPista;
        this.fecha = fecha;
        this.duracion = duracion;
    }
    
    /**
     * Obtiene el identificador de la pista.
     * 
     * @return Identificador de la pista.
     */

    public int getIdPista() {
        return idPista;
    }
    

    /**
     * Obtiene la fecha de la reserva.
     * 
     * @return Fecha de la reserva.
     */

    public String getFecha() {
        return fecha;
    }

    /**
     * Obtiene la duración de la reserva.
     * 
     * @return Duración de la reserva en horas.
     */

    public int getDuracion() {
        return duracion;
    }
}