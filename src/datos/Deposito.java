package datos;

public class Deposito {
private int id_deposito;

public Deposito(int id_deposito) {
	super();
	this.id_deposito = id_deposito;
}

public int getId_deposito() {
	return id_deposito;
}

public void setId_deposito(int id_deposito) {
	this.id_deposito = id_deposito;
}

@Override
public String toString() {
	return "Deposito [id_deposito=" + id_deposito + "]";
}




}
