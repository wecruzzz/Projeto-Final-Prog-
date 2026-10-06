package Model;

public class Chekin {

    private int N_reserva;
    private int TBHotel_Codigo;
    private String data_entrada;
    private String data_saida;
    private int N_adultos;
    private int N_Crianca;
    private int Tbcliente_codigo;

    public int getN_reserva() {
        return N_reserva;
    }

    public void setN_reserva(int N_reserva) {
        this.N_reserva = N_reserva;
    }

    public int getTBHotel_Codigo() {
        return TBHotel_Codigo;
    }

    public void setTBHotel_Codigo(int TBHotel_Codigo) {
        this.TBHotel_Codigo = TBHotel_Codigo;
    }

    public String getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(String data_entrada) {
        this.data_entrada = data_entrada;
    }

    public String getData_saida() {
        return data_saida;
    }

    public void setData_saida(String data_saida) {
        this.data_saida = data_saida;
    }

    public int getN_adultos() {
        return N_adultos;
    }

    public void setN_adultos(int N_adultos) {
        this.N_adultos = N_adultos;
    }

    public int getN_Crianca() {
        return N_Crianca;
    }

    public void setN_Crianca(int N_Crianca) {
        this.N_Crianca = N_Crianca;
    }

    public int getTbcliente_codigo() {
        return Tbcliente_codigo;
    }

    public void setTbcliente_codigo(int Tbcliente_codigo) {
        this.Tbcliente_codigo = Tbcliente_codigo;
    }
}