package Model;

public class Funcionario {
   private int Cod_funcionario;
   private int TBHotel_Codigo;
   private String Nome;
   private String email;
   private String senha;
   private String cargo;

    public int getCod_funcionario() {
        return Cod_funcionario;
    }

    public void setCod_funcionario(int cod_funcionario) {
        Cod_funcionario = cod_funcionario;
    }

    public int getTBHotel_Codigo() {
        return TBHotel_Codigo;
    }

    public void setTBHotel_Codigo(int TBHotel_Codigo) {
        this.TBHotel_Codigo = TBHotel_Codigo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}




//Cod_funcionario int UN AI PK
//TBHotel_Codigo int UN
//Email varchar(100)
//Senha varchar(30)
//cargo varchar(100)
