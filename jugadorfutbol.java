//Clase jugadorfutbol Java
public class jugadorfutbol {

    private int correr;
    private int defensa;
    private int efectividad;

    //Constructor por defecto
    public jugadorfutbol() {
    }

    //Constructor con parámetros
    public jugadorfutbol(int correr, int defensa, int efectividad) {
        this.correr = correr;
        this.defensa = defensa;
        this.efectividad = efectividad;
    }

    //setters y getters
    public void setCorrer(int c) {
        correr = c;
    }
    public void setDefensa(int d) {
        defensa = d;
    }
    public void setEfectividad(int e) {
        efectividad = e;
    }
    public int getCorrer() {
        return correr;
    }
    public int getDefensa() {
        return defensa;
    }
    public int getEfectividad() {
        return efectividad;
    }

    //Método para comprobar si jugador es correcta
    public boolean jugadorCorrecto() {
        boolean correrCorrecto, defensaCorrecto, efectividadCorrecto;
        correrCorrecto = correr > 0;
        defensaCorrecto = defensa >= 1 && defensa <= 12;
        switch (defensa) {
            case 2:
                if (esPerfecto()) {
                    efectividadCorrecto = efectividad >= 61 && efectividad <= 100;
                } else {
                    efectividadCorrecto = efectividad >= 51 && efectividad <= 100;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                efectividadCorrecto = efectividad >= 1 && efectividad <= 30;
                break;
            default:
                efectividadCorrecto = efectividad >= 1 && efectividad <= 31;
        }
        return efectividadCorrecto && defensaCorrecto && correrCorrecto;
    }

    //Método privado para comprobar si el jugador es correcto
    //Este método lo utiliza el método jugadorcorrecto
    private boolean esPerfecto() {
        return (correr % 5 == 0 && correr % 100 != 0 || correr % 10 == 0);
    }

    //Método que modifica la defensa cambiándola por la del correr siguiente                                           
    public void correrSiguiente() {
        efectividad++;
        if (!jugadorCorrecto()) {
            correr = 1;
            defensa++;
            if (!jugadorCorrecto()) {
                defensa = 1;
                efectividad++;
            }

        }
    }
    //Sobrecargando jugadorcorrecto para dos parámetros int
    int jugadorcorrecto(int jugador1, int jugador2){
        System.out.println("Dos parámetros: "+jugador1+", "+jugador2);
        return jugador1+jugador2;
    }
    //Sobrecargando jugadorcorrecto para dos parámetros double
    double jugadorcorrecto(double jugador1, double jugador2){
        System.out.println("Dos parámetros tipo double: "+jugador1+", "+jugador2);
        return jugador1+jugador2;
    }
     //Sobrecargando jugadorcorrecto para un parámetro int
    void jugadorcorrecto(int jugadorestrella){
        System.out.println("Un parámetro: " +jugadorestrella+"\n");
    }
    //Método toString para mostrar jugador 
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (correr < 10) {
            sb.append("0");
        }
        sb.append(correr);
        sb.append("-");
        if (defensa < 10) {
            sb.append("0");
        }
        sb.append(defensa);
        sb.append("-");
        sb.append(efectividad);
        return sb.toString();
    }
} //Fin de la clase jugadorfutbol