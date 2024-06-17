package telas;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FormularioCliente {

    public void Cliente() {
        // Criando uma nova instância de JFrame
        JFrame janela = new JFrame("Minha Janela");

        // Configurando o tamanho da janela
        janela.setSize(400, 300);

        // Configurando o comportamento padrão ao fechar a janela
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adicionando um rótulo à janela
        JLabel rotulo = new JLabel("Olá, mundo!");
        janela.add(rotulo);

        // Tornando a janela visível
        janela.setVisible(true);
    }

}
