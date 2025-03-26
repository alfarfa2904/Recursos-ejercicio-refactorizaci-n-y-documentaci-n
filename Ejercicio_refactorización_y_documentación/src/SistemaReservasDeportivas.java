import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal para gestionar un sistema de reservas deportivas.
 */
public class SistemaReservasDeportivas {

    private List<Reserva> reservas;
    private GestorIluminacion gestorIluminacion;
    private static final int MAX_PISTAS = 10;

    /**
     * Constructor para inicializar el sistema de reservas deportivas.
     */
    public SistemaReservasDeportivas() {
        reservas = new ArrayList<>();
        gestorIluminacion = new GestorIluminacion(MAX_PISTAS);
    }

    /**
     * Reserva una pista deportiva.
     */
    public boolean reservarPista(Reserva reserva) {
        if (reserva.getIdPista() < 0 || reserva.getIdPista() >= MAX_PISTAS || reserva.getDuracion() <= 0) {
            return false; // Datos inválidos
        }

        if (!esFechaDisponible(reserva.getIdPista(), reserva.getFecha())) {
            return false; // Fecha no disponibl
        }

        reservas.add(reserva);
        return true;
    }

    /**
     * Cancela una reserva específica.
     */
    public boolean cancelarReserva(int idReserva) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getIdReserva() == idReserva) {
                reservas.remove(i);
                return true;
            }
        }
        return false; // No se encontró la reserva
    }

    /**
     * Verifica la disponibilidad de una pista en una fecha específica.
     */
    public boolean verificarDisponibilidad(int idPista, LocalDate fecha) {
        return esFechaDisponible(idPista, fecha);
    }

    /**
     * Método privado para verificar si una fecha está disponible.
     */
    private boolean esFechaDisponible(int idPista, LocalDate fecha) {
        for (Reserva r : reservas) {
            if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {
                return false; // Fecha no disponible
            }
        }
        return true; // Fecha disponible
    }
}

/**
 * Clase para gestionar la iluminación de las pistas.
 */
class GestorIluminacion {
    private boolean[] iluminacion;

    public GestorIluminacion(int maxPistas) {
        iluminacion = new boolean[maxPistas];
    }

    public boolean encenderLuces(int idPista) {
        if (idPista < 0 || idPista >= iluminacion.length) {
            return false; // ID de pista inválido
        }
        iluminacion[idPista] = true;
        return true;
    }

    public boolean apagarLuces(int idPista) {
        if (idPista < 0 || idPista >= iluminacion.length) {
            return false; // ID de pista inválido
        }
        iluminacion[idPista] = false;
        return true;
    }
}

/**
 * Clase para representar una reserva.
 */
class Reserva {
    private static int contadorReservas = 0;
    private int idReserva;
    private int idPista;
    private LocalDate fecha;
    private int duracion;

    public Reserva(int idPista, LocalDate fecha, int duracion) {
        this.idReserva = ++contadorReservas;
        this.idPista = idPista;
        this.fecha = fecha;
        this.duracion = duracion;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public int getIdPista() {
        return idPista;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getDuracion() {
        return duracion;
    }
}
