package carregabanco.view;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import carregabanco.controller.CarregaBancoController;
import carregabanco.model.AlunoModel;

public class CarregaBancoView {
	public CarregaBancoView() {
        //JOptionPane.showMessageDialog(null,"Meu primeiro programa gr�fico!\n Obrigado, Curso Java Progressivo!");
		CarregaBancoController carregaBancoController = new CarregaBancoController();
		ArrayList<AlunoModel> valores = carregaBancoController.loader("alunostads.csv");
		carregaBancoController.inserirNoBanco(valores);
		
		//A parte da visualiza��o seria isso
		System.out.println(valores.size());
		for(AlunoModel n: valores)
			System.out.println(n.getCampus() + " - " + n.getNome_estudante()+ " - " + n.getIdade());
		
	}
}