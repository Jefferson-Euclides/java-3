package challenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProcessaArquivo {

	public List<Jogador> retornaListaRegistros() {
		List<Jogador> listaJogadores = new ArrayList<>();

		try {
			BufferedReader arquivoCSV = new BufferedReader(
					new InputStreamReader(new FileInputStream("../java-3-master/src/main/resources/data.csv")));
			String linhaArquivo;
			Scanner lerArquivo = new Scanner(arquivoCSV);
			lerArquivo.nextLine();

			while (lerArquivo.hasNext()) {
				linhaArquivo = lerArquivo.nextLine();
				String[] JogadorAux = linhaArquivo.split(",");
				
				Jogador jogador = new Jogador();
				jogador.setFullName(JogadorAux[2]);
				jogador.setClub(JogadorAux[3]);
				jogador.setAge(JogadorAux[6]);
				jogador.setBirthDate(JogadorAux[8]);
				jogador.setNationality(JogadorAux[14]);
				jogador.setEurWage(JogadorAux[17]);
				jogador.setEurReleaseClause(JogadorAux[18]);
				
				listaJogadores.add(jogador);
			}
			lerArquivo.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return listaJogadores;
	}
}
