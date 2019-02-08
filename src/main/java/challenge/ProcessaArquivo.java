package challenge;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProcessaArquivo {
	
	public List<Jogador> retornaListaRegistros(String caminhoDoArquivo) {

		List<Jogador> result = new ArrayList<>();

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(caminhoDoArquivo).getFile());

		try (Scanner scanner = new Scanner(file)) {
			boolean primeiraLinha = false;
			scanner.nextLine();
			while (scanner.hasNextLine()) {
				Jogador jogador = new Jogador();
				String line = scanner.nextLine();
				String registro[] = line.split(",");
				
				jogador.setFullName(registro[2]);
				jogador.setClub(registro[3]);
				jogador.setAge(registro[6]);
				jogador.setBirthDate(registro[8]);
				jogador.setNationality(registro[14]);
				jogador.setEurWage(registro[17]);
				jogador.setEurReleaseClause(registro[18]);
				
				result.add(jogador);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		return result;

	  }
}
