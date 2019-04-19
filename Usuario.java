package estrada.leon.rafael.pongrafa.Tabla;

public class Usuario {
    private Integer id;
    private String nombre;
    private float puntuacionmaquina;
    private float tiempo;

    public Usuario(Integer id, String nombre, float puntuacionmaquina, float tiempo) {
        this.id = id;
        this.nombre = nombre;
        this.puntuacionmaquina = puntuacionmaquina;
        this.tiempo = tiempo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPuntuacionmaquina() {
        return puntuacionmaquina;
    }

    public void setPuntuacionmaquina(float puntuacionmaquina) {
        this.puntuacionmaquina = puntuacionmaquina;
    }

    public float getTiempo() {
        return tiempo;
    }

    public void setTiempo(float tiempo) {
        this.tiempo = tiempo;
    }
}
