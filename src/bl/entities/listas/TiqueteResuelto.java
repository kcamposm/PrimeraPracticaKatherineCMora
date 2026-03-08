package bl.entities.listas;

import bl.entities.tiquete.Tiquete;

public class TiqueteResuelto {


    private Tiquete tiquete;
    private TiqueteResuelto siguienteTiquete;

    public TiqueteResuelto(Tiquete tiquete) {
        this.tiquete = tiquete;
        this.siguienteTiquete = null;
    }

    public void setSiguiente(TiqueteResuelto primero) {
        siguienteTiquete = primero;
    }

    public TiqueteResuelto getSiguiente() {
        return siguienteTiquete;
    }


    public void setTiquete(Tiquete tiquete) {
        this.tiquete = tiquete;
    }

    public Tiquete getTiquete() {
        return tiquete;
    }

}

