import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal para gestionar un sistema de reservas deportivas.
 * Permite realizar reservas de pistas y gestionar la iluminación.
 * 
 * @author [Jaime Peinado]
 */

public class SistemaReservasDeportivas {

    private List<Reserva> reservas;
    private boolean[] iluminacion;
    private static final int MAX_PISTAS = 10; // Asumimos un máximo de 10 pistas

    /**
     * Constructor para inicializar el sistema de reservas deportivas.
     */
    
    public SistemaReservasDeportivas() {
        reservas = new ArrayList<>();
        iluminacion = new boolean[MAX_PISTAS];
    }
    
    /**
     * Reserva una pista deportiva.
     * 
     * @param idPista Identificador de la pista.
     * @param fecha Fecha de la reserva en formato LocalDate.
     * @param duracion Duración de la reserva en horas.
     * @return true si la reserva fue exitosa, false en caso contrario.
     */

    public boolean reservarPista(int idPista, String fecha, int duracion) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        
       
        for (Reserva r : reservas) {
            if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {
                return false; // La pista ya está reservada en esa fechas
            }
        }
        reservas.add(new Reserva(idPista, fecha, duracion));
        return true;
       
    }
    
    /**
     * Cancela una reserva específica.
     * 
     * @param idReserva Identificador de la reserva.
     * @return true si la cancelación fue exitosa, false en caso contrario.
     */

    public boolean cancelarReserva(int idReserva) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getIdPista() == idReserva) {
                reservas.remove(i);
                return true;
            }
        }
        return false; // No se encontró la reserva
    }
    
    /**
     * Activa la iluminación de una pista específica.
     * 
     * @param idPista Identificador de la pista.
     * @return true si la iluminación fue activada, false en caso contrario.
     */

    public boolean activarIluminacion(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        iluminacion[idPista] = true;
        return true;
    }
    
    /**
     * Desactiva la iluminación de una pista específica.
     * 
     * @param idPista Identificador de la pista.
     * @return true si la iluminación fue desactivada, false en caso contrario.
     */

    public boolean desactivarIluminacion(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        iluminacion[idPista] = false;
        return true;
    }
    
    /**
     * Verifica la disponibilidad de una pista en una fecha específica.
     * 
     * @param idPista Identificador de la pista.
     * @param fecha Fecha de la reserva en formato LocalDate.
     * @return true si la pista está disponible, false en caso contrario.
     */

    public boolean verificarDisponibilidad(int idPista, String fecha, String hora) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        for (Reserva r : reservas) {
            if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {
                return false; // La pista no está disponible en esa fecha
            }
        }
        return true; // La pista está disponible
    }
}