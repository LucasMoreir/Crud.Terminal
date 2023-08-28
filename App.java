import java.security.PublicKey;
import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;
import javax.annotation.processing.SupportedSourceVersion;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.text.Normalizer.Form;
import java.util.Date;



class registro{
    private int id;
    private String nome;
    private int salario;


    registro(int id, String nome, int salario){
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getSalario() {
        return salario;
    }
    public String toString() {
    return "ID               : " + id + "\n" +
           "Nome             : " + nome + "\n" +
           "Salário          : " + salario;
    }

}
class CRUD{
    public static void main(String[] argd) {
        List<registro> c = new ArrayList<registro>();
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        int ch;
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date data = new Date();
        SimpleDateFormat formatadorDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date sdata = new Date();
        
            System.out.println("--------------------------------------");
            System.out.println("--CADSTRO DE FUNCIONARIOS--");
            System.out.println(  "INICIO DO PROGRAMA ÀS:"+formatador.format(data));
            System.out.println("------------------------------------");
        do{
            System.out.println("1.CADASTRAR");
            System.out.println("2.VISUALIZAR");
            System.out.println("3.PROCURAR");
            System.out.println("4.DELETAR");
            System.out.println("5.ATUALIZAR");
            System.out.println("0.FINALIZAR OPERAÇÃO");
            System.out.println("-----------------------------------");
            System.out.print("Insira a alterantiva desejada :");
            ch = s.nextInt();
            System.out.println("----------------------------------");
            switch(ch){
                case 1:
                    System.out.println("---------------------------------");
                    System.out.println(">> Registro do ID começa no número 100<<");
                    System.out.println("---------------------------------");
                    System.out.print("Insira o ID            :");
                    int ide = s.nextInt();
                    System.out.print("Insira o Nome Completo :");
                    String nome = s1.nextLine();
                    System.out.print("Insira o Salário       :");
                    int salario = s.nextInt();
                    System.out.println("Data de Registro       :"+formatadorDateFormat.format(sdata));
                    System.out.println("---------------------------------");
                    c.add(new registro(ide, nome, salario));

                break;
                case 2:
                    System.out.println("--------------------------------");
                    Iterator<registro> i = c.iterator(); //funcção para retrair o registro
                    while(i.hasNext()){
                        registro e = i.next();
                        System.out.println(e); 
                        System.out.println("Data de Registro : "+formatadorDateFormat.format(sdata));
                        System.out.println("----------------------------------");     
                    }
                break;
                case 3:
                    boolean found = false;
                    System.out.println("----------------------------------");
                    System.out.print("Ensira o ID do usuário : ");
                    int id = s.nextInt();
                    System.out.println("----------------------------------");
                    i = c.iterator();
                    while(i.hasNext()){
                        registro e = i.next();
                        if(e.getId() == id) {
                                System.out.println(e);
                                found = true;
                        }
                    }
                        System.out.println("----------------------------------");
                    if(!found){
                        System.out.println("----------------------------------");
                        System.out.println("ID não identificado");
                        System.out.println("----------------------------------");
                    }
                break;
                
                case 4: 
                    found = false;
                    System.out.println("----------------------------------");
                    System.err.print("Insira o ID do usuário : ");
                    id = s.nextInt();
                    System.out.println("----------------------------------");
                    i = c.iterator();
                    while(i.hasNext()) {
                        registro e = i.next();
                        if(e.getId() == id) {
                            i.remove();
                            found = true; 
                        }      
                    }
                        System.out.println("----------------------------------");
                    if(!found){
                        System.out.println("----------------------------------");
                        System.out.println("ID não identificado");
                    } else{
                        System.out.println("ID deletado com sucesso....!!!");
                        System.out.println("----------------------------------");
                    }
                    break;
                    case 5 :
                        found = false;
                        System.out.println("----------------------------------");
                        System.out.print("Insira o ID para atualizar : ");
                        id = s.nextInt();
                        System.out.println("----------------------------------");
                        ListIterator<registro>li = c.listIterator();
                        while(li.hasNext()){
                            registro e = li.next();
                            if(e.getId() == id) {
                                System.out.print("Insira novo nome : ");
                                nome = s1.nextLine();
                                System.out.print("Insira novo Salário : ");
                                salario = s.nextInt();
                                li.set(new registro(id, nome, salario));
                                found = true;
                            }
                        }
                            System.out.println("----------------------------------");  
                        if(!found){
                            System.out.println("----------------------------------");
                            System.out.println("ID não identificado");
                        } else{
                            System.out.println("ID atualizado com sucesso...!!!");
                            System.out.println("----------------------------------");
                        }
                    break;
                }
            }while(ch!=0);
            System.out.println("----------------------------------");
            System.out.println("O PROGRMA FOI FINALIZADO ÀS: "+formatador.format(data));
            System.out.println("----------------------------------");
        }
    }    
            
        

    

