package bl.entities.tiquete;

import java.time.Duration;
import java.util.Date;

public class Tiquete {


    //Atributos

    private String descripcion;
    private String  usuarioCreador;
    private Date fechaCreacion;
    private Date fechaResolucion;
    private Boolean  estado;
    private int tiquetId;
    private String commentarioResolucion;


    //Metodos
    //Constructor

    public Tiquete(String descripcion, String usuarioCreador, Date fechaCreacion, int tiquetId) {
        this.descripcion = descripcion;
        this.usuarioCreador = usuarioCreador;
        this.fechaCreacion = fechaCreacion ;
        this.fechaResolucion = null;
        this.commentarioResolucion = null;
        this.estado = false;
        this.tiquetId = tiquetId;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setUsuarioCreador(String usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(Date fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }


    public String getCommentarioResolucion() {
        return commentarioResolucion;
    }

    public void setCommentarioResolucion(String commentarioResolucion) {
        this.commentarioResolucion = commentarioResolucion;
    }

    public int getTiquetId() {
        return tiquetId;
    }

    public void setTiquetId(int tiquetId) {
        this.tiquetId = tiquetId;
    }

    @Override
    public String toString() {
        String status;

        if (estado){
            status = "Open";
        } else status = "Resolved";

        return "Tiquete " + tiquetId+ "{" + "\n" +
                "Descripcion= '" + descripcion + '\'' + "\n" +
                "Usuario Creador= '" + usuarioCreador + '\'' + "\n" +
                "Fecha Creacion= " +  fechaCreacion + "\n" +
                ", estado=" + status + "\n" +
                '}';
    }
}
