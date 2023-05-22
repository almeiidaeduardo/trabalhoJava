package civilizacoes;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<Civilizacao> civilizacoes;
    private List<Evento> eventos;
    private List<EventosEmComum> eventosEmComum;
    private Scanner scanner;

    public Menu() { // Criação das listas/menus civilizações, eventos e eventos em comum
        civilizacoes = new ArrayList<>();	
        eventos = new ArrayList<>();		
        eventosEmComum = new ArrayList<>();	
        scanner = new Scanner(System.in);
    }

    public void executavel() { // Exibe o menu principal e processa a escolha do usuário
        boolean sair = false;

        while (!sair) {
            System.out.println("********* MENU PRINCIPAL *********");
            System.out.println("Escolha uma opcao:");
            System.out.println("C) Civilizacoes");
            System.out.println("R) Eventos");
            System.out.println("U) Eventos em Comum");
            System.out.println("D) Sair");

            String opcao = scanner.nextLine();
            
         
            switch (opcao) {
                case "C":
                    crudCivilizacoes();
                    break;
                case "R":
                    crudEventos();
                    break;
                case "U":
                    crudEventosEmComum();
                    break;
                case "D":
                    sair = true;
                    break;
                default:
                    System.out.println("Invalido!");
                    break;
            }
        }
    }

    private void crudCivilizacoes() { //Exibe o menu de civilizações , utiliza um laço while para exibir o menu, até queo usuário escolha a opção "V" para voltar
        boolean voltar = false;

        while (!voltar) {
            System.out.println("********* MENU CIVILIZAÇÕES *********");
            System.out.println("Escolha uma opção:");
            System.out.println("C) Criar Civilização");
            System.out.println("R) Recuperar Civilizações");
            System.out.println("U) Atualizar Civilização");
            System.out.println("D) Deletar Civilização");
            System.out.println("V) Voltar");

            String opcao = scanner.nextLine();
            

            switch (opcao) {
                case "C":
                    criarCivilizacao();
                    break;
                case "R":
                    recuperarCivilizacoes();
                    break;
                case "U":
                    atualizarCivilizacao();
                    break;
                case "D":
                    removerCivilizacao();
                    break;
                case "V":
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    private void crudEventos() {//Exibe o menu de eventos , utiliza um laço while para exibir o menu, até que o usuário escolha a opção "V" para voltar
        boolean voltar = false;

        while (!voltar) {
            System.out.println("********* MENU EVENTOS *********");
            System.out.println("Escolha uma opção:");
            System.out.println("C) Criar Evento");
            System.out.println("R) Recuperar Eventos");
            System.out.println("U) Atualizar Evento");
            System.out.println("D) Deletar Evento");
            System.out.println("V) Voltar");

            String opcao = scanner.nextLine();
            scanner.nextLine(); 

            switch (opcao) {
                case "C":
                    criarEvento();
                    break;
                case "R":
                    recuperarEventos();
                    break;
                case "U":
                    atualizarEvento();
                    break;
                case "D":
                	 removerEvento();
                    break;
                case "V":
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    private void crudEventosEmComum() { //Exibe o menu de eventos em comum , utiliza um laço while para exibir o menu, até que o usuário escolha a opção "V" para voltar
        boolean voltar = false;

        while (!voltar) {
            System.out.println("********* MENU EVENTOS EM COMUM *********");
            System.out.println("Escolha uma opção:");
            System.out.println("C) Criar Evento em Comum");
            System.out.println("R) Recuperar Eventos em Comum");
            System.out.println("U) Atualizar Evento em Comum");
            System.out.println("D) Deletar Evento em Comum");
            System.out.println("V) Voltar");

            String opcao = scanner.nextLine();
            

            switch (opcao) {
                case "C":
                    criarEventoEmComum();
                    break;
                case "R":
                    recuperarEventosEmComum();
                    break;
                case "U":
                    atualizarEventoEmComum();
                    break;
                case "D":
                	 removerEventoEmComum();
                    break;
                case "V":
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    private void criarCivilizacao() { //Criar civilização
        System.out.println("********* CRIAÇÃO DE CIVILIZACAO *********");
        System.out.println("Pais:"); //Pergunta qua pais da civilização ao usuário
        String pais = scanner.nextLine(); //Lê a entrada do usuário e armazena na variável pais

        System.out.println("Lingua:"); //Pergunta qual a lingua da civilização ao usuário
        String lingua = scanner.nextLine(); //Lê a entrada do usuário e armazena na variável ingua

        Civilizacao civilizacao = new Civilizacao(pais, lingua); //Cria um novo objeto Civilizacao, passando pais e lingua
        civilizacoes.add(civilizacao); //Adiciona objeto a lista

        System.out.println("SUCESSO! CIVILIZACAO CRIADA!");
        System.out.println(civilizacao);
        System.out.println();
    }

    private void recuperarCivilizacoes() {
        System.out.println("********* RECUPERAÇÃO DE CIVILIZAÇÕES *********");
        if (civilizacoes.isEmpty()) { //Se a lista civilizações estiver vazia
            System.out.println("Não existem civilizações cadastradas.");
        } else {
            System.out.println("Civilizações cadastradas:");
            for (Civilizacao civilizacao : civilizacoes) { //Mostra todas as civilizações cadastradas
                System.out.println(civilizacao);
            }
        }
        System.out.println();
    }

    private void atualizarCivilizacao() {
        System.out.println("********* ATUALIZAÇÃO DE CIVILIZAÇÃO *********");
        System.out.println("Qual civilizacao deseja alterar?:"); //Pergunta qual civilização deseja alterar
        String pais = scanner.nextLine();//Lê e armazena na variável pais

        Civilizacao civilizacaoAtualizar = null;
        for (Civilizacao civilizacao : civilizacoes) { //Percorre cada objeto na lista civilizacao
            if (civilizacao.getPais().equalsIgnoreCase(pais)) {  //Verifica se o pais atual é igual ao informado
                civilizacaoAtualizar = civilizacao;
                break;
            }
        }

        if (civilizacaoAtualizar != null) { //Encontra uma civilização igual a que foi informada
            System.out.println("Nova lingua da civilizacao:");
            String novaLingua = scanner.nextLine();

            civilizacaoAtualizar.setLingua(novaLingua);

            System.out.println("Civilização atualizada com sucesso!");
            System.out.println(civilizacaoAtualizar);
        } else { //Caso não exista nenhuma civilização com o nome informado
            System.out.println("Não foi encontrada a civilizacao");
        }
        System.out.println();
    }

    private void  removerCivilizacao() {
        System.out.println("********* REMOVER CIVILIZAÇÃO *********");
        System.out.println("Pais que deseja deletar:"); //Pergunta qual civilização deseja delatar
        String pais = scanner.nextLine(); //Lê e armazena na variável pais

        Civilizacao civilizacaoDeletar = null; 
        for (Civilizacao civilizacao : civilizacoes) { //Percorre cada objeto na lita civilizacao
            if (civilizacao.getPais().equalsIgnoreCase(pais)) { //Verifica se o pais atual é igual ao informado
                civilizacaoDeletar = civilizacao;
                break;
            }
        }

        if (civilizacaoDeletar != null) { //Indica que foi encontrado um pais igua ao informado
            civilizacoes.remove(civilizacaoDeletar); //Remove a civilização informada
            System.out.println("SUCESSO! CIVILIZACAO REMOVIDA");
        } else {
            System.out.println("Não foi encontrada a civilizacao.");
        }
        System.out.println();
    }

    private void criarEvento() {
        System.out.println("********* CRIAÇÃO DE EVENTO *********");
        System.out.println("Informe o pais:"); //Pergunta qual pais da civilização ao usuário
        String pais = scanner.nextLine(); //Lê a entrada do usuário e armazena na variável pais

        Civilizacao civilizacaoRelacionada = null;
        for (Civilizacao civilizacao : civilizacoes) {
            if (civilizacao.getPais().equalsIgnoreCase(pais)) { //Verifica se o pais informado é igual ao atual
                civilizacaoRelacionada = civilizacao;
                break;
            }
        }

        if (civilizacaoRelacionada == null) { //Pais diferente do atual
            System.out.println("Não foi encontrada a civilização");
            System.out.println("Impossivel criar envento");
            System.out.println();
            return;
        }

        System.out.println("Ano do evento:"); //Pergunta o ano
        int ano = scanner.nextInt(); //Lê e armazena na variavel ano
        scanner.nextLine(); 

        System.out.println("Nome do evento:"); //Pergunta o nome
        String nome = scanner.nextLine(); //Lê e armazena na variavel nome

        System.out.println("Descrição do evento:"); //Pergunta a descriçao
        String descricao = scanner.nextLine();  //Lê e armazena na variavel descricao

        Evento evento = new Evento(pais, civilizacaoRelacionada.getLingua(), ano, nome, descricao); //Cria um novo objeto evento
        eventos.add(evento); //Adiciona o objeto na lista de eventos

        System.out.println("SUCESSO! EVENTO CRIADO!");
        System.out.println(evento);
        System.out.println();
    }

    private void recuperarEventos() {
        System.out.println("********* RECUPERAÇÃO DE EVENTOS *********");
        if (eventos.isEmpty()) { //Verifica se a lista de eventos esta vazia
            System.out.println("Não existe nenhum evento");
        } else {
            System.out.println("Eventos:");
            for (Evento evento : eventos) {// Percorre e imprime os eventos
                System.out.println(evento);
            }
        }
        System.out.println();
    }

    private void atualizarEvento() {
        System.out.println("********* ATUALIZACAO DE EVENTO *********");
        System.out.println("Nome do evento que deseja atualizar:"); //pergunta o nome do evento que sera atualizado
        String nome = scanner.nextLine();//Lê e armazena na variável nome

        Evento eventoAtualizar = null;
        for (Evento evento : eventos) { //percorre toda a lista evento
            if (evento.getNome().equalsIgnoreCase(nome)) { //Verifica se o evento atual é igual ao informado
                eventoAtualizar = evento;
                break;
            }
        }

        if (eventoAtualizar != null) { //Evento encontrado
            System.out.println("Novo ano do evento:"); //Pergunta ano 
            int novoAno = scanner.nextInt(); //Lê e armazena na variável novoAno
            scanner.nextLine(); 

            System.out.println("Nova descrição do evento:");//Pergunta descrição
            String novaDescricao = scanner.nextLine();//Lê e armazena na variável novaDescricao

            eventoAtualizar.setAno(novoAno); //Atualiza o ano
            eventoAtualizar.setDescricao(novaDescricao); //Atualiza a descrição

            System.out.println("SUCESSO! EVENTO ATUALIZADO!");
            System.out.println(eventoAtualizar);
        } else { //Caso não exista evento com o nome informado
            System.out.println("Nao existe nenhum evento com esse nome");
        }
        System.out.println();
    }

    private void  removerEvento() {
        System.out.println("********* REMOVER EVENTO *********");
        System.out.println("Nome do evento que sera deletado:"); //Nome do evento que sera deletado
        String nome = scanner.nextLine(); //Lê e armazena na variável nome

        Evento eventoDeletar = null;
        for (Evento evento : eventos) { //Percorre a lista eventos
            if (evento.getNome().equalsIgnoreCase(nome)) { //Verifica se o evento atual é igual ao informado
                eventoDeletar = evento;
                break;
            }
        }

        if (eventoDeletar != null) { //Evento encontrado
            eventos.remove(eventoDeletar); //Remove o evento da lista de eventos
            System.out.println("SUCESSO! EVENTO DELETADO!");
        } else { //Evento não encontrado
            System.out.println("Nao existe nenhum evento com esse nome");
        }
        System.out.println();
    }

    private void criarEventoEmComum() {
        System.out.println(" ********* CRIAÇÃO DE EVENTO EM COMUM  *********");
        System.out.println("Pais da primeira civilizacao:"); //Nome do pais da primeira civilização
        String pais1 = scanner.nextLine(); //Lê e armazena na variável pasi1

        System.out.println("Pais da segunda civilizacao:");//Nome do pais da segunda civilizaão
        String pais2 = scanner.nextLine(); //Lê e armazena na variável pais2

        
        Civilizacao civilizacao1 = null;
        Civilizacao civilizacao2 = null;
        for (Civilizacao civilizacao : civilizacoes) { //Percorre cada objeto na lista civilizacoes
            if (civilizacao.getPais().equalsIgnoreCase(pais1)) { //Verifica se a civilização atual é igual a pais1
                civilizacao1 = civilizacao; //Atribui a civilização
            }
            if (civilizacao.getPais().equalsIgnoreCase(pais2)) { //Verifica se a civilização atual é igual a pais2
                civilizacao2 = civilizacao; //Atribui a civilização
            }
            if (civilizacao1 != null && civilizacao2 != null) { //verifica se as duas civilizações contem algum valor atribuido
                break;
            }
        }

        if (civilizacao1 == null || civilizacao2 == null) { //Civilização não encontrada
            System.out.println("Nao foi encontrada uma ou duas civilizacoes");
            System.out.println("Impossivel criar evento em comum");
            System.out.println();
            return;
        }

        System.out.println("Ano do evento em comum:"); //Pergunta ano
        int ano = scanner.nextInt(); //Lê e armazena na variável ano
        scanner.nextLine(); 

        System.out.println("Nome do evento em comum:");//Pergunta evento
        String nome = scanner.nextLine();//Lê e armzena na variável evento

        System.out.println("Descrição do evento em comum:"); //Pergunta descrição
        String descricao = scanner.nextLine(); //Lê e armazena na variável descricao

        EventosEmComum eventoEmComum = new EventosEmComum(civilizacao1, civilizacao2, ano, nome, descricao); //Cria um novo evento e comum
        eventosEmComum.add(eventoEmComum); //Adiciona na ista eventosEmComum

        System.out.println("SUCESSO! EVENTO EM COMUM CRIADO");
        System.out.println(eventoEmComum);
        System.out.println();
    }

    private void recuperarEventosEmComum() {
        System.out.println(" ********* RECUPERAÇÃO DE EVENTOS EM COMUM  *********");
        if (eventosEmComum.isEmpty()) { //Verifica se a lista eventosEmComum esta vazia
            System.out.println("Nenhum evento em comum cadastrado");
        } else { //Caso não esteja vazia
            System.out.println("Eventos em comum cadastrados:");
            for (EventosEmComum eventoEmComum : eventosEmComum) {
                System.out.println(eventoEmComum); //Mostra os eventos em comum cadastrados
            }
        }
        System.out.println();
    }

    private void atualizarEventoEmComum() {
        System.out.println("********* ATUALIZAÇÃO DE EVENTO EM COMUM  *********");
        System.out.println("Nome do evento em comum que sera atualizado:");//Nome do evento em comum
        String nome = scanner.nextLine(); //Lê e armazena na variável nome

        EventosEmComum eventoEmComumAtualizar = null;
        for (EventosEmComum eventoEmComum : eventosEmComum) { //Percorre a lista eventosEmComum
            if (eventoEmComum.getNome().equalsIgnoreCase(nome)) { //Verifica se evento e comum atual é igual ao informado
                eventoEmComumAtualizar = eventoEmComum;
                break;
            }
        }

        if (eventoEmComumAtualizar != null) { //Evento em comum encontrado
            System.out.println("Novo ano do evento em comum:");// //Novo ano
            int novoAno = scanner.nextInt(); //Lê e armazena na variável novoAno
            scanner.nextLine(); 

            System.out.println("Nova descrição do evento em comum:");//Nova descricao
            String novaDescricao = scanner.nextLine();//Lê e armazena na variável novaDescricao

            eventoEmComumAtualizar.setAno(novoAno); //Atualiza o ano
            eventoEmComumAtualizar.setDescricao(novaDescricao);//atualiza a descrião

            System.out.println("SUCESSO! EVENTO EM COMUM ATUALIZADO");
            System.out.println(eventoEmComumAtualizar);
        } else { //Evento em comum não encontrado
            System.out.println("Nenhum evento em comum com esse nome encontrado");
        }
        System.out.println();
    }

    private void  removerEventoEmComum() {
        System.out.println(" ********* REMOVER EVENTO EM COMUM  *********");
        System.out.println("Nome do evento em comum que sera deletado:"); //Pergunta nome do evento em comum
        String nome = scanner.nextLine(); //Lê e armazena na variável nome

        EventosEmComum eventoEmComumDeletar = null;
        for (EventosEmComum eventoEmComum : eventosEmComum) { //Percorre a lista eventosEmComum
            if (eventoEmComum.getNome().equalsIgnoreCase(nome)) { //Verifica se evento e comum atual é igual ao informado
                eventoEmComumDeletar = eventoEmComum;
                break;
            }
        }

        if (eventoEmComumDeletar != null) { //Evento em comum encontrado
            eventosEmComum.remove(eventoEmComumDeletar); //Evento e comum removido da lista eventosEmComum
            System.out.println("SUCESSO! EVENTO EM COMUM DELETADO!");
        } else { //Evento em comum não encontrado
            System.out.println("Nenhum evento em comum com esse nome encontrado");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.executavel(); //Chama o metodo executavel
    }
}
