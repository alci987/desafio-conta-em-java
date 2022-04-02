package br.com.banco;

public class ContaBanco {
    /* Atributos */
    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;

    public void estdoAtual(){
        System.out.println("-----------------------------------------------------------");
        System.out.println("Conta: " + this.getNumConta());
        System.out.println("Tipo da Conta: " + this.getTipo());
        System.out.println("Titular: " + this.getDono());
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Status:" + (getStatus() ? "Conta aberta" : "Conta fechada"));

    }

    /* Métodos */

    public void abrirConta(String tipo){
        this.setTipo(tipo); // se é conta corrente ou poupança (cc ou cp)
        this.setStatus(true); // abre a conta

        if (tipo.equals("CC")) {
            this.setSaldo(50); // a conta corrente já começa com 50 reais de saldo
            System.out.println("Conta aberta com sucesso!!");
        }else if (tipo.equals("CP")) {
            this.setSaldo(150); // a conta poupança começa com 150 reais de saldo
            System.out.println("Conta aberta com sucesso!!!");
        }
    }

    public void fecharConta(){
        if (this.getSaldo() > 0){
            System.out.println("Sua conta não pode ser fechada porque ainda tem saldo");
        }else if (this.getSaldo() < 0){
            System.out.println("Sua conta não pode ser fechada porque possui um débido");
        }else{
            this.setStatus(false);
            System.out.println("Conta fechada com sucesso!!!");
        }
    }

    public void depositar(float valor){
        if (this.getStatus()){ // se a conta estiver aberta
            this.setSaldo(getSaldo() + valor);
            System.out.println("Depósito realizado  na conta de :" + this.getDono() + "!!!");
        }else{
            System.out.println("Impossível depositar em uma conta fechada!!!");
        }
    }

    public void sacar(float valor){
        if (this.getStatus()) { // se a conta estiver aberta
            if (this.getSaldo() >= valor){ // se tem saldo na conta
                this.setSaldo(this.getSaldo() - valor);
                System.out.println("Saque efetuado!!!");
            }else{
                System.out.println("Saldo insuficiente para saque.");
            }
        }else{
            System.out.println("Impossível efetuar saque em uma conta fechada!!!");
        }
    }

    public void pagarMensalidade(){
        int valormensalidade = 0;
        if (this.getTipo().equals("CC")){
            valormensalidade = 12; // taxa da mensalidade
        }else if (this.getTipo().equals("CP")){
            valormensalidade = 20;
        }
        if (this.getStatus()){ // verifica se tem conta aberta
            this.setSaldo(this.getSaldo() - valormensalidade);
            System.out.println("Mensalidade paga na conta de: " + this.getDono() + "!!!");
        }else{
            System.out.println("Impossível cobrar mensalidade de uma conta fechada.");
        }

    }

    /* Métodos especiais */

    public ContaBanco() {
        this.setSaldo(0.0f);
        this.setStatus(false);
    }

    /* Getters and Setter */

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
