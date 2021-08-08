package Class;

public class Usuario {

    private int idEmpleado;
    private String nombre;
    private int idTipoEmpleado;

    public Usuario(int idEmpleado, String nombre, int idTipoEmpleado) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.idTipoEmpleado = idTipoEmpleado;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdTipoEmpleado() {
        return idTipoEmpleado;
    }

    public void setIdTipoEmpleado(int idTipoEmpleado) {
        this.idTipoEmpleado = idTipoEmpleado;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", idTipoEmpleado=" + idTipoEmpleado + '}';
    }
    
    

}
